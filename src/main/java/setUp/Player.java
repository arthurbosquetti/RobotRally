package setUp;

public class Player {
	
	protected String name;
	protected boolean turn;
	protected Card[] hand;
	protected int lives;
	protected boolean flag1;
	protected boolean flag2;
	protected boolean alive;
	
	public Player() {   }

	public Player(String newName) {
		this.name  = newName;
		//this.lives = newLives; //this is reduntant
		this.flag1 = false;
		this.flag2 = false;
		this.alive = true;
	}

<<<<<<< HEAD
	public void setName(String name) {this.name=name;}// (Reduntant)
=======
	public void setName(String name) { this.name = name; }
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git

<<<<<<< HEAD
	public void setTurn(boolean b) {this.turn=b;}
<<<<<<< HEAD
	public boolean getTurn() {return turn;}
=======
	
	public boolean getTurn() {return turn;}
=======
	public void setTurn(boolean b) { this.turn = b; }
	
	public boolean getTurn() { return turn; }
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
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
	
<<<<<<< HEAD
	public void setLives(int newLives) {this.lives = newLives;}
=======
	public void setLives(int newLives) { this.lives = newLives; }
	
<<<<<<< HEAD
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
	public int getLives() {return lives;}
<<<<<<< HEAD
	
=======

>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
	public void setFlag1(boolean newFlag1) {this.flag1 = newFlag1;}
<<<<<<< HEAD
	public boolean getFlag1() {return flag1;}
=======
=======
	public int getLives() { return lives; }
	
	public void setFlag1(boolean newFlag1) { this.flag1 = newFlag1; }
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
	
	public boolean getFlag1() {
		return flag1;
	}
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git

	public void setFlag2(boolean newFlag2) {this.flag2 = newFlag2;}
	public boolean getFlag2() {return flag2;}

	public void setLivingStatus(boolean living) {this.alive = living;}
    public boolean isAlive() {return alive;}
    
    
    
}
