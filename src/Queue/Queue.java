package Queue;

//import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a generic queue implemented using an array.
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T> {
    int size;
    int front;
    int rear;
    T[] queue;

    /**
     * Constructs an empty queue with a default capacity of 20.
     */
    public Queue() {
        front = -1;
        rear = -1;
        size = 0;
        queue = (T[]) new Object[20];
    }

    /**
     * Constructs a queue initialized with the elements of the given list.
     * @param list the list of elements to initialize the queue with
     */
    public Queue(List<T> list) {
        size = list.size();
        front = 0;
        rear = size - 1;
        queue = (T[]) new Object[size * 2];
        int i = 0;
        for (T item : list) {
            this.queue[i++] = item;
        }
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     * @return true if the queue is full, false otherwise
     */
    private boolean isFull() {
        return (rear + 1) % queue.length == front && size == queue.length;
    }

    /**
     * Adds an element to the rear of the queue.
     * @param item the item to be added to the queue
     */
    public void enqueue(T item) {
        if (isFull()) {
            resize();
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % queue.length;
        }
        queue[rear] = item;
        size++;
        System.out.println("Element " + item + " is inserted successfully.");
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
            T item = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            size--;
            return item;
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
        System.out.println("The size is: " + size);
        return size;
    }

    /**
     * Resizes the internal array of the queue to accommodate more elements.
     */
    private void resize() {
        int temp = size * 2;
        T[] tempQueue = Arrays.copyOf(queue, temp);
        for (int i = 0; i < size; i++) {
            tempQueue[i] = queue[(front + i) % queue.length];
        }
        queue = tempQueue;
        front = 0;
        rear = size - 1;
    }

    /**
     * Displays the elements of the queue.
     */
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (int i = front; i != rear; i = (i + 1) % queue.length) {
                System.out.print(queue[i] + " ");
            }
            System.out.println(queue[rear]);
        }
    }


    /**
     * Finds the position of an item in the queue.
     * @param item the item to find the position of
     * @return the position of the item in the queue, or -1 if the item is not found
     */
    public int find(T item) {
        if (isEmpty()) {
            System.out.println("Queue.Queue is empty.");
            return -1;
        }
        for (int i = front; i != rear; i = (i + 1) % queue.length) {
            if (queue[i].equals(item)) {
                return i;
            }
        }
        if (queue[rear].equals(item)) {
            return rear;
        }
        return -1;
    }

    public void insertionSort() {
        if (isEmpty()) {
            System.out.println("Cannot sort an empty queue.");
            return;
        }

        for (int i = 1; i < size; i++) {
            T key = queue[i];
            int j = i - 1;

            while (j >= 0 && ((Comparable) queue[j]).compareTo(key) > 0) {
                queue[j + 1] = queue[j];
                j--;
            }
            queue[j + 1] = key;
        }
        System.out.println("Queue sorted successfully.");
    }

    public void displayElement(T element){
        var item = find(element);
        if( item == - 1){
            System.out.println("Element not found.");
        }else{
            System.out.printf("The element {element} is on the index {item}.",element, item);
        }
    }



}
