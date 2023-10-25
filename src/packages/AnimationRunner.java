//Name: Eliya Rabia
//ID: 318771052
package packages;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;


/**
 * The type packages.Animation runner.
 * this class is about animation runner object.
 */
public class AnimationRunner {
    //represent the gui of the object.
    private GUI gui;
    //represent the frame per second of the object.
    private int framesPerSecond;
    //represent the sleeper of the object.
    private Sleeper sleeper;
    public static final int FRAME_PER_SECOND = 60;
    public static final  int MILL_SECOND = 1000;

    /**
     * Instantiates a new packages.Animation runner.
     *
     * @param gui     the gui
     * @param sleeper the sleeper
     */
    public AnimationRunner(GUI gui, Sleeper sleeper) {
        this.gui = gui;
        this.framesPerSecond = FRAME_PER_SECOND;
        this.sleeper = sleeper;
    }

    /**
     * Run.
     *
     * @param animation the animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = MILL_SECOND / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * Gets gui.
     *
     * @return the gui
     */
    public GUI getGui() {
        return this.gui;
    }
}