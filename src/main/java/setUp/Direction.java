package setUp;

public enum Direction {
    NORTH(0),
    WEST(90),
    SOUTH(180),
    EAST(270);

    private int direction;

    private Direction(int dir) {
        this.direction = dir;
    }

    public void turnLeft() {
        if (direction < 270) {
            direction += 90;
        } else {
            direction = 0;
        }
    }

    public void turnRight() {
        if (direction > 0) {
            direction -= 90;
        } else {
            direction = 270;
        }
    }

}
