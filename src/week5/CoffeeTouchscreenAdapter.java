package week5;


/* IMAGINE AS ADAPTER CABLE TO ALLOW OLD TO WORK WITH NEW */

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface
{
	OldCoffeeMachine oldMachine;
	
	/* CONSTRUCTOR */
	public CoffeeTouchscreenAdapter(OldCoffeeMachine machine)
	{
		oldMachine = machine;
	}
	
	public void chooseFirstSelection()
	{
		System.out.println("Old Machine option A was selected via adapter");
		oldMachine.selectA();
	}

	public void chooseSecondSelection()
	{
		System.out.println("Old Machine option B was selected via adapter");
		oldMachine.selectB();
	}
}
