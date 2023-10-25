package packages;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type packages.Ball.
 * this class is about ball and the function that related to it.
 *
 * @author 318771052 Eliya Rabia < eliyarabia@gmail.com >
 * @version JDK 19.0.2
 * @since 2023 -01-17
 */
public class Ball implements Sprite {

    //represent the ball center by x and y.
    private Point center;

    //represent the radius of the ball.
    private final int radius;

    //represent the color of the ball.
    private final Color color;

    //represent the velocity of the ball.
    private Velocity velocity;

    //represent the environment of the ball.
    private GameEnvironment environment;

    //represent ball game min width border.
    private int widthBottom;

    //represent ball game min height border.
    private int heightBottom;

    //represent ball game max width border.
    private int widthTop;

    //represent ball game max height border.
    private int heightTop;


    /**
     * packages.Ball.
     * the function creates a ball.
     *
     * @param center is the ball center.
     * @param r      is the radius.
     * @param color  is the ball color.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        //in case invalid radius.
        if (r <= 0) {
            r = 1;
        }
        this.radius = r;
        this.center = center;
        this.color = color;
    }

    /**
     * packages.Ball.
     * the function creates a ball.
     *
     * @param x     represent the x value of the ball center
     * @param y     represent the y value of the ball center
     * @param r     represent the radius of the ball.
     * @param color represent the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        //in case in valid radius.
        if (r <= 0) {
            r = 1;
        }
        //in case in x out of the frame.
        if (x - r < 0) {
            x = r;
        }
        //in case in y out of the frame.
        if (y - r < 0) {
            y = r;
        }
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
    }

    /**
     * Get x.
     * the function return the x value of the ball center.
     *
     * @return the x value of the ball center.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Get y.
     * the function return the y value of the ball center.
     *
     * @return the y value of the ball center.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Get size.
     * the function return the radius of the ball.
     *
     * @return the radius of the ball.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Get color.
     * the function re turn the color of the ball.
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Set velocity.
     * the function gets a velocity and set it on the ball.
     *
     * @param v represent the new velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * get center.
     * the function returns the ball center.
     *
     * @return the ball center.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * Set velocity.
     * the function gets values and create with them a new velocity to set
     * for the ball.
     *
     * @param dx represent the x change.
     * @param dy represent the y change.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Get velocity.
     * the function return the velocity of the ball.
     *
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Move one step.
     * the function make the ball move by adding a velocity.
     */
    public void moveOneStep() {
        Point nextPoint = this.getVelocity().applyToPoint(this.center);
        Point trajectoryPoint =
                nextPoint.findClosestPointToRectangle(this.environment);
        Line trajectory;

        //to prevent the case the trajectory start and end will be the same.
        if (nextPoint.equals(trajectoryPoint)) {
            trajectory = new Line(this.center, trajectoryPoint);
        } else {
            trajectory = new Line(nextPoint, trajectoryPoint);
        }
        if (this.environment != null) {
            CollisionInfo info = this.environment
                    .getClosestCollision(trajectory);

            //in case the next point will hit an obstacle.
            if (trajectory.length() <= this.radius) {
                if (info != null) {
                    this.velocity = info.collisionObject()
                            .hit(this, info.collisionPoint(),
                                    this.velocity, nextPoint);
                    nextPoint = this.getVelocity().applyToPoint(this.center);
                }
            }
            this.center = nextPoint;
        }
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
    }

    /**
     * packages.Ball limits.
     * the function make sure that the ball don't go out of the surface
     * limits by changing the velocity horizon.
     */
    public void ballLimits() {
        double centerNewX = this.center.getX() + this.velocity.getDx();
        double centerNewY = this.center.getY() + this.velocity.getDy();

        //hit the top and down limits.
        if (centerNewY - this.radius < heightBottom || centerNewY
                + this.radius > heightTop) {
            this.velocity = new Velocity(this.velocity.getDx(),
                    -this.velocity.getDy());
        }

        //hit the left and right limits.
        if (centerNewX - this.radius < widthBottom || centerNewX
                + this.radius > widthTop) {
            this.velocity = new Velocity(-this.velocity.getDx(),
                    this.velocity.getDy());
        }
    }

    /**
     * Sets environment.
     * the function gets enviroment and set it in the ball.
     *
     * @param environment the environment
     */
    public void setEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Set limits.
     *
     * @param widthBottom  the width bottom
     * @param heightBottom the height bottom
     * @param widthTop     the width top
     * @param heightTop    the height top
     */
    public void setLimits(int widthBottom, int heightBottom, int widthTop,
                          int heightTop) {
        this.widthBottom = widthBottom;
        this.heightBottom = heightBottom;
        this.widthTop = widthTop;
        this.heightTop = heightTop;
    }

    /**
     * Add to game.
     * the function gets game and add the current ball to the game.
     *
     * @param g represent the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove from game.
     * the function gets game object and remove this ball fri=om it.
     *
     * @param g represent the game object.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}