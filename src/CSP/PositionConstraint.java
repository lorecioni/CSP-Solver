package CSP;

import java.util.ArrayList;
import java.util.List;

import problems.Langford;

/**
 * Personal implementation of Position Constraint constraint.
 * The constraint is satisfied if a value is found on the correct position (distance) in a set.
 */
public class PositionConstraint implements Constraint {

	private List<Variable> variables;
	private List<Variable> scope;

	public PositionConstraint(List<Variable> variables) {
		this.variables = variables;
		scope = new ArrayList<Variable>();
		scope = variables;
	}

	@Override
	public List<Variable> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		int distance, index;
		distance = index = 0;
		Object value;

		if (assignment.isComplete(variables)) {
			for (int j = 0; j < variables.size() ; j++) {
				value = assignment.getAssignment(variables.get(j));
				distance = getDistance(value);
				index = getVarIndex(variables.get(j));
								
				boolean pre, post;
				pre = false;
				post = false;

				if (index - (distance + 1) >= 0) {
					if (value == assignment.getAssignment(variables.get(index - (distance + 1)))){
						
						pre = true;
					}
				}
				
				if (index + (distance + 1) < variables.size()) {
					if (value == assignment.getAssignment(variables.get(index + (distance + 1)))){
						
						post = true;
						}
				}
				
				if ((pre || post) == false){
					return false;
				}
			}
			return true;
		}

		for (int i = 0; i < variables.size(); i++) {
			value = assignment.getAssignment(variables.get(i));
			index = getVarIndex(variables.get(i));
			distance = getDistance(value);

			for (int j = 1; j <= distance; j++) {
				if ((index + j) < variables.size()) {
					if (value == assignment.getAssignment(variables.get(index
							+ j))) {
						return false;
					}
				}
				if ((index - j) >= 0) {
					if (value == assignment.getAssignment(variables.get(index
							- j))) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private int getDistance(Object value) {
		int distance = 0;
		if (value == "BLACK") {
			distance = Langford.BLACK_VALUE;
		} else if (value == "RED") {
			distance = Langford.RED_VALUE;
		} else if (value == "BLUE") {
			distance = Langford.BLUE_VALUE;
		} else if (value == "YELLOW") {
			distance = Langford.YELLOW_VALUE;
		}
		return distance;
	}

	private int getVarIndex(Variable var) {
		boolean found = false;
		int index = 0;
		while (found == false && index < variables.size()) {
			if (variables.get(index) == var) {
				found = true;
			}
			index++;
		}
		index = index - 1;
		return index;
	}
}
