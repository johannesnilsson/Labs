package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	static List<Word> wordLadder = new ArrayList<Word>();
	
	public static void main(String [] args){
		
		//File myFile = new File("C:\\Users\\Johannes\\GITHUB2\\Labs\\src\\Lab2\\words-10.dat");
		File myFile = new File("/Users/emirhusic/git/Labs/Labs/src/Lab2/words-10.dat");
		Scanner scan = null; //kommentar
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
	        
	        for(int a=0; a<wordLadder.size(); a++) //index for words
	        {    
	        	Word currentWord = wordLadder.get(a); // keeps the current word
	        	for(int i=0; i < wordLadder.size(); i++) // comparing index
	        	{
	        		Word compareWord = wordLadder.get(i);	// get comparison word
	        		if(currentWord.checkWord(compareWord.getName())) // check if word is match
	        		{
	        			currentWord.addNeighbour(i);; // add the index of match
	        		}
	        	}
	        }
	        for(int i = 0; i < wordLadder.size(); i++)
	        {
	        	System.out.println(" theName: " +wordLadder.get(i).getName());
	        	for(int j = 0; j < wordLadder.get(i).neighbours.size(); j++)
	        	{
	        		System.out.print(" " +wordLadder.get(wordLadder.get(i).neighbours.get(j)).getName());
	        	}
	        	System.out.println();
	        }
	}		
}
