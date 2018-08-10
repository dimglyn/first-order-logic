import java.util.ArrayList;

/**
 * an atomic statement
 *
 */
public class Atomic {
	// an atomic statement is an equality if it is of the form: "Term = Term"
	private boolean isEq;
	
	// if the atomic statement is a relationship symbol 
	private boolean isRelSymb;
	
	// terms of the statement
	private ArrayList<Term> terms;
	
	// name of the statement
	private String name;
	
	// if the statement is a negation
	private boolean isNeg;
	
	
	public Atomic(Atomic a) {
		this(a.isRelSymb, a.name, a.isNeg);
		this.terms = new ArrayList<Term>();
		
		for(int i = 0; i < a.terms.size(); i++) {
			
			this.terms.add(new Term(a.terms.get(i)));
			
		}
	}
	/**
	 * constructs a new atomic statement
	 * @param isRelSymb if the atomic statement is a relationship symbol
	 */
	public Atomic(boolean isRelSymb, String name, boolean isNeg) {
		this.isRelSymb = isRelSymb;
		this.isEq = !isRelSymb;
		
		// an equality contains two terms 
		if(isEq)
			this.terms = new ArrayList<Term>(2);
		else 
			this.terms = new ArrayList<Term>();
		
		if(isRelSymb)
			this.name = name;
		else // an equality needs no name
			this.name = "";
		
		this.isNeg = isNeg;
		
	}
	
	public boolean isRelSymb() {
		return this.isRelSymb;
	}
	
	public ArrayList<Term> getTerms() {
		return this.terms;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isNeg() {
		return this.isNeg;
	}
	// override
	public boolean equals(Object a) {
		Atomic atomic = (Atomic) a;
		
		if(this.isRelSymb != atomic.isRelSymb)
			return false;
		
		if(!this.name.equals(atomic.getName()))
			return false;
		
		if(this.terms.size() != atomic.terms.size())
			return false;
		
		// list of terms of the first atomic statement should contain 
		// every term of the second in order for both atomic statements
		// to be equal
		for(int i = 0; i < this.terms.size(); i++) {
			if(!this.terms.contains(atomic.terms.get(i)))
				return false;
		}
		
		return true;
		
	}
	
	/**
	 *  make a substitutions in this statement
	 * @param s the substitution
	 */
	public void subst(Subst s) {
		
		for(int i = 0; i < this.terms.size(); i++) {
			// substitute the given variable in each term 
			// with the given term
			this.terms.get(i).subst(s.getVar(), s.getTerm());
		
			
		}
		
		
	}
	
	/**
	 * return a new atomic, which is a copy of this one 
	 * with a list of substitutions
	 * @param s list
	 */
	public Atomic subst(ArrayList<Subst> s) {
		Atomic atomic = new Atomic(this.isRelSymb, this.name, this.isNeg);
		atomic.terms = new ArrayList<Term>(this.terms);
		
		for(int i = 0; i < s.size(); i++) {
			atomic.subst(s.get(i));
		}
		
		return atomic;
		
	}
	/**
	 * 
	 * @return a list with the function symbols of this term, if the atomic
	 * statement
	 * null otherwise
	 */
	public ArrayList<Term> ops() {
	
		ArrayList<Term> ops = new ArrayList<Term>();
		
		for(int i = 0; i < this.terms.size(); i++) {
			if(this.terms.get(i).isFuncSymb())
				ops.add(this.terms.get(i));
		}
		
		return ops;
		
	}
	
	/**
	 * 
	 * @return a list with the variables and constants of the atomic 
	 * statement
	 * null otherwise
	 */
	public ArrayList<Term> args() {
		
		ArrayList<Term> args = new ArrayList<Term>();
		
		for(int i = 0; i < this.terms.size(); i++) {
			if(!this.terms.get(i).isFuncSymb())
				args.add(this.terms.get(i));
		}
		
		return args;
		
	}
	
	/**
	 * checks if the given variable occurs in this atomic statement
	 * @param var the variable to check for 
	 * @return true if it occurs
	 */
	public boolean occurCheck(Term var) {
		if(!var.isVar()) {
			System.out.println("The term to check should be a variable.");
			return false;
		}
		
		
		for(int i = 0; i < this.terms.size(); i++) {
			if(this.terms.get(i).equals(var))
				return true;
			
			// if a term is a function symbol check if the variable occurs in it
			if(this.terms.get(i).isFuncSymb()) {
				if(this.terms.get(i).occurCheck(var))
					return true;
			}
			
			
		}
		
		return false;
	
	}
	
	public boolean isCopyOf(Atomic a) {
		if(!this.name.equals(a.name))
			return false;
		
		ArrayList<Term> terms = this.getTerms();	
		
		ArrayList<Term> aterms = a.getTerms();
		
		if(terms.size() != aterms.size())
			return false;
		
		int size = terms.size();
		
		for(int i = 0; i < size; i++) {
			if(!terms.get(i).isCopyOf(aterms.get(i))) {
				return false;
			}
			
		
			
		}
		
		
		return true;
		
	}
	
	/**
	 * new vars 
	 * ex. x -> x1
	 * 
	 */
	public ArrayList<Subst> newVars() {
		ArrayList<Subst> list = new ArrayList<Subst>();
		
		for(int i = 0; i < this.terms.size(); i++) {
			list.addAll(this.terms.get(i).newVars());
			
		}
		
		return list;
	}
	
	
	
	public String toString() {
		String s = "";
		if(this.isEq) {
			s += this.terms.get(0).toString() + " = " + this.terms.get(1).toString();
		
			
		}
		else if(this.isRelSymb){
			s += this.name + "(";
			
			for(int i = 0; i < this.terms.size(); i++) {
				s += this.terms.get(i).toString();
				if(i < this.terms.size() - 1)
					s += ", ";
			}
			
			s += ")";
		}
		
		return s;
	}
	
	public void print() {
		System.out.println(this.toString());
	}

	
}
