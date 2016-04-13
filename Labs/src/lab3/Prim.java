package lab3;

import java.util.ArrayList;

public class Prim {

	private String [][] adjacencyMatrix;
	public static final int INFINITE = 999;
	

	 public  Prim(ArrayList<String> cities){
		 this.adjacencyMatrix = new String[cities.size() +1][cities.size() +1];
		 for(int i =1; i < cities.size()+1; i++){
			 adjacencyMatrix[i][0] = cities.get(i-1);
			 adjacencyMatrix[0][i] = cities.get(i-1);
		 }
	 }
	
	 public void setDistances(String source, String destination, String distance){
		 int x = findX(source);
		 int y = findY(destination);		 
		 adjacencyMatrix[x][y] = distance;
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
		 for(int i =1; i < adjacencyMatrix.length+1; i++){
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
			 if(s.compareTo(city) == 0){	// found city
				 return i;
			 }
		 }
		 return -1;
	 }
	 public int findY(String s){
		 for(int i = 1; i<adjacencyMatrix.length; i++){
			 String city = adjacencyMatrix[0][i];
			 if(s.compareTo(city) == 0){	// found city
				 return i;
			 }
		 }
		 return -1;
	 }	 
}