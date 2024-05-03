package DataStructure;

/**
 * Represents a queue implemented using linked nodes.
 */
public class QueueNodeGeneric <T>{
    protected NodeGeneric<T> head;
    protected NodeGeneric<T> tail;
    protected short size;

    /**
     * Constructs an empty queue.
     */
    public QueueNodeGeneric(){
        head = null;
        tail = null;
        size = 0 ;
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return head==null;
    }

    /**
     * Adds an element to the end of the queue.
     * @param element the element to be added to the queue
     */
    public void enqueue(T element){
        NodeGeneric<T> temp = new NodeGeneric<>(element);
        if(isEmpty()){
            tail = temp;
            head = temp;
        }else{
            tail.setNext(temp);
            tail=temp;
        }
        size++;
    }

    /**
     * Removes the element at the front of the queue.
     */
    public NodeGeneric<T> dequeue(){
        if(isEmpty()){
            System.out.println("Nothing to delete...");
            return null;
        }
        if(size == 1){
            NodeGeneric<T> result = head;
            head = tail = null;
            size --;
            return result;
        }
        NodeGeneric<T> result = head;
        head = head.getNext();
        size --;
        return result;
    }

    /**
     * Displays the elements of the queue.
     */
    public void displayElements(){
        if(isEmpty()){
            System.out.println("The queue is empty.");
            return;
        }
        for(NodeGeneric<T> current = head; current != null; current = current.getNext()){
            System.out.print(current.getData() + " ");
        }
        System.out.println();
    }

    /**
     * Retrieves the size of the queue.
     * @return the size of the queue
     */
    public short getSize(){
        return size;
    }



}
