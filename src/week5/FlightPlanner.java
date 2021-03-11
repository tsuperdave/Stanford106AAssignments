package week5;

import java.io.*;
import java.util.*;
import acm.util.*;

import acm.program.ConsoleProgram;


// read from file named flights.txt - BufferedReader √
	// each line of file consists of pair of cities separated by and arrow '->'
	// ignore blank lines for readability -- .hasNext() can determine end of file
// program should read file and store as appropriate data structure
// display complete list of cities
// allow user to select starting city
// in loop, print out all destinations from current city and allow user to select next city
// once user has chosen round trip route (selected flight to starting city), exit loop and print chosen route

public class FlightPlanner extends ConsoleProgram 
{
	
	// private HashMap<String, > flights;
	private ArrayList<String> cities;
	private BufferedReader br;
	
	public void run() 
	{
		cities = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader("flights.txt"));
			while(true)
			{
				String line = br.readLine();
				if(line == null) break;
				cities.add(line);
			}			
			br.close();
		}
		catch(IOException e)
		{
			throw new ErrorException(e);
		}
		System.out.println(cities);
	}
	
	
}
