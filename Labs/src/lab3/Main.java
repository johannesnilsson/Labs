package lab3;

import java.util.ArrayList;

public class Main {
	
	public static void main(String [] args){
	Parser pars = new Parser();
	ArrayList<String> cities = pars.parseCities();
	ArrayList<String> srcDistCost = pars.parseDistances();
	
//	for(int i = 0; i < srcDistCost.size(); i++){
//		System.out.println(srcDistCost.get(i));
//	}
//	for(int i = 0; i < cities.size(); i++){
//		System.out.println(cities.get(i));
//	}

	Prim p = new Prim(cities);

	for(int i = 0; i < srcDistCost.size() - 2; i+=3){
		p.setDistances(srcDistCost.get(i), srcDistCost.get(i+1), srcDistCost.get(i+2));
	}
	p.testPrint();
//	p.setDistances(source, destination, distance);
	//p.testPrint();

	}

}
