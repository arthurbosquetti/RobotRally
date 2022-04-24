package setUp.Tiles;

import setUp.Board;
import setUp.Robot;

public class TeleportTile extends Tile {
	
	public TeleportTile() {
		this.setValid(true);
	}
	
    @Override
    public String tileType() {
        return " |0|";
    }
    
    @Override
	public void steppedOn(Robot robot, Board board) {
    }
}
