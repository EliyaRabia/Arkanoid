//Name: Eliya Rabia.
//ID: 318771052


import biuoop.GUI;
import biuoop.Sleeper;
import packages.AnimationRunner;
import packages.LevelInformation;
import java.util.ArrayList;
import packages.GameFlow;
import packages.DirectHit;
import packages.Green3;
import packages.WideEasy;
import java.util.List;


/**
 * The type Ass 6 game.
 * this class is about ass 6 game.
 */
public class Ass6Game {
    // represent the gui width.
    public static final int WIDTH = 800;
    //represent the gui height.
    public static final int HEIGHT = 600;
    //represent one digit number.
    public static final int ONE_DIGIT = 1;
    //represent max level number.
    public static final int MAX_LEVEL = 3;
    //represent min level number.
    public static final int MIN_LEVEL = 1;
    //represent level 1, direct hit.
    public static final int LEVEL1 = 1;
    //represent level 2, wide easy.
    public static final int LEVEL2 = 2;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        int numberLevels = 0;
        GameFlow gameFlow = new GameFlow(numberLevels, new AnimationRunner(gui,
                new Sleeper()), gui.getKeyboardSensor());
        List<LevelInformation> levels = new ArrayList<>();
        for (String level : args) {
            if (level.length() == ONE_DIGIT) {
                if (Character.isDigit(level.charAt(0))) {
                    int levelNumber = Integer.parseInt(level);
                    if (levelNumber >= MIN_LEVEL && levelNumber <= MAX_LEVEL) {
                        LevelInformation gameType;
                        if (levelNumber == LEVEL1) {
                            gameType = new DirectHit();
                        } else {
                            if (levelNumber == LEVEL2) {
                                gameType = new WideEasy();
                            } else {
                                gameType = new Green3();
                            }
                        }
                        numberLevels++;
                        levels.add(gameType);
                    }
                }
            }
        }
        if (!levels.isEmpty()) {
            gameFlow.setNumberLevels(numberLevels);
            gameFlow.runLevels(levels);
        } else {
            numberLevels = 3;
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            gameFlow.setNumberLevels(numberLevels);
            gameFlow.runLevels(levels);
        }
    }
}
