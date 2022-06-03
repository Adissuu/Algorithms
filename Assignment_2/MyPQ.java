public interface MyPQ<K,V> {
    public int size();

    public boolean isEmpty();

    public V min();

    public V  removeMin();

    public void insert(K key, V value);
}