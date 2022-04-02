import io.cucumber.java.en.When;
import setUp.Board;
import setUp.Card;
import setUp.Deck;
import setUp.Tiles.Tile;
import setUp.Tiles.TallObstacle;
import setUp.Robot;

public class RobotRally {
	
	public static void main(String[] args) {

		/*Deck deck = new Deck();
		deck.newHand();
		
		//For testing the boards
		//Board board = new Board(1);
		//board.setTile(2, 2, new Tile(TileType.FLAG));
		//Board & Robot for testing
		Board board = new Board();
		board.setTile(2, 2, new TallObstacle());
		
	
		Robot robo = new Robot("dev");
		robo.setX(2);
		robo.setY(3);
		
		//able to print a board with a robot
		//board.printBoard();
		
		//printing board with robot on it
		board.printBoard(robo);
		
		//make move function working
		board.makeMove(robo, true, 1, false);
		
		Card card1 = new Card("F1");
	    card1.executeAction(robo, board);
	    */
		Board board = new Board();
		board.setTile(2, 2, new TallObstacle());
		
	
		Robot robo = new Robot("dev");
		robo.setX(2);
		robo.setY(3);
		
		Card card1 = new Card("F1");
	    card1.executeAction(robo, board);
	}
	
}
