// ---------------------------------------
// COMP 352
// Assignment 2
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 5, 2022
// ---------------------------------------
@SuppressWarnings("all")
public class MyPQUnsortedArray<K extends Comparable<K>, V> implements MyPQ<K, V>{

    // Initializing variables used throughout
    private int size = 1;
    private PQElem<K, V>[] arr = new PQElem[size];
    private int entries = 0;
    private int emptyPosition = 0;

   
    //Method to return entries in priority queue
    public int size() {
        return entries;
    }


    // Method that checks if priority queue is empty
    public boolean isEmpty() {
        return(entries==0);
    }

    
    //Method to insert a key value pair into a priority queue
    public void insert(K key, V value) {

        if (emptyPosition >= arr.length){
            arr = doubleSize();
            arr[emptyPosition] = new PQElem<K,V>(key, value);
            emptyPosition++;
            entries++;
            
        }
        else{
            arr[emptyPosition] = new PQElem<K,V>(key, value);
            emptyPosition++;
            entries++;
        }
    }


    
    //Return but don't remove the node with the minimum key
    public Node<K, V> min() {
        int minKey = Integer.MAX_VALUE;
        int index = -1;
        if (isEmpty()){
            return(null);
        }
        else{
            for (int i = 0; i<arr.length; i++){
                if(arr[i] != null){
                    
                    if((int)arr[i].getKey() <= minKey){
                        index = i;
                        minKey = (int)arr[i].getKey();
                    }
                }
            }
        }
        return arr[index];
    }

    
    //Return and remove the node with the minimum key
    public Node<K, V> removeMin() {

        int minKey = Integer.MAX_VALUE;
        int index = -1;
        if (isEmpty()){
            return(null);
        }
        else{
            for (int i = 0; i<arr.length; i++){
                if(arr[i] != null){
                    if((int)arr[i].getKey() <= minKey){
                        index = i;
                        minKey = (int)arr[i].getKey();
                    }
                }
            }
        }

        Node<K, V> temp = arr[index];
        arr[index] = null;
        entries--;

        if(entries <= 0.25*arr.length){
            arr = halveSize();
        }

        return temp;
    }

    
    //Halve the size of the priority queue to reduce wasted space
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


    //Method to double the size of the priority queue
    private PQElem<K, V>[] doubleSize(){
      PQElem<K, V>[] toReturn = new PQElem[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            toReturn[i] = arr[i];
        }
        return(toReturn);
    }
    
}