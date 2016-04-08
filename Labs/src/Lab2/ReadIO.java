package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadIO {
	static List<Word> wordLadder = new ArrayList<Word>();
	private String fileName;
	public ReadIO(){};
	
	public List<Word> createGraphs(String fileName){
		//File myFile = new File("C:\\Users\\Johannes\\GITHUB2\\Labs\\src\\Lab2\\words-10.dat");
		String s = "/Users/emirhusic/git/Labs/Labs/src/Lab2/"; //your working directory
		File myFile = new File(s + fileName);
		Scanner scan = null; 
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	        while(scan.hasNext()){
	        	String wordToAdd = scan.nextLine();	   
	        	wordLadder.add(new Word(wordToAdd));
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
		this.fileName = fileName;
		ArrayList<Integer> output = new ArrayList<Integer>();
		String s = "/Users/emirhusic/git/Labs/Labs/src/Lab2/";
		File myFile = new File(s + fileName);
		Scanner scan = null;
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scan.hasNext()){
			String begin = scan.next(); 
			String end = scan.next();
			BFS myBFS = new BFS(wordLadder,begin,end);
			output.add(myBFS.doit()); // add d to list						
		}
		writeToFile(output);
	}

	private void writeToFile(ArrayList<Integer> doit) {
		String ourOutPutFile = fileName + " ";
		ourOutPutFile = changeToOut(ourOutPutFile); // our output

		ArrayList<String> distances = new ArrayList<String>();
		for(int i =0; i<doit.size(); i++){
			distances.add(doit.get(i).toString());
		}
		Path file = Paths.get("/Users/emirhusic/git/labs/labs/src/lab2/RESULT-" +ourOutPutFile);
		try {
			Files.write(file, distances, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//modify to .out
	public String changeToOut(String s){
		char[] charArray = s.toCharArray();
		charArray[s.length() - 3] = 'o';
		charArray[s.length() - 2] = 'u';
		charArray[s.length() - 1] = 't';
		return new String(charArray);
	}
}
