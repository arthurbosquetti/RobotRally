package setUp;

public class Card{
	
	private String action;
	public Card(String action) {
		this.action = action;
	}
	public String getCardAction() {
		return action;
	}
	
	@Override
	public String toString() { //overriding the toString() method  
  		return action + "";
 	} 
	
}
