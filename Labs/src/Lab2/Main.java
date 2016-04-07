package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	static List<Word> wordLadder = new ArrayList<Word>();
	
	public static void main(String [] args){
		
		File myFile = new File("C:\\Users\\Johannes\\GITHUB2\\Labs\\src\\Lab2\\words-10.dat");
		//File myFile = new File("/Users/emirhusic/git/Labs/Labs/src/Lab2/words-10.dat");
		Scanner scan = null;
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	   
	        while(scan.hasNext()){
	        	String wordToAdd = scan.nextLine();
	        	System.out.println("Adding " + wordToAdd + " to the List");
	        	wordLadder.add(new Word(wordToAdd));
	        	System.out.println("SUG");
	        }
	        List<Integer> tempForNeighbors = null; // handle temp neighbors
	        
	        for(int i=0; i < wordLadder.size(); i++){
	        	//System.out.println("hahaha");
	        	
	        }
	}	
	
}
