// ---------------------------------------
// COMP 352
// Assignment 2
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 5, 2022
// ---------------------------------------
import java.util.Comparator;

//Since K hides the value of k and V hides the value of v
@SuppressWarnings("all")
public class MyPQUnsortedLinkedList<K extends Comparable<K>, V>  {

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
        //if the size is 0, true
        return (size==0);
    }
    
   
    //Method of returning the min
    public Node<K, V> min() {
        Node<K,V> t1 = head; //points to head
        Node<K,V> t2 = head.next; //points to node after the head

        if(!isEmpty()){
            while(t1 != null){
                //if key is greater than next key then return would be the smaller key
                if(t1.compare(t2, t1)>0){
                    t2=t1;
                }
                //moving to next node
                t1= t1.next;
            }
            return t2;
        }
        return null;
       
    }

   //Method of removing from the queue
    public Node<K, V> removeMin() {
       Node<K,V> t1 = head;
       Node<K,V> t2 = head.next;

       if (!isEmpty()){

           //if size is 1
           if(size==1){
               head = null;
               tail = null;
           }
           else{
               //Searching through the list to find the minimum 
               while (t1 != null){
                   if (t1.compare(t2, t1)>0){
                       t2 = t1;
                   }
                   t1 = t1.next;
               }

               //Remove from tail
               if(t2 == tail){
                   tail = tail.prev;
                   tail.next = null;
               }

               //Remove from head
               else if(t2 ==head){
                   head.next.prev=null;
                   head= head.next;
               }

               //Remove from middle
               else{
                   Node<K,V> removeNode = t2;
                   removeNode.prev.next = removeNode.next;
                   removeNode.next.prev = removeNode.prev;
               }
           }
            size--;
            return t2;
       }
       return null;
    }

    //Method of inserting to the queue
    public void insert(K k, V v) {
        Node<K,V> n = new Node<K,V>(k, v);

        if (isEmpty()){
            head = tail = n;
            head.prev = null;
            head.next = null;
        }
        else{
            tail.next= n;
            n.prev=tail;
            tail=n;
            tail.next = null;

        }
        size++;

    }
    
    //Method of displaying the queue
    public void diplay(){
        int i= 0;
        Node<K,V> t1 = head;

        while(t1 != null){
            System.out.print("I like Gabe and Element" + i + " has key" + t1.key + " and a value of " + t1.value + ".");
            t1 = t1.next;
            i++;
        }
    }


}