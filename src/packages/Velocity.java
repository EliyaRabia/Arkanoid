//Name: Eliya Rabia.
//ID: 318771052

package packages;

/**
 * The type packages.Velocity.
 * this class is about velocity and the functions that related to it.
 */
public class Velocity {
    /*
        represent value changing x value for velocity.
        default value 0 represent no movement.
    */
    private double dx = 0;
    /*
       represent value changing y value for velocity.
       default value 0 represent no movement.
    */
    private double dy = 0;


    /**
     * From angle and speed.
     * the function gets angle and speed and creates velocity from them.
     *
     * @param angle represent the angle.
     * @param speed represent the speed.
     * @return the velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }


    /**
     * Get x.
     * the function return the x value.
     *
     * @return the x.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Get y.
     * the function return the y value.
     *
     * @return the y.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * packages.Velocity.
     * the function gets x and y changing values and create velocity.
     *
     * @param dx represent the x change value for velocity.
     * @param dy represent the y change value for velocity.
     */
// constructor
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Apply to point.
     * the function gets a point and return the point after adding the
     * vilocity values to the point values.
     *
     * @param p represent the point.
     * @return the point after adding velocity.
     */
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }
}