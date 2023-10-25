//Name:Eliya Rabia.
//ID: 318771052

package packages;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * The type Pause screen.
 * this class is about pausing the game.
 */
public class PauseScreen implements Animation {
    //represent the keyboard controller.
    private KeyboardSensor keyboard;
    //user for stopping the animation.
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     * the function creates pause screen object.
     *
     */
    public PauseScreen() {
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space "
                + "to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}