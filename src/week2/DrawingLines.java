package week2;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/*
 * Write a GraphicsProgram that allows the user to draw lines on the canvas. Pressing the
mouse button sets the starting point for the line. Dragging the mouse moves the other
endpoint around as the drag proceeds. Releasing the mouse fixes the line in its current
position and gets ready to start a new line. For example, suppose that you press the
mouse button somewhere on the screen and then drag it rightward an inch, holding the
button down.
 */

/*
 * Assume we will need event listeners (mousePressed())
 * draw line while mouse click and held (mouseDragged())
 * if mouse release, stop drawing line (mouseReleased())
 * may need to get coordinates for mouse pointer location 
 */

public class DrawingLines extends GraphicsProgram 
{	
	/*VARIABLES*/
	//private GLabel label;
	private GLine line;	
	
	// double mousePressX, mousePressY;
	double mousePressedX, mousePressedY;
	double mouseDraggedX, mouseDraggedY;
	
	/*RUN*/
	public void run()
	{					
		addMouseListeners();	
	}
	
	/*METHODS*/
	public void mousePressed(MouseEvent e)
	{
		mousePressedX = e.getX();
		mousePressedY = e.getY();
		line = new GLine(mousePressedX, mousePressedY, mousePressedX, mousePressedY);
		line.setColor(Color.BLUE);
		add(line);
	}
	
	public void mouseDragged(MouseEvent e)
	{
		mouseDraggedX = e.getX();
		mouseDraggedY = e.getY();
		line.setEndPoint(mouseDraggedX, mouseDraggedY);
	}
	/*
	public void mouseReleased(MouseEvent e)
	{
		mouseReleaseX = e.getX();
		mouseReleaseY = e.getY();
		repaint();
	}

	public void mouseMoved(MouseEvent e)
	{
		label.setLabel("Mouse: (" + e.getX() + ", " + e.getY() + ")");
	}
	
	public void drawLine() 
	{
		line = new GLine(mouseDraggedX, mouseDraggedY, mouseReleaseX, mouseReleaseY);
		line.setColor(Color.BLUE);
		add(line);
	}
	
	public void drawLabel() 
	{
		label = new GLabel("");
		label.setFont("Times New Roman-18");
		add(label, 100, 100);
	}
	*/
}
