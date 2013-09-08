package problems;

public class Simulator {
	public static void main(String [] args) {
		
		//Create an instance of magic square problem with dimension given in command line
		int dimension;
		if (args.length == 0){
			dimension = 3; //Default value
		}
		else {
			dimension = Integer.parseInt(args[0]);
		}
		MagicSquare magicSquare = new MagicSquare(dimension);
		magicSquare.solve();
		
		//Create an instance of Langford problem
		Langford langford = new Langford();
		langford.solve();
	}
}
