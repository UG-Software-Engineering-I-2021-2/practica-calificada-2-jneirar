package ing;

public final class Pair<FirstType, SecondType> {
    private final FirstType first;
    private final SecondType second;

    public Pair(FirstType first, SecondType second) {
        this.first  = first;
        this.second = second;
    }

    public FirstType first() {
        return first;
    }

    public SecondType second() {
        return second;
    }
}
