package week5;

import java.io.*;
import java.util.*;
import acm.util.*;

import acm.program.ConsoleProgram;


// read from file named flights.txt - BufferedReader √
	// each line of file consists of pair of cities separated by and arrow '->'  √
	// ignore blank lines for readability -- .hasNext() can determine end of file √
// program should read file and store as appropriate data structure √
// display complete list of cities √




public class FlightPlanner extends ConsoleProgram 
{
	
	private HashMap<String, ArrayList<String>> flights;
	// private HashSet<String> listOfCities;								// could use Set to create list of cities for print out/starting locations
	private ArrayList<String> cities;
	private BufferedReader br;
	private static final String FILE_NAME = "flights.txt";
	
	
	public void run() 
	{
		println("Welcome to Flight Planner!");
		readFlightList();												// reads file/flight list
		
		println("Here\'s a list of all the cities in our databse:");
		printCityDB(cities);													// prints out available cities to fly to/from
		
		println("Let\'s plan a round-trip route!");		
		final String start = readLine("Enter a starting city: ");				// allow user to select starting city	
		String current = start;
		final ArrayList<String> newRoute = new ArrayList<String>();			
		newRoute.add(start);													// add input to array list for comparison
		
		while(true)
		{
			final String next = getNext(current);
			newRoute.add(next);
			if(next.equals(start)) break;
			current = next;
		}
		printNewRoute(newRoute);
		// could add input city to list to compare new entry
		// create loop, print out all destinations from current city and allow user to select next city 
		// break loop once user enters starting city
	}
	
	private void readFlightList()
	{
		flights = new HashMap<String, ArrayList<String>>();
		cities = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(FILE_NAME));
			while(true)
			{
				String line = br.readLine();
				if(line == null) break;
				if(line.length() != 0)
				{
					readInputLine(line);
				}
				// cities.add(line);
				// need way to read only list of available cities, not whole line
			}			
			br.close();
		}
		catch(IOException e)
		{
			throw new ErrorException(e);
		}
		// System.out.println(cities);		
	}
	
	private void printNewRoute(ArrayList<String> route)
	{
		println("The route you\'ve chosen is: ");
		for(int i = 0; i < route.size(); i++) 
		{
			if(i > 0) print (" -> ");
			print(route.get(i));
		}
		println();
	}
	
	private void readInputLine(String line)
	{
		final int arrow = line.indexOf("->");
		if(arrow == -1)
		{
			throw new ErrorException("Line " + line + " illegal entry");
		}
		String from = line.substring(0, arrow).trim();
		String to = line.substring(arrow + 2).trim();
		define(from);
		define(to);
		getDestination(from).add(to);
	}
	
	private String getNext(String city)
	{
		final ArrayList<String> dest = getDestination(city);
		String next = null;
		while(true)
		{
			println("From " + city + " you can fly directly to :");
			printCityDB(dest);
			final String prompt = "Where do you want to go from " + city + "? ";
			next = readLine(prompt);
			if(dest.contains(next)) break;
			println("You can\'t get to that city by a direct flight.");
		}
		return next;
	}
	
	private void define(String cityName)
	{
		if(!cities.contains(cityName))
		{
			cities.add(cityName);
			flights.put(cityName, new ArrayList<String>());
		}
	}
	
	private ArrayList<String> getDestination(String from)
	{
		return flights.get(from);
	}
	
	private void printCityDB(ArrayList<String> citiesList)
	{
		for(int i = 0; i < citiesList.size(); i++)
		{
			final String city = citiesList.get(i);
			println(" " + city);
		}
	}
	// allow user to select starting city
}
