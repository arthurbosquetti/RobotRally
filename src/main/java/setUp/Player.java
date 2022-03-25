package setUp;

public class Player {
	
	private String name;
	private boolean turn;
	private Card[] hand;
	private int lives;
	
	public void setName(String name) {
		this.name=name;
	}

	public void setTurn(boolean b) {
		this.turn=b;
	}

	public void setHand(Card[] cards) {
		this.hand=cards;
	}
	
	public void setLives(int newLives) {
		this.lives = newLives;
	}
	
	public int getLives() {
		return lives;
	}

	public boolean getTurn() {
		return turn;
	}
	
}
