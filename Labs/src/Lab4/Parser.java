package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
	ArrayList<Point> result = null;
	int index;
	double xCoord;
	double yCoord;	
	
	String sindex;
	String sxC;
	String syC;
	
	public Parser(){}
	
	public ArrayList<Point> doParse(String filename){
		String nbrOfEntries = filename.replaceAll( "[^\\d]", "" );
		result = new ArrayList<Point>(Integer.parseInt(nbrOfEntries));
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
				continue;
			}
			sindex = scan.next();
			sxC = scan.next();
			syC = scan.next();
			index = Integer.parseInt(sindex);
			xCoord = Double.parseDouble(sxC);
			yCoord = Double.parseDouble(syC);
			result.add(new Point(index, xCoord, yCoord));
		}
		
//		for(Point p : result){
//			System.out.println("ID: " + p.getID() + " xC: " + p.getX() + " yC: " + p.getY());
//		}
		
		return result;
	}
	public static void main(String [] args){
		System.out.println("Parsing...");
		Parser myP = new Parser();
		long time = System.currentTimeMillis();
		myP.doParse("pla85900");
//		myP.doParse("usa13509");
		long result = System.currentTimeMillis() - time;
		System.out.println("Done! Proccessed in: " + result + " ms.");
	}
}
