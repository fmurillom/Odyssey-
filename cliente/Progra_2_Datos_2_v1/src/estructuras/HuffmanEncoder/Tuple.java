package HuffmanEncoder;

public class Tuple<T> {
    public final T first;
    public final T second;

    public Tuple(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public Tuple() {
        this.first = null;
        this.second = null;
    }
}
