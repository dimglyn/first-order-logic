// Dimitris Glynatsis 3140036  Konstantinos Karakaksidis 3140071 Lampros Gavalakis 3130031

import java.util.ArrayList;
import java.util.Iterator;

/*
 * a knowledge base that consists of definite clauses
 *
 */
public class DefClauseKB 
{

	public ArrayList<DefiniteClause> theClauses = new ArrayList<DefiniteClause>();
    
    public ArrayList<DefiniteClause> getDefClauses()
    {
        return theClauses;
    }
    
    public Iterator<DefiniteClause> getIter() {
    	return theClauses.iterator();
    }
    
    
    
    
    
    /**
     * 
     * @param k size of sublists
     * @return a list that contains all sublists of facts of size k in this knowledge base 
     */
    public ArrayList<ArrayList<Atomic>> getAllKFacts(int k) {
    	ArrayList<Atomic> facts = this.getFacts();
    	
    	if(facts.size() < k) {
    		System.out.println("Not enough facts in the knowledge base.");
    		return null;
    	}
    	
    	
    	return getAllKFacts(k, facts);
    	
    	
    }
    
    /**
     * recursively return all(n!/(k!(n - k)!)) lists of size k from an initial list(of size n) 
     * @param k size of sublists
     * @param facts initial list of facts
     * @return a list containing all lists of facts of size k 
     */
    public ArrayList<ArrayList<Atomic>> getAllKFacts(int k, ArrayList<Atomic> facts) {
    	ArrayList<ArrayList<Atomic>> list = new ArrayList<ArrayList<Atomic>>();
    	ArrayList<Atomic> copy = new ArrayList<Atomic>(facts); 
    	
    	
//    	if(copy.size() < k || copy.isEmpty()) {
//    		
//    		return new ArrayList<ArrayList<Atomic>>();
//    	}
    
    	int size = copy.size();
    	
    	if(k == 1) {
    		
    		ArrayList<ArrayList<Atomic>> l = new ArrayList<ArrayList<Atomic>>();
    		for(int i = 0; i < copy.size(); i++) {
    			ArrayList<Atomic> l1 = new ArrayList<Atomic>();
    			l1.add(copy.get(i));
    			
    			l.add(l1);
    			
    		}
    		return l;
    	}
    	
    	for(int i = 0; i < size - k + 1; i++) {
    	  
    		Atomic first = copy.remove(0);
    		ArrayList<ArrayList<Atomic>> rest = getAllKFacts(k - 1, copy);
    		
    		
    		for(int j = 0; j < rest.size(); j++) {
    			rest.get(j).add(0, first);
    			list.add(rest.get(j));
    			
    		}
    		
    		
    		
    	}
    	
    	
   
    	
    	return list;
    	
    }
    /**
     * 
     * @return all facts in this knowledge base
     */
    public ArrayList<Atomic> getFacts() {
    	ArrayList<Atomic> facts = new ArrayList<Atomic>();
    	
    	for(int i = 0; i < this.theClauses.size(); i++) {
    		
    		if(this.theClauses.get(i).isFact()) {
    			facts.add(this.theClauses.get(i).getHead());
    		}
    		
    	}
    	
    	return facts;
    	
    }
    
    
    
    public void print() {
    	Iterator<DefiniteClause> iter = this.getIter();
    	System.out.println("Knowledge base: ");
    	while(iter.hasNext()) {
    		DefiniteClause next = iter.next();
    		
    		next.print();
    		//System.out.println("\n");
    		
    		
    
    	}
    	
    	
    	
    }

}
