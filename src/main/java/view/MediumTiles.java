package view;

public enum MediumTiles {

    EMPTY("main/resources/tiles/medium/empty.png"),
    FLAG1("main/resources/tiles/medium/flag1.png"),
    FLAG2("main/resources/tiles/medium/flag2.png"),
    CONVEYOR("main/resources/tiles/medium/conveyor.png"),
    GLUE("main/resources/tiles/medium/glue.png"),
    MINE("main/resources/tiles/medium/mine.png"),
    PIT("main/resources/tiles/medium/pit.png"),
    PORTAL("main/resources/tiles/medium/portal.png"),
    SPAWN1("main/resources/tiles/medium/spawn1.png"),
    SPAWN2("main/resources/tiles/medium/spawn2.png"),
    TALL("main/resources/tiles/medium/tall.png");

    private String pictureFile;

    private MediumTiles(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    public String getPictureFile() {
        return pictureFile;
    }
}
