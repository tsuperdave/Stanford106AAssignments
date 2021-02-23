package week3;

import acm.program.ConsoleProgram;

/*
 * When large numbers are written out on paper, it is traditional—at least in the United
States—to use commas to separate the digits into groups of three
 */

/*
 * check if number input length is > 3
 * add check in loop for decimal place (counts toward index)
 * if looping over each element in input, need to store the result after adding commas (including decimal place and sign)
 * may need to return as string (concant)
 */

public class AddCommasToNumberStrings extends ConsoleProgram 
{
	
	public void run() 
	{				
		while (true) 
		{
			 String digits = readLine("Enter a numeric string: ");
			 if (digits.length() == 0) break;
			 println(addCommasToNumericString(digits));
		}
	}
	
	private String addCommasToNumericString(String digits)
	{
		String result = "";
		int count = 0;
		
		for(int i = digits.length() - 1; i >= 0; i--)
		{				
			result = digits.charAt(i) + result;			
			count++;
				
			if(((count % 3) == 0) && ( i > 0)) 
			{	
				result = "," + result;
			}				
		}
	
		return result;
	}
	
}
	
	/* TESTING */
	/*
	private void addCommas(double number)
	{
		String numToString = Double.toString(number);
		Integer numLength = numToString.length();
		String result = "";
				
		if(numLength < 3) 
		{
			println("No commas required for the number " + number);
		}
		else
		{
			for(int i = 0; i < numLength; i++)
			{				
				String ch = Character.toString(numToString.charAt(i));
				if(ch == ".")
				{
					result += ch;
					continue;
				}
				println(ch);
				if(i % 3 == 0)
				{
					
				}
				result += ch;			
			}
		}
		println(result);
		// println("The length of number " + numLength + " with decimal added is " + result); // for testing	
	}
	*/
	

