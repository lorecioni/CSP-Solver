package CSP;

/**
 * Artificial Intelligence A Modern Approach (3rd Ed.): Figure 6.5, Page 215.<br>
 * https://aima-java.googlecode.com/svn/trunk/aima-core/src/main/java/aima/core/search/csp/BacktrackingStrategy.java
 * 
 * Partly modified and extended.
 * It uses the AC3 algorithm to reduce variables domains first. 
 */
public class Backtracking extends Solution {

	public Assignment solve(CSP csp) {
		DomainRestore info = new AC3().reduceDomains(csp);
		if (!info.isEmpty()) {
			if (info.isEmptyDomainFound())
				return null;
		}
		return recursiveBackTrackingSearch(csp, new Assignment());
	}
	
	public Assignment solve(CSP csp, Assignment assignment) {
		DomainRestore info = new AC3().reduceDomains(csp);
		if (!info.isEmpty()) {
			if (info.isEmptyDomainFound())
				return null;
		}
		return recursiveBackTrackingSearch(csp, assignment);
	}

	private Assignment recursiveBackTrackingSearch(CSP csp,
			Assignment assignment) {
		Assignment result = null;
		if (assignment.isComplete(csp.getVariables())) {
			result = assignment;
		} else {
			Variable var = selectUnassignedVariable(assignment, csp);
			for (Object value : orderDomainValues(var, assignment, csp)) {
				assignment.setAssignment(var, value);
				
				if (assignment.isConsistent(csp.getConstraints(var))) {
					DomainRestore info = inference(var, assignment, csp);
					if (!info.isEmpty())
					if (!info.isEmptyDomainFound()) {
						result = recursiveBackTrackingSearch(csp, assignment);
						if (result != null)
							break;
					}
					info.restoreDomains(csp);
				}
				assignment.removeAssignment(var);
			}
		}
		return result;
	}

	protected Variable selectUnassignedVariable(Assignment assignment, CSP csp) {
		for (Variable var : csp.getVariables()) {
			if (!(assignment.hasAssignmentFor(var)))
				return var;
		}
		return null;
	}

	protected Iterable<?> orderDomainValues(Variable var,
			Assignment assignment, CSP csp) {
		return csp.getDomain(var);
	}

	protected DomainRestore inference(Variable var, Assignment assignment,
			CSP csp) {
			return new AC3().reduceDomains(var,
					assignment.getAssignment(var), csp);
	}

}
