package edu.xrank.main;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import edu.xrank.utils.DBLPParser;
import edu.xrank.utils.DIGraph;

public class Main {

	public static void main(String[] args) {
		
		try {
			DIGraph<String> graph = new DIGraph<String>();
			graph.add("workshop", "inproceedings");
			graph.add("workshop", "proceedings");
			//System.out.println(graph);
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			SAXParser parser = parserFactory.newSAXParser();
			DBLPParser handler = new DBLPParser(graph);
			parser.getXMLReader().setFeature(
					"http://xml.org/sax/features/validation", true);
			parser.parse(new File("src/sample.xml"), handler); 
			System.out.println("-----------------");
			System.out.println(graph);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}

}
