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
	// In order to delete multiple chars.
	public String changeCharInPosition(int position, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}
	
	public boolean checkWord(String s){
		int nbrOfBreaks = 0;
		for(int i = 1; i < theWord.length(); i++){
			for(int j = 0; j < s.length(); j++ ){
				//System.out.println("theWord: " + theWord + " s: " + s);
				if(theWord.charAt(i) == s.charAt(j) && i != j){
					//s.replace(s.charAt(j), ' ');
					s =changeCharInPosition(j, '-', s); 
					//System.out.println("s after replace: " + s);
					nbrOfBreaks++;
					break;
				}
			}
		}
		return nbrOfBreaks == (theWord.length() - 1); 
	}
}
