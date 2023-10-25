//Name: Eliya Rabia.
//ID: 318771052

package packages;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * The type End screen.
 * this class is about end screen.
 */
public class EndScreen implements Animation {
    //represent the win or loose.
    private boolean status;
    //represent the score.
    private Counter score;
    //represent the keyboard.
    private KeyboardSensor keyboardSensor;
    //represent the animation runner.
    private AnimationRunner animationRunner;
    //represent should stop.
    private boolean shouldStop;
    //represent the gui width.
    public static final int WIDTH = 800;
    //represent the gui height.
    public static final int HEIGHT = 600;

    /**
     * Instantiates a new End screen.
     *
     * @param status          the status
     * @param score           the score
     * @param animationRunner the animation runner
     * @param keyboardSensor  the keyboard sensor
     */
    public EndScreen(boolean status, Counter score,
                     AnimationRunner animationRunner,
                     KeyboardSensor keyboardSensor) {
        this.status = status;
        this.score = score;
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
            String massage = "";
            if (this.status) {
                massage = "You Win! Your score is " + this.score.getValue();
            } else {
                massage = "Game Over. Your score is " + this.score.getValue();
            }
            //numbers by logic.
            d.drawText(60,
                    d.getHeight() / 2, massage, 50);
    }
}
