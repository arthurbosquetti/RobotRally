package setUp;

public class Card{
	MovingCard moving = new MovingCard();
	
	private String action;
	
	public Card(String action) {
		this.action = action;
	}
	public String getCardAction() {
		return action;
	}
	
	public void executeAction(Robot robot, Board board) {
		if (action == "F1" | action == "F2" |action == "F3"|action == "B"|action=="J") {
			moving.detMove(action, robot, board);
		}
		else if (action == "R") {
			//This never actually runs -> turnRight cannot be accessed
			robot.getDir().turnRight();
		}
		else if (action == "L") {
			//Same comment as above
			(robot.getDir()).turnLeft();
		}
	}
	
	@Override
	public String toString() { //overriding the toString() method  
  		return action + "";
 	} 
	
}
