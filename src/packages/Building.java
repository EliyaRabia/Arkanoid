//Name: Eliya Rabia.
//ID: 318771052

package packages;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type packages.Building.
 * this class is about building painting.
 */
public class Building implements Sprite {
    //represent the point for start painting.
    private Point start;
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;

    /**
     * Instantiates a new packages.Building.
     *
     * @param start the start
     */
    public Building(Point start) {
        this.start = start;
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.green);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.black);
        //numbers by logic to look nice.
        d.fillRectangle((int) this.start.getX(), (int) this.start.getY(),
                250, 300);
        d.setColor(Color.white);
        //number by logic to look nice
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                d.fillRectangle((int) this.start.getX() + 16 + (46 * j),
                        (int) this.start.getY() + 248 - (i * 58),
                        30, 45);
            }
        }
        d.setColor(Color.DARK_GRAY);
        //number by logic to look nice
        d.fillRectangle((int) this.start.getX() + 105,
                (int) this.start.getY() - 80, 40, 80);
        d.setColor(Color.gray);
        //number by logic to look nice
        d.fillRectangle((int) this.start.getX() + 115,
                (int) this.start.getY() - 200, 20, 120);
        d.setColor(Color.orange);
        //number by logic to look nice
        d.fillCircle((int) this.start.getX() + 125,
                (int) this.start.getY() - 215, 30);
        d.setColor(Color.red);
        //number by logic to look nice
        d.fillCircle((int) this.start.getX() + 125,
                (int) this.start.getY() - 215, 20);
        d.setColor(Color.white);
        //number by logic to look nice
        d.fillCircle((int) this.start.getX() + 125,
                (int) this.start.getY() - 215, 10);
    }
}
