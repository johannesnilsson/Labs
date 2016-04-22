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
	
	public Parser(){}
	
	public void doParse(String filename){
		String filepath = "src/Lab4/testFiles/" + filename + ".tsp";
		File myFile = new File(filepath);
		Scanner scan = null; 
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scan.hasNext()){
			if(!scan.hasNextInt()){
				scan.nextLine();
				//System.out.println("stuck?");
				continue;
			}
			sindex = scan.next();
			sxC = scan.next();
			syC = scan.next();
			index = Integer.parseInt(sindex);
			xCoord = Double.parseDouble(sxC);
			yCoord = Double.parseDouble(syC);
			//System.out.println("the read: index: " + sindex + " xCoord: " + sxC + " yCoord: " + syC);
			//System.out.println("the parsed index: " + index + " x: " + xCoord + " y: " + yCoord);
		}
	}
	public static void main(String [] args){
		System.out.println("Parsing...");
		Parser myP = new Parser();
		long time = System.currentTimeMillis();
		myP.doParse("a280");
		myP.doParse("ch150");
		myP.doParse("d18512");
		myP.doParse("pla85900");
		myP.doParse("usa13509");
		long result = System.currentTimeMillis() - time;
		System.out.println("Done! Proccessed in: " + result + " ms.");
	}
}
