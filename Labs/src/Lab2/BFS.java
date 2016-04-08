package Lab2;

import java.util.*;

public class BFS {
	
	Queue<Word> myQueue = new ArrayDeque<Word>();
	int layerCounter = 0;
	List<Word> wordLadder;
	String begin;
	String end;
	
	public BFS(List<Word> wordLadder, String begin, String end){
		this.wordLadder = wordLadder;
		this.begin = begin;
		this.end = end;
	}
	
	public int doit(){
		if(begin.equals(end)) return 0;
		int root = -1; // index of root
		for(int i = 0; i<wordLadder.size(); i++){
			wordLadder.get(i).setDistance(-1); // reset distance
			if(begin.equals(wordLadder.get(i).getName())){
				root = i;
			}
		}
		myQueue.add(wordLadder.get(root));
		wordLadder.get(root).setDistance(0);
		
		Word current = null; //temp holder
		while(!myQueue.isEmpty()){
			current = myQueue.poll();
			for(int j = 0; j < current.neighbours.size(); j++){
				int indexOfNextWord = current.neighbours.get(j);
				if(wordLadder.get(indexOfNextWord).distance == -1){
					wordLadder.get(indexOfNextWord).distance = current.distance + 1;
					myQueue.add(wordLadder.get(indexOfNextWord));
					
					if(end.equals(wordLadder.get(indexOfNextWord).getName())){
						return current.distance + 1;
					}
				}
			}
		}
		//System.out.println("the queue became empty");
		return -1;
	}
}
