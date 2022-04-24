package setUp.Tiles;

import setUp.Board;
import setUp.Game;
import setUp.Robot;

public class TallTile extends Tile {

    public TallTile() {
        this.setValid(false);
        this.setImage("tall.png");
    }

    @Override
    public String tileType() {
        return " |T|";
    }

	@Override
	public void steppedOn(Robot robot, Board board, Game game) {

	}
}
