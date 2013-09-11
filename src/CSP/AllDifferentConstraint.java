package CSP;

import java.util.List;

/**
 * Personal implementation of AllDifferent constraint.
 * The constraint is satisfied if all the variables in the given array are different each others.
 */

public class AllDifferentConstraint {
	public AllDifferentConstraint(List <Variable> variables, CSP csp) {		
		for(int i = 0; i < variables.size(); i++){		
			Variable var1 = variables.get(i);
				for (int j = 0; j < variables.size(); j++){
					if(i != j){
						csp.addConstraint(new NotEqualConstraint(var1, variables.get(j)));
					}
				}		
		}
	}
}
