//ID : 318771052
//Name : Eliya Rabia

package packages;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.Random;
import java.awt.Color;

/**
 * The type Game.
 * this class is about the actual game create it and the objects and the
 * animation.
 */
public class GameLevel implements Animation {
    private Counter lives;
    //represent the level information of each level in the game.
    private LevelInformation levelInformation;
    //represent the keyboard object.
    private KeyboardSensor keyboard;
    //represent the animation runner object.
    private AnimationRunner runner;
    //represent the loop animation running.
    private boolean running;

    // the sprite objects of the game
    private SpriteCollection sprites;

    //the environment of the game.
    private GameEnvironment environment;

    //the gui of the game.
    private GUI gui;

    //represent the block counter.
    private Counter blocksCounter;

    //represent the balls counter.
    private Counter ballsCounter;

    //represent the score counter.
    private Counter scoreCounter;

    //represent the rows destroyed indicator.
    private int[] rows;
    //the width og the gui.
    public static final int WIDTH = 800;
    //the height of the gui.
    public static final int HEIGHT = 600;
    //the paddle width.
    public static final int PADDLE_WIDTH = 60;
    //the paddle height.
    public static final int PADDLE_HEIGHT = 8;
    // the ball radius.
    public static final int RADIUS = 4;
    //the block screen width.
    public static final int BLOCK_SCREEN_WIDTH = 10;
    //the block screen height.
    public static final int BLOCK_SCREEN_HEIGHT = 10;
    //the angle of the ball.
    public static final int ANGLE = 90;
    //the speed of the ball.
    public static final int SPEED = 3;
    //the columns of the blocks.
    private static final int COLUMNS = 12;
    //the rows of the blocks.
    private static final int ROWS = 6;
    //the height of the blocks.
    public static final int BLOCK_HEIGHT = 10;
    //the width of the blocks.
    public static final int BLOCK_WIDTH = 40;
    //the space from the blocks for the beauty.
    private static final int SPACE_WIDTH = 2;
    //the space from the upper block screen for the beauty.
    private static final int SPACE_HEIGHT = 60;
    // the frames per second.
    public static final int FRAMES_PER_SECOND = 60;
    //the milliseconds PerFrame
    public static final int MILLISECONDS_PER_FRAME = 1000;
    //represent the number of balls.
    public static final int BALLS_NUMBER = 3;
    //represent the indicator height.
    public static final int INDICATOR_HEIGHT = 20;
    //represent value of destroyed row.
    public static final int DESTROYED = 1;
    //represent destroyed row value.
    public static final int DESTROYED_LEVEL = 100;
    //represent the block increase number for the counter.
    public static final int BLOCK_INCREASE_COUNTER = 1;


    /**
     * Game.
     * the function creates a game.
     *
     * @param levelInformation the level information
     * @param animationRunner  the animation runner
     * @param scoreCounter     the score counter
     * @param keyboardSensor   the keyboard sensor
     */
    public GameLevel(LevelInformation levelInformation,
                     AnimationRunner animationRunner,
                     Counter scoreCounter, KeyboardSensor keyboardSensor) {
        this.levelInformation = levelInformation;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.runner = animationRunner;
        this.keyboard = keyboardSensor;
        this.scoreCounter = scoreCounter;
    }


    /**
     * Sets gui.
     * the function set the current gui on the game.
     */
    public void setGui() {
        this.gui = new GUI("Arkanoid", WIDTH, HEIGHT);
    }

    /**
     * Add collidable.
     * the function gets a collidable object and add it in the environment.
     *
     * @param c represent the collidable object.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Add sprite.
     * the function gets a sprite object and add it in the sprites.
     *
     * @param s represent the sprite object.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initialize.
     * the function set the gui and creates objects ,counters and rows
     * destroyed indicator.
     */
    public void initialize() {
        addBackground();
        createObjects();
        this.rows = new int[ROWS];
    }

    /**
     * Add backgrounds.
     */
    private void addBackground() {
        if (this.levelInformation.getBackground() == null) {
            return;
        }
        sprites.addSprite(this.levelInformation.getBackground());
    }

    /**
     * Create objects.
     * the function create balls , blocks , and paddle.
     */
    public void createObjects() {
        createBalls();
        createCounters();
        createIndicator();
        createBlocks();
        createPaddle();
    }

    /**
     * Create counters.
     * the function creates counters for block, balls and score.
     */
    public void createCounters() {
        this.blocksCounter = new Counter();
        this.ballsCounter = new Counter(this.levelInformation.numberOfBalls());
    }

    /**
     * Create indicator.
     * the function creates indicator object at the top of the screen.
     */
    public void createIndicator() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), WIDTH,
                INDICATOR_HEIGHT);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.scoreCounter,
                rectangle, Color.white, this.levelInformation.levelName());
        scoreIndicator.addToGame(this);
    }

    /**
     * Create blocks.
     * the function creates the game blocks.
     */
    public void createBlocks() {
        this.blocksCounter = new Counter(
                this.levelInformation.numberOfBlocksToRemove());
        BlockRemover blockRemover = new BlockRemover(this,
                this.blocksCounter);
        BallRemover ballRemover = new BallRemover(this,
                this.ballsCounter);
        ScoreTrackingListener scoreTrackingListener =
                new ScoreTrackingListener(this.scoreCounter);

        //the point of the up screen block.
        Point upPoint = new Point((double) 0,
                INDICATOR_HEIGHT);
        Rectangle up = new Rectangle(upPoint, WIDTH, BLOCK_SCREEN_HEIGHT);

        //the point of the left screen block.
        Point leftPoint = new Point(0, INDICATOR_HEIGHT
                + BLOCK_SCREEN_HEIGHT);
        Rectangle left = new Rectangle(leftPoint, BLOCK_SCREEN_WIDTH,
                HEIGHT - (INDICATOR_HEIGHT + BLOCK_SCREEN_HEIGHT));

        //the point of the down screen block
        Point downPoint = new Point(BLOCK_SCREEN_WIDTH, HEIGHT
                - BLOCK_SCREEN_HEIGHT);
        Rectangle down = new Rectangle(downPoint, WIDTH
                - 2 * BLOCK_SCREEN_WIDTH, BLOCK_SCREEN_HEIGHT);

        //the point of the right screen block.
        Point rightPoint = new Point(WIDTH - BLOCK_SCREEN_WIDTH,
                INDICATOR_HEIGHT + BLOCK_SCREEN_HEIGHT);
        Rectangle right = new Rectangle(rightPoint, BLOCK_SCREEN_WIDTH,
                HEIGHT - (INDICATOR_HEIGHT + BLOCK_SCREEN_HEIGHT));

        //creates screens blocks
        Block upBlock = new Block(up, Color.red);
        Block leftBlock = new Block(left, Color.red);
        Block rightBlock = new Block(right, Color.red);
        Block deathRegion = new Block(down, Color.LIGHT_GRAY);

        //add to the environment.
        this.environment.addCollidable(deathRegion);
        this.environment.addCollidable(upBlock);
        this.environment.addCollidable(leftBlock);
        this.environment.addCollidable(rightBlock);
        deathRegion.addHitListener(ballRemover);


        //add to the game.
        upBlock.addToGame(this);
        rightBlock.addToGame(this);
        leftBlock.addToGame(this);
        deathRegion.addToGame(this);

        //creates other blocks.
        java.util.List<Block> blocksLevel = this.levelInformation.blocks();
        for (Block block : blocksLevel) {
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            block.addToGame(this);
        }
    }

    /**
     * Create paddle.
     * the function creates the paddle for the game.
     */
    public void createPaddle() {

        //x by logic.
        double x = 30;

        // -1 for the beauty.
        Point upperLeft = new Point(x,
                HEIGHT - PADDLE_HEIGHT - BLOCK_SCREEN_WIDTH - 1);
        Rectangle rec = new Rectangle(upperLeft,
                this.levelInformation.paddleWidth(), PADDLE_HEIGHT);
        Paddle paddle = new Paddle(this.keyboard, rec,
                Color.pink, this.levelInformation.paddleSpeed());
        paddle.setEnvironment(this.environment);

        // +1 for the beauty.
        paddle.setLeftLimit(BLOCK_SCREEN_WIDTH + 1);

        // -1 for the beauty.
        paddle.setRightLimit(WIDTH - this.levelInformation.paddleWidth()
                - BLOCK_SCREEN_WIDTH - 1);
        paddle.addToGame(this);
    }

    /**
     * Create balls.
     * the function creates 3 balls and add them to the game.
     */
    public void createBalls() {
        Random rand = new Random();
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {

            Point center = this.levelInformation.getCenters().get(i);
            Ball ball = new Ball(center, this.levelInformation.getRadius(),
                    Color.blue);
            ball.setVelocity(this.levelInformation.initialBallVelocities()
                    .get(i));
            ball.setEnvironment(this.environment);
            ball.addToGame(this);
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        endGame();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
    }

    /**
     * Run.
     * the function called to run function of runner object to create and
     * start the animation loop of the game.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * Remove collidable.
     * the function gets collidable and remove it from the game.
     *
     * @param c the collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.getList().remove(c);
    }

    /**
     * End game.
     * the function end the gui in case there are no balls left or
     * there are no blocks to break.
     */
    public void endGame() {
        if (this.ballsCounter.getValue() == 0) {
            this.running = false;
        }
        if (this.blocksCounter.getValue() == 0) {
            this.scoreCounter.increase(DESTROYED_LEVEL);
            this.running = false;
        }
    }

    /**
     * Remove sprite.
     * the function gets sprite and remove it from the game.
     *
     * @param s the sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSprites().remove(s);
    }

    /**
     * Check destroyed rows.
     * the function checking for each row if there are blocks in case there
     * are no blocks add 100 points to the counter and update the rows array
     * accordingly.
     */
    public void checkDestroyedRows() {
        boolean flag = true;
        for (int i = 0; i < ROWS; i++) {

            //checking if this row already destroyed
            if (this.rows[i] != DESTROYED) {
                for (Collidable c : this.environment.getList()) {

                    //checking if there is a block in this row.
                    if (c.getCollisionRectangle().getUpperLeft().getY()
                            == (SPACE_HEIGHT + (i * (BLOCK_HEIGHT)))) {
                        flag = false;
                        break;
                    }
                }

                //in case there are no blocks in this row.
                if (flag) {

                    //update to destroyed row value.
                    rows[i] = DESTROYED;
                    this.scoreCounter.increase(DESTROYED_LEVEL);
                }
            }
            flag = true;
        }
    }

    /**
     * Gets balls number.
     *
     * @return the blocks remainder.
     */
    public int getBlockCounter() {
        return this.blocksCounter.getValue();
    }

    /**
     * Gets balls number.
     *
     * @return the balls number
     */
    public int getBallsNumber() {
        return this.ballsCounter.getValue();
    }

    /**
     * Get level information.
     *
     * @return the level information
     */
    public LevelInformation getLevelInformation() {
        return this.levelInformation;
    }

    /**
     * Get gui gui.
     *
     * @return the gui
     */
    public GUI getGui() {
        return this.gui;
    }
}