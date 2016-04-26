package myTestobjects;
import java.util.ArrayList;

public class ClosestPair {
	private ArrayList<Points> xSort;
	private ArrayList<Points> ySort;
	private String names;
	
	public ClosestPair(ArrayList<Points> points,String fileName, String nbrOfEntries){
		
		// make 2 sorted list of the points.
		xSort = sortList(points,"x"); // the sort takes O(n log n) time
		ySort = sortList(points,"y");

		Pair minimum = closestPairRec(xSort,ySort);
		//System.out.println(fileName +" " +nbrOfEntries +" " +minimum.getDistance());
		names = fileName +" " +nbrOfEntries +" " +minimum.getDistance();
		
	}
	
//	private double bruteForceAttack(ArrayList<Points> p) {
//		double tempSize = Integer.MAX_VALUE;
//		for(int i = 0; i < p.size(); i++){
//			for(int j = 0; j < p.size(); j++){
//				if(distanceTo(p.get(i),p.get(j)) < tempSize && i != j){
//					tempSize = distanceTo(p.get(i),p.get(j));
//				//	System.out.println(tempSize +" between pts " +p.get(i).getID() +" "+ p.get(j).getID());
//				}
//			}
//		}
//		return tempSize;
//	}
	public String getFileNames(){
		return names;
	}

	public Pair closestPairRec(ArrayList<Points> Px, ArrayList<Points> Py){		
		if(Px.size() <= 3){
			Pair minPair = bfClosest(Px);
			return minPair;
		}
		// create Qx,Qy, Rx,Ry
		ArrayList<Points> Qx = new ArrayList<Points>(Px.size()/2);
		ArrayList<Points> Qy = new ArrayList<Points>(Py.size()/2);
		ArrayList<Points> Rx = new ArrayList<Points>(Px.size()/2);
		ArrayList<Points> Ry = new ArrayList<Points>(Py.size()/2);
		
		double midCoord = Px.size()/2;
		double line = Px.get(Px.size()/2).getX();

		for(int i = 0; i < Px.size(); i++){
			if(i < midCoord){
				Qx.add(Px.get(i));
			} else{
				Rx.add(Px.get(i));
			}
		}
		
		for(int i =0; i < Py.size(); i++){
			if(Py.get(i).getX() <line){
				Qy.add(Py.get(i));
			}else{
				Ry.add(Py.get(i));
			}
		}

		Pair Q = closestPairRec(Qx, Qy); // minimum distance pair of left
		Pair R = closestPairRec(Rx, Ry); // minimum distance pair of right
		
		double minDistQ = Q.getDistance();
		double minDistR = R.getDistance();
		
		Pair minPairDistance = null;
		
		if(minDistQ < minDistR){ //&& distanceTo(Q.getP1(),Q.getP2()) != 0 ){
			minPairDistance = Q;
		}else{
			minPairDistance = R;
		}
		double lambda = minPairDistance.getDistance();
		double midPoint = Qx.get(Qx.size()-1).getX();
		
		ArrayList<Points> Sy = new ArrayList<Points>();
		for(int i =0; i < Py.size(); i++){
			if(Math.abs(midPoint - Py.get(i).getX()) < lambda){
				Sy.add(Py.get(i));
			}
		}

		for(int i =0; i < Sy.size(); i++){
			Points p1 = Sy.get(i);
			for(int j = i+1; j < Sy.size() && j < i+14; j++){
		//		if(j == i+14) System.out.println("lo########l      " + (j-i));
				Points p2 = Sy.get(j);
//				if(p2.getY() - p1.getY() >= lambda){
//					break;
//				}
				double distance = distanceTo(p1,p2);
				if(distance < minPairDistance.getDistance() && i!=j){
					lambda = distance;
					minPairDistance = Pair.setPair(p1, p2, distance);
				}
			}
		}
		return minPairDistance;
	}

	public Pair bfClosest(ArrayList<Points> P){
		
		if(P.size() < 2){
			return null;
		}
		Pair temp = Pair.setPair(P.get(0), P.get(1), distanceTo(P.get(0),P.get(1)));
		if(P.size() >2){
			for (int i = 0; i < P.size() -1; i++){
				Points point1 = P.get(i);
			       for (int j = i + 1; j < P.size(); j++)
			        {
			          Points point2 = P.get(j);
			          double distance = distanceTo(point1, point2);
			          if (distance < temp.getDistance())
			            temp = Pair.setPair(point1, point2, distance);
			        }
				}
			}
		return temp;
	}
	// returns the minimum distance between two points
	// using minimum-Euclidean distance
	public double distanceTo(Points p1, Points p2){
	    double distanceX = p2.getX() - p1.getX();
	    double distanceY = p2.getY() - p1.getY();
	    return Math.hypot(distanceX, distanceY);

	}
	
	public void print(ArrayList<Points> p){
		for(int i =0; i < p.size(); i++){
			System.out.println(p.get(i).getID() +" - (" +p.get(i).getX() + " , " +p.get(i).getY() +")");
		}
	//	System.out.println("_______________");
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
			// there still exists elements in both lists
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
			// there still exists elements in both lists
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