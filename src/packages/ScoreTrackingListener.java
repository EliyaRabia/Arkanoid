//Name: Eliya Rabia.
//ID: 318771052

package packages;

/**
 * The type Score tracking listener.
 * this class is about score tracking listener object.
 */
public class ScoreTrackingListener implements HitListener {

    //represent the score tracking counter.
    private Counter currentScore;

    //represent the number increase when hit event occurs.
    public static final int FIVE = 5;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(FIVE);
    }
}