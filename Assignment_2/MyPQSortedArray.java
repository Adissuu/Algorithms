// ---------------------------------------
// COMP 352
// Assignment 2
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 5, 2022
// ---------------------------------------
@SuppressWarnings("all")
public class MyPQSortedArray<K extends Comparable<K>, V> implements MyPQ<K,V> {

    int size = 1;
    PQElem<K, V>[] arr = new PQElem[size];
    int entries = 0;
    int head = 0;

    
    
    public int size() {
        return entries;
    }

    //Method that ckecks if the queue is empty
    public boolean isEmpty() {
        return (entries==0);
    }

  
    //Method to insert a key value pair into a priority queue
    public void insert(K key, V value) {

        //If empty enter at start
        if (arr[0] == null){
            arr[0] = new PQElem<K,V>(key, value);
            entries++;
        }

        //If full double size and find correct location to enter
        else if (entries >= arr.length){
            arr = doubleSize();
            int i;
            for (i = entries - 1; (i >= 0 && (int)arr[i].getKey() > (int)key); i--)
                arr[i + 1] = arr[i];
    
            arr[i + 1] = new PQElem<K,V>(key, value);
            entries++;
        }

        //Find correct position and enter so as to maintain order
        else{
            int i;
            for (i = entries - 1; (i >= 0 && (int)arr[i].getKey() > (int)key); i--)
                arr[i + 1] = arr[i];
    
            arr[i + 1] = new PQElem<K,V>(key, value);
            entries++;
        }
    }

    
    //Method to double the size of the priority queue
    private PQElem<K, V>[] doubleSize(){
        PQElem<K, V>[] Return = new PQElem[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            Return[i] = arr[i];
        }
        return(Return);
    }

    
    //Return but don't remove the node with the minimum key
    public Node<K, V> min() {
        if (!isEmpty()){
            return arr[head];
        }
        else{
            return null;
        }
    }

    
    //Return and remove the node with the minimum key 
    public Node<K, V> removeMin() {
        if(isEmpty()){
            return null;
        }
        else{
          PQElem<K, V> temp = arr[head];
            arr[head] = null;
            head++;
            entries--;
            if(entries <= 0.25*arr.length){
                arr = halveSize();
                head = 0;
            }
            return temp;
        }

    }

    
    private PQElem<K, V>[] halveSize() {
        int newSize = (int) (arr.length*0.5);
        int index = 0;
        PQElem<K, V>[] toReturn = new PQElem[newSize];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                toReturn[index] = arr[i];
                index++;
            }
        }
        return(toReturn);
    }
}

