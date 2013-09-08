package CSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

/**
 * Artificial Intelligence A Modern Approach (3rd Ed.)
 * https://aima-java.googlecode.com/svn/trunk/aima-core/src/main/java/aima/core/search/csp/CSP.java
 */

public class CSP {

	private List<Variable> variables;
	private List<Domain> domains;
	private List<Constraint> constraints;

	private Hashtable<Variable, Integer> varIndexHash;
	private Hashtable<Variable, List<Constraint>> cnet;

	private CSP() {
	}

	public CSP(List<Variable> vars) {
		variables = new ArrayList<Variable>(vars.size());
		domains = new ArrayList<Domain>(vars.size());
		constraints = new ArrayList<Constraint>();
		varIndexHash = new Hashtable<Variable, Integer>();
		cnet = new Hashtable<Variable, List<Constraint>>();
		Domain emptyDomain = new Domain(new ArrayList<Object>(0));
		int index = 0;
		for (Variable var : vars) {
			variables.add(var);
			domains.add(emptyDomain);
			varIndexHash.put(var, index++);
			cnet.put(var, new ArrayList<Constraint>());
		}
	}

	public List<Variable> getVariables() {
		return Collections.unmodifiableList(variables);
	}

	public int indexOf(Variable var) {
		return varIndexHash.get(var);
	}

	public Domain getDomain(Variable var) {
		return domains.get(varIndexHash.get(var));
	}

	public void setDomain(Variable var, Domain domain) {
		domains.set(indexOf(var), domain);
	}


	public void removeValueFromDomain(Variable var, Object value) {
		Domain currDomain = getDomain(var);
		List<Object> values = new ArrayList<Object>(currDomain.size());
		for (Object v : currDomain)
			if (!v.equals(value))
				values.add(v);
		setDomain(var, new Domain(values));
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}


	public List<Constraint> getConstraints(Variable var) {
		return cnet.get(var);
	}

	public void addConstraint(Constraint constraint) {
		constraints.add(constraint);
		for (Variable var : constraint.getScope())
			cnet.get(var).add(constraint);
	}


	public Variable getNeighbor(Variable var, Constraint constraint) {
		List<Variable> scope = constraint.getScope();
		if (scope.size() == 2) {
			if (var == scope.get(0))
				return scope.get(1);
			else if (var == scope.get(1))
				return scope.get(0);
		}
		return null;
	}


	public CSP copy() {
		CSP result = new CSP();
		result.variables = variables;
		result.domains = new ArrayList<Domain>(domains.size());
		result.domains.addAll(domains);
		result.constraints = constraints;
		result.varIndexHash = varIndexHash;
		result.cnet = cnet;
		return result;
	}
}