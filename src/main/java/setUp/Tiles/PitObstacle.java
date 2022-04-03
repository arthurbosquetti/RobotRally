package setUp.Tiles;

import setUp.Robot;
public class PitObstacle extends Tile {
    
//    public PitObstacle() {
//        super(TileType.PIT, true);
//    }

    @Override
    public String tileType() {
        return "P";
    }

    public void steppedOn(Robot robot) {
        robot.hurt(1);
    }

}