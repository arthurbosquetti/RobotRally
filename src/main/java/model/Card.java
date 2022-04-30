package model;


public class Card{
	MovingCard moving = new MovingCard();
	
	private String action;
	
	public Card(String action) {
		this.action = action;
	}
	
	public MovingCard get_MovingCard() {
		return moving;
	}
	
	public String getCardAction() {
		return action;
	}
	
	public void executeAction(Robot robot, Board board) {
		if ( (this.action.equals("F1"))|| (this.action.equals("F2")) || (this.action.equals("F3")) || (this.action.equals("B")) || (this.action.equals("J") || (this.action.equals("NO")))) {
			moving.detMove(action, robot, board);
		}
		else if (this.action.equals("R")) {
			robot.getDir().turnRight();
		}
		else if (this.action.equals("L")) {
			(robot.getDir()).turnLeft();
		}
	}
	
	@Override
	public String toString() { //overriding the toString() method  
  		return action + "";
 	} 
 	
	
}
