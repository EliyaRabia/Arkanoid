//ID : 318771052
//Name : Eliya Rabia

package packages;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Direct hit.
 * this class is about green 3 level.
 */
public class Green3 implements LevelInformation {
    private int radius;
    //represent the number of balls.
    private int numberOfBalls;
    //list of velocity
    private List<Velocity> ballsVelocities;
    //paddle speed.
    private int paddleSpeed;
    //paddle width.
    private int paddleWidth;
    //level name.
    private String levelName;
    //background.
    private Sprite background;
    // list of blocks.
    private List<Block> blocks;
    //represent the centers.
    private List<Point> centers;
    //number of block to remove.
    private int numberOfBlocksToRemove;
    //represent the balls number.
    public static final int BALLS = 2;
    //represent the blocks to remove number.
    public static final int BLOCKS = 25;
    //row.
    public static final int ROWS = 5;
    //columns.
    public static final int COLUMNS = 6;

    /**
     * Instantiates a new Green 3.
     * creates green 3 object.
     */
    public Green3() {
        this.blocks = new ArrayList<>();
        this.numberOfBalls = BALLS;
        //numbers by logic.
        this.paddleWidth = 50;
        this.radius = 5;
        this.paddleSpeed = 10;
        this.ballsVelocities = new ArrayList<>();
        this.levelName = "Green 3";
        this.numberOfBlocksToRemove = BLOCKS;
        //numbers by logic.
        Point center1 = new Point(400, 550);
        Point center2 = new Point(400, 550);
        this.centers = new ArrayList<>();
        this.centers.add(center1);
        this.centers.add(center2);
        for (int i = 0; i < this.numberOfBalls; i++) {
            //numbers by logic.
            if (i == 0) {
                this.ballsVelocities.add(Velocity
                        .fromAngleAndSpeed(40, 7));
            }
            if (i == 1) {
                this.ballsVelocities.add(Velocity
                        .fromAngleAndSpeed(-40, 7));
            }
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < i + COLUMNS; j++) {
                //numbers by logic.
                Rectangle rectangle = new Rectangle(new Point(745 - (j * 45),
                        240 - (20 * (i + 1))), 45, 20);
                Color color = Color.black;
                if (i == 0) {
                    color = Color.white;
                }
                if (i == 1) {
                    color = Color.blue;
                }
                if (i == 2) {
                    color = Color.yellow;
                }
                if (i == 3) {
                    color = Color.red;
                }
                if (i == 4) {
                    color = Color.gray;
                }
                this.blocks.add(new Block(rectangle, color));
            }
        }
        //numbers by logic.
        this.background = new Building(new Point(50, 300));
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
        return radius;
    }

    @Override
    public List<Point> getCenters() {
        return this.centers;
    }
}
