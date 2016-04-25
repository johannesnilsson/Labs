package myTestobjects;
public class Points {
	
	private double x;
	private double y;
	private int ID;
	// create point with coordinate x,y
	public Points(int ID,double x, double y){
		this.ID = ID;
		this.x = x;
		this.y = y;
	}
	//return x coordinate
	public double getX(){
		return x;
	}
	//return y coordinate
	public double getY(){
		return y;
	}
	public int getID(){
		return ID;
	}
	// return true if this x coordinate is greater then point p x coordinate
	public boolean xGreater(Points p){
		return x > p.getX();
	}
	// return true if this y coordinate is greater then point p y coordinate
	public boolean yGreater(Points p){
		return y > p.getY();
	}

}
