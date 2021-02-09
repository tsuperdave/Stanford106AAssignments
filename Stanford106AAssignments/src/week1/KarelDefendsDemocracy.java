package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() 
	{
		while(frontIsClear()) 
		{
			move();
			while(beepersPresent()) 
			{
				pickBeeper();
			}
			turnRight();
			
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
			turnLeft();
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
check if beepers (check if beepers is > 1 using while loop)
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
