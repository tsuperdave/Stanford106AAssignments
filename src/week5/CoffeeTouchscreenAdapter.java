package week5;

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface
{
	OldCoffeeMachine oldMachine;
	
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
