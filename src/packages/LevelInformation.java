//ID : 318771052
//Name: Eliya Rabia

package packages;
import java.util.List;

/**
 * Level information
 * this interface is about level information.
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int
     */
    int numberOfBalls();

    /**
     * Initial ball velocities list.
     * The initial velocity of each ball.
     *
     * @return the list
     */
    List<Velocity> initialBallVelocities();

    /**
     * packages.Paddle speed int.
     * the function returns the paddle speed.
     *
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * packages.Paddle width int.
     * the function returns the paddle width.
     *
     * @return the paddle width.
     */
    int paddleWidth();

    /**
     * Level name string.
     * the function returns the level name.
     *
     * @return the string name.
     */
    String levelName();

    /**
     * Gets background.
     * the function returns the background of the level.
     *
     * @return the background
     */
    Sprite getBackground();

    /**
     * Blocks list.
     * the function returns the block list of the level.
     *
     * @return the list of blocks.
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove int.
     *
     * @return the number of blocks to remove.
     */
    int numberOfBlocksToRemove();

    /**
     * Gets radius.
     *
     * @return the radius
     */
    int getRadius();

    /**
     * Gets centers.
     *
     * @return the centers
     */
    List<Point> getCenters();
}