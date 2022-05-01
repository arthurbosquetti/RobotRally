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
	
	//makes move based on action of card
	public void executeAction(Robot robot, Movement mov) {
		//if it's a movement use movingcard
		if ( (this.action.equals("F1"))|| (this.action.equals("F2")) || (this.action.equals("F3")) || (this.action.equals("B")) || (this.action.equals("J"))) {
			moving.detMove(action, robot, mov);
		}
		//otherwise turn right or left
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
