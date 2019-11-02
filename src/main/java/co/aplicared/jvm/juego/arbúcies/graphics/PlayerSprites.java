package co.aplicared.jvm.juego.arbúcies.graphics;

public enum PlayerSprites {
    NORTH(0, Sprite.player0Sprite),
    EAST(1, Sprite.player1Sprite),
    SOUTH(2, Sprite.player2Sprite),
    WEST(3, Sprite.player3Sprite);

    private final int ind;
    private final Sprite spr;

    PlayerSprites(int index, Sprite sprite) {
        this.ind = index;
        this.spr = sprite;
    }

    public Sprite sprite() {
        return spr;
    }

    public int index() {
        return ind;
    }
}
