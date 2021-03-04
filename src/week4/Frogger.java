package week4;

import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;

/*
 * canvas width and height are set to dimensions provided in handout
 * can find canvas total pixels in w and h by colums, rows * sqsize
 * mouse clicks must be in window for frog to move
 * frog can move but not outside window boundary
 * need mouse listener (clicked) for determining click and moving frog
 * need to find closest square to move frog to
 * if position of mouse click is closer to x or y, need to move 75 pixels that direction
 */


public class Frogger extends GraphicsProgram 
{
	
	/* INSTANCE VARIABLES */ 	
	public static final int SQSIZE = 75;
	public static final int NCOLS = 7;
	public static final int NROWS = 3;
	public static final int APPLICATION_WIDTH = NCOLS * SQSIZE;
	public static final int APPLICATION_HEIGHT = NROWS * SQSIZE;
	
	private GImage frog;
	private double frogX, frogY;

	public void run() 
	{
		frog = new GImage("frog.gif");
		// GDimension frogPxls = frog.getSize();
		frogX = (NCOLS / 2 + 0.5) * SQSIZE;												// updates center of canvas position in x (.5 is for half a column)
		frogY = (NROWS - 0.5) * SQSIZE;													// gets center of canvas in y position (.5 is for half a row)
		// println(frogPxls);
		add(frog, frogX - frog.getWidth() / 2, frogY - frog.getHeight() / 2);			// plot frog in x and y position, subtract half of frog h and w
		addMouseListeners();		
	}
	
	public void mousePressed(MouseEvent e)
	{
		double mouseX = e.getX();														// store mouse click x, y pos
		double mouseY = e.getY();														// need abs x and y difference so new pos is calculated correct
		if(Math.abs(mouseX - frogX) > Math.abs(mouseY - frogY))							// get diff in mouse clicks to frog pos, find lowest val (meaning closer to row or column)		
		{
			if(mouseX > frogX)
			{
				moveFrog(SQSIZE, 0);													// move frog 75 pixels +X
			} else {				
				moveFrog(-SQSIZE, 0);													// else move frog -X
			}							
		} else {				
			if(mouseY > frogY)
			{
				moveFrog(0, SQSIZE);
			} else {
				moveFrog(0, -SQSIZE);	
			}
		}
	}	
	
	private void moveFrog(double x, double y)											// need to add method to move frog. need to check if frog is inside canvas/world
	{
		if(frogInCanvasCheck(frogX + x, frogY + y))										// check if 
		{
			frogX += x;																	// update frog X pos
			frogY += y;																	// update frog Y pos
			frog.move(x,  y);															// move frog x, y direction
		}
	}
	
	private boolean frogInCanvasCheck(double x, double y)
	{
		return (x >= 0 && x < APPLICATION_WIDTH && y >= 0 && y <= APPLICATION_HEIGHT);
	}
}
