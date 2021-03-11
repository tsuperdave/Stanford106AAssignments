package week5;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import acm.graphics.*;
import acm.program.*;

public class BoxDiagram extends GraphicsProgram {
	
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	
	private JButton add;
	private JButton remove;
	private JButton clear;
	private JTextField textField;
	private JLabel textLabel;
	private GPoint lastClick;
	private GObject currentObject;
	
	private HashMap<String, GObject> objectMap;			// could add objects to list?
	private Iterator<String> iterator;
	
	public void init()	
	{
		objectMap = new HashMap<String, GObject>();		// need to add new instance
		add = new JButton("Add");
		remove = new JButton("Remove");
		clear = new JButton("Remove");
		textField = new JTextField(30);
		textLabel = new JLabel("Name");
		add(textLabel, SOUTH);
		add(textField, SOUTH);
		add(add, SOUTH);
		add(remove, SOUTH);
		add(clear, SOUTH);
	}
	
	public void run ()
	{
		addActionListeners();							// add event listener for buttons
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e)
	{
		lastClick = new GPoint(e.getPoint());
		currentObject = getElementAt(lastClick);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if(currentObject != null) currentObject.sendToFront();
	}
	
	public void mouseDragged(MouseEvent e)
	{
		lastClick = new GPoint(e.getPoint());
		if(currentObject != null)
		{
			currentObject.move(e.getX() - lastClick.getX(), e.getY() - lastClick.getY());
			lastClick = new GPoint(e.getPoint());
		}
	}
	
	public void actionPerformed(ActionEvent e)			// will need to determine which action was performed and where
	{
		Object source = e.getSource();
		if(source == add || source == textField)
		{
			createBox(textField.getText());				// need to add box if add or text field was entered
		} else if(source == remove)
		{
			removeBox(textField.getText());				// need to delete box
		} else if(source == clear)
		{
			iterator = objectMap.keySet().iterator();							// need to clear all boxes on screen
			while(iterator.hasNext())											// if iterator detects list has next item in map
			{
				removeBox(iterator.next());										
			}
		}
	}
	
	private void createBox(String name) 									// create GCompound for adding box/border/text, then add to a list
	{
		GCompound box = new GCompound();									
		GRect border = new GRect(BOX_WIDTH, BOX_HEIGHT);
		GLabel label = new GLabel(name);									
		box.add(border, BOX_WIDTH / 2, BOX_HEIGHT / 2);						// add border to GComp, same dimensions as box
		box.add(label, label.getWidth() / 2, label.getHeight() / 2);		// add label, center of window as well
		add(box, getWidth() / 2, getHeight() / 2);							// add box to center of JFrame
		objectMap.put(name, box);											// add object to list/map
	}
	
	private void removeBox(String name)
	{
		GObject object = objectMap.get(name);
		if(object != null)
		{
			remove(object);
		}
	}
	// could create first obj in center of 'Center' field to build other objects around
	// create GCompound for Grect/TextField for respective buttons
	// add mouse dragged method for moving boxes after placement
	// ensure GCompounds are within layout bounds
	
}
