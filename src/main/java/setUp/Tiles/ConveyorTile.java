package setUp.Tiles;

import setUp.Robot;
import setUp.Direction;

public class ConveyorTile extends Tile {
    
    Direction direction;

    public ConveyorTile(Direction dir) {
        super(TileType.CONVEYOR, true);
        direction = dir;
    }
    public ConveyorTile() {
        super(TileType.CONVEYOR, true);
        this.direction = new Direction(0);
    }



}
