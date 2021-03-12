package week5;

public class TestCoffeeMachine {
	
	public static void main(String[] arg)
	{	
		// OldCoffeeMachine oldM = new OldCoffeeMachine();
		CoffeeMachineInterface machineAdapter = new CoffeeTouchscreenAdapter(new OldCoffeeMachine());
		
		machineAdapter.chooseFirstSelection();
		machineAdapter.chooseSecondSelection();
	}
}
