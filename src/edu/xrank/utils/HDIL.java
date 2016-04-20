package edu.xrank.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.MinMaxPriorityQueue;

public class HDIL {

	public List<String> evalQuery(List<String> keywords, int maxresults, Map<Integer,Integer> invertList)
	{
		//expecting 1000 results
		MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.maximumSize(maxresults).create();
		List<String> resultlist = new ArrayList<String>();
		Iterator i1 = invertList.entrySet().iterator();
		boolean done = false;
		while(!done && i1.hasNext())
		{
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry) i1.next();
			int lcp =  (int) pair.getValue();
			int curEntry = (int) pair.getKey();
			for(int j=1;j<=invertList.size();j++)
			{
				int probeIndex = ((curEntry+j))%invertList.size();
				lcp = getLongestCommonPrefix();
			}
			
			if(!heap.contains(lcp))
			{
				for(int ki=0;ki>lcp;ki++)
				{
					heap.add(getRank(keywords,ki));
				}
			}
			int threshold = invertList.values().stream().mapToInt(null).sum();
			@SuppressWarnings("static-access")
			MinMaxPriorityQueue<Integer> dupheap = heap.create();
			boolean isthreshold = true;
			for(int ii=0;ii<maxresults;ii++)
			{
				if(!(dupheap.remove()>=threshold))
				{
					isthreshold = false;
					break;
				}
			}
			if(isthreshold)
			{
				done = true;
			}
		}
		return resultlist;
	}
	
	private Integer getRank(List<String> keywords, int ki) {
		return ki;
		// TODO Auto-generated method stub
		
	}

	public int getLongestCommonPrefix()
	{//fetch the value from btree
		return 0;
		
	}
	
}
