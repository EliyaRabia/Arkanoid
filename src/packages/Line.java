package packages;

/**
 * The type packages.Line.
 * this class is about line and the function that related to it.
 *
 * @author 318771052 Eliya Rabia < eliyarabia@gmail.com >
 * @version JDK 19.0.2
 * @since 2023 -01-17
 */
public class Line {
    /*
    represent the start point of the line.
    */
    private final Point start;
    /*
        represent the end point of the line.
    */
    private final Point end;
    /**
     * The Threshold.
     */
    static final double THRESHOLD = 0.00001;


    /**
     * packages.Line.
     * the function gets start and end points to create a line.
     *
     * @param start represent the start point of the line
     * @param end   represent the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * packages.Line.
     * the function gets two x and two y values and creates start and end
     * points to create a new line.
     *
     * @param x1 represent the x of the start point.
     * @param y1 represent the y of the start point.
     * @param x2 represent the x of the end point.
     * @param y2 represent the y of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Length.
     * the function will return the length of the line.
     *
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Middle.
     * the function create new point that represent the middle point of the
     * line by doing average from the start and end values.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        double x = (start.getX() + end.getX()) / 2;
        double y = (start.getY() + end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * Start.
     * the function return the start point of the line.
     *
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * End.
     * the function return the end point of the line.
     *
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Equals.
     * the function gets line and compare him with the exists one if they are
     * the same the function will return true else false.
     *
     * @param other represent line.
     * @return true if the lines are the same else false.
     */
    public boolean equals(Line other) {
        if (other == null) {
            return false;
        }
        boolean a = this.start.equals(other.start())
                && this.end.equals(other.end());
        boolean b = this.start.equals(other.end())
                && this.end.equals(other.start());
        boolean c;
        // check if the lines are contained
        if (this.slope() == other.slope() && (this.isContained(other.start)
                || this.isContained(other.end) || other.isContained(this.start)
                || other.isContained(this.end))) {
            c = true;
        } else {
            c = false;
        }
        return a || b || c;
    }

    /**
     * Slope.
     * the function calculate the slope of the line.
     *
     * @return the slope of the line.
     */
    public double slope() {
        double slopeY = start.getY() - end.getY();
        double slopeX = start.getX() - end.getX();
        return slopeY / slopeX;
    }

    /**
     * Is contained.
     * the function gets point and check if the point is on the line.
     *
     * @param other represent the point.
     * @return true if the point on the line else false.
     */
    public boolean isContained(Point other) {
        if (other != null) {
            boolean a =
                    (this.start.getX() - THRESHOLD) <= other.getX()
                            && other.getX() <= this.end.getX() + THRESHOLD
                            || this.end.getX() - THRESHOLD <= other.getX()
                            && other.getX() <= this.start.getX() + THRESHOLD;
            boolean b = this.start.getY() - THRESHOLD <= other.getY()
                    && other.getY() <= this.end.getY() + THRESHOLD
                    || this.end.getY() - THRESHOLD <= other.getY()
                    && other.getY() <= this.start.getY() + THRESHOLD;
            return a && b;
        } else {
            return false;
        }
    }

    /**
     * Intersection with.
     * the function gets a line and check if there is an intersection with
     * the exists line if yes return his value else null.
     *
     * @param other represent line.
     * @return the point of intersection.
     */
    public Point intersectionWith(Line other) {
        // check if the lines are equal.
        if (equals(other)) {
            return null;
        }
        // check if they're not intersecting
        if (!isIntersecting(other)) {
            return null;
        } else {
            //check if there are infinite intersection points.
            double slope1 = this.slope();
            double slope2 = other.slope();
            if (slope1 == slope2) {
                if (isContained(other.start) || isContained(other.end)) {
                    return null;
                }
            }
        }
        // get the intersection.
        Point intersection = findIntersection(other);
        if (intersection == null) {
            return null;
        }
        // check if the intersection that found is contained in both lines.
        if (isContained(intersection) && other.isContained(intersection)) {
            return intersection;
        } else {
            return null;
        }
    }


    /**
     * Is intersecting.
     * the function gets line and check if there is an intersection with the
     * exists line if yes return true else false.
     *
     * @param other represent a line.
     * @return true if there is intersection else false.
     */
    public boolean isIntersecting(Line other) {
        if (this.equals(other)) {
            return true;
        }
        double slope1 = this.slope();
        double slope2 = other.slope();
        if (slope1 == slope2) {
            return isContained(other.start) || isContained(other.end);
        }
        Point intersection = findIntersection(other);
        return isContained(intersection) && other.isContained(intersection);
    }

    /**
     * Find intersection.
     * the function gets line and find if there is an intesection with the
     * exists one.
     *
     * @param other represent a line.
     * @return the intersection point if the isn't return null.
     */
    public Point findIntersection(Line other) {
        //this line
        double a1 = this.end.getY() - this.start.getY();
        double b1 = this.start.getX() - this.end.getX();
        double c1 = a1 * (this.start.getX()) + b1 * (this.start.getY());
        //other line
        double a2 = other.end().getY() - other.start().getY();
        double b2 = other.start().getX() - other.end().getX();
        double c2 = a2 * (other.start().getX()) + b2 * (other.start.getY());
        double determinant = a1 * b2 - a2 * b1;
        // means the lines are parallels.
        if (determinant == 0) {
            return this.checkOnePoint(other);
        }
        double x = (b2 * c1 - b1 * c2) / determinant;
        double y = (a1 * c2 - a2 * c1) / determinant;
        return new Point(x, y);
    }

    /**
     * Check one point.
     * the function gets line and check if the lines are connecting and not
     * contained if yes return the connecting point.
     *
     * @param other represent a line.
     * @return if the lines are connecting and not contained return the
     * connecting point.
     */
    public Point checkOnePoint(Line other) {
        // check if the start equal to the start in the other line,
        // and the lines not contained
        if (this.start.equals(other.start()) && !(this.isContained(other.end()))
                && !(other.isContained(this.end))) {
            return this.start;
        }
        // check if the start equal to the end in the other line,
        // and the lines not contained
        if (this.start.equals(other.end()) && !(this.isContained(other.start()))
                && !(other.isContained(this.end))) {
            return this.start;
        }
        // check if the end equal to the start in the other line,
        // and the lines not contained
        if (this.end.equals(other.start()) && !(this.isContained(other.end()))
                && !(other.isContained(this.start))) {
            return this.end;
        }
        // check if the end equal to the end in the other line,
        // and the lines not contained
        if (this.end.equals(other.end()) && !(this.isContained(other.start()))
                && !(other.isContained(this.start))) {
            return this.end;
        }
        //otherwise, there is no point.
        return null;
    }

    /**
     * Closest intersection to start of line point.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect the rect
     * @return the point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line line = new Line(this.start, this.end);
        java.util.List<Point> intersectionsPoints =
                rect.intersectionPoints(line);

        // there are no intersections points.
        if (intersectionsPoints == null) {
            return null;
        }
        double length = this.start.distance(intersectionsPoints.get(0));
        Point closer = intersectionsPoints.get(0);
        for (int i = 1; i < intersectionsPoints.size(); i++) {

            //check if there is a closer point.
            if (this.start.distance(intersectionsPoints.get(i)) < length) {
                length = this.start.distance(intersectionsPoints.get(i));
                closer = intersectionsPoints.get(i);
            }
        }
        return closer;
    }

    /**
     * Closest point.
     * the function calculating the closest point on the line to the current
     * line.
     *
     * @param l the l
     * @param p the p
     * @return the point
     */
    public Point closestPoint(Line l, Point p) {
        double x1 = l.start.getX();
        double y1 = l.start.getY();
        double x2 = l.end.getX();
        double y2 = l.end.getY();
        double x3 = p.getX();
        double y3 = p.getY();

        // calculate the distance between the point and the line.
        double numerator =
                Math.abs((y2 - y1) * x3 - (x2 - x1) * y3 + x2 * y1 - y2 * x1);
        double denominator = Math.sqrt(Math.pow(y2 - y1, 2)
                + Math.pow(x2 - x1, 2));
        double distance = numerator / denominator;

        // calculate the closest point on the line to the given point
        double t = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1))
                / Math.pow(denominator, 2);
        double x = x1 + t * (x2 - x1);
        double y = y1 + t * (y2 - y1);
        Point vertical = new Point(x, y);
        Line intersection = new Line(vertical, p);
        if (intersection.isIntersecting(l)) {
            return intersection.findIntersection(l);
        }
        if (l.isContained(vertical)) {
            return vertical;
        } else {

            //in case y not on the line.
            if (vertical.getX() >= x1 && vertical.getX() <= x2
                    || vertical.getX() <= x1 && vertical.getX() >= x2) {
                if (Math.abs(vertical.getY() - y1)
                        >= Math.abs(vertical.getY() - y2)) {
                    vertical.setY(y2);
                } else {
                    vertical.setY(y1);
                }
            } else {

                //in case x not on the line.
                if (Math.abs(vertical.getX() - x1)
                        >= Math.abs(vertical.getX() - x2)) {
                    vertical.setX(x2);
                } else {
                    vertical.setX(x1);
                }
            }
        }
        return vertical;
    }
}