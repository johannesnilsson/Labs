package myTestobjects;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class EmkicTest {
		public static void main(String[]args){

		
		ArrayList<Points> temp = new ArrayList<Points>();

		Parser myParser = new Parser();
        @SuppressWarnings("unused")
        ClosestPair test = null;
       
        File folder = new File("src/Lab4/testFiles/");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> tempNames = new ArrayList<String>();;
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
            tempNames.add(test.getFileNames());
        }
        
        PrintWriter writer = null;
		try {
			writer = new PrintWriter("src/myTestobjects/our-output.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(int i = 0; i < tempNames.size(); i++){
        	//System.out.println(tempNames.get(i));
        	writer.println(tempNames.get(i));
        }
		writer.close();
	}
}
