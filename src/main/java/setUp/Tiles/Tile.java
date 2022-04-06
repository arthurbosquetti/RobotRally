package setUp.Tiles;

import setUp.Robot;;

public abstract class Tile {
	
	private boolean valid;

	public abstract String tileType();
	public abstract void steppedOn(Robot robot);

	@Override
	public String toString() {
		return " " + this.tileType() + " ";
	}

	public boolean validTile() {
		return valid;
	}
	
	public void setValid(boolean newValid) {
		this.valid = newValid;
	}
}
