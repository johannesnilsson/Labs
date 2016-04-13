package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Parser {
	public static void main(String [] args){
		Parser myParser = new Parser();
		myParser.parseInput();
	}
	
	public Parser(){}
	
	public void parseInput(){
		File myFile = new File("C:\\Users\\Johannes\\Desktop\\USA-highway-miles.in");
		Scanner scan = null; 
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scan.hasNext()){
			String line = scan.nextLine();
			if(!line.contains("--")){
				if(line.contains("\"")){
					String newline = line.substring(1, line.length()-2);
					System.out.println("MAKE CITY: " + newline);
					//make new city with title newline
				} else {
					System.out.println("MAKE CITY: " + line);
					//make new city with the title line
				}
			} else if(line.contains("--")){
				System.out.println();
				if(line.charAt(0) == '"'){
					int pos = line.indexOf('"' , 1);	
					String cityStart = line.substring(1, pos);
					System.out.println("the start city: " + cityStart);
					if(line.charAt(line.indexOf("--") + 2) == '"'){
						int endpos = line.lastIndexOf('"');
						String cityDest = line.substring(line.indexOf("--") + 3, endpos);
						System.out.println("the endCity: " + cityDest);
					} else {
						int endPos = line.lastIndexOf(' ');
						String cityDest = line.substring(line.indexOf("--")+2, endPos);
						System.out.println("The city dest: " + cityDest);
					}
				} else if(line.charAt(0) != '"'){
					int endpos = line.indexOf("--");
					String startCity = line.substring(0, endpos);
					System.out.println("the startcity: " + startCity);
					if(line.charAt(line.indexOf("--") + 2) == '"'){
						int endpos2 = line.lastIndexOf('"');
						String cityDest = line.substring(line.indexOf("--") + 3, endpos2);
						System.out.println("the endCity: " + cityDest);
					} else {
						int endpos4 = line.lastIndexOf(' ');
						String cityDest = line.substring(line.indexOf("--") + 2, endpos4);
						System.out.println("city dest : " + cityDest);
					}
				}
				String cost = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
				System.out.println("THE COST: " + cost);
			}
		}
	}
}