//Name: Eliya Rabia.
//ID: 318771052

package packages;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * The type Empty level.
 * this class is about empty level.
 */
public class EmptyLevel implements Animation {
    //represent the jey board.
    private KeyboardSensor keyboardSensor;
    //represent the animation runner.
    private AnimationRunner animationRunner;
    //represent need to stop.
    private boolean shouldStop;
    //represent the width of the gui.
    public static final int WIDTH = 800;
    //represent the height of the gui.
    private static final int HEIGHT = 600;

    /**
     * Instantiates a new End screen.
     *
     * @param animationRunner the animation runner
     * @param keyboardSensor  the keyboard sensor
     */
    public EmptyLevel(AnimationRunner animationRunner,
                      KeyboardSensor keyboardSensor) {
        this.animationRunner = animationRunner;
        this.keyboardSensor = keyboardSensor;
        this.shouldStop = false;
    }
    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
        d.setColor(Color.black);
        //number by logic.
        d.drawText(60, d.getHeight() / 2, "You Don't enter any Level"
                + "Number between 1 to 3", 30);
    }
}
