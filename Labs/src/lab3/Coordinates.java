package lab3;

import java.util.ArrayList;

public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getY(){
		return y;
	}

	public int getX(){
		return x;
	}
	public static boolean containsCoord(int x,int y, ArrayList<Coordinates> coordinates){
		if(coordinates == null) return false;
		
		for(int i = 0; i<coordinates.size(); i++){
			if(coordinates.get(i).getX() == x && coordinates.get(i).getY() == y){
				return true;
			}
		}
		
		return false;
		
	}
}
