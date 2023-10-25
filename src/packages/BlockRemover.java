//Name: Eliya Rabia.
//ID: 318771052.

package packages;

/**
 * The type packages.Block remover.
 * this class is about the block remover listener.
 */
public class BlockRemover implements HitListener {

    //represent the block remover game.
    private GameLevel gameLevel;

    //represent the counter of remaining blocks on the game.
    private Counter remainingBlocks;

    /**
     * Instantiates a new packages.Block remover.
     *
     * @param gameLevel          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeFromGame(gameLevel);
        beingHit.removeHitListener(this);
    }

    /**
     * Gets remaining blocks.
     * the function returns the remaining blocks.
     *
     * @return the remaining blocks
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }
}