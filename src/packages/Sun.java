//Name: Eliya Rabia.
//ID: 318771052

package packages;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type packages.Sun.
 * this class is about sun drawing.
 */
public class Sun implements Sprite {
    //represent the center of the sun.
    private Point center;
    //represent the radius of the sun.
    private int radius;

    /**
     * Instantiates a new packages.Sun.
     * the function creates sun object.
     *
     * @param center the center
     * @param radius the radius
     */
    public Sun(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow);
        //numbers by logic.
        for (int i = 0; i < 50; i++) {
            d.drawLine((int) this.center.getX(), (int) this.center.getY(),
                    30 + (i * 11), 350);
        }
        //numbers by logic.
        d.setColor(Color.orange);
        d.fillCircle((int) this.center.getX(), (int) this.center.getY(),
                this.radius + 20);
        d.setColor(Color.ORANGE);
        d.fillCircle((int) this.center.getX(), (int) this.center.getY(),
                this.radius + 10);
        d.setColor(Color.yellow);
        d.fillCircle((int) this.center.getX(), (int) this.center.getY(),
                this.radius);
        //sky
        d.setColor(Color.CYAN);
        //numbers by logic.
        d.fillRectangle(10, 20, 780, 30);
        //grass
        d.setColor(Color.green);
        //numbers by logic.
        d.fillRectangle(10, 580, 780, 10);
        for (int i = 0; i < 350; i++) {
            d.drawLine(8 + (i * 3), 575, 12 + (i * 3), 580);
        }
    }

    @Override
    public void timePassed() {
    }
}
