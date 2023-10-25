//Name: Eliya Rabia.
//ID: 318771052

package packages;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Game flow.
 * this class is about game flow.
 */
public class GameFlow {
    //represent the animation runner.
    private AnimationRunner animationRunner;
    //represent the keyboard.
    private KeyboardSensor keyboardSensor;
    //represent losing.
    private boolean loser;
    //represent the score counter.
    private Counter score;
    //represent the number of levels.
    private int numberLevels;
    //gui width.
    public static final int WIDTH = 800;
    //gui height.
    public static final int HEIGHT = 600;
    //zero blocks.
    public static final int ZERO_BLOCKS = 0;
    //zero balls.
    public static final int ZERO_BALLS = 0;

    /**
     * Instantiates a new Game flow.
     *
     * @param numberLevels    number levels.
     * @param animationRunner the animation runner
     * @param keyboardSensor  the keyboard sensor
     */
    public GameFlow(int numberLevels, AnimationRunner animationRunner,
                    KeyboardSensor keyboardSensor) {
        this.animationRunner = animationRunner;
        this.keyboardSensor = keyboardSensor;
        this.loser = false;
        this.score = new Counter();
        this.numberLevels = numberLevels;
    }

    /**
     * set number levels.
     * the function set the number levels.
     *
     * @param numberLevels the levels
     */
    public void setNumberLevels(int numberLevels) {
        this.numberLevels = numberLevels;
    }

    /**
     * Run levels.
     * the function gets list of level information and run each level.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.animationRunner,
                    this.score, this.keyboardSensor);
            level.initialize();
            level.run();
            this.numberLevels = this.numberLevels - 1;
            //lose
            if (level.getBallsNumber() == ZERO_BALLS) {
                EndScreen endScreen = new EndScreen(false, this.score,
                        this.animationRunner, this.keyboardSensor);
                this.animationRunner.run(new KeyPressStoppableAnimation(
                        this.keyboardSensor,
                        KeyboardSensor.SPACE_KEY, endScreen));
                this.animationRunner.getGui().close();
                return;
            }
            //win
            if (this.numberLevels == 0
                    && level.getBlockCounter() == ZERO_BLOCKS) {
                EndScreen endScreen = new EndScreen(true, this.score,
                        this.animationRunner, this.keyboardSensor);
                this.animationRunner.run(new KeyPressStoppableAnimation(
                        this.keyboardSensor,
                        KeyboardSensor.SPACE_KEY, endScreen));
                this.animationRunner.getGui().close();
                return;
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new Green3());
        GUI gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        int number = 1;
        GameFlow gameFlow = new GameFlow(number, new AnimationRunner(gui,
                new Sleeper()), gui.getKeyboardSensor());
        gameFlow.runLevels(levels);
    }
}
