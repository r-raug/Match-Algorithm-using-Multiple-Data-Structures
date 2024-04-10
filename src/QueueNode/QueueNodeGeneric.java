package QueueNode;

/**
 * Represents a queue implemented using linked nodes.
 */
public class QueueNodeGeneric <T>{
    private NodeGeneric<T> head;
    private NodeGeneric<T> tail;
    private int size;

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
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Nothing to delete...");
            return;
        }
        if(size == 1){
            head = tail = null;
            size --;
            return;
        }
        head = head.getNext();
        size --;
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
    public int getSize(){
        return size;
    }



}
