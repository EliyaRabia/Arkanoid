//ID : 318771052
//Name: Eliya Rabia

package packages;

/**
 * The interface packages.Collidable.
 * this interface is about collidables.
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     * the function Return the "collision shape" of the object.
     *
     * @return the collision rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Hit velocity.
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param hitter          represent the ball
     * @param collisionPoint  represent the collision point
     * @param currentVelocity represent the current velocity
     * @param nextPoint       represent the optional next point.
     * @return the velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity,
                 Point nextPoint);
}