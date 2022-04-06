import io.cucumber.java.en.When;
import setUp.Board;
import setUp.Level;
import setUp.Card;
import setUp.Deck;
import setUp.Tiles.Tile;
import setUp.Tiles.TallObstacle;
import setUp.Robot;

public class RobotRally {
	
	public static void main(String[] args) {

		Deck deck = new Deck();
		deck.newHand();
		
		Board board = new Board();
		Level easy = new Level("Easy", board);

		Robot robo = new Robot("dev");
		robo.setX(2);
		robo.setY(2);

		board.printBoard(robo);

		Card card1 = new Card("F1");
	    card1.executeAction(robo, board);
	}
	
}
