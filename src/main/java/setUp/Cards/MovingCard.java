package setUp.Cards;

import setUp.Robot;

public class MovingCard {
	private int steps;
	
	public void detMove(String action, Robot robot) {
		if (action == "F1") {
			this.steps = 1;
		}
		else if (action == "F2") {
			this.steps = 2;
		}
		else if (action == "F3") {
			this.steps = 3;
		}
		else if (action == "B")	{
			this.steps = -1;
		}
			
	}
}
