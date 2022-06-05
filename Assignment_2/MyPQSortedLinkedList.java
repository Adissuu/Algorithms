// ---------------------------------------
// COMP 352
// Assignment 2
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 5, 2022
// ---------------------------------------
import java.util.Comparator;

//Since K hides the value of k and V hides the value of v
@SuppressWarnings("all")
public class MyPQSortedLinkedList<K extends Comparable <K>, V> {

    //Defining Node class
    class Node <K extends Comparable<K>, V> implements Comparator<Node<K, V>> {
  
        K key;
        V value;
        Node <K,V> prev;
        Node <K,V> next;
      
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
      
        @Override
        public int compare(Node<K, V> o1, Node<K, V> o2) {
            return o1.key.compareTo(o2.key);
        }
      }
    Node<K,V> head = null;
    Node<K,V> tail = null;
    int size=0; //first size is 0
    

    //Method of returning the size of queue
    public int size() {
        return size;
    }

    //Method of returning true if the list is empty
    public boolean isEmpty() {
        return (size==0);
    }

   //Method of returning the min
    public Node<K,V> min() {
        //if the list is not empty, return tail
        if(!(isEmpty())){
            return tail;
        }
        return null;
    }

    //Method of removing from the queue
    public Node<K,V> removeMin() {
        //if the list is not empty
        if(!(isEmpty())){
            //Sorting tail
            Node<K,V> oldTail=tail;
            
            //if size is 1
            if(size==1){
                head=null;
                tail=null;
            }
            else{
                tail=tail.prev;
                tail.next=null;
            }
            size--;
            return oldTail;
        }
        return null;
    }
    
    //Method of inserting to the queue
    public void insert(K k, V v) {
        Node<K,V> n = new Node<K,V>(k,v);
        Node<K,V> t1= head;
        boolean insertAtTail = true;

        //adding node if list is empty
        if (isEmpty()){
            head = tail = n;
            head.prev = null;
            tail.next = null;
        }
        //if list is not empty
        else{
            //looping through list
            while(t1 != null && n.compare(n, t1)< 0){
                t1=t1.next;
            }
            if (t1 != null){

                //Adding at head of list
                if (t1==head){
                    n.next=head;
                    n.next.prev=n;
                    head = n;
                }
                //Adding in middle
                else{
                    Node<K,V> Bef = t1.prev;
                    n.next=t1;
                    n.prev=Bef;
                    t1.prev= n;
                    Bef.next= n;
                    
                }
                insertAtTail = false;
            }
            //Adding at tail
            if (insertAtTail){
                tail.next = n;
                n.prev = tail;
                tail = n;
                tail.next = null;
            }
        }
        size++;
    }
    //Method of displaying the queue
    public void display(){
        int i=1;
        Node<K,V> t1=head;

        while(t1 != null){
            System.out.print("Element " + i + " has the key of " + t1.key + " and a value of " + t1.value + ".");
            t1 = t1.next;
            i++;
        }
    }
}
