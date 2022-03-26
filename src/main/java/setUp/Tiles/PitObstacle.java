package setUp.Tiles;

import setUp.Robot;
public class PitObstacle extends Tile {
    
    public PitObstacle() {
        super(TileType.PIT, true);
    }

    public void hit(Robot robot) {
        robot.hurt(1);
    }

}