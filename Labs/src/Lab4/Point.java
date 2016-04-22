package Lab4;
public class Point {
	
	private double x;
	private double y;
	// create point with coordinate x,y
	public Point(double x, double y){
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
	// return true if this x coordinate is greater then point p x coordinate
	public boolean xGreater(Point p){
		return x > p.getX();
	}
	// return true if this y coordinate is greater then point p y coordinate
	public boolean yGreater(Point p){
		return y > p.getY();
	}

}
