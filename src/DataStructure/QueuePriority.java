package DataStructure;

import Model.Professors;
import auxiliaryStructure.compareProfessorsClass;

import java.util.Comparator;

public class QueuePriority<T extends Comparable<T>> extends Queue<T>{


    private Comparator<T> comparator;

    /**
     * Constructor for the priority queue.
     *
     * @param comparator the comparator to determine the priority of elements in the queue
     */
    public QueuePriority(Comparator<T> comparator) {
        this.comparator = comparator;
    }


    /**
     * Inserts an item into the priority queue.
     *
     * @param item the item to be inserted into the queue
     */
    @Override
    public void enqueue(T item) {

        if (isFull()) {
            resize();
        }

        if (isEmpty() || comparator.compare(item, queue[front]) < 0) {
            front = (front - 1 + queue.length) % queue.length;
            queue[front] = item;
        } else {
            int pos = rear;
            while (pos != front && comparator.compare(item, queue[(pos - 1 + queue.length) % queue.length]) < 0) {
                queue[pos] = queue[(pos - 1 + queue.length) % queue.length];
                pos = (pos - 1 + queue.length) % queue.length;
            }
            queue[pos] = item;
        }
        rear = (rear + 1) % queue.length;
        size++;
    }


    /**
     * Displays the specific element in the queue.
     *
     * @param element the element to be displayed
     */
    public void displayElement(T element){
        var item = findPosition(element);
        if( item == - 1){
            System.out.println("Element not found.");
        }else{
            System.out.printf("The element {element} is on the index {item}.",element, item);
        }
    }


    /**
     * Displays the elements with higher priority than the specified item in the queue.
     *
     * @param item the reference item
     */
    public void displayHigherElements(T item){
        var position = findPosition(item);
        for( int i = position; i < size - 1 ; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }


    /**
     * Displays the elements with lower priority than the specified item in the queue.
     *
     * @param item the reference item
     */
    public void displayLowerElements(T item){
        var position = findPosition(item);
        for( int i = 0; i < position ; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }


    /**
     * Finds the position of an item in the queue.
     *
     * @param item the item to be located
     * @return the position of the item in the queue, or -1 if the item is not found
     */
    public int findPosition(T item) {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int i = 0;
        compareProfessorsClass comparator = new compareProfessorsClass(); // Instanciando a classe de comparação
        while (i < size && comparator.compareProfessors((Professors) queue[i], (Professors) item) < 0) { // Comparando usando a classe de comparação
            i = (i + 1) % queue.length;
        }
        return i;
    }

    /**
     * Returns the element at the specified position in the queue.
     *
     * @param index the index of the element
     * @return the element at the specified position in the queue
     */
    public T getElement(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Invalid index or queue is empty.");
            return null;
        }
        return queue[index];
    }


}
