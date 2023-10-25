//ID : 318771052
//Name : Eliya Rabia

package packages;

/**
 * The interface Hit notifier.
 * this interface is about hit notifier object.
 */
public interface HitNotifier {

    /**
     * Add hit listener.
     * the function gets hit listener and add it to hit events list.
     *
     * @param hl represent the hit listener.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hit listener.
     * the function gets hit listener and remove it from the hit events list.
     *
     * @param hl represent the hit listener.
     */
    void removeHitListener(HitListener hl);
}