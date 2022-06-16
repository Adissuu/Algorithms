public abstract class AbsHashMap {

    public int capacity;

    // constructor
    public AbsHashMap(int c) {
        capacity = c;
    }

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract String get(int key);

    public abstract String put(int k, String v);

    public abstract String remove(int k);
}
