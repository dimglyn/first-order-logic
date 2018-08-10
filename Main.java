import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	  private static File file;
	  private static BufferedReader reader;

	
	
	  public static void main(String[] args) {
/*//		  Atomic a = new Atomic(true, "Weapon", false);
//		  a.getTerms().add(new Term(1, "x1"));
//		  
//		  Atomic b = new Atomic(true, "Criminal", false);
//		  b.getTerms().add(new Term(1, "x"));
//		  
//		  Unifier u = new Unifier();
//		  u.unify(a, b, new ArrayList<Subst>()).get(0).print();
		  
		  
		  Atomic a1 = new Atomic(true, "American", false);
		  a1.getTerms().add(new Term(1, "x"));
		  
		  Atomic a2 = new Atomic(true, "Weapon", false);
		  a2.getTerms().add(new Term(1, "y"));
		  
		  Atomic a3 = new Atomic(true, "Sells", false);
		  a3.getTerms().add(new Term(1, "x"));
		  a3.getTerms().add(new Term(1, "y"));
		  a3.getTerms().add(new Term(1, "z"));

		  Atomic a4 = new Atomic(true, "Hostile", false);
		  a4.getTerms().add(new Term(1, "z"));
		  
		  Atomic a5 = new Atomic(true, "Criminal", false);
		  a5.getTerms().add(new Term(1, "x"));
		  
		  
		  Atomic a6 = new Atomic(true, "Missile", false);
		  a6.getTerms().add(new Term(2, "M1"));
		  
		  Atomic a7 = new Atomic(true, "Owns", false);
		  a7.getTerms().add(new Term(2, "Nono"));
		  a7.getTerms().add(new Term(2, "M1"));
		  
		  Atomic a8 = new Atomic(true, "Missile", false);
		  a8.getTerms().add(new Term(1, "x"));
		  
		  Atomic a9 = new Atomic(true, "Owns", false);
		  a9.getTerms().add(new Term(2, "Nono"));
		  a9.getTerms().add(new Term(1, "x"));
		  
		  Atomic a10 = new Atomic(true, "Sells", false);
		  a10.getTerms().add(new Term(2, "West"));
		  a10.getTerms().add(new Term(1, "x"));
		  a10.getTerms().add(new Term(2, "Nono"));
		  
		 
		
		  Atomic a11 = new Atomic(true, "Weapon", false);
		  a11.getTerms().add(new Term(1, "x"));
		  
		  

		  Atomic a12 = new Atomic(true, "Enemy", false);
		  a12.getTerms().add(new Term(1, "x"));
		  a12.getTerms().add(new Term(2, "America"));
		  
		  
		  Atomic a13 = new Atomic(true, "Hostile", false);
		  a13.getTerms().add(new Term(1, "x"));
		  
		  Atomic a14 = new Atomic(true, "American", false);
		  a14.getTerms().add(new Term(2, "West"));
		  
		  
		  Atomic a15 = new Atomic(true, "Enemy", false);
		  a15.getTerms().add(new Term(2, "Nono"));
		  a15.getTerms().add(new Term(2, "America"));
		  
		  
		  //((American(x), Weapon(y), Sells(x, y, z), Hostile(z)) => Criminal(x))
		  DefClauseKB kb = new DefClauseKB();
		  
		  DefiniteClause dc = new DefiniteClause(a5);
		  dc.getPremises().add(a1);
		  dc.getPremises().add(a2);
		  dc.getPremises().add(a3);
		  dc.getPremises().add(a4);
		  

		  kb.getDefClauses().add(dc);
		  // Missile(M1)
		  dc = new DefiniteClause(a6);
	      kb.getDefClauses().add(dc);
		  
		  // Owns(Nono, M1)
		  dc = new DefiniteClause(a7);
		  kb.getDefClauses().add(dc);
		  
		  //((Missile(x), Owns(Nono,x) => Sells(West,x,Nono))
		  dc = new DefiniteClause(a10);
		  dc.getPremises().add(a8);
		  dc.getPremises().add(a9);
		 
		  
		  kb.getDefClauses().add(dc);
		  
		  //(Missile(x) => Weapon(x))
		  dc = new DefiniteClause(a11);
		  Atomic a16 = new Atomic(true, "Missile", false);
		  a16.getTerms().add(new Term(1, "x"));
		  
		  dc.getPremises().add(a16);
		
		  kb.getDefClauses().add(dc);
		  
		  //(Enemy(x, America) => Hostile(x))

		  dc = new DefiniteClause(a13);
		  dc.getPremises().add(a12);
	
		  kb.getDefClauses().add(dc);
		  //American(West)
		  dc = new DefiniteClause(a14);
				  
		  kb.getDefClauses().add(dc);
		  //Enemy(Nono, America)
		  dc = new DefiniteClause(a15);
	
		  kb.getDefClauses().add(dc);
		  
		  
		  kb.print();
		  
		  Atomic a = new Atomic(true, "Criminal", false);
		  a.getTerms().add(new Term(2, "West"));

		  System.out.println("\nTo prove: ");
		  a.print();
		  System.out.println();
		  
		  Main main = new Main();
		  
		  ArrayList<Subst> unifier = main.folFcAsk(kb, a);
		  
		  System.out.println();
		  
		   if(unifier != null)
			   System.out.println("Statement proved.\nUnifier: ");
		  
		  
		  for(int i = 0; i < unifier.size(); i++) {
			  unifier.get(i).print();
		  }
		  */
		  
		//  String s = "Father(Mother(Brother(x)),x,Sister(Brother(y)))";
	/*	  String s = "Mother(Brother(x)),x,Sister(Brother(y))";
		  
		 for(int i = 0; i < s.split(",+(?![^\\(]*\\))").length; i++)
		 	System.out.println(s.split(",+(?![^\\(]*\\))")[i]); */
		
		/*  Atomic fs = getAtomic(s);
		  
		  System.out.println(fs.getName());
		  System.out.println(fs.getTerms().size());
		  System.out.println(fs.getTerms().get(2).getName());
		  System.out.println(fs.getTerms().get(2).getTerms().get(0).getName());

		  
		  
		  fs.print();
	    */
		  
		  String filepath = "src\\knowledgeBase.txt";
		  
		  DefClauseKB KB = readFile(filepath);
		
		  KB.print();
		  
		  
		  Scanner input = new Scanner(System.in);
		  
		  System.out.println("Please give the atomic statement to prove: ");
		  
		  Atomic a = getAtomic(input.next());
		  
		  input.close();
		  
		  Main main = new Main();
		  
		  ArrayList<Subst> theta = main.folFcAsk(KB, a);
		  
		  if(theta == null)
			  System.out.println("Can't prove the statement from the given knowledge base.");
		  else {
			
			  System.out.println("\nStatement proved.");
		  }
		  
	    }
	  
	  
	  
	  

		public static DefClauseKB readFile(String filepath){

			

			try{
				file = new File(filepath);
			}catch (Exception e){
				e.printStackTrace();
			}

			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}


			DefClauseKB kb = new DefClauseKB();

			try{
				String  line = reader.readLine();

				DefiniteClause clause;
				Atomic a;
				do {
					String x[] = line.split("=>");
					
					if(x.length==1){
					
						a = getAtomic(x[0]);
						
						clause = new DefiniteClause(a);
					}else{
						a = getAtomic(x[1]);
						
					
						clause = new DefiniteClause(a);
						
						String[] tokens = x[0].split(" AND ");
						
						for (String c:tokens) {
							
							
							if (c.startsWith("("))
								c = c.substring(1,c.length()-1);
							
							clause.getPremises().add(getAtomic(c));
	
						}
					}
					kb.getDefClauses().add(clause);

					line = reader.readLine();
				}while (line!=null);

				return kb;
			}catch (Exception e){
				System.out.println("lol");
			}

			return kb;
		}

		public static Atomic getAtomic(String s){
			Atomic a;
			if (!s.contains("=")){
				a = new Atomic(true, s.substring(0,s.indexOf("(")),false);
				s = s.substring(s.indexOf("(")+1,s.length()-1);
				String[] tokens = s.split(",+(?![^\\(]*\\))", -1);
				for (String x:tokens){
					int code;
					if(!x.contains("(")){
						if(!Character.isUpperCase(x.charAt(0)))
							code = 1;
						else
							code = 2;
						a.getTerms().add(new Term(code,x));
					}else{
						a.getTerms().add(parseFunctionSymbol(x));
					}
				}

			}else{
				a = new Atomic(false,"",false);
				String x [] = s.split("=");
				int code;
				for (String k:x) {
					if (!k.contains("(")) {
						if (!Character.isUpperCase(k.charAt(0)))
							code = 1;
						else
							code = 2;
						a.getTerms().add(new Term(code, k));
					} else {
						a.getTerms().add(parseFunctionSymbol(k));
					}
				}
			}

			return a;
		}

		public static Term parseFunctionSymbol(String s){

			Term term = new Term(3,s.substring(0,s.indexOf("(")));
			
			s = s.substring(s.indexOf("(")+1,s.length()-1);
			
			String tokens []= s.split(",+(?![^\\(]*\\))", -1);
			
			for (String x:tokens) {
				int code;
				if (!x.contains("(")){
					if(!Character.isUpperCase(x.charAt(0)))
						code = 1;
					else
						code = 2;
					term.getTerms().add(new Term(code,x));
				}else{
					term.getTerms().add(parseFunctionSymbol(x));
				}
			}

			return term;
		}

	  
	  public ArrayList<Subst> folFcAsk(DefClauseKB KB, Atomic a) {
		  boolean f = false;
		  
		  Unifier u = new Unifier();
		  while(true) {
			  ArrayList<DefiniteClause> newfacts = new ArrayList<DefiniteClause>();
			  ArrayList<DefiniteClause> clauses = KB.getDefClauses();
			  ArrayList<Atomic> facts = KB.getFacts();
			  
			  // check if the facts contain the atomic statement to prove
			  if(facts.contains(a)) {
				  System.out.println("The given statement is in the knowledge base.");
				  return new ArrayList<Subst>();
			  }
			  
			  // if the statement to prove can be unified with a fact in the knowledge base
			  for(Atomic fact: facts) {
				  ArrayList<Subst> factUnifier = u.unify(a, fact, new ArrayList<Subst>());
				  if(factUnifier != null) {
					  return factUnifier;
				  }
				  
			  }
			  
			  for(int i = 0; i < clauses.size(); i++) { // for each statement in kb

				  if(!clauses.get(i).isFact()) { // of the form (a1 /\ ... /\ an) => b
					
					  // new vars
					 clauses.get(i).newVars();
					 // for each theta, where unify(a1 /\ ... /\ an, a1' /\ ... /\ an') = theta
	
					 ArrayList<ArrayList<Atomic>> subfacts = KB.getAllKFacts(clauses.get(i).getPremises().size());
					
					 for(int j = 0; j < subfacts.size(); j++) {
						 // change variable in ai'
						 for(int m = 0; m < subfacts.get(j).size(); m++) {
							 subfacts.get(j).get(m).newVars();
						 }
					    
					     
					     // we have to check for all permutations 
					     ArrayList<ArrayList<Atomic>> permuts = getPermutations(subfacts.get(j));
					     ArrayList<Subst> theta = null;
					     for(int k = 0; k < permuts.size(); k++) {
					    	 //theta
					    	 theta = u.unify(clauses.get(i).getPremises(), permuts.get(k), new ArrayList<Subst>());
					    	 if(theta != null)
					    		 break;
					     }
					     
					     
					     //
						 // theta
						 //ArrayList<Subst> theta = u.unify(clauses.get(i).getPremises(), subfacts.get(j), new ArrayList<Subst>());
						
					     
					     
						 if(theta != null) { // where theta != failure
	 System.out.println("Rule: ");clauses.get(i).print(); 
	  
		System.out.println("Unifier: ");
		
		for(int m = 0; m < theta.size(); m++)
		System.out.println(theta.get(m));
		System.out.println();
							 Atomic b1 = new Atomic(clauses.get(i).getHead()).subst(theta);
							 
							 // check if b1 is a copy of some fact in the knowledge base
							 for(int m = 0; m < facts.size(); m++) {
								 if(b1.isCopyOf(facts.get(m))) {
									 f = true;
								 }
							 }
							 // if b1 is not a copy of some fact in kb
							 if(!f) {
								 // new <- new U {b1}
								 newfacts.add(new DefiniteClause(b1));
							   
								
								 
								 // theta' <- unify(b1,a)
								 ArrayList<Subst> theta1 = u.unify(b1, a, new ArrayList<Subst>());
								 // if theta1 is not failure return it

								if(theta1 != null) {
									System.out.print("Final unifier: ");
									if(theta1.isEmpty())
										System.out.print("empty set.");
									 for(int m = 0; m < theta1.size(); m++)
										 	System.out.println(theta1.get(m));
									 
									 return theta1;
								 }
							 }
							 
							 
							 
						 }
						 
						 
					 } // end for theta 
					 
					  
				  } // end if form (a1 /\ ... /\ an) => b
					  
				  if(!newfacts.isEmpty()) {
					  System.out.println("New facts: ");
					  for(int m = 0; m < newfacts.size(); m++){
							newfacts.get(m).print();
					  }
					  System.out.println();
				  }
				  
				  
			  }
			  System.out.println();
			  KB.getDefClauses().addAll(newfacts);
			  // until new = {}
			  if(newfacts.isEmpty()) 
				  break;
			  
		  
		  } // end whlile
		  
		  System.out.println("Failure returned.");
		  // return failure
		  return null;
	  }
	  
	  
	  public static ArrayList<ArrayList<Atomic>> getPermutations(ArrayList<Atomic> al) {
		  ArrayList<ArrayList<Atomic>> permuts = new ArrayList<ArrayList<Atomic>>();
		  
		  // recursion break
		  if(al.isEmpty()) {
			  permuts.add(new ArrayList<Atomic>());
			  return permuts;
		  
		  }
		  ArrayList<Atomic> copy = new ArrayList<Atomic>(al);
		  
		 // ArrayList<Atomic> tmp = new ArrayList<Atomic>();
		  int size = copy.size();
		  for(int i = 0; i < size; i++) {
			  copy = new ArrayList<Atomic>(al);
			  // take first element
			  Atomic a = copy.remove(i);

			  
			  // get all permutations of the rest
			  ArrayList<ArrayList<Atomic>> rest = getPermutations(copy);
			  
			  // add to each permutation the first element at the beginning
			  for(int j = 0; j < rest.size(); j++) {
				  rest.get(j).add(0, a);
				  permuts.add(rest.get(j));
			  }
			  
			  
		  }
		  
		  
		  
		  return permuts;
		  
	  }

	
	
	
	
}
