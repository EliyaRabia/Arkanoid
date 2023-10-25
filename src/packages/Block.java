//ID :318771052
//Name : Eliya Rabia

package packages;
import biuoop.DrawSurface;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;
import java.util.ArrayList;

/**
 * The type packages.Block.
 * this class is about the block of the game.
 */
public class Block implements Collidable, Sprite, HitNotifier {

    //represent list of listeners.
    private List<HitListener> hitListeners;

    //the rectangle of the block.
    private Rectangle rectangle;

    //the color of the block.
    private Color color;

    //represent the color of the block borders.
    private static final Color BLACK = Color.black;

    //represent the change value of the velocity while hitting.
    public static final int CHANGE_VELOCITY = -1;


    /**
     * Instantiates a new packages.Block.
     *
     * @param rectangle the rectangle
     * @param color     the color
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new LinkedList<>();
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        surface.setColor(BLACK);
        surface.drawRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint,
                        Velocity currentVelocity, Point nextPoint) {
        this.notifyHit(hitter);

        //checking if the hitting point is in the corners.
        Velocity v = this.rectangle.corners(collisionPoint, hitter.getCenter(),
                nextPoint, currentVelocity);

        // in case the hitting point is not on the corner.
        if (v.getDy() == currentVelocity.getDy()
                || v.getDx() == currentVelocity.getDx()) {
            double dX = currentVelocity.getDx();
            double dY = currentVelocity.getDy();

            //in case hitting point is on the sides.
            if (this.rectangle.getLeftLine().isContained(collisionPoint)
                    || this.rectangle.getRightLine()
                    .isContained(collisionPoint)) {
                dX *= CHANGE_VELOCITY;
            }

            // in case the hitting point is on the bases.
            if (this.rectangle.getUpLine().isContained(collisionPoint)
                    || this.rectangle.getDownLine()
                    .isContained(collisionPoint)) {
                dY *= CHANGE_VELOCITY;
            }
            return new Velocity(dX, dY);
        } else {
            //in case the hitting point is on the corners.
            return v;
        }
    }

    @Override
    public void timePassed() {
    }

    /**
     * Add to game.
     * the function gets game and add the current block to the game.
     *
     * @param g represent the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Remove from game.
     * the function gets game object and remove this block from it.
     *
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * Remove from game.
     * the function gets game object and remove this block from it.
     *
     * @param hitter represent the ball which hitting the object.
     */
    private void notifyHit(Ball hitter) {

        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);

        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}

