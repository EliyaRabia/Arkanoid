//Name: Eliya Rabia.
//ID: 318771052

package packages;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Wide easy.
 * this class is about wide easy level.
 */
public class WideEasy implements LevelInformation {
    //represent number of balls.
    private int numberOfBalls;
    //list of velocity.
    private List<Velocity> ballsVelocities;
    //paddle speed.
    private int paddleSpeed;
    //paddle width.
    private int paddleWidth;
    //level name.
    private String levelName;
    //background.
    private Sprite background;
    //blocks.
    private List<Block> blocks;
    //represent the radius.
    private int radius;
    //blocks to remove.
    private int numberOfBlocksToRemove;
    //list of centers.
    private List<Point> centers;
    //represent the number of blocks to remove.
    public static final int BLOCKS = 15;
    //represent the number of balls.
    public static final int BALLS = 10;

    /**
     * Instantiates a new Direct hit.
     */
    public WideEasy() {
        this.blocks = new ArrayList<>();
        this.numberOfBalls = BALLS;
        //number2 by logic.
        this.paddleWidth = 600;
        this.paddleSpeed = 1;
        this.radius = 7;
        this.ballsVelocities = new ArrayList<>();
        this.levelName = "Wide Easy";
        this.numberOfBlocksToRemove = BLOCKS;
        this.centers = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls; i++) {
            //numbers by logic.
            double x = 400;
            double y = 550;
            Point center;
            //numbers by logic.
            if (i < 5) {
                this.ballsVelocities.add(Velocity
                        .fromAngleAndSpeed(-70 + (i * 7), 5));
            } else {
                this.ballsVelocities.add(Velocity
                        .fromAngleAndSpeed(35 + (i - 4) * 7, 5));
            }
            center = new Point(x, y);
            this.centers.add(center);
        }
        //numbers by logic.
        for (int i = 0; i < this.numberOfBlocksToRemove; i++) {
            Rectangle rectangle = new Rectangle(new Point(10 + (i * 52),
                    350), 52, 20);
            Color color = Color.black;
            if (i == 1 || i == 0) {
                color = Color.cyan;
            }
            if (i == 3 || i == 2) {
                color = Color.pink;
            }
            if (i == 4 || i == 5) {
                color = Color.blue;
            }
            if (i == 6 || i == 7 || i == 8) {
                color = Color.green;
            }
            if (i == 9 || i == 10) {
                color = Color.yellow;
            }
            if (i == 11 || i == 12) {
                color = Color.orange;
            }
            if (i == 13 || i == 14) {
                color = Color.red;
            }
            this.blocks.add(new Block(rectangle, color));
        }
        //numbers by logic.
        this.background = new Sun(new Point(100, 100), 30);
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

