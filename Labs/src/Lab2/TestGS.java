package Lab2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.JUnit4;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;


public class TestGS {
	private final static String TESTDATA_DIR = "/Users/emirhusic/git/labs/labs/src/lab2";
	private final static char SC = File.separatorChar;
	
	/**
	 * Method to run an actual test case.
	 * 
	 * @param testname
	 *            Name of test data to be used, e.g. "stable-marriage-friends".
	 */
	private void runTestCase10(String datfile, String infile, String outfile) {

		String[] args = new String[2];
		args[0] = datfile;
		args[1] = infile;
		//args[0] = outfile;
		Main.main(args); // FIXME: Change GS to your own class!
		
		File actualFile = new File("/Users/emirhusic/git/labs/labs/src/lab2/RESULT-" + outfile);
		File expectedFile = new File("/Users/emirhusic/git/labs/labs/src/lab2/" + outfile);
		//File actualFile = new File("/Users/emirhusic/git/labs/labs/src/lab2/RESULT-words-10.out");
	   // File expectedFile = new File("/Users/emirhusic/git/labs/labs/src/lab2/words-10.out");
	    Scanner scanA = null;
		try {
			scanA = new Scanner(actualFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    Scanner scanB = null;
		try {
			scanB = new Scanner(expectedFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    String s =null;
	    String k =null;
	    while(scanA.hasNext()){
	    	s += scanA.nextLine();
	    }
	    
	    while(scanB.hasNext()){
	    	k += scanB.nextLine();
	    }
	    
	    assertEquals(s,k);
	}
	
	@Test
	public void test1() {
		String datfile = "words-10.dat";
		String infile = "words-10-test.in";
		String outfile = "words-10-test.out";
		runTestCase10(datfile,infile,outfile);
	    }
	
	/**
	 * Simple test case for the 'friends' test data.
	 */
	@Test
	public void test2() {
		String datfile = "words-250.dat";
		String infile = "words-250-test.in";
		String outfile = "words-250-test.out";
		runTestCase10(datfile,infile,outfile);			
    }
	
	/**
	 * Simple test case for the 'friends' test data.
	 */
	@Test
	public void test3() {
		String datfile = "words-5757.dat";
		String infile = "words-5757-test.in";
		String outfile = "words-5757-test.out";
		runTestCase10(datfile,infile,outfile);
    
		//unTestCase("words-10");
	}

}