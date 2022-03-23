package setUp.Tiles;

public class Tile {

    private TileType type;

    public Tile(TileType type) {
        this.type = type;

    }

    public void hit()
	{	
		System.out.println("nothing");
	}
	
	public boolean validTile() {
		return true;
	}
}
