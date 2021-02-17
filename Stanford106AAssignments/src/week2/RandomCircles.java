package week2;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.*;

/*
 * ---------
 * This program draws a set of 10 circles with different sizes,
 * positions, and colors. Each circle has a randomly chosen
 * color, a randomly chosen radius between 5 and 50 pixels,
 * and a randomly chosen position on the canvas, subject to
 * the condition that the entire circle must fit inside the
 * canvas without extending past the edge.
 * ---------
need to create a set of 10 randomly generated circles -- create var for num of circ, way to count down to stop creation?
need function for generating random numbers between 5 and 50
circles must fit inside canvas and not extend past edge
circles that do not show up may be of same color as window background or same as other circles
*/

public class RandomCircles extends GraphicsProgram 
{
	private static final int NUM_OF_CIRCLES = 10; // number of circles
	private static final double MIN_RADIUS = 5; // minimum circle radius
	private static final double MAX_RADIUS = 50; // max circle radius
	
	public void run()
	{
		RandomGenerator randomGen = RandomGenerator.getInstance();
		
		for(int i = 0; i < NUM_OF_CIRCLES; i++)
		{
			double radiusGen = randomGen.nextDouble(MIN_RADIUS, MAX_RADIUS);
			double xPosition = randomGen.nextDouble(0, getWidth() - 2 * radiusGen);
			double yPosition = randomGen.nextDouble(0, getHeight() - 2 * radiusGen);
			GOval circle = new GOval(xPosition, yPosition, 2 * radiusGen, 2 * radiusGen);
			circle.setFilled(true);
			circle.setColor(randomGen.nextColor());
			add(circle);		
		}
	}
}
