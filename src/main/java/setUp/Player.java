package setUp;

public class Player {
	
	private String name;
	private boolean turn;
	private Card[] hand;
	private int lives;
	private boolean flag1;
	private boolean flag2;
	private boolean alive;
	
	public Player() {   }

	public Player(String newName, int newLives) {
		this.name = newName;
		this.lives = newLives;
		this.flag1 = false;
		this.flag2 = false;
		this.alive = true;
	}

	public void setName(String name) { this.name = name; }

<<<<<<< HEAD
	public void setTurn(boolean b) {this.turn=b;}
	
	public boolean getTurn() {return turn;}
=======
	public void setTurn(boolean b) { this.turn = b; }
	
	public boolean getTurn() { return turn; }
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git

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
	
	public Card[] getHand() { return hand; }
	
	public void setLives(int newLives) { this.lives = newLives; }
	
<<<<<<< HEAD
	public int getLives() {return lives;}

	public void setFlag1(boolean newFlag1) {this.flag1 = newFlag1;}
=======
	public int getLives() { return lives; }
	
	public void setFlag1(boolean newFlag1) { this.flag1 = newFlag1; }
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
	
	public boolean getFlag1() {
		return flag1;
	}

	public void setFlag2(boolean newFlag2) {
		this.flag2 = newFlag2;
	}
	
	public boolean getFlag2() {
		return flag2;
	}

	public void setLivingStatus(boolean living) {
        this.alive = living;
    }

    public boolean isAlive() {
        return alive;
    }
}
