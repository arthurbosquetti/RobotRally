package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
import view.TileType;

public class GlueTile extends Tile {

	public GlueTile() {
		this.setValid(true);
		this.setType(TileType.GLUE);
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
