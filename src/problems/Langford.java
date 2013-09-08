package problems;

import CSP.*;

import java.util.ArrayList;
import java.util.List;

/*
 * CSP Lib: pro019
 * 
 * Consider two sets of the numbers from 1 to 4. The problem is to arrange the eight numbers 
 * in the two sets into a single sequence in which the two 1's appear one number apart, the 
 * two 2's appear two numbers apart, the two 3's appear three numbers apart, and the two 4's 
 * appear four numbers apart.
 * 
 * Also in this case I use colors instead of numbers to display the solution.
 * 
 * Personal implementation.
 */

public class Langford extends CSP {

	public static final String RED = "RED";
	public static final String BLACK = "BLACK";
	public static final String BLUE = "BLUE";
	public static final String YELLOW = "YELLOW";

	public static final int BLACK_VALUE = 1;
	public static final int RED_VALUE = 2;
	public static final int BLUE_VALUE = 3;
	public static final int YELLOW_VALUE = 4;

	private static List<Variable> collectVariables() {
		List<Variable> variables = new ArrayList<Variable>();

		for (int i = 0; i < (8); i++) {
			variables.add(new Variable("P" + i));
		}
		return variables;
	}

	public Langford() {
		super(collectVariables());

		Domain colors = new Domain(new Object[] { RED, BLACK, BLUE, YELLOW });

		for (Variable var : getVariables())
			setDomain(var, colors);

		addConstraint(new PairConstraint(getVariables(), RED));
		addConstraint(new PairConstraint(getVariables(), BLUE));
		addConstraint(new PairConstraint(getVariables(), YELLOW));
		addConstraint(new PairConstraint(getVariables(), BLACK));

		for (int i = 0; i < getVariables().size(); i++) {
			addConstraint(new PositionConstraint(getVariables()));
		}

	}

	public void solve() {
		System.out.println("--------");
		System.out.print("Langford");
		System.out.print("\t[BLACK = " + BLACK_VALUE + ", RED = " + RED_VALUE + ", BLUE = "
				+ BLUE_VALUE + ", YELLOW = " + YELLOW_VALUE + "]\n");
		System.out.println("--------\n");

		Backtracking solver = new Backtracking();
		Assignment solution = solver.solve(this.copy());
		if (solution != null) {
			showColors(solution);
		} else {
			System.out.println("No solution found");
		}
	}

	private void showColors(Assignment solution) {
		ArrayList<String> colors = new ArrayList<String>();
		String value;

		for (Variable var : getVariables()) {
			value = (String) solution.getAssignment(var);
			colors.add(value);
		}

		System.out.println(colors);
		System.out.println("");
	}
}