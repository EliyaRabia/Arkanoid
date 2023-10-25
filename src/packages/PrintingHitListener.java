//ID : 318771052
//Name : Eliya Rabia

package packages;

/**
 * The type Printing hit listener.
 * this class is about printing hit listener.
 */
public class PrintingHitListener implements HitListener {

    /**
     * hit event.
     * the function print a message that the ball hit on a block.
     *
     * @param hitter   represent the hitting ball.
     * @param beingHit represent the being hit object.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A packages.Block was hit.");
    }
}