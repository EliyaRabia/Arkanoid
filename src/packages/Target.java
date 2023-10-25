//Name: Eliya Rabia.
//ID: 318771052

package packages;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type packages.Target.
 * this class is about target object.
 */
public class Target implements Sprite {
    //represent the target.
    private Rectangle rectangle;

    /**
     * Instantiates a new packages.Target.
     * create a target object.
     *
     * @param rectangle the rectangle.
     */
    public Target(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.red);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.drawRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.blue);
        //numbers by logic.
        int radius = 20;
        int centerX = (int) (this.rectangle.getUpperLeft().getX()
                + this.rectangle.getWidth() / 2);
        int centerY = (int) (this.rectangle.getUpperLeft().getY()
                + this.rectangle.getHeight() / 2);
        //draw circle around the target.
        //numbers by logic.
        d.drawCircle(centerX, centerY, radius);
        d.drawCircle(centerX, centerY, radius * 2);
        d.drawCircle(centerX, centerY, radius * 3);
        //draw left line.
        //numbers by logic.
        d.drawLine((int) (this.rectangle.getUpperLeft().getX() - 2),
                (int) (this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight() / 2),
                (int) (this.rectangle.getUpperLeft().getX() - 80),
                (int) (this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight() / 2));
        //draw right line.
        //numbers by logic.
        d.drawLine((int) (this.rectangle.getUpperRight().getX() + 2),
                (int) (this.rectangle.getUpperRight().getY()
                        + this.rectangle.getHeight() / 2),
                (int) (this.rectangle.getUpperRight().getX() + 80),
                (int) (this.rectangle.getUpperRight().getY()
                        + this.rectangle.getHeight() / 2));
        //draw upper line.
        //numbers by logic.
        d.drawLine((int) (this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth() / 2),
                (int) (this.rectangle.getUpperLeft().getY() - 2),
                (int) (this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth() / 2),
                (int) (this.rectangle.getUpperLeft().getY() - 80));
        //draw down line.
        //numbers by logic.
        d.drawLine((int) (this.rectangle.getDownLeft().getX()
                        + this.rectangle.getWidth() / 2),
                (int) (this.rectangle.getDownLeft().getY() + 2),
                (int) (this.rectangle.getDownLeft().getX()
                        + this.rectangle.getWidth() / 2),
                (int) (this.rectangle.getDownLeft().getY() + 80));
        d.setColor(Color.white);
        //draw small targets
        //numbers by logic.
        d.drawText(280, 150, "ONE SHOT", 50);
    }

    @Override
    public void timePassed() {
    }
}