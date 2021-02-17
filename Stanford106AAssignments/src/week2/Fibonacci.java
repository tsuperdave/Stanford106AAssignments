package week2;

import acm.program.*;

/*
 * Write a program that displays the terms in the Fibonacci sequence, starting with Fib(0)
and continuing as long as the terms are less than 10,000.
 */

/*
 * need to declare variable with a max number to break out of any loops
 * need starting number/spot in fib sequence (0, 1)
 * need variable for sum of values while counting
 * console log sequence
 */

public class Fibonacci extends ConsoleProgram 
{

	private static final int MAX_TERM_VALUE = 10000;
	private int currentVal = 0;
	private int nextVal = 1;
	
		
	public void run() {
		if(nextVal >= 1) 
		{
			while(currentVal <= MAX_TERM_VALUE)
			{
				System.out.println(currentVal);
				int valAfterNext = currentVal + nextVal;
				currentVal = nextVal;
				nextVal = valAfterNext;
			}
		}
		System.out.println("Next value must be 1 or higher");
	}
}

