package model.tiles;
import java.util.concurrent.ThreadLocalRandom;
import model.Direction;

public class TileFactory {
	
	public static Direction randomDir() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
		int a = randomNum * 90;
		Direction dir = new Direction(a);
		return dir;
	}
	
    public static Tile getTile(String tile) {
        if (tile.equalsIgnoreCase("FLAG1")) {
            return new FlagTile(1);
        } else if (tile.equalsIgnoreCase("FLAG2")) {
            return new FlagTile(2);
        } else if (tile.equalsIgnoreCase("SPAWN1")) {
            return new SpawnTile(1);
        } else if (tile.equalsIgnoreCase("SPAWN2")) {
            return new SpawnTile(2);
        } else if (tile.equalsIgnoreCase("TELEPORT")) {
            return new TeleportTile();
        } else if (tile.equalsIgnoreCase("MINE")) {
            return new MineTile();
        } else if (tile.equalsIgnoreCase("PIT")) {
            return new PitTile();
        } else if (tile.equalsIgnoreCase("GLUE")) {
            return new GlueTile();
        } else if (tile.equalsIgnoreCase("CONVEYOR")) {
            return new ConveyorTile(randomDir());
        }  else if (tile.equalsIgnoreCase("TALL")) {
            return new TallTile();
        } else if (tile.equalsIgnoreCase("EMPTY")) {
            return new EmptyTile();
        }
        return null;
    }
}