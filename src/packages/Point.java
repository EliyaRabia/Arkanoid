package packages;

/**
 * The type packages.Point.
 * this class is about a point and the function that related to it.
 *
 * @author 318771052 Eliya Rabia < eliyarabia@gmail.com >
 * @version JDK 19.0.2
 * @since 2023 -01-17
 */
public class Point {
    /*
    represent x value of the point center.
    */
    private double x;
    /*
        represent the y value of the point center.
    */
    private double y;
    /**
     * The constant THRESHOLD.
     */
/*
    represent threshold.
*/
    static final double THRESHOLD = 0.00001;

    /**
     * packages.Point.
     * the function gets x and y values and crates a point.
     *
     * @param x represent the x value of the point.
     * @param y represent the y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance.
     * the function gets a point and return the distance from the exists one.
     *
     * @param other is a point.
     * @return the distance.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(other.getX() - this.x, 2)
                + Math.pow(other.getY() - this.y, 2));
    }

    /**
     * Equals.
     * the function gets a point and check if is it equal to the exists one.
     *
     * @param other is a point.
     * @return true if they are equal else false.
     */
    public boolean equals(Point other) {
        boolean a, b = false;
        a = other.getX() == this.x && other.getY() == this.y;
        if (Math.abs(this.x - other.getX()) <= THRESHOLD) {
            if (Math.abs(this.y - other.getY()) <= THRESHOLD) {
                b = true;
            }
        }
        return a || b;
    }

    /**
     * Get x.
     * the function return the x value of the point.
     *
     * @return the x value.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Get y.
     * the function return the y value of the point.
     *
     * @return the y value.
     */
    public int getY() {
        return (int) this.y;
    }

    /**
     * Set y.
     * the function set the x value of the point.
     *
     * @param change represent the number we want to set
     */
    public void setY(double change) {
        this.y = change;
    }

    /**
     * Set x.
     * the function set the x value of the point.
     *
     * @param change represent the number we want to set
     */
    public void setX(double change) {
        this.x = change;
    }

    /**
     * Find the closest point to rectangle point.
     * the function gets environment and search over all the collidables
     * what is the closest point to the closest rectangle.
     *
     * @param g is the environment.
     * @return the closest point.
     */
    public Point findClosestPointToRectangle(GameEnvironment g) {
        if (g == null) {
            return null;
        }
        Point closest = null;
        Point newPoint = null;
        for (Collidable collide : g.getList()) {
            for (Line l : collide.getCollisionRectangle().lineList()) {
                newPoint = l.closestPoint(l, this);

                //in case this is the first point we found.
                if (closest == null) {
                    closest = newPoint;
                } else {

                    //checking if the new point is closer.
                    if (newPoint != null) {
                        if (closest.distance(this)
                                > newPoint.distance(this)) {
                            closest = newPoint;
                        }
                    }
                }
            }
        }
        return closest;
    }

    /**
     * Inside boolean.
     * the function gets rectangle and radius and return true id this point
     * with the radius is in the area of the rectangle else false.
     *
     * @param rec    represent the rec
     * @param radius represent the radius
     * @return the boolean true or false.
     */
    public boolean inside(Rectangle rec, int radius) {
        if (this.x + radius >= rec.getUpperLeft().getX()
                && this.x + radius <= rec.getUpperRight().getX()
                && this.y + radius >= rec.getUpperRight().getY()
                && this.y + radius <= rec.getDownRight().getY()) {
            return true;
        }
        return false;
    }
}