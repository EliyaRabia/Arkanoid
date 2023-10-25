//Name: Eliya Rabia.
//ID: 318771052

package packages;
import biuoop.DrawSurface;

/**
 * The interface packages.Sprite.
 * this interface is about the sprites in the game.
 */
public interface Sprite {
    /**
     * Draw on.
     * the function gets a draw surface and draw the sprite on it.
     *
     * @param d represent the draw surface
     */
    void drawOn(DrawSurface d);

    /**
     * Time passed.
     * the function notify the sprite that the time passed.
     *
     */
    void timePassed();
}