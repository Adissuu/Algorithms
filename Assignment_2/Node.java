import java.util.Comparator;
  class Node <K extends Comparable<K>, V> implements Comparator<Node<K, V>> {

    K key;
    V value;
    Node <K,V> prev;
    Node <K,V> next;
  
    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }
  
   
    public K getKey() {
        return this.key;
    }
  
    
    public V getValue() {
        return this.value;
    }
    
    public void setKey(K key){
        this.key = key;
    }
  
    public void setValue(V value){
        this.value = value;
    }
  
    public String toString(){
        return("\n" + "Key: " + getKey() + " Value: " + getValue());
    }

    @Override
    public int compare(Node<K, V> o1, Node<K, V> o2) {
        return o1.key.compareTo(o2.key);
    }
  }

