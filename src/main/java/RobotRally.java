import setUp.Board;
import setUp.Tiles.Tile;
import setUp.Tiles.TallObstacle;
import setUp.Robot;

public class RobotRally {
	
	public static void main(String[] args) {
		
		//Board & Robot for testing
		Board board = new Board(1);
		board.setTile(2, 1, new TallObstacle());
		board.printBoard();
		
		Robot robo = new Robot("dev");
		robo.setX(2);
		robo.setY(2);
		
		//make move function working
		board.makeMove(robo, true, 1);
		
		
	}
	
}
