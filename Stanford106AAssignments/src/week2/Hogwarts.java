package week2;

import acm.program.*;

public class Hogwarts extends ConsoleProgram {
	

	public void run() 
	{
		bludger(2001);
	}
		 
	private void bludger(final int y)
	{
		int x = y / 1000;
		println("bludger first calc: " + x);
		
		final int z = (x + y);		
		println("bludger second calc: " + z);
		
		x = quaffle(z, y);
		println("return val from quaffle: " + x);
		
		println("bludger: x = " + x + ", y = " + y + ", z = " + z);
		 
	}
		 
	private int quaffle(final int x, int y) 
	{
		final int z = snitch(x + y, y);
		y /= z;
		println("quaffle first calc: " + y);
		
		println("quaffle: x = " + x + ", y = " + y + ", z = " + z);
		return z;
	}
		 
	private int snitch(final int x, int y) 
	{
		y = x / (x % 10);
		println("snitch first calc: " + y);
		
		println("snitch: x = " + x + ", y = " + y);
		return y;
	}
} 

