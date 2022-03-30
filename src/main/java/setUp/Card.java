package setUp;

import setUp.Cards.JumpCard;

public class Card{
	MovingCard moving = new MovingCard();
	
	private String action;
	
	public Card(String action) {
		this.action = action;
	}
	public String getCardAction() {
		return action;
	}
	
	public void executeAction(String action, Robot robot, Board board) {
		if (action == "F1" | action == "F2" |action == "F3"|action == "B"|action=="j") {
			moving.detMove(action, robot, board);
		}
		else if (action == "R") {
			robot.getDir().turnRight();
		}
		else if (action == "L") {
			robot.getDir().turnLeft();
		}
	}
	
	@Override
	public String toString() { //overriding the toString() method  
  		return action + "";
 	} 
	
}
