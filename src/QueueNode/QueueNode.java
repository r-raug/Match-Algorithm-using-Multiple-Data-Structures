package QueueNode;

public class QueueNode {
    private Node head;
    private Node tail;
    private int size;

    public QueueNode(){
        head = null;
        tail = null;
        size = 0 ;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void enqueue(int element){
        Node temp = new Node(element);
        if(isEmpty()){
            tail = temp;
            head = temp;
        }else{
            tail.setNext(temp);
            tail=temp;
        }
        size++;
    }

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

    public void displayElements(){
        if(isEmpty()){
            System.out.println("The queue is empty.");
            return;
        }
        for(Node current = head; current != null; current = current.getNext()){
            System.out.print(current.getData() + " ");
        }
        System.out.println();
    }

    public int getSize(){
        return size;
    }



}
