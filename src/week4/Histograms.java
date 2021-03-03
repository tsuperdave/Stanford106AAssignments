package week4;

import java.io.*;
import java.util.*;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

/* read from file, count lines as this will be length of array. may use arraylist
 * create array
 * input scores from file into array, need to parse as int
 * print scores
 * 
 * need var to store ranges
 * 
 */

public class Histograms extends ConsoleProgram 
{
	
	/* INSTANCE VARIABLES */
	// private int lineCount = 0;
	private int[] histogramArray;
	private static final String USE_THIS_FILE = "MidtermScores";
	
	public void run() 
	{
		createHistogramList();
		readScoresFromFile();
		printHistogram();
	}
	
	private void createHistogramList()
	{
		histogramArray = new int[11];
		for(int i = 0; i <= 10; i++)
		{
			histogramArray[i] = 0;
		}
	}
	
	private void readScoresFromFile()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(USE_THIS_FILE));
			while(true) 
			{
				String line = br.readLine();
				if(line == null) break;				
				int score = Integer.parseInt(line);	
				//println(score);
				if(score < 0 || score > 100)
				{
					throw new ErrorException("Score out of Range");
				}
				else
				{
					int scoreRange = score / 10;
					histogramArray[scoreRange]++;						
				}
				//println(line);
			}
			// lineCount = scoresList.size();
			// println(lineCount);
			// println(line);
			// br.close();
		}
		catch(IOException e)
		{
			throw new ErrorException(e);
		}
		
	}
	
	private void printHistogram()
	{
		for(int scoreRange = 0; scoreRange <= 10; scoreRange++)
		{
			String label;
			switch (scoreRange)
			{
			case 0: label = "00-09"; break;
			case 10: label = "  100"; break;
			default: label = (10 * scoreRange) + "-" + (10 * scoreRange + 9); break;
			}
			// String tallys = createTallys(scoresList.get(scoreRange / 10));
			String tallys = createTallys(histogramArray[scoreRange]);
			// println(scoresList.get(scoreRange));
			println(label + ": " + tallys);
		}
	}
	
	private String createTallys(int num) 
	{
		String tallys = "";
		for(int i = 0; i < num; i++)
		{
			tallys += "*";
		}
		return tallys;
	}
	
}
