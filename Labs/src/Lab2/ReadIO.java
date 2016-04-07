package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadIO {
	static List<Word> wordLadder = new ArrayList<Word>();
	//BFS myBFS = new BFS(wordLadder,"write","their");
	public ReadIO(){};
	
	public List<Word> createGraphs(String fileName){
		//File myFile = new File("C:\\Users\\Johannes\\GITHUB2\\Labs\\src\\Lab2\\words-10.dat");
		String s = "/Users/emirhusic/git/Labs/Labs/src/Lab2/";
		File myFile = new File(s + fileName);
		Scanner scan = null; //kommentar
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	   
	        while(scan.hasNext()){
	        	String wordToAdd = scan.nextLine();
	       // 	System.out.println("Adding " + wordToAdd + " to the List");
	        	wordLadder.add(new Word(wordToAdd));
	        //	System.out.println("SUG");
	        }
	        
	        for(int a=0; a<wordLadder.size(); a++) //index for words
	        {    
	        	Word currentWord = wordLadder.get(a); // keeps the current word
	        	for(int i=0; i < wordLadder.size(); i++) // comparing index
	        	{
	        		Word compareWord = wordLadder.get(i);	// get comparison word
	        		if(currentWord.checkWord(compareWord.getName()) && !currentWord.getName().equals(wordLadder.get(i).getName())) // check if word is match
	        		{
	        			currentWord.addNeighbour(i);; // add the index of match
	        		}
	        	}
	        }

			return wordLadder;
	}
	public void readInput(String fileName){
		ArrayList<Integer> output = new ArrayList<Integer>();
		String s = "/Users/emirhusic/git/Labs/Labs/src/Lab2/";
		File myFile = new File(s + fileName);
		Scanner scan = null; //kommentar
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scan.hasNext()){
			String begin = scan.next(); // osäker shittos
			String end = scan.next();		//osäker shittos
			BFS myBFS = new BFS(wordLadder,begin,end);
			output.add(myBFS.doit()); // add d to list						
		}
		writeToFile(output);
		//return null;
	}

	private void writeToFile(ArrayList<Integer> doit) {
		
		for(int i = 0; i < doit.size(); i++){
			System.out.println(doit.get(i));
		}		
	}

}
