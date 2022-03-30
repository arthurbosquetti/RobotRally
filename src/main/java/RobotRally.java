import setUp.Board;
import setUp.Deck;
import setUp.Tiles.Tile;
import setUp.Tiles.TileType;

public class RobotRally {
	
	public static void main(String[] args) {
		
		Deck deck = new Deck();
		deck.newHand();
		
		//For testing the boards
		//Board board = new Board(1);
		//board.setTile(2, 2, new Tile(TileType.FLAG));
		//board.printBoard();
	}
	
}
