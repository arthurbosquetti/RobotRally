package setUp.Tiles;

import setUp.Board;
import setUp.Game;
import setUp.Robot;

public class GlueTile extends Tile {

	public GlueTile() {
		this.setValid(true);
//		this.setImage("acid.png");
	}
	
    @Override
    public String tileType() {
        return " |G|";
    }

    @Override
    public void steppedOn(Robot robot, Board board, Game game) {
    	robot.setGlue(false); // then canMove is true, but might be too confusing
    }


}
