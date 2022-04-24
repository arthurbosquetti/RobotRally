package setUp.Tiles;

import setUp.Board;
import setUp.Robot;

public class EmptyTile extends Tile{
	
	public EmptyTile() {
		this.setValid(true);
		this.setImage("floor.png");
	}
	
    @Override
    public String tileType() {
        return " |_|";
    }

	@Override
	public void steppedOn(Robot robot, Board board) {
		
	}
}
