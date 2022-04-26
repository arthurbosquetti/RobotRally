package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
import view.TileType;

public class EmptyTile extends Tile{
	
	public EmptyTile() {
		this.setValid(true);
		this.setType(TileType.EMPTY);
	}
	
    @Override
    public String tileType() {
        return " |_|";
    }

	@Override
	public void steppedOn(Robot robot, Board board, Game game) {
		
	}
}
