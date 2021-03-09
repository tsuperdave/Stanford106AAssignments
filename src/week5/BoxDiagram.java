package week5;

import java.awt.*;
import javax.swing.*;

import acm.program.*;

public class BoxDiagram extends GraphicsProgram {
	
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	
	private JButton add;
	private JButton remove;
	private JButton clear;
	private JTextField textField;
	private JLabel textLabel;
	
	public void init()	
	{
		
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
		addActionListeners();
		addMouseListeners();
	}
	
	public void run ()
	{
		
	}
	
	// add event listener for buttons
	// create GCompound for Grect/TextField for respective buttons
	// add mouse dragged method for moving boxes after placement
	// ensure GCompounds are within layout bounds
	
}
