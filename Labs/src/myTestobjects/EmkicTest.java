package myTestobjects;


import java.io.File;
import java.util.ArrayList;

public class EmkicTest {
		public static void main(String[]args){

		ArrayList<Points> temp = new ArrayList<Points>();
			
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
