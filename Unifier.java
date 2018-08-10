// Dimitris Glynatsis 3140036  Konstantinos Karakaksidis 3140071 Lampros Gavalakis 3130031

import java.util.ArrayList;

/**
 * unifier
 */
public class Unifier {
	
	public Unifier() {
	}
	
	/**
	 * implementation of unifyVar algorithm 
	 * theta is the unifier so far
	 * @param b the variable 
	 * @param j the expression(term)
	 */
	private ArrayList<Subst> unifyVar(Term b, Term j, ArrayList<Subst> theta) {
		if(!b.isVar()) {
			System.out.println("Can't unify a non variable.");
			return null;
		}
		//if {b/value} E theta then return unify(value, j, theta)
		for(int i = 0; i < theta.size(); i++) {
			
			if(theta.get(i).getVar().equals(b)) {
				
				return unify(theta.get(i).getTerm(), j, theta);
				
			}
			
			//else if {j/value} E theta then return unify(b, value, theta)
			if(theta.get(i).getVar().equals(j)) {
				
				return unify(b, theta.get(i).getTerm(), theta);
				
			}
		}
		
		// if occur-check(j,b) return null(failure)
		if(j.occurCheck(b)) {

			return null;
		}
		
		// add {b/j} to theta
		theta.add(new Subst(b, j));
		return theta;
		
		
	} 
	
	public ArrayList<Subst> unify(Object z, Object j, ArrayList<Subst> theta) {
		//failure
		if(theta == null)
			return null;
		
		
		//if z = j then return theta
		if(z.equals(j))
			return theta;
		
		//if variable(z) then return unify-var(z, j, theta)
		if(z instanceof Term && ((Term) z).isVar()) {
			return unifyVar((Term)z,(Term)j, theta);
			
		}
			
		//if variable(j) then return unify-var(j, z, theta)
		if(j instanceof Term && ((Term) j).isVar()) {
			return unifyVar((Term)j,(Term)z, theta);
	
		}
		
		//if compound(z) and compound?(j)then return unify(args(z), args(j), unify(op(z), op(j), theta))
		// j and z are each either atomic statement or a functional symbol 
		if(z instanceof Atomic || (z instanceof Term && ((Term)z).isFuncSymb())) {
			if(j instanceof Atomic || (j instanceof Term && ((Term)j).isFuncSymb())) {
			    
				if(z instanceof Atomic) {
					
					if(j instanceof Atomic) {
					// both atomic
						// if z and j have different names they can't be unified
						if(!((Atomic)z).getName().equals(((Atomic)j).getName()))
								return null;
						//return unify(args(z), args(j), unify(op(z), op(j), theta))
						return unify(((Atomic)z).args(), ((Atomic)j).args(), unify(((Atomic)z).ops(), ((Atomic)j).ops(), theta));
					}
					else {
					// z atomic and j term 
						// if z and j have different names they can't be unified
						if(!((Atomic)z).getName().equals(((Term)j).getName()))
								return null;
						//return unify(args(z), args(j), unify(op(z), op(j), theta))
						return unify(((Atomic)z).args(), ((Term)j).args(), unify(((Atomic)z).ops(), ((Term)j).ops(), theta));
					}
				}
				else {
				
					if(j instanceof Atomic) {
						// z term and j atomic
						// if z and j have different names they can't be unified
						if(!((Term)z).getName().equals(((Atomic)j).getName()))
								return null;
						//return unify(args(z), args(j), unify(op(z), op(j), theta))
						return unify(((Term)z).args(), ((Atomic)j).args(), unify(((Term)z).ops(), ((Atomic)j).ops(), theta));
					}
					else {
						// both term 
						// if z and j have different names they can't be unified
						if(!((Term)z).getName().equals(((Term)j).getName()))
								return null;
						//return unify(args(z), args(j), unify(op(z), op(j), theta))
						return unify(((Term)z).args(), ((Term)j).args(), unify(((Term)z).ops(), ((Term)j).ops(), theta));
					}
				}
						
				
			} // end if j
		} // end if z
		
		
		
		//if list(z) and list(j) the return unify(rest(z), rest(j), unify(first(z), first(j), theta))
		if(z instanceof ArrayList<?> && j instanceof ArrayList<?>) {
			// create copies of lists
			ArrayList<?> listz = new ArrayList<>((ArrayList<?>)z);
			
			ArrayList<?> listj = new ArrayList<>((ArrayList<?>)j);
			//if the lists are of different size can't be unified
			// return failure
			if(listz.size() != listj.size())
				return null;
			
			
			
			if(!((ArrayList<?>)z).isEmpty() && !((ArrayList<?>)j).isEmpty()) {
				//Object firstz = ((ArrayList<?>)z).remove(0);
				Object firstz = listz.remove(0);
				
				//Object firstj = ((ArrayList<?>)j).remove(0);
				Object firstj = listj.remove(0);
//				System.out.println("Unifiy ---");
//				System.out.println(firstz);
//				System.out.println(firstj);
//				System.out.println("Unifiy ---");
				return unify(listz, listj, unify(firstz, firstj, theta));
			}
		}
		
		
		//return failure
		return null;
	}
	
	
	
}
