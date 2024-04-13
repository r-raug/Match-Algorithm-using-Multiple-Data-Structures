package DataStructure;

//import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a generic queue implemented using an array.
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T>{
    int size;
   // int front;
   // int rear;
    T[] queue;

    /**
     * Constructs an empty queue with a default capacity of 20.
     */
    public Queue() {
        //front = -1;
        //rear = -1;
        size = 0;
        queue = (T[]) new Comparable[20];
    }

    /**
     * Constructs a queue initialized with the elements of the given list.
     * @param list the list of elements to initialize the queue with
     */
    public Queue(List<T> list) {
        size = list.size();
        //front = 0;
        //rear = size - 1;
        queue = (T[]) new Comparable[size * 2];
        int i = 0;
        for (T item : list) {
            this.queue[i++] = item;
        }
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull() {
        //return (rear + 1) % queue.length == front && size == queue.length;
        return size == queue.length;
    }

    /**
     * Adds an element to the rear of the queue.
     * @param item the item to be added to the queue
     */
    public void enqueue(T item) {
        if (isFull()) {
            resize();
        }else {
            //if (!isEmpty()) {
            //front = 0;
            //rear = 0;
            queue[size] = item;
            size++;
        }
        //}
//        } else {
//            //rear = (rear + 1) % queue.length;
//            insertionSort();
//            //var temp = queue[findPosition(item)];
//            var position = findPosition(item);
//            queue[findPosition(item)] = item;
//            for( int i = position + 1 ; i <= rear ; i++){
//                var temp = queue[i];
//                queue[i] = temp;
//                temp = queue[i+1];
//            }

        //}
        //queue[rear] = item;
        //size++;
        //System.out.println("Element " + item + " is inserted successfully.");
    }

    /**
     * Removes and returns the element at the front of the queue.
     * @return the element at the front of the queue, or null if the queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue.Queue is empty.");
            return null;
        } else {
//            T item = queue[front];
//            if (front == rear) {
//                front = -1;
//                rear = -1;
//            } else {
//                front = (front + 1) % size;
//            }
//            size--;
//            return item;
            T item = queue[0];
            for(int i = 0; i < size -1; i++){
                queue[i] = queue[i+1];
            }
            size --;
            return item ;
        }

    }

    /**
     * Retrieves the size of the queue.
     * @return the size of the queue
     */
    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        System.out.println("The size is: " + (size - 1));
        return size;
    }

    /**
     * Resizes the internal array of the queue to accommodate more elements.
     */
    public void resize() {
//        int temp = size * 2;
//        T[] tempQueue = Arrays.copyOf(queue, temp);
//        for (int i = 0; i < size; i++) {
//            tempQueue[i] = queue[(front + i) % queue.length];
//        }
//        queue = tempQueue;
//        front = 0;
//        rear = size - 1;
        T[] temp = (T[])(new Object[queue.length * 2]);
        for( int i = 0 ; i < queue.length; i++){
            temp[i] = queue[i];
        }
        queue = temp;


    }

    /**
     * Displays the elements of the queue.
     */
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
//        } else {
//            for (int i = front; i != rear; i = (i + 1) % queue.length) {
//                System.out.print(queue[i] + " ");
//            }
//            System.out.println(queue[rear]);
//        }
        }else{
            for(int i = 0; i < size ; i++){
                System.out.print(queue[i] + " ");
            }
            System.out.println("");
        }
    }








}
