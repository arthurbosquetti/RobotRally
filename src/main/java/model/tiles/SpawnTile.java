package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
import view.TileType;

public class SpawnTile extends Tile {
    private int spawnNum;
    
    public SpawnTile(int spawnNum) {
    	this.setValid(true);
        this.spawnNum = spawnNum;
        this.setType((spawnNum == 1)? TileType.SPAWN1 : TileType.SPAWN2);
    }

    @Override
    public String tileType() {return " |" + spawnNum+"|"; }

	@Override
	public void steppedOn(Robot robot, Board board, Game game) {}
}