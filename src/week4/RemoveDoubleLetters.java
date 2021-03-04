package week4;

import acm.program.*;

public class RemoveDoubleLetters extends ConsoleProgram 
{
	
	/* INSTANCE VARIABLES */
	String wordOne = "bookkeeper";
	
	public void run()
	{		
		println(removeDoubleLetters(wordOne));		
	}
	
	String removeDoubleLetters(String str)
	{
		println("Input string is: " + str);
		char[] characters = str.toCharArray();
		String newWord = Character.toString(characters[0]);
		
		for(int i = 1; i < characters.length; i++)
		{
			if(!(characters[i] == characters[i -1]))
			{
				newWord += characters[i];
			}
		}
		return "Modified string is: " + newWord;
	}
	
	/*
	void removeDoubleLetters()
	{	
		
		while(true) 
		{
			String word = readLine("Enter a word with 2 of the same letter: ");
			if(word.equals("")) break;				
				String[] characters = word.split("");
				String newWord = "";
				
				for(int i = 0; i < characters.length; i++)
				{	
					println(characters[i]);
					if(!newWord.contains(characters[i]))
					{
						println(characters[i]);
						newWord += characters[i];
						print(newWord);
					}				
				}
				
		}
	}
	*/
	
	 
}
