// ---------------------------------------
// COMP 352
// Assignment 2
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 5, 2022
// ---------------------------------------
  public class PQElem<K extends Comparable<K>, V> implements Node<K,V>{

    private K key;
    private V value;

    public PQElem(K key, V value){
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
}

