package myTestobjects;

public class Pair {
	
	private Points p1;
	private Points p2;
	private int ID1;
	private int ID2;
	private double distance;

	public Pair(Points p1,int ID1, Points p2, int ID2, double distance){
		this.p1 = p1;
		this.p2 = p2;
		this.ID1 = ID1;
		this.ID2 = ID2;
		this.distance = distance;
	}
	public double getDistance(){
		return Math.abs(distance);
	}
	
	public Pair getPair(){
		return this;
	}
	
	public Points getP1(){
		return p1;
	}
	public Points getP2(){
		return p2;
	}
	public int getID1(){
		return ID1;
	}
	public int getID2(){
		return ID2;
	}
	public static Pair setPair(Points p1, Points p2, double distance){
		Pair temp = new Pair(p1,p1.getID(),p2,p2.getID(),distance);
		return temp; 
	}



}
