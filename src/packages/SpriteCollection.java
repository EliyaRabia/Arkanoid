//Name: Eliya Rabia.
//ID: 318771052

package packages;
import biuoop.DrawSurface;
import java.util.List;

/**
 * The type packages.Sprite collection.
 * this class is about the sprites in the game.
 */
public class SpriteCollection {

    //list of sprites in the game.
    private java.util.List<Sprite> sprites = null;

    /**
     * packages.Sprite collection.
     * the function creates a list of sprites.
     */
    public SpriteCollection() {
        this.sprites = new java.util.ArrayList<Sprite>();
    }

    /**
     * Add sprite.
     * the function gets a sprite and add it to the sprites list.
     *
     * @param s represent the sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Notify all time passed.
     * the function notify all the sprites that the time passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> copy = new java.util.ArrayList<Sprite>(this.sprites);
        for (Sprite s : copy) {
            s.timePassed();
        }
    }

    /**
     * Draw all on.
     * the function gets a draw surface and draw all the sprites on it.
     *
     * @param d represent the surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
    /**
     * Gets sprites.
     * the function returns the sprites.
     * @return the sprites
     */
    public List<Sprite> getSprites() {
        return sprites;
    }
}