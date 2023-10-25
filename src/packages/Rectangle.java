//ID : 318771052
//Name : Eliya Rabia

package packages;
import java.util.ArrayList;
import java.util.List;


/**
 * The type packages.Rectangle.
 * this class is about the rectangle of the game.
 */
public class Rectangle {

    //represent the upper left point of the rectangle.
    private Point upperLeft;

    //represent the upper right point of the rectangle.
    private Point upperRight;

    //represent the down left point of the rectangle.
    private Point downLeft;

    //represent the down right point of the rectangle.
    private Point downRight;

    //represent the up line of the rectangle.
    private Line upLine;

    //represent the right line of the rectangle.
    private Line rightLine;

    //represent the down line of the rectangle.
    private Line downLine;

    //represent the left line of the rectangle.
    private Line leftLine;

    /**
     * packages.Rectangle.
     * the function gets point , width and height and creates the rectangle
     * corners and the lines.
     *
     * @param upperLeft represent the point.
     * @param width     represent the width
     * @param height    represent the height
     */
    public Rectangle(Point upperLeft, double width, double height) {

        //the upper left corner.
        this.upperLeft = upperLeft;

        //the down left corner.
        this.downLeft = new Point(upperLeft.getX(), upperLeft.getY()
                + height);

        //the down right corner.
        this.downRight = new Point(upperLeft.getX() + width,
                upperLeft.getY() + height);

        //the up right corner.
        this.upperRight = new Point(upperLeft.getX() + width,
                upperLeft.getY());

        //the up line.
        this.upLine = new Line(upperLeft.getX(), upperLeft.getY(),
                upperLeft.getX() + width, upperLeft.getY());

        //the down line.
        this.downLine = new Line(upperLeft.getX(), upperLeft.getY()
                + height, upperLeft.getX() + width,
                upperLeft.getY() + height);

        //the left line.
        this.leftLine = new Line(upperLeft.getX(), upperLeft.getY(),
                upperLeft.getX(), upperLeft.getY() + height);

        //the right line.
        this.rightLine = new Line(upperLeft.getX() + width,
                upperLeft.getY(), upperLeft.getX() + width,
                upperLeft.getY() + height);
    }

    /**
     * Intersection points.
     * the function gets line and return a list of intersection points.
     *
     * @param line represent the line
     * @return the intersection points list.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> l = new ArrayList<Point>();

        //checking intersection with left line of the rectangle.
        if (line.isIntersecting(this.leftLine)) {
            if (line.intersectionWith(this.leftLine) != null) {
                l.add(line.intersectionWith(this.leftLine));
            }
        }

        //checking intersection with right line of the rectangle.
        if (line.isIntersecting(this.rightLine)) {
            if (line.intersectionWith(this.rightLine) != null) {
                l.add(line.intersectionWith(this.rightLine));
            }
        }

        //checking intersection with up line of the rectangle.
        if (line.isIntersecting(this.upLine)) {
            if (line.intersectionWith(this.upLine) != null) {
                l.add(line.intersectionWith(this.upLine));
            }
        }

        //checking intersection with down line of the rectangle.
        if (line.isIntersecting(this.downLine)) {
            if (line.intersectionWith(this.downLine) != null) {
                l.add(line.intersectionWith(this.downLine));
            }
        }

        //in case there are no intersections.
        if (l.isEmpty()) {
            return null;
        }
        return l;
    }

    /**
     * Gets width.
     * the function returns the width of the rectangle.
     *
     * @return the width
     */
    public double getWidth() {
        return this.upLine.length();
    }

    /**
     * Gets height.
     * the function returns the height of the rectangle.
     *
     * @return the height
     */
    public double getHeight() {
        return this.leftLine.length();
    }

    /**
     * Gets upper left.
     * the function returns the upper left corner of the rectangle.
     *
     * @return the upper left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Gets down left.
     * the function return the down left corner of the rectangle.
     *
     * @return the down left point.
     */
    public Point getDownLeft() {
        return this.downLeft;
    }

    /**
     * Gets upper right.
     * the function returns the upper right corner of the rectangle.
     *
     * @return the upper right point.
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * Gets down right.
     * the function returns the down right corner of the rectangle.
     *
     * @return the down right point.
     */
    public Point getDownRight() {
        return this.downRight;
    }

    /**
     * Gets up line.
     * the function return the up line of the rectangle.
     *
     * @return the up line
     */
    public Line getUpLine() {
        return this.upLine;
    }

    /**
     * Gets down line.
     * the function return the down line of the rectangle.
     *
     * @return the down line
     */
    public Line getDownLine() {
        return downLine;
    }

    /**
     * Gets left line.
     * the function return the left line of the rectangle.
     *
     * @return the left line
     */
    public Line getLeftLine() {
        return leftLine;
    }

    /**
     * Gets right line.
     * the function return the right line of the rectangle.
     *
     * @return the right line
     */
    public Line getRightLine() {
        return rightLine;
    }

    /**
     * packages.Line list.
     * the function return lines list of the rectangle lines.
     *
     * @return the list.
     */
    public java.util.List<Line> lineList() {
        List<Line> lineList = new ArrayList<>();
        lineList.add(this.upLine);
        lineList.add(this.downLine);
        lineList.add(this.rightLine);
        lineList.add(this.leftLine);
        return lineList;
    }

    /**
     * Corners velocity.
     * //the function gets collision packages.Point, center point , next
     * point , velocity and if the collision point is on one of the corner if
     *  yes check with the center and the next from which direction the point
     *  move and change the velocity accordingly if there are no intersection
     *  with the corner return the velocity as is.
     *
     * @param collisionPoint represent the collision point.
     * @param center         represent the center point.
     * @param nextPoint      represent the next point.
     * @param v              represent the velocity.
     * @return the velocity after changing if necessary.
     */
    public Velocity corners(Point collisionPoint, Point center, Point nextPoint,
                            Velocity v) {
        double dX = v.getDx();
        double dY = v.getDy();

        //right up corner
        if (this.upLine.isContained(collisionPoint)
                && this.rightLine.isContained(collisionPoint)) {
            if (center.getX() > nextPoint.getX()
                    && center.getY() < nextPoint.getY()) {
                dX *= -1;
                dY *= -1;
            }
            if (center.getX() > nextPoint.getX()
                    && (center.getY() >= nextPoint.getY())) {
                dX *= -1;
            }
            if (center.getX() <= nextPoint.getX()
                    && center.getY() < nextPoint.getY()) {
                dY *= -1;
            }
        }

        //left up corner.
        if (this.upLine.isContained(collisionPoint)
                && this.leftLine.isContained(collisionPoint)) {
            if (center.getX() >= nextPoint.getX()
                    && center.getY() < nextPoint.getY()) {
                dY *= -1;
            }
            if (center.getX() < nextPoint.getX()
                    && center.getY() < nextPoint.getY()) {
                dY *= -1;
                dX *= -1;
            }
            if (center.getX() < nextPoint.getX()
                    && center.getY() >= nextPoint.getY()) {
                dX *= -1;
            }
        }

        //down left corner.
        if (this.downLine.isContained(collisionPoint)
                && this.leftLine.isContained(collisionPoint)) {
            if (center.getX() < nextPoint.getX()
                    && center.getY() > nextPoint.getY()) {
                dY *= -1;
                dX *= -1;
            }
            if (center.getX() < nextPoint.getX()
                    && center.getY() <= nextPoint.getY()) {
                dX *= -1;
            }
            if (center.getX() >= nextPoint.getX()
                    && center.getY() > nextPoint.getY()) {
                dY *= -1;
            }
        }

        //down right corner.
        if (this.downLine.isContained(collisionPoint)
                && this.rightLine.isContained(collisionPoint)) {
            if (center.getX() <= nextPoint.getX()
                    && center.getY() > nextPoint.getY()) {
                dY *= -1;
            }
            if (center.getX() > nextPoint.getX()
                    && center.getY() <= nextPoint.getY()) {
                dX *= -1;
            }
            if (center.getX() > nextPoint.getX()
                    && center.getY() > nextPoint.getY()) {
                dY *= -1;
                dX *= -1;
            }
        }
        return new Velocity(dX, dY);
    }
}
