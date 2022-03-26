package setUp.Tiles;

import setUp.Robot;;

public class Tile {

    private TileType type;
    private static boolean firstFlagReached;
    private static boolean secondFlagReached;
    private static boolean robotMoved;

    public Tile(TileType type) {
        this.type = type;

    }

    public void hit(Robot robot)
	{	
		System.out.println("nothing");
	}
	
	public boolean validTile() {
		return true;
	}
	
	public String toString() {
		return this.type.getPicture();
	}
	
	public static boolean firstFlagReached() {
		return firstFlagReached;
	}
	
	public static boolean secondFlagReached() {
		return secondFlagReached;
	}
	
	public static boolean robotMoved() {
		return robotMoved;
	}

	public void obstacleType(String string) {
		// TODO Auto-generated method stub
		
	}
}
