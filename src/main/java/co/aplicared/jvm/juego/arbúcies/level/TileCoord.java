package co.aplicared.jvm.juego.arbúcies.level;

public class TileCoord {
    private final int TILE_SIZE = 16;
    private int x, y;

    public TileCoord(int x, int y) {
        this.x = x * TILE_SIZE;
        this.y = y * TILE_SIZE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x * TILE_SIZE;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y * TILE_SIZE;
    }

    public int[] getArray() {
        int[] r = new int[2];
        r[0] = x;
        r[1] = y;
        return r;
    }
}
