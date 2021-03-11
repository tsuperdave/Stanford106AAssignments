package week4;

import java.util.*;

import acm.program.*;

public class NameCounts extends ConsoleProgram
{
		
	public void run()
	{
		HashMap<String, Integer> nameCount = new HashMap<String, Integer>();			// call new HashMap constructor
		readNames(nameCount);
		printList(nameCount);
	}
	
	void readNames(Map<String,Integer> map) 
	{
		while(true) 
		{
			String name = readLine("Enter a name: ");
			if(name.equals("")) break;
			
			Integer count = map.get(name);
			if(count == null)
			{
				count = new Integer(1);
			}
			else 
			{
			count = new Integer(count + 1);
			}
			map.put(name, count);
		}		
	}
	
	private void printList(Map<String,Integer> map)
	{
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext())
		{
			String key = iterator.next();
			int count = map.get(key);
			println("Name " + key + " has recorded " + count);
		}
	}
}


