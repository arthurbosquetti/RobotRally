package setUp;

public class Player {
	
	private String name;
	private boolean turn;
	private Card[] hand;
	private int lives;
	private boolean flag;
	private boolean Flag;
	
	public Player() {}

	public Player(String newName, int newLives) {
		this.name = newName;
		this.lives = newLives;
		this.flag = false;
		this.Flag = false;
	}

	public void setName(String name) {this.name=name;}

	public void setTurn(boolean b) {this.turn=b;}

	public void setHand(Card[] cards, Player player2) {
		if (cards.length!=5) {
			this.hand=null;
			player2.setTurn(false);
		}
		else {
			this.hand=cards;
			this.setTurn(false);
			player2.setTurn(true);
			}
		}
	public Card[] getHand() {return hand;}
	
	
	public void setLives(int newLives) {this.lives = newLives;}
	
	public int getLives() {return lives;}

	public boolean getTurn() {return turn;}
	
	public void setFlag1(boolean flag1) {this.flag = flag1;}
	
	public boolean getFlag1() {
		return flag;
	}

	public void setFlag2(boolean flag2) {
		this.Flag = flag2;
	}
	
	public boolean getFlag2() {
		return Flag;	
	}
}
