package week3;

import acm.program.ConsoleProgram;

/*
Write a method
	public String removeAllOccurrences(String str, char ch)
that removes all occurrences of the character ch from the string str. For example, your
method should return the values shown:

removeAllOccurrences("This is a test", 't') returns "This is a es"
removeAllOccurrences("Summer is here!", 'e') returns "Summr is hr"
removeAllOccurrences("---0---", '-') returns "0"
*/

public class DeleteCharactersFromString extends ConsoleProgram 
{
	
	public void run() 
	{			
		removeAllOccurrences("This is a test", 't'); // returns "This is a es"
		removeAllOccurrences("Summer is here!", 'e'); // returns "Summr is hr"
		removeAllOccurrences("---0---", '-'); // returns "0"
		
		/*TESTS*/
		/*
		println(removeAllOccurrences("This is a test", 't')); // returns "This is a es"
		println(removeAllOccurrences("Summer is here!", 'e')); // returns "Summr is hr"
		println(removeAllOccurrences("---0---", '-')); // returns "0"
		*/				
	}
	
	public String removeAllOccurrences(String str, char ch)
	{
		String charToRemove = Character.toString(ch);			// convert to same prim type	
		return str.replace(charToRemove, "");					// return result
	}	
}
