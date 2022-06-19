
// ---------------------------------------
// COMP 352
// Assignment 3
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 19, 2022
// ---------------------------------------
import java.util.ArrayList;
import java.util.List;

public class MyHashMap<Integer, Character>
        extends AbsHashMap<Integer, Character> {

    // To insert the the elements of the hashMap
    private ArrayList<Entry<Integer, Character>> map = new ArrayList<Entry<Integer, Character>>();
    // To calculate the number of elements that each bucket has
    private List bucket = new ArrayList();
    private int totalEntries = 0;
    private int collision;

    public MyHashMap(int capacity) {
        super(capacity);
        for (int i = 0; i < capacity; i++)
            map.add(i, new Entry<>(0, '0'));
    }

    // OVERRIDING FUNCTIONS
    @Override
    public int size() {
        return totalEntries;
    }

    @Override
    public boolean isEmpty() {
        return (totalEntries == 0);
    }

    @Override
    public char getMap(int key) {
        StartTimer();
        int index = findKey(key);
        // Array get
        if (index == -1 || map.get(index).getValue() == '0') {
            System.out.println("no value");
            endTimer();
            return '.';
        }
        System.out.print("The entry at key =" + key + "' is " + map.get(index).getKey() + ", '"
                + map.get(index).getValue() + "\n");
        endTimer();
        return map.get(index).getValue();
    }

    @Override
    public char putMap(int key, char value) {
        StartTimer();
        if (findIndex(key % getCapacity()) == -1) {
            map.add(key % getCapacity(), new Entry<>(key, value));
            bucket.add(key);
            totalEntries++;
            System.out.println("Size of the table = " + getCapacity()
                    + ", Number of elements = " + size() +
                    "\nNumber of collision = " + collision
                    + "\nNumber of items in the bucket storing '" + value + "' is " + nodesAt(key) + ". ");
            endTimer();
            return '.';

        } else {
            map.get(key % getCapacity()).setValue(value);
            bucket.add(key);
            collision++;
            System.out.println("Size of the table = " + getCapacity()
                    + ", Number of elements = " + size() +
                    "\nNumber of collision = " + collision
                    + "\nNumber of items in the bucket storing '" + value + "' is " + nodesAt(key) + ". ");
            endTimer();
            return map.get(key % getCapacity()).getValue();
        }
    }

    @Override
    public char removeMap(int key) {
        StartTimer();
        int index = findIndex(key);
        if (index == -1) {
            System.out.println("Nothing at key " + key + "\n");
            return 0;
        }
        char value = map.get(key % getCapacity()).getValue();
        map.remove(index); // Remove the element.
        totalEntries--;
        System.out.println("Value removed at key " + key);
        endTimer();
        return value;
    }

    // END OF OVERRIDING
    // Next two methods are usefull to perform the get, put, and remove methods as
    // the first one gives the index based on the key and the second one does the
    // opposite.
    private int findIndex(int key) {
        for (int i = 0; i < map.size(); i++) {
            int currentKey = hash(map.get(i));
            if (currentKey == key % getCapacity() && map.get(i).getValue() != '0')
                return i;
        }
        return -1;
    }

    public int findKey(int index) {
        for (int i = 0; i < map.size(); i++) {
            int currentIndex = map.get(i).getKey();
            if (currentIndex == index && map.get(i).getValue() != '0')
                return i;
        }
        return -1;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("The HashMap is capute.");
            return;
        }
        System.out.println(
                "The capacity of the map is " + getCapacity() + ", and it contains " + size() + " values: {");
        for (int i = 0; i < getCapacity(); i++) {
            if (map.get(i).getValue() != '0')
                System.out.println("(" + map.get(i).getKey() + ", '" + map.get(i).getValue() + "') ");
        }
        System.out.print("}\n");
    }

    // number of nodes for a given bucket
    private int nodesAt(int key) {
        int bucketNum = 0;
        for (int i = 0; i < bucket.size(); i++) {
            int currentKey = (int) bucket.get(i);
            if (key % getCapacity() == currentKey % getCapacity())
                bucketNum++;
        }
        return bucketNum;
    }

    // Timers
    public long StartTimer() {
        long StartTimer = System.currentTimeMillis();
        return StartTimer;
    }

    public void endTimer() {
        long endTimer = System.currentTimeMillis();
        long executionTime = endTimer - StartTimer();
        System.out.println("The method took " + executionTime + " ms to be executed.\n");
    }
}