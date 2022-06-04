
public class MyPQUnsortedLinkedList<K, V> implements MyPQ {

    public class Node {
        K key;
        V value;
        Node prev;
        Node next;

        public Node(K k, V v, Node pre, Node ne) {
            this.key = k;
            this.value = v;
            this.prev = pre;
            this.next = ne;
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object min() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object removeMin() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(Comparable key, Object value) {
        // TODO Auto-generated method stub

    }

}