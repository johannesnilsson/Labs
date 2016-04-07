package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	static List<Word> wordLadder = new ArrayList<Word>();
	
	public static void main(String [] args){
		
		// create graph get input file of words
		ReadIO myIO = new ReadIO();
		wordLadder = myIO.createGraphs(args[0]);//args[0]);
		System.out.println(args[0]);
		System.out.println(args[1]);
		myIO.readInput(args[1]);		//read compare file
		
		// get input of compare words.
		        
	       // BFS(List<Word> wordLadder, String begin, String end)
	       // BFS myBFS = new BFS();
	        //System.out.println(myBFS.doit());
	        
	}		
}
