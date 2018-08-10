// Dimitris Glynatsis 3140036  Konstantinos Karakaksidis 3140071 Lampros Gavalakis 3130031

/**
 * a substitution {variable/Term} 
 */
public class Subst {
	//a variable
	private Term var;
	
	// an atomic statement
	private Term term;
		
	public Subst(Term var, Term term) {
		this.var = var;
		this.term = term;
	}
	
	public Term getVar() {
		return this.var;
	}
	
	public Term getTerm() {
		return this.term;
	}
	public void setVar(Term var) {
		this.var = var;
	}
	
	public void setTerm(Term term) {
		this.term = term;
	}
	// override
	public boolean equals(Subst s) {
		
		return var.equals(s.var) && term.equals(s.term);
	}
	
	public String toString() {
		String s = "{";
		s += this.var.toString() + "/" + this.term.toString();
		s += "}";
		
	    return s;
	}

	
	public void print() {
		System.out.println(this.toString());
	}
}
