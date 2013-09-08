package CSP;

import java.util.ArrayList;
import java.util.List;

/**
 * Personal implementation of AllDifferent constraint.
 * The constraint is satisfied if all the variables in the given array are different each others.
 */

public class AllDifferentConstraint implements Constraint {

	private List <Variable> variables;
	private List<Variable> scope;

	public AllDifferentConstraint(List <Variable> variables) {
		this.variables = variables;
		scope = new ArrayList<Variable>(variables.size());
		scope = variables;
	}

	@Override
	public List<Variable> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		for(int i = 0; i < variables.size(); i++){		
			Object value = assignment.getAssignment(variables.get(i));
			if (value != null){
				for (int j = 0; j < variables.size(); j++){
					if(i != j){
						if(value == assignment.getAssignment(variables.get(j))){
							return false;
						}		
					}
				}
			}
		}
		return true;
	}
}
