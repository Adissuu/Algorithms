//Assignment 2
//Gabriel Dubois(), Ali Fetanat(40158208)


public class LinkedList<T extends Comparable> implements MyContainer<T>
{
    protected Node head;
    protected int size;

    public LinkedList()
   {
        head = null;
        size = 0;
    }

    
    public void insert(T obj)
   {
        // because it's unsorted just insert at the head
        head = new Node(obj, null, head);
        size++;
    }

    
    public int getSize()
   {
        return size;
    }
    
    public boolean isEmpty()
   {
        return size == 0;
    }

    
    public T remove(int idx)
   {
        Node found = moveTo(idx);
        return removeNode(found);
    }
   
    public T removeNode(Node node)
   {
        T res = null;
        if(node != null)
       {
            if(head == node)
           {
                // update head node first
                head = head.next;
            }

            // now remove node and adjust size
            res = node.data;
            node.remove();
            size--;

        }

        return res;
    }