//Name: Eliya Rabia
//ID: 318771052

package packages;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Countdown animation.
 */
public class CountdownAnimation implements Animation {
    private int counter;
    //represent if still counting.
    private boolean counting;
    //represent the started time.
    private long timeStarted;
    //represent the game sprites.
    private SpriteCollection gameSprites;
    //represent the seconds we are counting;
    public static final int SECONDS = 3;
    //represent the mill seconds we are counting.
    public static final long MILLS = 3000;
    //represent if the wanted time is passed.
    public static final int TIME_PASS = 0;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param gameSprites the game sprites
     */
    public CountdownAnimation(SpriteCollection gameSprites) {
        this.counting = true;
        this.gameSprites = gameSprites;
        this.timeStarted = System.currentTimeMillis();
        this.counter = SECONDS;
    }
    @Override
    public void doOneFrame(DrawSurface surface) {
        if (this.counter == 0) {
            this.counting = false;
        }
        this.gameSprites.drawAllOn(surface);
        surface.setColor(Color.RED);
        //number by logic to look nice.
        surface.drawText(350, 450, Integer.toString(this.counter),
                65);
        long usedTime = System.currentTimeMillis() - this.timeStarted;
        long milliSecondLeftToCount = MILLS / SECONDS - usedTime;
        if (milliSecondLeftToCount < TIME_PASS) {
            this.timeStarted = System.currentTimeMillis();
            this.timeStarted = System.currentTimeMillis();
            this.counter--;
        }
    }
    @Override
    public boolean shouldStop() {
        return !this.counting;
    }
}
