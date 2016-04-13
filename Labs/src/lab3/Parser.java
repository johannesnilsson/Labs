package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

	public Parser(){}
	
	public ArrayList<String> parseCities(){
		ArrayList<String> result = new ArrayList<String>(130);
		File myFile = new File("src/lab3/USA-highway-miles.in");
		Scanner scan = null; 
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scan.hasNext()){
			String line = scan.nextLine();
			if(line.contains("--")){
				break;
			}
			if(line.contains("\"")){
				String newline = line.substring(1, line.length()-2);
				//System.out.println("MAKE CITY: " + newline);
				result.add(newline);
			} else {
				//System.out.println("MAKE CITY: " + line);
				result.add(line);
			}
		}
		return result;
	}
	
	/*ARRAY FORMAT: ---[STARTCITY][ENDCITY][COST]---*/
	public ArrayList<String> parseDistances(){
		ArrayList<String> result = new ArrayList<String> (25000);
		File myFile = new File("src/lab3/USA-highway-miles.in");
		Scanner scan = null; 
		try {
			scan = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scan.hasNext()){
			String line = scan.nextLine();
			if(!line.contains("--")){
			continue;
			} else if(line.charAt(0) == '"'){
				int pos = line.indexOf('"' , 1);	
				String cityStart = line.substring(1, pos);
//				System.out.println("the start city: " + cityStart);
				result.add(cityStart);
				if(line.charAt(line.indexOf("--") + 2) == '"'){
					int endpos = line.lastIndexOf('"');
					String cityDest = line.substring(line.indexOf("--") + 3, endpos);
//					System.out.println("the endCity: " + cityDest);
					result.add(cityDest);
				} else {
					int endPos = line.lastIndexOf(' ');
					String cityDest = line.substring(line.indexOf("--")+2, endPos);
//					System.out.println("The city dest: " + cityDest);
					result.add(cityDest);
				}
			} else if(line.charAt(0) != '"'){
				int endpos = line.indexOf("--");
				String startCity = line.substring(0, endpos);
//				System.out.println("the startcity: " + startCity);
				result.add(startCity);
				if(line.charAt(line.indexOf("--") + 2) == '"'){
					int endpos2 = line.lastIndexOf('"');
					String cityDest = line.substring(line.indexOf("--") + 3, endpos2);
//					System.out.println("the endCity: " + cityDest);
					result.add(cityDest);
				} else {
					int endpos4 = line.lastIndexOf(' ');
					String cityDest = line.substring(line.indexOf("--") + 2, endpos4);
//					System.out.println("city dest : " + cityDest);
					result.add(cityDest);
				}
			}
			String cost = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
//			System.out.println("THE COST: " + cost);
			result.add(cost);	
		}	
		return result;
	}
}
