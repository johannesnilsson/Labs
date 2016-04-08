package Lab2;

import java.util.*;

public class Main {
	static List<Word> wordLadder = new ArrayList<Word>();
	
	public static void main(String [] args){
		// create graph get input file of words
		ReadIO myIO = new ReadIO();
		wordLadder = myIO.createGraphs(args[0]);//args[0]);
		System.out.println(args[0]); // print .dat file
		System.out.println(args[1]); // print test.in file
		myIO.readInput(args[1]);		//read compare file
	}		
}
