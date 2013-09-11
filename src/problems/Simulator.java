package problems;
import gui.*;
import java.text.DecimalFormat;

@SuppressWarnings("unused")
public class Simulator {
	public static void main(String [] args) {
		
		double startTime = System.currentTimeMillis(); 
		Runtime runtime = Runtime.getRuntime();
		
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
		
		Sudoku sudoku = new Sudoku();
		sudoku.solve();
		
		usedTimeMemory(startTime, runtime);
	
	}
	
	public static void usedTimeMemory(double startTime, Runtime rt){
		
		float mb = (1024*1024);
		//Print used memory
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(3);
        System.out.println("Used Memory: "
            + df.format((rt.totalMemory() - rt.freeMemory())/mb) + " Mb");
        
        //.Print computation time
        double endTime = System.currentTimeMillis(); 
        
        double time = (endTime - startTime)/1000;
        System.out.println("Time: " + df.format(time) + " s");
	}
}
