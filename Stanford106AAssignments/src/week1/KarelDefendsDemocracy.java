package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() 
	{
		while(frontIsClear()) 
		{
			move();
			if(noBeepersPresent())
			{
				turnLeft();
				move();
				while(beepersPresent())
				{
					pickBeeper();
				}
				turnAround();
				move();
				move();
				while(beepersPresent())
				{
					pickBeeper();
				}
				turnAround();
				move();
				turnRight();
			}
			move();
		}	
				
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

/*
starts 1,3
move forward (karel is facing east by default)
check if wall/blocked
check if beepers present
if beeper is not present, turn left and move
while beeper is present, pick up (until none left)
*/

/*
commands available by default:
move
turnLeft
pickBeeper
placeBeeper
frontIsClear or frontIsBlocked -- boolean
left/rightIsClear (or IsBlocked) -- boolean
beepersPresent or noBeepersPresent
beepersInBag or noBeepersInBag
facingNorth (East/South/West) or notFacingNorth (S/E/W)
*/
