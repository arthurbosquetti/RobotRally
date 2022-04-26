package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
import view.TileType;

public class TallTile extends Tile {

    public TallTile() {
        this.setValid(false);
		this.setType(TileType.TALL);
    }

    @Override
    public String tileType() {
        return " |T|";
    }

	@Override
	public void steppedOn(Robot robot, Board board, Game game) {

	}
}
