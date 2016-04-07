package Lab2;

import java.util.*;

public class Word {
	String theWord = null;
	List<Integer> neighbours = null;

	public Word(String word){
		theWord = word;
		neighbours = new ArrayList<Integer>();
	}
	
	public String getName(){
		return theWord;
	}
	
	public void addNeighbour(int x){
		neighbours.add(x);
	}
	
	public boolean checkWord(String s){
		int nbrOfBreaks = 0;
		for(int i = 1; i < theWord.length(); i++){
			for(int j = 0; j < s.length(); j++ ){
				System.out.println("index i: " + i + " index j: " + j);
				if(theWord.charAt(i) == s.charAt(j)){
					nbrOfBreaks++;
					break;
				}
			}
		}
		
		return nbrOfBreaks == (theWord.length() - 1); 
	}
}
