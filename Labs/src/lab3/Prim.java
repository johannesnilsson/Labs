package lab3;

import java.util.ArrayList;

public class Prim {

	private String [][] adjacencyMatrix;
	public static final int INFINITE = Integer.MAX_VALUE;
	private ArrayList<Coordinates> myCoordinates;
	private ArrayList<Coordinates> visitedCord;
	private ArrayList<Integer> visitedRows;

	 public  Prim(ArrayList<String> cities){
		 visitedRows = new ArrayList<Integer>();
		 visitedCord = new ArrayList<Coordinates>();
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
		 System.out.println("Root: " +source);

		 visitedRows.add(y);
		 
		 int tempX = 0;
		 Coordinates tempCord = null;
		int joh = 0;	
		 
			for(int i=0; i<visitedRows.size(); i++){
				joh++;
				y = visitedRows.get(i);
				if(visitedRows.size() == adjacencyMatrix.length-1) break;

				for(int j=1; j<adjacencyMatrix.length; j++){

					if(!(y==j || Coordinates.containsCoord(j,y,visitedCord))){
						if(adjacencyMatrix[j][y] != null){
							joh++;
							String tempVal = adjacencyMatrix[j][y];
							int tempVal2 = Integer.parseInt(tempVal);
							if (tempVal2 < minCost){
								minCost = tempVal2;
								tempX = j;
								tempCord = new Coordinates(j,y);
							}
						}
					}
					if(visitedRows.size() -1==i && j == adjacencyMatrix.length-1){ // row has not been visited before
						if(!visitedRows.contains(tempX)) {
							visitedRows.add(tempX);
							myCoordinates.add(tempCord);
						}
							int x3= tempCord.getX();
							int y3= tempCord.getY();
							if(!Coordinates.containsCoord(x3,y3,visitedCord)){
								visitedCord.add(tempCord);
							}
						minCost = INFINITE;
						i = -1;
					}
				}
			}
			for(int i = 0; i < 128; i++){
				if(!visitedRows.contains(i)){
					//System.out.println("does not contain: " +i);
				}
			}
			
			//System.out.println("Size of array: " +visitedRows.size());
			
			int cost = 0;
			for(int i = 0; i < myCoordinates.size(); i++){
				int x1 = myCoordinates.get(i).getX();
				int y1 =  myCoordinates.get(i).getY();
				String tempVal = adjacencyMatrix[x1][y1];
				int tempVal2 = Integer.parseInt(tempVal);
				cost += tempVal2;
				
			}
	//		System.out.println("Amount of coordinates: " +myCoordinates.size());
			System.out.println("Answer of MST: " +cost);
			
		/*	
			for(int i = 0; i < myCoordinates.size(); i++){
				System.out.println("x: " +myCoordinates.get(i).getX() +" " +"y: " +myCoordinates.get(i).getY());
			}
		*/	
				//int k= 1;
			/*
				for(int j=1; j<adjacencyMatrix.length; j++){
				//	int a =myCoordinates.get(j).getY();
					if(j%10==0) k-=10;
					System.out.println("\\node (" +adjacencyMatrix[0][j] +") at (" +(j%10)*10 +"," +k +") {" +adjacencyMatrix[0][j] +"};");
				}
				*/
			
		/*	
			for(int i = 0; i < myCoordinates.size(); i++){
				int a =myCoordinates.get(i).getY();
				int b =myCoordinates.get(i).getX();
				System.out.println("\\draw" +"(" +adjacencyMatrix[0][a] +")--(" +adjacencyMatrix[0][b] +");");
			}
			int haha = 0;
			for(int i=0; i<100; i++){
				haha +=i;
			}
			System.out.println(haha);
			System.out.println(joh);
			*/
		}
			 		 
	 public void setDistances(String source, String destination, String distance){
		 int x = findX(source);
		 int y = findY(destination);
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
		// System.out.println("the city that was not found --->" +s);
		 return -1;
	 }	 
}
