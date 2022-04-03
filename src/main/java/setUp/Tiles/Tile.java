package setUp.Tiles;

import setUp.Robot;;

public abstract class Tile {

	public abstract String tileType();
	public abstract void steppedOn(Robot robot);

	@Override
	public String toString() {
		return " " + this.tileType() + " ";
	}

//    private TileType type;
//	private boolean valid;
//	private int x; private int y;
//
//    public Tile(TileType type, boolean isValid) {
//        this.type = type;
//		this.valid = isValid;
//    }
//
//    public void hit(Robot robot)
//	{
//		System.out.println("Floor tile, no result");
//	}
//
//	public boolean validTile() {
//		return valid;
//	}
//
//	public String toString() {
//		return this.type.getPicture();
//	}
//
//	public void obstacleType(String string) {
//		// TODO Auto-generated method stub
//
//	}
}
