//ID : 318771052
//Name : Eliya Rabia

package packages;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 * this class is about key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    //represent the sey board.
    private KeyboardSensor sensor;
    //represent the pressed key.
    private String key;
    //represent the animation.
    private Animation animation;
    //represent should stop.
    private boolean stop;
    //represent if the key is already pressed.
    private boolean isAlreadyPressed;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key,
                                      Animation animation) {
        this.animation = animation;
        this.sensor = sensor;
        this.key = key;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    @Override
    public void doOneFrame(biuoop.DrawSurface d) {
        if (this.sensor.isPressed(key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
        this.animation.doOneFrame(d);
    }
}
