package Lab2;

import java.util.*;

public class BFS {
	
	Queue<Word> myQueue = new ArrayDeque<Word>();
	//boolean[] discovered = new boolean[]; // stolek??
	int layerCounter = 0;
	List<Word> wordLadder;
	String begin;
	String end;
	
	public BFS(List<Word> wordLadder, String begin, String end){
		this.wordLadder = wordLadder;
		this.begin = begin;
		this.end = end;
		
		//doit(); // do it

	}
	
	public int doit(){
		if(begin.equals(end)) return 0;
		int root = -1; // index of root
		for(int i = 0; i<wordLadder.size(); i++){
		//	System.out.println(wordLadder.get(i).getName());
			wordLadder.get(i).setDistance(-1); // reset distance
			if(begin.equals(wordLadder.get(i).getName())){
				root = i;
			//	System.out.println("root became = " + i);
			
			//	System.out.println("the root word: " + wordLadder.get(i).getName());
			}//root = i; // find index same time
		}
		//if(root == -1) return -2; // if we did not find match of word
		
		myQueue.add(wordLadder.get(root));
	//	if(wordLadder.get(root).equals(end)) return 0;
		wordLadder.get(root).setDistance(0);
		
		Word current = null; //temp holder
		while(!myQueue.isEmpty()){
			current = myQueue.poll();
			
			for(int j = 0; j < current.neighbours.size(); j++){
				int indexOfNextWord = current.neighbours.get(j);
				if(wordLadder.get(indexOfNextWord).distance == -1){
					wordLadder.get(indexOfNextWord).distance = current.distance + 1;
					myQueue.add(wordLadder.get(indexOfNextWord));
					
				//	System.out.println("the last comparison: " + wordLadder.get(indexOfNextWord).getName());
					if(end.equals(wordLadder.get(indexOfNextWord).getName())){
						return current.distance + 1;
					}
				}
			}
		}
		
		System.out.println("the queue became empty");
		return -1;
	}
}
