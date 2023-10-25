//ID : 318771052
//Name : Eliya Rabia

package packages;


/**
 * The interface Hit listener.
 * this interface is about hit listener
 */
public interface HitListener {

    /**
     * Hit event.
     * the function is called whenever the beingHit object is hit.
     * The hitter parameter is the packages.Ball that's doing the hitting.
     *
     * @param beingHit represent the being hit object.
     * @param hitter   the hitter
     */
    void hitEvent(Block beingHit, Ball hitter);
}
