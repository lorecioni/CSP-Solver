package problems;

import CSP.*;

import java.util.ArrayList;
import java.util.List;

/*
 * CSP Lib: pro019
 * 
 * An order n magic square is a n by n matrix containing the numbers 1 to n^2, with each row, 
 * column and main diagonal equal the same sum. As well as finding magic squares, we are 
 * interested in the number of a given size that exist.
 * 
 * The matrix dimension is given in the constructor.
 * 
 * Personal implementation.
 */

public class MagicSquare extends CSP {

	// Square dimension
	private int dimension;
	private int sum;

	private static List<Variable> collectVariables(int n) {
		List<Variable> variables = new ArrayList<Variable>();

		for (int i = 0; i < (n * n); i++) {
			variables.add(new Variable("P" + i));
		}
		return variables;
	}

	public MagicSquare(int n) {
		super(collectVariables(n));
		
		float magic = ((1f / 2f) * (n) * (n * n + 1));
		this.sum = (int) magic;
		
		this.dimension = n;

		Object[] domain = new Object[n * n];
		for (int i = 0; i < (n * n); i++) {
			domain[i] = i + 1;
		}

		Domain numbers = new Domain(domain);
		for (Variable var : getVariables())
			setDomain(var, numbers);

		addConstraint(new AllDifferentConstraint(getVariables()));

		for (int j = 0; j < dimension; j++) {
			addConstraint(new ExactSumConstraint(getRow(getVariables(), j), sum));
			addConstraint(new ExactSumConstraint(getColumn(getVariables(), j),
					sum));
		}
		addConstraint(new ExactSumConstraint(getDiagonalLeft(getVariables()),
				sum));
		addConstraint(new ExactSumConstraint(getDiagonalRight(getVariables()),
				sum));

	}

	private ArrayList<Variable> getRow(List<Variable> vars, int index) {
		ArrayList<Variable> result = new ArrayList<Variable>();
		int value = index * dimension;
		for (int i = 0; i < dimension; i++) {
			result.add(vars.get(value + i));
		}
		return result;
	}

	private ArrayList<Variable> getColumn(List<Variable> vars, int index) {
		ArrayList<Variable> result = new ArrayList<Variable>();
		int value = index;
		for (int i = 0; i < dimension; i++) {
			result.add(vars.get(value));
			value = value + dimension;
		}
		return result;
	}

	private ArrayList<Variable> getDiagonalLeft(List<Variable> vars) {
		ArrayList<Variable> result = new ArrayList<Variable>();
		int value = 0;
		for (int i = 0; i < dimension; i++) {
			result.add(vars.get(value));
			value = value + dimension + 1;
		}
		return result;
	}

	private ArrayList<Variable> getDiagonalRight(List<Variable> vars) {
		ArrayList<Variable> result = new ArrayList<Variable>();
		int value = dimension - 1;
		for (int i = 0; i < dimension; i++) {
			result.add(vars.get(value));
			value = value + (dimension - 1);
		}
		return result;
	}

	public void solve() {
		System.out.println("--------------------");
		System.out
				.print("Magic square (" + dimension + " x " + dimension + ")");
		System.out.print("\t[Sum = " + sum + "]\n");
		System.out.println("--------------------");

		Backtracking solver = new Backtracking();
		Assignment solution = solver.solve(this.copy());
		if (solution != null) {
			showSquare(solution);
		} else {
			System.out.println("No solution found");
		}

	}

	private void showSquare(Assignment solution) {
		for (int i = 0; i < getVariables().size(); i++) {
			if (i % dimension == 0) {
				System.out.print("\n");
			}
			System.out.print("  "
					+ solution.getAssignment(getVariables().get(i)));
		}
		System.out.println("\n");
	}
}