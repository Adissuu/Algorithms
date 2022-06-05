// ---------------------------------------
// COMP 352
// Assignment 2
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 5, 2022
// ---------------------------------------
public interface MyPQ<K extends Comparable<K>, V> {
    public int size();
    public boolean isEmpty();
    public void insert(K key, V value);
    public Node<K, V> min();
    public Node<K, V> removeMin();
}