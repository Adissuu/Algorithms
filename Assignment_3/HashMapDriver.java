
import java.util.ArrayList;

// ---------------------------------------
// COMP 352
// Assignment 3
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 19, 2022
// ---------------------------------------

public class HashMapDriver {

    public static void validate() {
        // a)
        ArrayList<Entry<Integer, Character>> data = new ArrayList<Entry<Integer, Character>>();
        for (int i = 0; i < 50; i++) {
            data.add(i, new Entry<>());
        }
        // b)
        MyHashMap<Integer, Character> map = new MyHashMap<>(100);
        // c)
        for (int i = 0; i < 50; i++) {
            map.putMap(data.get(i).getKey(), data.get(i).getValue());
        }

        // d)
        for (int i = 0; i < 50; i++) {
            int key = data.get(i).getKey();
            data.get(key);
        }
        // e)
        for (int i = 0; i < 25; i++) {
            int key = data.get(i).getKey();
            data.remove(key);
        }
        for (int i = 0; i < 50; i++) {
            int key = data.get(i).getKey();
            data.get(key);
        }
    }

    public static void interpret() {
        // a)
        // b)
        ArrayList<Entry<Integer, Character>> dataInterpret = new ArrayList<Entry<Integer, Character>>();
        for (int i = 0; i < 150; i++) {
            dataInterpret.add(i, new Entry<>());
        }
        // c)
        for (int n = 25; n <= 150; n = n + 25) {
            MyHashMap.startTimer();
            MyHashMap<Integer, Character> mapInterpret = new MyHashMap<>(100);
            for (int i = 0; i < n; i++) {
                mapInterpret.putMap(dataInterpret.get(i).getKey(), dataInterpret.get(i).getValue());
            }
            MyHashMap.endTimer();
        }
    }

    public static void main(String[] args) {
        validate();
        interpret();
    }
}