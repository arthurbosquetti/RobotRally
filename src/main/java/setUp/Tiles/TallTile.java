package setUp.Tiles;

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
    public void steppedOn(Robot robot) {
    	
    }
}
