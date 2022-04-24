package view;

public enum HardTiles {

    EMPTY("main/resources/tiles/hard/empty.png"),
    FLAG1("main/resources/tiles/hard/flag1.png"),
    FLAG2("main/resources/tiles/hard/flag2.png"),
    CONVEYOR("main/resources/tiles/hard/conveyor.png"),
    GLUE("main/resources/tiles/hard/glue.png"),
    MINE("main/resources/tiles/hard/mine.png"),
    PIT("main/resources/tiles/hard/pit.png"),
    PORTAL("main/resources/tiles/hard/portal.png"),
    SPAWN1("main/resources/tiles/hard/spawn1.png"),
    SPAWN2("main/resources/tiles/hard/spawn2.png"),
    TALL("main/resources/tiles/hard/tall.png");

    private String pictureFile;

    private HardTiles(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    public String getPictureFile() {
        return pictureFile;
    }
}
