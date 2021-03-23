package week5AdapterPattern;

/* IMAGINE AS ADAPTER CABLE TO ALLOW OLD TO WORK WITH NEW */

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface
{
	private OldCoffeeMachine oldVendingMachine;
	
	/* CONSTRUCTOR */
	public CoffeeTouchscreenAdapter(OldCoffeeMachine oldVendingMachine)
	{
		this.oldVendingMachine = oldVendingMachine;
	}
	
	@Override
	public void chooseFirstSelection()
	{
		System.out.println("Old Machine option A was selected via adapter");
		oldVendingMachine.selectA();
	}

	@Override
	public void chooseSecondSelection()
	{
		System.out.println("Old Machine option B was selected via adapter");
		oldVendingMachine.selectB();
	}
}
