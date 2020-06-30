package co.aplicared.jvm.juego.arbúcies.entity;

import co.aplicared.jvm.juego.arbucies.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Particle extends Entity {
    private final List<Particle> particles = new ArrayList<Particle>();
    private Sprite sprite;

    private int life;

    public Particle() {

    }
}
