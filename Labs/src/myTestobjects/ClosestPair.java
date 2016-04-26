package myTestobjects;

import java.util.*;
import java.util.ArrayList;

public class ClosestPair {
	private ArrayList<Points> xSort;
	private ArrayList<Points> ySort;
	private ArrayList<Points> P;
	
	public ClosestPair(ArrayList<Points> points,String fileName, String nbrOfEntries){
		this.P = points;
		//print(P);
		
		// comes in all points
		// make 2 sorted list of the points.
		xSort = sortList(points,"x"); // the sort takes O(n log n) time
		ySort = sortList(points,"y");
		//print(xSort);

		Pair minimum = closestPairRec(xSort,ySort);
		System.out.println(fileName +" " +nbrOfEntries +" " +minimum.getDistance());
		System.out.println("Between points ID:" +minimum.getP1().getID() +" - ID:" +minimum.getP2().getID());


	}
	
	public Pair closestPairRec(ArrayList<Points> Px, ArrayList<Points> Py){
		
		if(Px.size() <= 3){
			Pair minPair = bfClosest(Px);
		//	System.out.println("The min distance is: " +minPair.getDistance());
		//	System.out.println("Between points ID:" +minPair.getP1().getID() +" - ID:" +minPair.getP2().getID());
			return minPair;
		}
	
		// create Qx,Qy, Rx,Ry
		ArrayList<Points> Qx = new ArrayList<Points>(Px.size()/2);
		ArrayList<Points> Qy = new ArrayList<Points>(Px.size()/2);
		ArrayList<Points> Rx = new ArrayList<Points>(Px.size()/2);
		ArrayList<Points> Ry = new ArrayList<Points>(Px.size()/2);
		
		
		int middlePoint = Px.size()/2;
		// both list should be same size,
		for(int i = 0; i < Px.size(); i++){
			if(i < middlePoint){
				Qx.add(Px.get(i));
				Qy.add(Py.get(i));
			}
			else{
				Rx.add(Px.get(i));
				Ry.add(Py.get(i));
			}
		}
		Pair Q = closestPairRec(Qx, Qy); // minimum distance pair of left
		Pair R = closestPairRec(Rx,Ry); // minimum distance pair of right
		
		Pair minPairDistance = null;
		if(distanceTo(Q.getP1(),Q.getP2()) < distanceTo(R.getP1(),R.getP2()) ){ //&& distanceTo(Q.getP1(),Q.getP2()) != 0 ){
			minPairDistance = Q;
		}else{
			minPairDistance = R;
		}
		int maxXCoord = Qx.size(); // this may be incorrect
		int line = maxXCoord; // dont get it this is the vertical line?!
		
		double lambda = minPairDistance.getDistance();
		//create Sy
		ArrayList<Points> Sy = new ArrayList<Points>();
		

		for(int i = 0; i < Py.size(); i++){
			if(Py.get(i).getX() >= line - lambda 
					&& Py.get(i).getX() <= line + lambda
					){//&& minPairDistance.getDistance() != 0){
				Sy.add(Py.get(i));
			}
		}
		System.out.println("printing SY");
		print(Sy);
		//print(Sy);
		//System.out.println("hahahah " + "size of Sy: " +Sy.size());
		//print(Sy);
		
		// for each points in Sy comptue distance to next 15 pts,
		// check if it is smaller then our minpairdist
		
	//	int tempMin;
	//	Pair closePair = Integer.MAX_VALUE;
		if(Sy.size() == 15) {
			print(Sy);
			System.out.println("hahahaahah#############################################################################");
		}
		//System.out.println(Sy.size());
		Pair delta = new Pair(null,-1,null,-1,Integer.MAX_VALUE);
		for(int i =0; i < Sy.size(); i++){
			//System.out.println("size of Sy " +Sy.size());
			if(Sy.size() - i < 15){
				for(int k = i; k < Sy.size(); k++){
					//System.out.println("hahahaahah");
					double distance = distanceTo(Sy.get(i),Sy.get(k));
					if(distance < delta.getDistance() && i != k){ //&& minPairDistance.getDistance() != 0){
					//	System.out.println("we found a smaller distance!!");
						delta = Pair.setPair(Sy.get(i),Sy.get(k), distance);
					//	minPairDistance = new Pair(Sy.get(i),Sy.get(i).getID(),Sy.get(k),Sy.get(k).getID(),distanceTo(Sy.get(i),Sy.get(k)));
					}
				}
			}
			else{
				for(int j = i+1; j<i+15; j++){
					double distance = distanceTo(Sy.get(i),Sy.get(j));
					if(distance < delta.getDistance() && j != i){
					//	System.out.println("we found a smaller distance!!");
				//		System.out.print("it is " +Sy.get(i).getID() +"-" + Sy.get(j).getID());		
						delta = Pair.setPair(Sy.get(i), Sy.get(j), distance);
					//	minPairDistance = new Pair(Sy.get(i),Sy.get(i).getID(),Sy.get(j),Sy.get(j).getID(),distanceTo(Sy.get(i),Sy.get(j)));

					}
		
				}
			}
		}
		
	//	print(Qx);
	//	print(Qy);
	//	print(Rx);
	//	print(Ry);
		System.out.println(delta.getDistance() +"<<<<<    >>>>>" +minPairDistance.getDistance());
		if(delta.getDistance() < minPairDistance.getDistance()){
			return delta;
		}
		return minPairDistance;
	}


	public Pair bfClosest(ArrayList<Points> P){
		
		Pair temp = new Pair(null,-1,null,-1,Integer.MAX_VALUE); //b put integer max
		for(int i = 0; i < P.size() -1; i++){
			double distance = distanceTo(P.get(i),P.get(i+1));
			if(distance < temp.getDistance()){
				temp = Pair.setPair(P.get(i), P.get(i+1), distance);
				//temp = new Pair(P.get(i),P.get(i).getID(),P.get(i+1),P.get(i+1).getID(),distance);
			}
		}
		if(Integer.MAX_VALUE ==temp.getDistance()){
			System.out.println("THE DISTANCE IS BIGGER THEN MAX OF INT ----###############");
		}
		return temp;
	}
	// returns the minimum distance between two points
	// using minimum-Euclidean distance
	public double distanceTo(Points p1, Points p2){
		double distanceX,distanceY,distance;
		distanceX = (p2.getX() - p1.getX())*(p2.getX() - p1.getX());
		distanceY = (p2.getY() - p1.getY())*(p2.getY() - p1.getY());
		distance = Math.sqrt(distanceX + distanceY);
		//System.out.println("the distance is " +distance);
		return distance;
	}
	
	public void print(ArrayList<Points> p){
		for(int i =0; i < p.size(); i++){
			System.out.println(p.get(i).getID() +" - (" +p.get(i).getX() + " , " +p.get(i).getY() +")");
		}
		System.out.println("_______________");
	}
	
	
	public ArrayList<Points> sortList(ArrayList<Points> p, String sortCord){
		// we have only one element
		if(p.size() == 1){
			return p;
		}
		//divide list p in two halves, n/2
		ArrayList<Points> left = new ArrayList<Points>(p.size()/2);
		ArrayList<Points> right = new ArrayList<Points>(p.size()/2);
	
		for(int i =0; i < p.size()/2; i++){
			left.add(p.get(i));
		}
		for(int i =p.size()/2; i < p.size(); i++){
			right.add(p.get(i));
		}
		// Recursively continue splitting
		ArrayList<Points> A = sortList(left,sortCord);
		ArrayList<Points> B = sortList(right,sortCord);
		ArrayList<Points> sortedList = mergeLists(A,B,sortCord);
		
		return sortedList;
	}
	
	public ArrayList<Points> mergeLists(ArrayList<Points> A, ArrayList<Points> B, String sortCord){
		//keep two pointers for each list
		int i = 0, j = 0;
		ArrayList<Points> temp = new ArrayList<Points>(A.size() + B.size());
		
		if(sortCord.equals("x")){
			// there stil exists elements in both lists
			while(i < A.size() && j < B.size()){
				//if x in A is smaller
				if(A.get(i).xGreater(B.get(j))){
					temp.add(B.get(j));
					j++;
				}
				else{
					temp.add(A.get(i));
					i++;
				}
			}	
		}
		
		if(sortCord.equals("y")){
			// there stil exists elements in both lists
			while(i < A.size() && j < B.size()){
				//if x in A is smaller
				if(A.get(i).yGreater(B.get(j))){
					temp.add(B.get(j));
					j++;
				}
				else{
					temp.add(A.get(i));
					i++;
				}
			}
		}
		// we jumped out the while loop, so one list is done.
		// fill the rest from the non empty list.
		while(i < A.size()){
			temp.add(A.get(i));
			i++;
		}
		while(j < B.size()){
			temp.add(B.get(j));
			j++;
		}
		// return the sorted list
		return temp;
	}
}