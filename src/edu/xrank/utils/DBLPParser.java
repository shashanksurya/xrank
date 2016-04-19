package edu.xrank.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.xrank.entity.Conference;
import edu.xrank.entity.Element;
import edu.xrank.entity.Paper;

public class DBLPParser extends DefaultHandler
{
	private int curElement = -1;
	private int ancestor = -1;
	private Paper paper;
	private Conference conference;
	StringBuffer author;
	private DIGraph graph;
	int line = 0;
	public DBLPParser(DIGraph g) {
		graph = g;
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
	{
		if (qName.equals("inproceedings")) {
			ancestor = Element.INPROCEEDING;
			curElement = Paper.INPROCEEDING;
			paper = new Paper();
			paper.key = attributes.getValue("key");
			//System.out.println("PAPER KEY "+paper.key);
			graph.add("inproceedings","<paper "+paper.key+">");
		} else if (qName.equals("proceedings")) {
			ancestor = Element.PROCEEDING;
			curElement = Conference.PROCEEDING;
			conference = new Conference();
			conference.key = attributes.getValue("key");
			//System.out.println("CONFERENCE KEY "+conference.key);
			graph.add("proceedings","<conference "+conference.key+">");
		} else if (qName.equals("author") && ancestor == Element.INPROCEEDING) {
			author = new StringBuffer();
		}

		if (ancestor == Element.INPROCEEDING) {
			curElement = Paper.getElement(qName);
		} else if (ancestor == Element.PROCEEDING) {
			curElement = Conference.getElement(qName);
		} else if (ancestor == -1) {
			ancestor = Element.OTHER;
			curElement = Element.OTHER;
		} else {
			curElement = Element.OTHER;
		}

		line++;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (ancestor == Element.INPROCEEDING) {
			String str = new String(ch, start, length).trim();
			if (curElement == Paper.AUTHOR) {
				author.append(str);
				//System.out.println("AUTHOR "+str);
				if(!graph.contains("<author "+paper.key+">"))
					graph.add("<paper "+paper.key+">","<author "+paper.key+">");
				graph.add("<author "+paper.key+">",str);
			} else if (curElement == Paper.CITE) {
				paper.citations.add(str);
			} else if (curElement == Paper.CONFERENCE) {
				paper.conference = str;
				if(!graph.contains("<conference "+paper.key+">"))
					graph.add("<paper "+paper.key+">","<conference "+paper.key+">");
				graph.add("<conference "+paper.key+">",str);
			} else if (curElement == Paper.TITLE) {
				paper.title += str;
				//System.out.println("PAPER TITLE "+str);
				if(!graph.contains("<title "+paper.key+">"))
					graph.add("<paper "+paper.key+">","<title "+paper.key+">");
				graph.add("<title "+paper.key+">",str);
			} else if (curElement == Paper.YEAR) {
				if(!graph.contains("<year "+paper.key+">"))
					graph.add("<paper "+paper.key+">","<year "+paper.key+">");
				graph.add("<year "+paper.key+">",str);
			}
		} else if (ancestor == Element.PROCEEDING) {
			String str = new String(ch, start, length).trim();
			if (curElement == Conference.CONFNAME) {
				conference.name = str;
				if(!graph.contains("<confname "+conference.key+">"))
					graph.add("<conference "+conference.key+">","<confname "+conference.key+">");
				graph.add("<confname "+conference.key+">",str);
			} else if (curElement == Conference.CONFDETAIL) {
				conference.detail = str;
				if(!graph.contains("<confdetail "+conference.key+">"))
					graph.add("<conference "+conference.key+">","<confdetail "+conference.key+">");
				graph.add("<confdetail "+conference.key+">",str);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		//System.out.println(graph);
		if (qName.equals("author") && ancestor == Element.INPROCEEDING) {
			paper.authors.add(author.toString().trim());
		}
		
		if (Element.getElement(qName) == Element.INPROCEEDING) {
			ancestor = -1;
			
				if (paper.title.equals("") || paper.conference.equals("")
						|| paper.year == 0) {
					System.out.println("Error in parsing " + paper);
					return;
				}
				
				//paper done
			 
		} else if (Element.getElement(qName) == Element.PROCEEDING) {
			ancestor = -1;
				if (conference.name.equals(""))
					conference.name = conference.detail;
				if (conference.key.equals("") || conference.name.equals("")
						|| conference.detail.equals("")) {
					System.out.println("Line:" + line);
					System.exit(0);
				}
				//conference done
		}
	}

		
}

