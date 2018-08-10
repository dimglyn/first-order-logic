// Dimitris Glynatsis 3140036  Konstantinos Karakaksidis 3140071 Lampros Gavalakis 3130031

import java.util.ArrayList;
import java.util.Iterator;

/**
 * First order logic
 * A definite clause(special case of horn clause) consists of a list of
 *  premises(atomic statements) and a head
 */
public class DefiniteClause {
	/** the premises of the definite clause*/
	private ArrayList<Atomic> premises;
	
	/** head of the definite clause */
	private Atomic head;
	

	/**
	 * constructor
	 */
    public DefiniteClause()
    {
        premises = new ArrayList<Atomic>();
        
    }
    
    /**
	 * constructor
	 */
    public DefiniteClause(Atomic head)
    {
    	this();
    	this.head = head;
    	
    }
         
    public  ArrayList<Atomic> getPremises()            
    {
        return premises;
    }
    
    public Iterator<Atomic> getPremisesList()
    {
        return premises.iterator();
    }
         

	
	public boolean isFact() {
		return this.premises.isEmpty() && this.head != null;
	}
	
	public Atomic getHead() {
		return this.head;
	}

	// see atomic, terms newVars
	public void newVars() {
		//this.head.newVars();
		ArrayList<Subst> substs = new ArrayList<Subst>();
		
		for(int i = 0; i < this.premises.size(); i++) {
			
			substs.addAll(this.premises.get(i).newVars());
			
		}
		
		this.head.subst(substs);
		
		
	}
	
	
	
	public void print() {
		
		Iterator<Atomic> iter = this.getPremisesList();
		while(iter.hasNext()) {
			Atomic next = iter.next();
			
			System.out.print(next.toString());
			
			if(iter.hasNext())
				System.out.print(" /\\ ");
			else
				System.out.print(" => ");
			
		}
		
		
		this.head.print();
		
	}
}
