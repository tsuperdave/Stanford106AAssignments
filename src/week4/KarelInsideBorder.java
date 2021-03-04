package week4;

import stanford.karel.SuperKarel;

/* 													INSTRUCTIONS
 * create a border of beepers (one per square only) inside the width/height of world window by 1 space (column/row)
 *  min world size is 3x3 (only 1 beeper in center)
 *  Karel starts off facing East at square 1, 1 (bottom left corner of world)
 *  final location or path is up to us
 *  Commands are limited to instructions in Karel Booklet @ https://see.stanford.edu/materials/icspmcs106a/28-practice-midterm.pdf
 */

/* 														TO DO
 * need to determine H and W of world?
 * since we start 1,1, we can immediately move to 2,2 and place a beeper
 * after placing first beeper, start placing beepers in line heading N or E, also checking if front is clear
 * if wall detected (front not clear), pick up beeper and back up one space, then turn towards new line of beepers to be placed
 * 
 * */

public class KarelInsideBorder extends SuperKarel 
{
	
	public void run()
	{
		move();													// being moving to 2,2
		turnLeft();
		move();
		turnRight();
		putBeeper();											// this will place a beeper at 2,2 no matter what, as min world size can only be 3x3
		
		/* MOVING EAST */															
		while(frontIsClear())									// if no wall, will move and place beeper
		{
			move();
			if(noBeepersPresent())								// if no beeper is present, place one. This will prevent overlap at wall or on 3x3 world
			{
				putBeeper();
			}
			
		}
		pickBeeper();											// if wall detected, break from loop and pick up recently placed beeper
		turnAround();											// turn around
		move();													// move space back to where inside border will be
		turnRight();											// turn right to face new pathing
		
		/* MOVING NORTH */
		while(frontIsClear())									
		{
			move();
			if(noBeepersPresent())
			{
				putBeeper();
			}
		}
		pickBeeper();											
		turnAround();
		move();
		turnRight();
		
		/* MOVING WEST */
		while(frontIsClear())									
		{
			move();
			if(noBeepersPresent())
			{
				putBeeper();
			}
		}	
		pickBeeper();																				
		turnAround();
		move();
		turnRight();
		
		/* MOVING SOUTH */
		while(frontIsClear())									
		{
			move();
			if(noBeepersPresent())
			{
				putBeeper();
			}
		}	
		pickBeeper();											// this will pick up final beeper at 1,2 and after all inside border has been placed
	}
	
	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	public void turnAround()
	{
		turnLeft();
		turnLeft();
	}
}
