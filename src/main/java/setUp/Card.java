package setUp;

import setUp.Cards.JumpCard;
import setUp.Cards.MovingCard;

public class Card{
	MovingCard moving = new MovingCard();
	JumpCard jump = new JumpCard();
	
	private String action;
	
	public Card(String action) {
		this.action = action;
	}
	public String getCardAction() {
		return action;
	}
	
	public void executeAction(String action, Robot robot) {
		if (action == "F1" | action == "F2" |action == "F3"|action == "B" ) {
			moving.detMove(action, robot);
		}
		else if (action == "R") {
			robot.getDir().turnRight();
		}
		else if (action == "L") {
			robot.getDir().turnLeft();
		}
		else if (action == "J") {
			
		}
	}
	
	@Override
	public String toString() { //overriding the toString() method  
  		return action + "";
 	} 
	
}
