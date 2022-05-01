package model.tiles;

import model.Robot;
import view.TileType;

public interface Tile {

	boolean validTile();

	void setValid(boolean newValid);

	void setType(TileType newType);

	String getType();
}
