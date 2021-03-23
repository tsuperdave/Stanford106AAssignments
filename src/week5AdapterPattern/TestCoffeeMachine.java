package week5AdapterPattern;

public class TestCoffeeMachine {
	
	public static void main(String[] arg)
	{	
		CoffeeMachineInterface machineAdapter = new CoffeeTouchscreenAdapter(new OldCoffeeMachine());
		
		machineAdapter.chooseFirstSelection();
		machineAdapter.chooseSecondSelection();
	}
}
