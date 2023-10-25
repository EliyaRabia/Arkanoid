//Name: Eliya Rabia.
//ID: 318771052

package packages;

/**
 * Game environment.
 * this class is about the environment of the game.
 */
public class GameEnvironment {

    //the collidable objects.
    private java.util.List<Collidable> collideables = null;

    /**
     * Game environment.
     * the function creates game environment.
     */
    public GameEnvironment() {
        this.collideables = new java.util.ArrayList<Collidable>();
    }

    /**
     * Add collidable.
     * the function gets collidable and add it to the collidable list.
     *
     * @param c represent the collidable.
     */
    public void addCollidable(Collidable c) {
        this.collideables.add(c);
    }

    /**
     * Get the closest collision.
     * Assume an object moving from line.start() to line.end()
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory represent the trajectory.
     * @return the closest collision or null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closestPoint = null;
        Collidable object = null;
        if (this.collideables == null) {
            return null;
        }
        for (Collidable collide : this.collideables) {

            //find the closest intersection with the current collidable.
            Point collidingPoint =
                    trajectory.closestIntersectionToStartOfLine(
                            collide.getCollisionRectangle());
            if (collidingPoint != null) {

                //for the first time we found colliding packages.Point.
                if (closestPoint == null) {
                    closestPoint = collidingPoint;
                    object = collide;
                } else {

                    //checking if there is closer point.
                    if (closestPoint.distance(trajectory.start())
                            > collidingPoint.distance(trajectory.start())) {
                        closestPoint = collidingPoint;
                        object = collide;
                    }
                }
            }
        }
        if (closestPoint != null) {
            return new CollisionInfo(closestPoint, object);
        }
        return null;
    }

    /**
     * Gets list.
     * the function return the list of collidables.
     *
     * @return the list
     */
    public java.util.List<Collidable> getList() {
        return this.collideables;
    }

    /**
     * Find related rectangle.
     * the function gets point and radius and pass on collidables to search
     * if the point with the radius inside any collidable if yes return true
     * else return false.
     *
     * @param p      represent the point
     * @param radius represent the radius
     * @return the boolean
     */
    public boolean findRelatedRectangle(Point p, int radius) {
        for (Collidable collide : this.collideables) {
            if (p.inside(collide.getCollisionRectangle(), radius)) {
                return true;
            }
        }
        return false;
    }
}