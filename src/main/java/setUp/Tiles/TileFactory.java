package setUp.Tiles;

public class TileFactory {
    public static Tile getTile(String tile) {
        if (tile.equalsIgnoreCase("FLAG")) {
            return new FlagTile();
        } else if (tile.equalsIgnoreCase("PIT")) {
            return new PitObstacle();
        } else if (tile.equalsIgnoreCase("TALL")) {
            return new TallObstacle();
        } else if (tile.equalsIgnoreCase("EMPTY")) {
            return new EmptyTile();
        }
        return null;
    }
}
