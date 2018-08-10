# first-order-logic
We read the knowledge base from the knowledgebase file that has the form:
A1 AND A2 AND ... AND AN => H1
A1 AND A2 AND ... AND AM => H2

INFO
Each line is a fixed Horn clause, where Ai are atomic types consisting of Premises and Hi are the Heads.

There are spaces before and after every AND but not before and after =>.
The term that we want to be proved can be atomic and is given by the keypad.

Implementation:
-----------------------------------------------------------

- Atomic
This class implements an atomic type. Atomic types can either be an equation with the form of t1 = t2, where t1 and t2 are either terms or relationship symbol (predicate). The Booleans isEq and isRelSymb are to determine which of the two forms is the atomic mode.
- DefClauseKB
This class implements a knowledge base, a CNF that is consisted of definite horn clauses
- DefiniteClause
This class implements a definite horn clause
- Main
In the main class, we are using the folfcAsk algorithm.
- Subst
We have implemented an substitution in the forn {variable / term}
- Term
Implementing a term.
We use the code to identify whether a term is a 1-variable, 2-constant, 3-relationship symbol.
- Unifier
We implement the Algorithm of Unification.
