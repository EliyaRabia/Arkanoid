//Name: Eliya Rabia.
//ID: 318771052.

package packages;

/**
 * The type packages.Counter.
 * this class is about counter object.
 */
public class Counter {

    //represent the counting parameter.
    private int count;

    /**
     * Instantiates a new packages.Counter.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Instantiates a new packages.Counter.
     * the function gets integer and creates new counter object with initialize
     * the integer value.
     *
     * @param count represent the integer count value.
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * Increase.
     * the function gets number and increase the current count by this number.
     *
     * @param number the number
     */
    public void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * Decrease.
     * the function gets number and decrease the current count by this number.
     *
     * @param number the number
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * Get value int.
     * the function returns the current value of count.
     *
     * @return the int
     */
    public int getValue() {
        return this.count;
    }
}