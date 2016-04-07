package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	static List<Word> wordLadder = new ArrayList<Word>();
	
	public static void main(String [] args){
		File myFile = new File("C:\\Users\\Johannes\\Documents\\LOL\\lab2\\src\\lab2\\words-10.dat");
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
	}
}
