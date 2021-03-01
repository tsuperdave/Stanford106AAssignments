package week4;

import acm.program.*;
import java.io.*;

public class WordCount extends ConsoleProgram {
	
	/* INSTANCE VARIABLES */	
	private int lineCount = 0;
	private int wordCount = 0;
	private int charCount = 0;
		
	/* RUN */
	public void run() {
		BufferedReader br = openFileReader("File: ");
		try
		{
			while(true)
			{
				String line = br.readLine();
				if(line == null) break;				
				lineCount++;
				wordCount += countWords(line);
				charCount += line.length();
			}
				br.close();
			
		}
		catch (IOException e)
		{
			println("AIR OR ONE");
		}
		
		println("Lines = " + lineCount);
		println("Words = " + wordCount);
		println("Chars = " + charCount);
	}
	
	/* METHODS */
	private BufferedReader openFileReader(String input)
	{
		BufferedReader br = null;
		while(br == null)
		{
			String fileName = readLine(input);
			try
			{
				br = new BufferedReader(new FileReader(fileName));
			}
			catch(IOException e)
			{
				println("AIR OR TWO");
			}
		}
		return br;
	}
	
	private int countWords(String line)							// count num of words in file
	{
		boolean isWord = false;									// set default char to false
		int count = 0;											// need to count num of words
		for(int i = 0; i < line.length(); i++)					// loop over each line
		{
			char ch = line.charAt(i);							// check line if is character at specific index
			if(Character.isLetterOrDigit(ch))					// check index if is character
			{				
				isWord = true;									// set to ifWord to true
			}
			else
			{
				if(isWord) count++;									// check ifWord is true and increment THEN set back to false
				isWord = false;
			}			
		}
		if(isWord) count++;
		return count;											// once loop is finished, return word count
	}
}
