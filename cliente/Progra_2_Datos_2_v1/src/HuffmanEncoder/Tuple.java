package HuffmanEncoder;

/**
 * Class used to return pairs of objects
 *
 * @param <T> type of those objects
 */
public class Tuple<T> {
    public final T first;
    public final T second;

    /**
     * Constructor
     *
     * @param first first value
     * @param second second value
     */
    public Tuple(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public Tuple() {
        this.first = null;
        this.second = null;
    }
}
