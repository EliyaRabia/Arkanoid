//Name: Eliya Rabia.
//ID: 318771052.
package packages;

/**
 * The type packages.Ball remover.
 * this class is about remove ball listener.
 */
public class BallRemover implements HitListener {

    //represent the ball game.
    private GameLevel gameLevel;

    //represent the counter of the ball that in the game.
    private Counter remainingBalls;

    public static final int DECREASE_BALL = 1;

    /**
     * Instantiates a new packages.Ball remover.
     *
     * @param gameLevel          the game
     * @param remainingBalls the remaining Balls
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

   @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(DECREASE_BALL);
        hitter.removeFromGame(gameLevel);
    }
}