package week4;

import java.util.*;

import acm.program.ConsoleProgram;

public class UniqueNames extends ConsoleProgram 
{
	/* INSTANCE VARIABLES */
	private ArrayList<String> names;
	
	public void run() 
	{
		names = new ArrayList<String>();
		while(true) 
		{
			String nameInput = readLine("Enter a name: ");
			if(nameInput.equals("")) break;
			if(!names.contains(nameInput)) 
			{
				names.add(nameInput);
			}
						
		}
		println("Name List is: ");
		//println(names);
		printNames(names);
	}
	
	void printNames(ArrayList names)
	{
		for(int i = 0; i < names.size(); i++)
		{
			println(names.get(i));
		}
	}
	
}
