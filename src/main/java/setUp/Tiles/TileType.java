package setUp.Tiles;

public enum TileType {
	
	//TODO: change strings to pictures
	OPEN_FLOOR("| |"),
	PIT("|P|"),
	FLAG("|^|"),
	TALL("|T|");
	
	private String picture;
	
	private TileType(String pic) {
		this.picture = pic;
	}
	
	public String getPicture() {
		return picture;
	}
}

