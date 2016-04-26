package myTestobjects;


import java.io.File;
import java.util.ArrayList;

public class EmkicTest {
		public static void main(String[]args){
			//id,x,y,

		Points p1 = new Points(1,13,10);
		Points p2 = new Points(2,4,32);
		Points p3 = new Points(3,1,1);
		Points p4 = new Points(4,200,2);
		Points p5 = new Points(5,300,300);
		Points p6 = new Points(6,301,301);
		Points p7 = new Points(7,377,377);
		Points p8 = new Points(8,377.5,377);
		
		ArrayList<Points> temp = new ArrayList<Points>();
		//temp.add(p1);
		temp.add(p2);
		temp.add(p3);
		temp.add(p4);
		temp.add(p5);
		temp.add(p6);
		temp.add(p7);
		temp.add(p8);
		temp.add(p1);
//		for(int i = 0; i < temp.size(); i++){
//			System.out.println(temp.get(i).getID());
//		}
		//public ClosestPair(ArrayList<Points> points){
//		Parser myParser = new Parser();
//		temp =myParser.doParse("ulysses16");
//		
//		
//		ClosestPair test = new ClosestPair(temp, "ulysses16.tsp", "1084");
		
		Parser myParser = new Parser();
        @SuppressWarnings("unused")
        ClosestPair test = null;
       
        File folder = new File("src/Lab4/testFiles/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                                    // System.out.print("../testFiles/" + file.getName() +"       ");
                                     String nbrOfEntries = file.getName().replaceAll( "[^\\d]", "");
                                     String filename = file.getName().replace(".tsp", "");
                                  //   System.out.println(filename);
                                 //    System.out.print(": " + nbrOfEntries + " ");
                                     temp = myParser.doParse(filename);
                                     test = new ClosestPair(temp,file.getName(),nbrOfEntries);
              
            }
        }

	}
}
