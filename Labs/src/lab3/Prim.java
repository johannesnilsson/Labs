package lab3;

import java.util.ArrayList;

public class Prim {

	private String [][] adjacencyMatrix;
	public static final int INFINITE = Integer.MAX_VALUE;
	private ArrayList<Coordinates> myCoordinates;
	private ArrayList<Integer> visitedRows;
	//private ArrayList<Integer> Queue;

	 public  Prim(ArrayList<String> cities){
		 visitedRows = new ArrayList<Integer>();
		 myCoordinates = new ArrayList<Coordinates>();
		 this.adjacencyMatrix = new String[cities.size() +1][cities.size() +1];
		 for(int i =1; i < cities.size()+1; i++){
			 adjacencyMatrix[i][0] = cities.get(i-1);
			 adjacencyMatrix[0][i] = cities.get(i-1);
		 }
	 }
	 
	 
	 
	 
	 public void getMST(String source){
		 int x = findX(source);	// find coordinates for source
		 int y = findX(source); // find coordinates for source
		 int minCost = INFINITE; // big number
		 System.out.println("the city that we use as root: " +source);

		 visitedRows.add(y);
		 
		 int tempX = 0;
		 Coordinates tempCord = null;
		while(visitedRows.size() <= 128){ // INSEEER ERROR
			
			for(int i=0; i<visitedRows.size(); i++){
				y = visitedRows.get(i);
			//	System.out.println("ahaha");
				System.out.println(i);

				for(int j=1; j<adjacencyMatrix.length; j++){
					//System.out.println("i: " +i +" " +"j: " +j);
					if(y==j) continue;
					if(Coordinates.containsCoord(j,y,myCoordinates)) continue;
					String tempVal = adjacencyMatrix[j][y];
					//System.out.println(tempVal);
					int tempVal2 = Integer.parseInt(tempVal);
					if (tempVal2 < minCost){
						minCost = tempVal2;
						tempX = j;
						tempCord = new Coordinates(j,y);
					//	System.out.println(j +" " +y);
					}
			//		System.out.println(tempCord.getX());
			//		System.out.println(tempCord.getY());
					
//					System.out.println("exakt innan vi ska stoppa in grajor");
//					System.out.println("visitedRows.size()-1   " +(visitedRows.size()-1));
//					System.out.println("i: " +i);
//					System.out.println("j: " +j);
//					System.out.println("adjacencyMatrix.length:" +adjacencyMatrix.length);
//					
					
					if(visitedRows.size() -1 ==i && j == adjacencyMatrix.length-1){
						visitedRows.add(tempX);
						minCost = INFINITE;
						System.out.println("----------------------------------------------------------------------------------");
//						System.out.println(tempCord.getY());
						myCoordinates.add(tempCord);
						i = -1;
					}
				}
			}
		}
		 
		 
		 
		 
		 
		// Coordinates myCord = null;
	
	 }
		
	 
	/* 
	 public void getMST(){
		
		 
		 
		 int cost = 0;
		 int minCost = 0;
		 Coordinates max = null;
		 for(int i=1; i<adjacencyMatrix.length; i++){
			 for(int j=1; j<adjacencyMatrix.length; i++){
				cost = Integer.parseInt(adjacencyMatrix[i][j]);
				
				if(i == j) continue;
				
				if(cost < minCost){
					minCost = cost;
					max = new Coordinates(i,j);
				}
				if(j == adjacencyMatrix.length -1 && max != null){
					myCoordinates.add(max);
				}
			 }
		 }
	 }
	
	*/
	 public void setDistances(String source, String destination, String distance){
		 int x = findX(source);
		 int y = findY(destination);
	//	 System.out.println(distance +"   <---- disdtamce");
	//	 System.out.println(x);
//		 System.out.println(y);
		 adjacencyMatrix[x][y] = distance;
		 adjacencyMatrix[y][x] = distance;
	 }

	 
	 public void testPrint(){
		 for(int i = 0; i < adjacencyMatrix.length; i++){
			 System.out.println();
			 for(int j = 0; j < adjacencyMatrix.length; j++){
				 	System.out.print(adjacencyMatrix[i][j]+ " ");
			 }
		 }
	 }
	 public void addCity(String s){
		 for(int i =1; i < adjacencyMatrix.length; i++){
			 if(adjacencyMatrix[i][0] == null && null == adjacencyMatrix[0][i]){
				 adjacencyMatrix[i][0] = s;
				 adjacencyMatrix[0][i] = s;
				 break;
			 }
		 }
	 }
	 
	 public int findX(String s){
		 for(int i = 1; i<adjacencyMatrix.length; i++){
			 String city = adjacencyMatrix[i][0];
			 city = city.trim();
			 if(s.compareTo(city) == 0){	// found city
				 return i;
			 }
		 }
		 return -1;
	 }
	 public int findY(String s){
		 for(int i = 1; i<adjacencyMatrix.length; i++){
			 String city = adjacencyMatrix[0][i];
			 city = city.trim();
			 if(s.compareTo(city) == 0){	// found city
				 return i;
			 }
		 }
		// System.out.println("the city that we did not found is --->" +s);
		 return -1;
	 }	 
}
