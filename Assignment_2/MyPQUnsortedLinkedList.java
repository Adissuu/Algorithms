
public class MyPQUnsortedLinkedList<K,V> implements MyPQ {

    
    public class Node {
        K key;
        V value;
        Node prev;
        Node next;

        public Node(K k, V v, Node pre, Node ne){
            this.key = k;
            this.value = v;
            this.prev = pre;
            this.next = ne;
        }
    }


    
}