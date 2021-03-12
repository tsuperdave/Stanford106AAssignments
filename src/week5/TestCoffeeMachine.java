package week5;

public class TestCoffeeMachine {
	
	public static void main(String[] arg)
	{	
		// OldCoffeeMachine oldM = new OldCoffeeMachine();
		CoffeeTouchscreenAdapter machineAdapter = new CoffeeTouchscreenAdapter();		
		machineAdapter.chooseFirstSelection();
		machineAdapter.chooseSecondSelection();
	}
}
