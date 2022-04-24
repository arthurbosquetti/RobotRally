package setUp;

public class Player {
	
	private String name;
	private boolean turn;
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

	public void setName(String name) { this.name = name; }
	
	public String getName() { return name; }

	public void setTurn(boolean b) {this.turn=b;}
	
	public boolean getTurn() {return turn;}
	
	public void setDeck(Deck newDeck) {this.deck = newDeck;}
	
	public Deck getDeck() {return deck;}

	public void checkHand(Card[] cards, Player player2) {
		if (cards.length == 5) {
			this.setTurn(false);
			player2.setTurn(true);
		}
	}
	
	public void setLives(int newLives) {this.lives = newLives;}
	
	public int getLives() {return lives;}

	public void setFlag1(boolean newFlag1) {this.flag1 = newFlag1;}
	
	public boolean getFlag1() {return flag1;}

	public void setFlag2(boolean newFlag2) {
		this.flag2 = newFlag2;
		if (flag2 == true) {
			setWinner(true);
		}
	}
	
	public boolean getFlag2() {return flag2;}

	public void setLivingStatus(boolean living) {this.alive = living;}

    public boolean isAlive() {return alive;}
    
    public void setWinner(boolean won) {this.won = won;}
    
    public boolean getWinner() {return won;}

}
