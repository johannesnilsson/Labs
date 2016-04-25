package myTestobjects;


import java.util.ArrayList;

public class EmkicTest {
		public static void main(String[]args){
			//id,x,y,
		Points p1 = new Points(1,1,1);
		Points p2 = new Points(2,2,2);
		Points p3 = new Points(3,2,4);
		Points p4 = new Points(4,132,3321);
		Points p5 = new Points(5,1434,3);
		Points p6 = new Points(6,14,143);
		
		ArrayList<Points> temp = new ArrayList<Points>();
		temp.add(p1);
		temp.add(p2);
		temp.add(p3);
		temp.add(p4);
		temp.add(p5);
//		temp.add(p6);
		//public ClosestPair(ArrayList<Points> points){
		
			ClosestPair test = new ClosestPair(temp);
	}
}
