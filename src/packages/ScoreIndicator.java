//Name: Eliya Rabia.
//ID: 318771052

package packages;
import java.awt.Color;

/**
 * The type Score indicator.
 * this class is about score indicator.
 */
public class ScoreIndicator implements Sprite {
    //represent the level name
    private final String levelName;

    //represent the score counter.
    private final Counter scoreCounter;

    //represent the rectangle of the indicator.
    private final Rectangle scoreFrame;

    //represent the color of the rectangle.
    private final Color color;

    /**
     * The constant FOR_BEAUTY.
     */
//represent number for beauty the draw on for Y.
    public static final int FOR_BEAUTY_Y = 2;
    //represent number for beauty the draw on for X.
    public static final int FOR_BEAUTY_X = 250;

    /**
     * The constant TEXT_SIZE.
     */
//represent the text size.
    public static final int TEXT_SIZE = 15;


    /**
     * Instantiates a new Score indicator.
     *
     * @param counter   the counter
     * @param rectangle the rectangle
     * @param color     the color
     * @param levelName the level name
     */
    public ScoreIndicator(Counter counter, Rectangle rectangle, Color color,
                          String levelName) {
        this.scoreCounter = counter;
        this.scoreFrame = rectangle;
        this.color = color;
        this.levelName = levelName;
    }


    @Override
    public void drawOn(biuoop.DrawSurface d) {
        int y = (int) this.scoreFrame.getUpperLeft().getY();
        int x = (int) this.scoreFrame.getUpperLeft().getX();
        int widthFrame = (int) this.scoreFrame.getWidth();
        int heightFrame = (int) this.scoreFrame.getHeight();
        d.setColor(this.color);
        d.fillRectangle(x, y, widthFrame, heightFrame);
        String score = "Score: " + this.scoreCounter.getValue();
        d.setColor(Color.BLACK);

        //number by logic for beauty.
        d.drawText(FOR_BEAUTY_X, heightFrame - FOR_BEAUTY_Y,
                score, TEXT_SIZE);
        //draw the level name.
        d.drawText(widthFrame - FOR_BEAUTY_X, heightFrame - FOR_BEAUTY_Y,
                "Level Name : " + levelName, TEXT_SIZE);
    }


    @Override
    public void timePassed() {
    }

    /**
     * Add to game.
     * the function gets game and add this object to it.
     *
     * @param gameLevel the game
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}