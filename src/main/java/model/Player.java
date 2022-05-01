package model;

public abstract class Player {
	
	private String name;
	private int lives;
	private boolean flag1;
	private boolean flag2;
	private boolean alive;
	private boolean won;
	private Deck deck;
	
	
	public Player(String newName, int newLives) {
		this.name = newName;
		this.lives = newLives;
		this.flag1 = false;
		this.flag2 = false;
		this.alive = true;
		this.won = false;
		this.deck = new Deck();
		deck.newHand();
	}
	
	//Name of Player
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	
	public Deck getDeck() {return deck;}
	
	//how many lives the player has
	public void setLives(int newLives) {this.lives = newLives;}
	public int getLives() {return lives;}

	//flag 1 found
	public void setFlag1(boolean newFlag1) {this.flag1 = newFlag1;}
	public boolean getFlag1() {return flag1;}

	//flag 2 found
	public void setFlag2(boolean newFlag2) {
		this.flag2 = newFlag2;
		if (flag2 == true) {
			setWinner(true);
		}
	}
	public boolean getFlag2() { return flag2; }

	//player is living
	public void setLivingStatus(boolean living) { this.alive = living; }
    public boolean isAlive() { return alive; }
    
    //player has won
    public void setWinner(boolean won) { this.won = won; }
    public boolean getWinner() { return won; }

}
