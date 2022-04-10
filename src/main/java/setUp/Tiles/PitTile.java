package setUp.Tiles;

import setUp.Robot;
public class PitTile extends Tile {
    
    public PitTile() {
        this.setValid(true);
        this.setImage("tiles/pit.png");
    }

    @Override
    public String tileType() {
        return " |P|";
    }

    public void steppedOn(Robot robot) {
       robot.hurt(1);
    }

}