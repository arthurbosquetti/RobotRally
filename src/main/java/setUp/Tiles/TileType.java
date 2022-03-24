package setUp.Tiles;

public enum TileType {
	
	//TODO: change strings to pictures
	OPEN_FLOOR("|F|"),
	PIT("|P|"),
	ACID("|A|"),
	FLAG("|^|"),
	RADIATION("|R|");
	
	private String picture;
	
	private TileType(String pic) {
		this.picture = pic;
	}
	
	public String getPicture() {
		return picture;
	}
}

