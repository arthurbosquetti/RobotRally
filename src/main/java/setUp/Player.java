package setUp;

public class Player {
	
	private String name;
	private boolean turn;
	private Card[] hand;
	
	public void setName(String name) {
		this.name=name;
	}

	public void setTurn(boolean b) {
		this.turn=b;
	}

	public void setHand(Card[] cards) {
		this.hand=cards;
	}
	
}
