package co.aplicared.jvm.juego.arbúcies.util;

public enum Compass {
    NORTH(0, "North"),
    EAST(1, "East"),
    SOUTH(2, "South"),
    WEST(3, "West");

    private final int val;
    private final String description;

    Compass(int i, String description) {
        val = i;
        this.description = description;
    }

    public int value() {
        return val;
    }

    public String desc() {
        return description;
    }
}