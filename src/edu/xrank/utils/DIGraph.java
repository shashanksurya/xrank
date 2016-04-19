package edu.xrank.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DIGraph<V> {
	       
	    private Map<V,List<V>> neighbors = new HashMap<V,List<V>>();
	    
	    
	    public String toString () {
	        StringBuffer s = new StringBuffer();
	        for (V v: neighbors.keySet()) s.append("\n    " + v + " -> " + neighbors.get(v));
	        return s.toString();                
	    }
	    
	    public void add (V vertex) {
	        if (neighbors.containsKey(vertex)) return;
	        neighbors.put(vertex, new ArrayList<V>());
	    }
	    
	    public boolean contains (V vertex) {
	        return neighbors.containsKey(vertex);
	    }
	    

	    public void add (V from, V to) {
	        this.add(from); this.add(to);
	        neighbors.get(from).add(to);
	    }
	    
	    public void remove (V from, V to) {
	        if (!(this.contains(from) && this.contains(to)))
	            throw new IllegalArgumentException("Nonexistent vertex");
	        neighbors.get(from).remove(to);
	    }

		public Map<V, List<V>> getNeighbors() {
			return neighbors;
		}

		

		
}
