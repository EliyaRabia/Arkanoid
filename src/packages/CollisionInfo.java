//ID : 318771052
//Name: Eliya Rabia

package packages;

/**
 * The type packages.CollisionInfo.
 * this class is about collision of objects.
 */
public class CollisionInfo {

    //collision point with the object.
    private Point collidingPoint;

    //the object that hit.
    private Collidable object;

    /**
     * Instantiates a new Collision info.
     * the function gets colliding packages.Point and his hitting object and
     * creates a packages.CollisionInfo.
     *
     * @param collidingPoint the colliding point.
     * @param object         the object.
     */
    public CollisionInfo(Point collidingPoint, Collidable object) {
        this.collidingPoint = collidingPoint;
        this.object = object;
    }

    /**
     * Collision point.
     * the function return the colliding point.
     *
     * @return the point
     */
    public Point collisionPoint() {
        return this.collidingPoint;
    }

    /**
     * Collision object.
     * the function return the collidable object involved in the collision.
     *
     * @return the object
     */
    public Collidable collisionObject() {
        return this.object;
    }
}