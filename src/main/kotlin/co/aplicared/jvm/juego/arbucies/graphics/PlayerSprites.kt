package co.aplicared.jvm.juego.arbucies.graphics

enum class PlayerSprites(private val index: Int, private val s1: Sprite, private val s2: Sprite) {
    FRONT(0, Sprite.Player.player0Frnt0, Sprite.Player.player0Frnt1),
    LEFT(1, Sprite.Player.player0Left0, Sprite.Player.player0Left1),
    BACK(2, Sprite.Player.player0Bck0, Sprite.Player.player0Bck1),
    RIGHT(3, Sprite.Player.player0Rght0, Sprite.Player.player0Rght1);

    fun sprite(): Sprite {
        return s1
    }

    fun spriteAlt(): Sprite {
        return s2
    }

    fun index(): Int {
        return index
    }
}