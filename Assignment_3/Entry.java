
// ---------------------------------------
// COMP 352
// Assignment 3
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 19, 2022
// ---------------------------------------
import java.util.Random;

public class Entry<Integer, Character> {

    private int key;
    private char value;

    // Constructors
    public Entry(int key, char value) {
        this.key = key;
        this.value = value;
    }

    // default const
    public Entry() {
        value = charRandom();
        key = keyRandom();
    }

    private int keyRandom() {
        Random random = new Random();
        key = random.nextInt(10000000);
        return key;
    }

    private char charRandom() {
        Random random = new Random();
        value = (char) (random.nextInt(26) + 'a');
        return value;
    }

    // Getters and Setters
    public int getKey() {
        return key;
    }

    public char getValue() {
        return value;
    }

    void setKey(int key) {
        this.key = key;
    }

    public void setValue(char value) {
        this.value = value;
    }

    // Return the key
    @Override
    public int hashCode() {
        return key;
    }
}