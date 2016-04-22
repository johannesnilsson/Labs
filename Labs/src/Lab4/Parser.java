package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	int index;
	double xCoord;
	double yCoord;	
	
	String sindex;
	String sxC;
	String syC;
	boolean cordFlag = false;
	
	public Parser(){}
	
	public void doParse(){
		File myFile = new File("src/Lab4/testFiles/ulysses22.tsp");
		Scanner scan = null; 
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scan.hasNext()){
			String line = scan.nextLine();
			if(line.compareTo("NODE_COORD_SECTION") != 0 && cordFlag){	
				System.out.println("stuck?");
				continue;
			}
			sindex = scan.next();
			sxC = scan.next();
			syC = scan.next();
//			index = scan.nextInt();
//			xCoord = scan.nextDouble();
//			yCoord = scan.nextDouble();
			System.out.println("the read: index: " + sindex + " xCoord: " + sxC + " yCoord: " + syC);
			
		}
	}
	public static void main(String [] args){
		System.out.println("Running!");
		double myD = 334.5909245845;
		System.out.println(myD);
		Parser myP = new Parser();
		myP.doParse();
	}
}
