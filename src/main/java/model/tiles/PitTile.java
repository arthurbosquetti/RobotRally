package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
import view.TileType;
public class PitTile extends Tile {
    
    public PitTile() {
        this.setValid(true);
		this.setType(TileType.PIT);
    }

    @Override
    public String tileType() {
        return "PIT";
    }

    public void steppedOn(Robot robot, Board board, Game game) {
       robot.hurt(1);
    }

}