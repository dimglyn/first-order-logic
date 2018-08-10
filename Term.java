// Dimitris Glynatsis 3140036  Konstantinos Karakaksidis 3140071 Lampros Gavalakis 3130031

import java.util.ArrayList;

/** 
 * a term
 *
 */
public class Term  {
		// name of the term
		private String name;
		
		// if the term is variable 
		private boolean isVar;
		
		// if the term is a constant
		private boolean isConst;
		
		// if the term is a function symbol 
		private boolean isFuncSymb;
		
		// is not null if and only if the term is a function symbol
		private ArrayList<Term> terms;
		
		// 1 for variable, 2 for constant, 3 for function symbol
		private int code;
		
		public Term(Term term) {
			this(term.code, new String(term.name));
			
			if(term.terms != null) {
				this.terms = new ArrayList<Term>();
				// deep copy of the terms
				for(int i = 0; i < term.terms.size(); i++) {
					this.terms.add(new Term(term.terms.get(i)));
				}
			}
			
			
		}
		
		
		/**
		 * constructs a new term
		 * @param code 
		 * code 1 means the term is a variable
		 * code 2 means the term is a constant
		 * code 3 means the term is a function symbol 
		 */
		public Term(int code, String name) {
			
			if(code < 1 || code > 3) {
				System.out.println("Code must be 1,2 or 3.");
				return;
			}
			this.code = code;
			
			this.isVar = (code == 1);
			this.isConst = (code == 2);
			this.isFuncSymb = (code == 3);
			
			
			
			if(this.isFuncSymb) {
				this.terms = new ArrayList<Term>();
			}
			
			this.name = name;
			
		
		}
		

		public ArrayList<Term> getTerms() {
			if(!this.isFuncSymb) 
				return null;
			
			return this.terms;
		}
		
		
		public boolean isVar() {
			return this.isVar;
		}
		
		public boolean isConst() {
			return this.isConst;
		}
		
		public boolean isFuncSymb() {
			return this.isFuncSymb;
		}
		
		public String getName() {
			return this.name;
		}
		
		//override
		public boolean equals(Object t) {
			Term term = (Term) t;
			
			if(this.code != term.code)
				return false;
			
			if(!this.name.equals(term.name))
				return false;
			// if the terms are function symbols
			if(this.isFuncSymb) {
				if(this.terms.size() != term.terms.size()) 
					return false;
				
				// list of terms of the first function symbol should contain 
				// every term of the second in order for both function symbols
				// to be equal
				for(int i = 0; i < this.terms.size(); i++) {
					if(!this.terms.contains(term.terms.get(i)))
						return false;
				}
			}
				
			
			return true;
		}
		
		/**
		 * substitute the given variable of this term with the given
		 * @param t the given term 
		 */
		public void subst(Term v, Term t) {
			if(isConst) {
				
				return;
			}
			// if this term is the variable to be substituted
			if(this.equals(v)) {
				this.code = t.code;
				this.isConst = t.isConst;
				this.isFuncSymb = t.isFuncSymb;
				this.isVar = t.isVar;
			    this.terms = null;
			    
			    
			    if(t.isFuncSymb) {
			    	this.terms = t.terms;
			    }
			    
			    this.name = t.name;
			}
			
		    // if this term is a function symbol 
		    if(this.isFuncSymb) {
		    	for(int i = 0; i < this.terms.size(); i++) {
		    		this.terms.get(i).subst(v, t);
		    	}
		    }
			
		}
		
		/**
		 * 
		 * @return a list with the function symbols of this term, if this term
		 * is a function symbol
		 * null otherwise
		 */
		public ArrayList<Term> ops() {
			if(!this.isFuncSymb) 
				return null;
			
			ArrayList<Term> ops = new ArrayList<Term>();
			
			for(int i = 0; i < this.terms.size(); i++) {
				if(this.terms.get(i).isFuncSymb)
					ops.add(this.terms.get(i));
			}
			
			return ops;
			
		}
		
		/**
		 * 
		 * @return a list with the variables and constants of this term, if this term
		 * is a function symbol
		 * null otherwise
		 */
		public ArrayList<Term> args() {
			if(!this.isFuncSymb) 
				return null;
			
			ArrayList<Term> args = new ArrayList<Term>();
			
			for(int i = 0; i < this.terms.size(); i++) {
				if(!this.terms.get(i).isFuncSymb)
					args.add(this.terms.get(i));
			}
			
			return args;
			
		}
		
		/**
		 * checks if the given variable occurs in this term
		 * @param var the variable to check for 
		 * @return true if it occurs
		 */
		public boolean occurCheck(Term var) {
			if(!var.isVar) {
				System.out.println("The term to check should be a variable.");
				return false;
			}
			
			if(!this.isFuncSymb) {
				return false;
			}
			
			for(int i = 0; i < this.terms.size(); i++) {
				if(this.terms.get(i).equals(var))
						return true;
				
				if(this.terms.get(i).isFuncSymb) {
					// occur check in each term of the function symbol 
					if(this.terms.get(i).occurCheck(var))
						return true;
				}
					
				
			}
			
			
			return false;
		}
		
		/**
		 * checks if this term is a copy of a given term 
		 * a variable is a copy of another variable
		 * a constant is a copy of another constant if they are equal
		 * a function symbol is a copy of another function symbol 
		 * if the have the same name and all terms of ther first are copies
		 * of the terms of the second
		 * @param t the given term
		 * @return true if the given term is a copy 
		 */
		public boolean isCopyOf(Term t) {
			// not both variable, const or function symbol
			if(this.code != t.code)
				return false;
			
			// a variable is a copy of another variable
			if(t.isVar) {
				return true;
			}
		
			if(this.isConst) {
				if(this.equals(t))
					return true;
				else 
					return false;
			
			
			} 
				
			
			if(this.isFuncSymb) {
				
				if(!this.name.equals(t.name)) 
					return false;
					
				ArrayList<Term> terms = this.getTerms();
				
				ArrayList<Term> termst = t.getTerms();
				
				int size = terms.size();
				
				if(size != termst.size())
					return false;
				
				for(int i = 0; i < size; i++) {
					if(!terms.get(i).isCopyOf(termst.get(i))) 
						return false;
				}
				
				
				
				
				
			}
			
			
			
			return true;
			
			
		}
		

		 /**
		  * x -> x1, x1 -> x2 ...
		  * @return the list of substitutions
		  */
		public ArrayList<Subst> newVars() {
			ArrayList<Subst> list = new ArrayList<Subst>();
			if(this.isVar) {
				String name = this.name;
				
				Subst subst = new Subst(new Term(1, this.name), null);
				
				Integer newN = 0;
				String s = "";
				for(int i = 0; i < name.length(); i++) {
					Character c = name.charAt(i); // get last character
					if(Character.isDigit(c)) {
						 s += c;
					}
				 }
				 if(s.length() > 0) {
					 newN = Integer.parseInt(s) + 1;
					 String newName = name.substring(0, name.length() - s.length()).concat(newN.toString());
						
					 this.name = newName;
				 } else {
					 this.name = this.name.concat("1");
							 
				 }
				
			     subst.setTerm(new Term(1, this.name));
				 list.add(subst);
			} else if(this.isFuncSymb) {
				
				for(int i = 0; i < this.terms.size(); i++) {
					list.addAll(terms.get(i).newVars());
					
				}
				
			}
			return list;
			
			
		}
		
		public String toString() {
			String s = "";
			
			s += this.name;
			
			if(this.isFuncSymb) {
				s += "(";
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
	