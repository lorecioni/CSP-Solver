package problems;

import CSP.*;

import java.util.ArrayList;
import java.util.List;

/*
 * Personal implementation of the Sudoku puzzle.
 */

public class Sudoku extends CSP {
	
	private Assignment assignments = new Assignment();

	public static List<Variable> collectVariables() {
		List<Variable> variables = new ArrayList<Variable>();

		for (int i = 0; i < 81; i++) {
			variables.add(new Variable("P" + i));
		}
		return variables;
	}

	@SuppressWarnings("unused")
	public Sudoku() {
		super(collectVariables());
		
		Object[] domain = new Object[9];
		for (int i = 0; i < 9; i++) {
			domain[i] = i + 1;
		}

		Domain numbers = new Domain(domain);
		for (Variable var : getVariables())
			setDomain(var, numbers);
		
		AllDifferentConstraint row, column, square;
		
		for (int j = 0; j < 9; j++) {
			row = new AllDifferentConstraint(getRow(j), this);
			column = new AllDifferentConstraint(getColumn(j), this);
		}
		
		square = new AllDifferentConstraint(getSquare(0), this);
		square = new AllDifferentConstraint(getSquare(3), this);
		square = new AllDifferentConstraint(getSquare(6), this);
		square = new AllDifferentConstraint(getSquare(27), this);
		square = new AllDifferentConstraint(getSquare(30), this);
		square = new AllDifferentConstraint(getSquare(33), this);
		square = new AllDifferentConstraint(getSquare(54), this);
		square = new AllDifferentConstraint(getSquare(57), this);
		square = new AllDifferentConstraint(getSquare(60), this);

//		
		//Initial assignment of the variables
		assignVar(2, 9);
		assignVar(6, 7);
		assignVar(10, 4);
		assignVar(12, 5);
		assignVar(14, 9);
		assignVar(16, 1);
		assignVar(18, 3);
		assignVar(22, 1);
		assignVar(26, 2);
		assignVar(28, 1);
		assignVar(31, 6);
		assignVar(34, 7);
		assignVar(38, 2);
		assignVar(39, 7);
		assignVar(41, 1);
		assignVar(42, 8);
		assignVar(46, 5);
		assignVar(49, 4);
		assignVar(52, 3);
		assignVar(54, 7);
		assignVar(58, 3);
		assignVar(62, 4);
		assignVar(64, 8);
		assignVar(66, 2);
		assignVar(68, 4);
		assignVar(70, 6);
		assignVar(74, 6);
		assignVar(78, 5);

	}

	private ArrayList<Variable> getRow(int index) {
		ArrayList<Variable> result = new ArrayList<Variable>();
		int value = index * 9;
		for (int i = 0; i < 9; i++) {
			result.add(getVariables().get(value + i));
		}
		return result;
	}

	private ArrayList<Variable> getColumn(int index) {
		ArrayList<Variable> result = new ArrayList<Variable>();
		int value = index;
		for (int i = 0; i < 9; i++) {
			result.add(getVariables().get(value));
			value = value + 9;
		}
		return result;
	}
	
	private ArrayList <Variable> getSquare(int index){
		ArrayList<Variable> result = new ArrayList<Variable>();
		result.add(getVariables().get(index));
		result.add(getVariables().get(index + 1));
		result.add(getVariables().get(index + 2));
		result.add(getVariables().get(index + 9));
		result.add(getVariables().get(index + 10));
		result.add(getVariables().get(index + 11));
		result.add(getVariables().get(index + 18));
		result.add(getVariables().get(index + 19));
		result.add(getVariables().get(index + 20));
		return result;
	}

	public void solve() {
		System.out.println("------");
		System.out.println("Sudoku");
		System.out.println("------");

		Backtracking solver = new Backtracking();
		Assignment solution = solver.solve(this.copy(), assignments);
		if(solution != null){
			showSquare(solution);
		}
		else {
			System.out.println("No solution found");
		}
	}
	
	public void assignVar(int index, Object value){
		assignments.setAssignment(getVariables().get(index), value);
		
	}

	private void showSquare(Assignment solution){
		for (int i = 0; i < getVariables().size(); i++){
			
			if (i % 3 == 0 && i != 0 && i% 9 != 0){
				System.out.print("  |");
			}
			if (i % 9 == 0){
				System.out.print("\n");
			}
			if (i % 27 == 0 && i != 0){
				System.out.println("  -------------------------------");
			}
			System.out.print("  " + solution.getAssignment(getVariables().get(i)));
		}
		System.out.println("\n");
	}
	
	public Assignment getAssignment(){
		return assignments;
	}
	

}