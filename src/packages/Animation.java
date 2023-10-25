//Name: Eliya Rabia.
//ID: 318771052
package packages;
import biuoop.DrawSurface;

/**
 * The interface packages.Animation.
 * this interface is about animation.
 */
public interface Animation {

    /**
     * Do one frame.
     * the function do the logic of the game loop.
     *
     * @param d the d
     */
    void doOneFrame(DrawSurface d);
    /**
     * shouldStop.
     * the function returns the opposite value of running.
     * @return the opposite value of running.
     */
    boolean shouldStop();
}