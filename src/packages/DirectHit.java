//Name: Eliya Rabia.
//ID: 318771052

package packages;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Direct hit.
 * this class is about direct hit animation.
 */
public class DirectHit implements LevelInformation {
    //represent the number of balls.
    private int numberOfBalls;
    //represent the velocity list.
    private List<Velocity> ballsVelocities;
    //represent the paddle speed.
    private int paddleSpeed;
    //represent the paddle width.
    private int paddleWidth;
    //represent the centers
    private List<Point> centers;
    //represent the level name.
    private String levelName;
    //represent the background.
    private Sprite background;
    //represent the blocks list.
    private List<Block> blocks;
    //represent the radius.
    private int radius;
    //represent the number of blocks need to remove.
    private int numberOfBlocksToRemove;
    //represent the balls number.
    public static final int BALL_NUMBER = 1;

    /**
     * Instantiates a new Direct hit.
     */
    public DirectHit() {
        this.blocks = new ArrayList<>();
        this.numberOfBalls = BALL_NUMBER;
        //number by logic.
        this.paddleWidth = 50;
        this.paddleSpeed = 5;
        this.radius = 6;
        this.ballsVelocities = new ArrayList<>();
        this.levelName = "Direct hit";
        this.numberOfBlocksToRemove = BALL_NUMBER;
        //numbers by logic.
        int recSize = 20;
        this.centers = new ArrayList<>();
        Point center = new Point(400, 500);
        this.centers.add(center);
        Point centerRec = new Point(380, 280);
        Rectangle rec = new Rectangle(centerRec, recSize, recSize);
        Block block = new Block(rec, Color.RED);
        this.blocks.add(block);
        //numbers by logic.
        this.ballsVelocities.add(Velocity.fromAngleAndSpeed(0, 5));
        this.background = new Target(rec);
    }


    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.ballsVelocities;
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public int getRadius() {
        return this.radius;
    }

    @Override
    public List<Point> getCenters() {
        return this.centers;
    }
}
