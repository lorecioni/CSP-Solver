package CSP;

import util.FIFOQueue;
import java.util.List;

/**
 * Artificial Intelligence A Modern Approach (3rd Ed.): Figure 6.3, Page 209.
 * https://aima-java.googlecode.com/svn/trunk/aima-core/src/main/java/aima/core/search/csp/AC3Strategy.java

Implementation of the MAC Algorithm
 */
public class AC3 {

	public DomainRestore reduceDomains(CSP csp) {
		DomainRestore result = new DomainRestore();
		FIFOQueue<Variable> queue = new FIFOQueue<Variable>();
		for (Variable var : csp.getVariables())
			queue.add(var);
		reduceDomains(queue, csp, result);
		return result.compactify();
	}

	public DomainRestore reduceDomains(Variable var, Object value, CSP csp, Assignment assignment) {
		DomainRestore result = new DomainRestore();
		Domain domain = csp.getDomain(var);
		if (domain.contains(value)) {
			if (domain.size() > 1) {
				FIFOQueue<Variable> queue = new FIFOQueue<Variable>();
				queue.add(var);
				result.storeDomainFor(var, domain);
				csp.setDomain(var, new Domain(new Object[] { value }));
				reduceDomains(queue, csp, result);
			}
		} else {
			result.setEmptyDomainFound(true);
		}
		return result.compactify();
	}

	private void reduceDomains(FIFOQueue<Variable> queue, CSP csp,
			DomainRestore info) {
		while (!queue.isEmpty()) {
			Variable var = queue.pop();
			for (Constraint constraint : csp.getConstraints(var)) {
				if (constraint.getScope().size() == 2) {
					Variable neighbor = csp.getNeighbor(var, constraint);
					if (revise(neighbor, var, constraint, csp, info)) {
						if (csp.getDomain(neighbor).isEmpty()) {
							info.setEmptyDomainFound(true);
							return;
						}
						queue.push(neighbor);
					}
				}
			}
		}
	}
	
	private void reduceDomains(FIFOQueue<Variable> queue, CSP csp,
			DomainRestore info, Assignment assignment) {
		while (!queue.isEmpty()) {
			Variable var = queue.pop();
			for (Constraint constraint : csp.getConstraints(var)) {
				if (constraint.getScope().size() == 2) {
					Variable neighbor = csp.getNeighbor(var, constraint);
					if (!assignment.hasAssignmentFor(neighbor)){
						if (revise(neighbor, var, constraint, csp, info)) {
							if (csp.getDomain(neighbor).isEmpty()) {
								info.setEmptyDomainFound(true);
								return;
							}
							queue.push(neighbor);
						}
					}
				}
				else if (constraint.getScope().size() > 2){
					List <Variable> scope = constraint.getScope();
					for (Variable neigh : scope){
						if (!assignment.hasAssignmentFor(neigh)){
							if (revise(neigh, var, constraint, csp, info)) {
								if (csp.getDomain(neigh).isEmpty()) {
									System.out.println("empty");
									info.setEmptyDomainFound(true);
									return;
								}
								queue.push(neigh);
							}
						}
					}
				}
				
			}
		}
	}

	private boolean revise(Variable xi, Variable xj, Constraint constraint,
			CSP csp, DomainRestore info) {
		boolean revised = false;
		Assignment assignment = new Assignment();
		for (Object iValue : csp.getDomain(xi)) {
			assignment.setAssignment(xi, iValue);
			boolean consistentExtensionFound = false;
			for (Object jValue : csp.getDomain(xj)) {
				assignment.setAssignment(xj, jValue);
				if (constraint.isSatisfiedWith(assignment)) {
					consistentExtensionFound = true;
					break;
				}
			}
			if (!consistentExtensionFound) {
				info.storeDomainFor(xi, csp.getDomain(xi));
				csp.removeValueFromDomain(xi, iValue);
				revised = true;
			}
		}
		return revised;
	}
}
