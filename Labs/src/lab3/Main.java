package lab3;

import java.util.ArrayList;

public class Main {
	
	public static void main(String [] args){
	Parser pars = new Parser();
	ArrayList<String> cities = pars.parseCities();
	
	for(int i = 0; i < cities.size(); i++){
		System.out.println(cities.get(i));
	}
	//ArrayList<String> srcDistCost = pars.parseDistances();
	
//	Prim p = new Prim(cities);
//	p.testPrint();

	}

}
