package week4;

import java.util.*;

import acm.program.*;

public class MidTerm extends ConsoleProgram{
	
	/* INSTANCE VARIABLES */
	private ArrayList<Integer> numbers;
	
	public void run()
	{
		/* PROBLEM 2a */
		println(doSomething());													// 1.25. the first expression will need to be set to double for return
		println(doSomethingElse());												// false. first portion of if statement is false so this 'short circuits' and ignores 2nd check
		println(doSomethingAgain());											// "B84". Numbers that are added to String in statement are 'concatenated'
		
		/* PROBLEM 2b */														// output for 2b is 78 for first number and 73 for second number
		int num1 = 2;
		int num2 = 13;
		println("The 1st number is: " + Mystery(num1, 6));
		println("The 2nd number is: " + Mystery(num2 % 5, 1 + num1 * 2));
		
		/* PROBLEM 3 */
		numbers = new ArrayList<>();											// takes numbers for input (int, all positive) and will stop if input is empty or 0
		while(true) 															// will output the biggest and 2nd biggest number, and both can be the same (max) if 2 of 
		{																				// the same number are input and both are largest overall
			String numberInput = readLine("Enter a number: ");			
			if(numberInput.equals("") || numberInput.equals("0")) break;
			int num = Integer.parseInt(numberInput);
			numbers.add(num);										
		}		
		println(printBiggestAndSecondBiggestNum(numbers));
		
		
	}
	
	/* METHODS FOR 2a */
	private double doSomething() {
		double result = 5.0 / 4 - 4 / 5;
		return result;
	}
	
	private boolean doSomethingElse()
	{
		boolean result = 7 < 9 - 5 && 3 % 0 == 3;
		return result;
	}
	
	private String doSomethingAgain()
	{
		String result = "B" + 8 + 4;
		return result;
	}
	
	/* METHODS FOR 2b */
	private int Mystery(int num1, int num2) 
	{
		num1 = Unknown(num1, num2);
		num2 = Unknown(num2, num1);
		return(num2);
	}
	
	private int Unknown(int num1, int num2) 
	{
		int num3 = num1 + num2;
		num2 += num3 * 2;
		return(num2);
	}
	
	/* METHOD FOR 3 */
	String printBiggestAndSecondBiggestNum(ArrayList<Integer> numbers)
	{	
		int max = numbers.get(0);
		// starting place for max value
		int secondBiggest = numbers.get(0);														// starting place for 2nd biggest val
		
		for(int i = 1; i < numbers.size(); i++)													// iterate over arraylist starting at index 1 since we store val at index 0 above							
		{
			if(numbers.get(i) == max)															// this checks for any duplicate numbers that both could be max value
			{
				secondBiggest = numbers.get(i);
			}
			
			if(numbers.get(i) > max)															//	if current index value is bigger than max, store it as 2nd biggest val
			{																					//			then store current index value as max
				secondBiggest = max;
				max = numbers.get(i);
			}
			
			if(numbers.get(i) > secondBiggest && numbers.get(i) != max)							// compare if current index val is bigger than 2ndbiggest and not equal to max
			{
				secondBiggest = numbers.get(i);													// store value as 2nd biggest
			}			
			
		}
		return "The largest number is ; " + max +
				"\nThe Second Largest number is: " + secondBiggest;
	}
		
}
