// ---------------------------------------
// COMP 352
// Assignment 3
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 19, 2022
// ---------------------------------------
public abstract class AbsHashMap<Integer, Character> extends Entry<Integer, Character> {

    private int capacity;

    public AbsHashMap(int capacity) {
        this.capacity = capacity;
    }

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract char getMap(int key);

    public abstract char putMap(int key, char value);

    public abstract char removeMap(int key);

    public int getCapacity() {
        return capacity;
    }

    // Helpful to return the index of the inserted element
    public int hash(Entry entry) {
        int hash = entry.hashCode() % capacity;
        return hash;
    }

}