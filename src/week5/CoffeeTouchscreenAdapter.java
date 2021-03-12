package week5;

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface
{
	private OldCoffeeMachine oldMachine;

	public void CoffeeTouchScreenAdapter()
	{
		this.oldMachine = new OldCoffeeMachine();
	}

	public void chooseFirstSelection()
	{
		System.out.println("Old Machine option A was selected via adapter");
		this.oldMachine.selectA();		
	}

	public void chooseSecondSelection()
	{
		System.out.println("Old Machine option B was selected via adapter");
		this.oldMachine.selectB();		
	}
}
