//ID : 318771052
//Name : Eliya Rabia

package packages;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type packages.Paddle.
 * this class is about the paddle in the game.
 */
public class Paddle implements Sprite, Collidable {
    //represent the paddle speed.
    private int speed;

    //the keyboard for the paddle.
    private biuoop.KeyboardSensor keyboard;

    //the paddle rectangle.
    private Rectangle rectangle;

    //the color of the paddle.
    private Color color;

    //the environment of the game.
    private GameEnvironment environment;

    //the paddle left limit movement.
    private int leftLimit;

    //the paddle right limit movement.
    private int rightLimit;

    // represent the 5 part of the paddle.
    private static final int FIVE_PARTS = 5;

    //represent the first part of the paddle.
    private static final int FIRST_PART = 1;

    //represent the second part of the paddle.
    private static final int SECOND_PART = 2;

    //represent the third part of the paddle.
    private static final int THIRD_PART = 3;

    //represent the fourth part of the paddle.
    private static final int FOURTH_PART = 4;

    //represent the fifth part of the paddle.
    private static final int FIFTH_PART = 5;

    //represent the first part angle.
    private static final int FIRST_PART_ANGLE = 300;

    //represent the second part angle.
    private static final int SECOND_PART_ANGLE = 330;

    //represent the fourth part angle.
    private static final int FOURTH_PART_ANGLE = 30;

    //represent the fifth part angle.
    private static final int FIFTH_PART_ANGLE = 60;

    //represent the color of the paddle borders.
    private static final Color BLACK = Color.black;

    /**
     * packages.Paddle.
     * the function creates new paddle.
     *
     * @param keyboard  represent the keyboard
     * @param rectangle represent the rectangle
     * @param color     represent the color
     * @param speed     the speed
     */
    public Paddle(biuoop.KeyboardSensor keyboard, Rectangle rectangle,
                  Color color, int speed) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.color = color;
        this.speed = speed;
    }

    /**
     * Sets left limit.
     * the function gets left limit for the paddle and set it.
     *
     * @param leftLimit represent the left limit
     */
    public void setLeftLimit(int leftLimit) {
        this.leftLimit = leftLimit;
    }

    /**
     * Sets right limit.
     * the function gets right limit for the paddle and set it.
     *
     * @param rightLimit represent the right limit
     */
    public void setRightLimit(int rightLimit) {
        this.rightLimit = rightLimit;
    }

    /**
     * Sets environment.
     * the function gets environment and set it.
     *
     * @param environment the environment
     */
    public void setEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }

    /**
     * Move left.
     * the function move the paddle to the left.
     */
    public void moveLeft() {
        double y = this.rectangle.getUpperLeft().getY();
        double x = this.rectangle.getUpperLeft().getX();
        double newX = x - this.speed;
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();

        //check if this is the limit.
        if (newX <= this.leftLimit) {
            newX = this.leftLimit;
        }
        this.rectangle = new Rectangle(new Point(newX, y), width, height);
    }

    /**
     * Move right.
     * the function move the paddle to the right.
     */
    public void moveRight() {
        double y = this.rectangle.getUpperLeft().getY();
        double x = this.rectangle.getUpperLeft().getX();
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();
        double newX = x + this.speed;

        //check if this is the limit.
        if (newX >= this.rightLimit) {
            newX = this.rightLimit;
        }
        this.rectangle = new Rectangle(new Point(newX, y), width, height);
    }

    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(keyboard.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(keyboard.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        int width = (int) this.rectangle.getWidth();
        int height = (int) this.rectangle.getHeight();
        int x = (int) this.rectangle.getUpperLeft().getX();
        int y = (int) this.rectangle.getUpperLeft().getY();
        d.setColor(color);
        d.fillRectangle(x, y, width, height);
        d.setColor(BLACK);
        d.drawRectangle(x, y, width, height);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint,
                        Velocity currentVelocity, Point nextPoint) {
        double dX = currentVelocity.getDx();
        double dY = currentVelocity.getDy();
        int region = collidingRegion(collisionPoint);
        Velocity v;
        double angle = 0;

        //each region has different angle.
        if (region == THIRD_PART) {
            v = new Velocity(dX, -dY);
        } else {
            if (region == FIRST_PART) {
                angle = FIRST_PART_ANGLE;
            }
            if (region == SECOND_PART) {
                angle = SECOND_PART_ANGLE;
            }
            if (region == FOURTH_PART) {
                angle = FOURTH_PART_ANGLE;
            }
            if (region == FIFTH_PART) {
                angle = FIFTH_PART_ANGLE;
            }
            double speed = Math.sqrt((dX * dX) + (dY * dY));
            v = Velocity.fromAngleAndSpeed(angle, speed);
        }
        return v;
    }

    /**
     * Colliding region int.
     * the function gets colliding packages.Point and return in which part
     * of the paddle the point is.
     *
     * @param collidingPoint represent the colliding point.
     * @return the part number.
     */
    public int collidingRegion(Point collidingPoint) {
        double upperLeftX = this.rectangle.getUpperLeft().getX();

        double width = this.rectangle.getWidth() / FIVE_PARTS;
        double x = collidingPoint.getX();
        if (x == upperLeftX) {
            return FIRST_PART;
        }
        if (x == this.rectangle.getUpperRight().getX()) {
            return FIFTH_PART;
        }
        for (int i = 0; i < FIVE_PARTS; i++) {
            if (((width * i) + upperLeftX) < x && x <= (upperLeftX
                    + ((i + 1) * width))) {
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * Add to game.
     * the function gets game and add the paddle to it.
     *
     * @param g is the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

}