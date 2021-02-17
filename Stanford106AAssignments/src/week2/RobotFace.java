package week2;

import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/* ASSIGNMENT
 * Your job is to draw a robot-looking face like the one shown in the following sample run:
 * The head. The head is a big rectangle whose dimensions are given by the named
   constants HEAD_WIDTH and HEAD_HEIGHT. The interior of the head is gray, although it
   should be framed in black.
• The eyes. The eyes should be circles whose radius in pixels is given by the named
   constant EYE_RADIUS. The centers of the eyes should be set horizontally a quarter of
   the width of the head in from either edge, and one quarter of the distance down from
   the top of the head. The eyes are yellow.
• The mouth. The mouth should be centered with respect to the head in the x-dimension
  and one quarter of the distance up from the bottom of the head in the y-dimension.
  The dimensions of the mouth are given by the named constants MOUTH_WIDTH and
  MOUTH_HEIGHT. The mouth is white.
 */

/*
 * SKELETON
 * declare variables, const for dimension and placement of objects
 * get center of screen in x and y, save to variable
 * center of rectangles in x will be center of window in x, y is variable
 * add objects to screen
 * ensure colors are set
 * may need to add method for 2nd rectangle for outline
 */

public class RobotFace extends GraphicsProgram 
{
	/*object dimensions*/
	private static final double HEAD_WIDTH = 150;
	private static final double HEAD_HEIGHT = 250;
	private static final double EYE_RADIUS = 10;
	private static final double MOUTH_WIDTH = 80;
	private static final double MOUTH_HEIGHT = 20;
	
	
	public void run()
	{
		/*locates center coordinates based on window size*/
		double centWindowX = getWidth() / 2;
		double centWindowY = getHeight() / 2;
		/*adds objects for the face*/
		addFace(centWindowX - HEAD_WIDTH / 2, centWindowY - HEAD_HEIGHT / 2);
		addBorder(centWindowX - HEAD_WIDTH / 2, centWindowY - HEAD_HEIGHT / 2);
		addEye(centWindowX - HEAD_WIDTH / 4, centWindowY - HEAD_HEIGHT / 4);
		addEye(centWindowX + HEAD_WIDTH / 4, centWindowY - HEAD_HEIGHT / 4);
		addMouth(centWindowX - HEAD_WIDTH / 4, centWindowY + HEAD_HEIGHT / 4);
	}
	
	private void drawRect(double xPos, double yPos, double width, double height, Color color)
	{
		GRect rect = new GRect(xPos, yPos, width, height);
		rect.setFilled(true);
		rect.setColor(color);
		add(rect);
	}
	
	private void drawCirc(double objectX, double objectY, double radius, Color color)
	{
		double x = objectX - radius;
		double y = objectY - radius;
		GOval circle = new GOval(2 * radius, 2 * radius);
		circle.setFilled(true);
		circle.setColor(color);
		add(circle, x, y);
	}
	
	private void drawBorder(double xPos, double yPos, double width, double height, Color color)
	{
		GRect border = new GRect(xPos, yPos, width, height);
		border.setFilled(false);
		border.setColor(color);
		add(border);
	}
	
	private void addFace(double xPos, double yPos)
	{
		drawRect(xPos, yPos, HEAD_WIDTH, HEAD_HEIGHT, Color.GRAY);
	}
	
	private void addBorder(double xPos, double yPos)
	{
		drawBorder(xPos, yPos, HEAD_WIDTH, HEAD_HEIGHT, Color.BLACK);
	}
	
	private void addEye(double objectX, double objectY)
	{
		drawCirc(objectX, objectY, EYE_RADIUS, Color.YELLOW);
	}
	
	private void addMouth(double xPos, double yPos)
	{
		drawRect(xPos, yPos, MOUTH_WIDTH, MOUTH_HEIGHT, Color.BLUE);
	}
	
}
