package DataStructure;
import auxiliaryStructure.compareProfessorsClass;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a generic queue implemented using an array.
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T extends Comparable<T>>{
    int size;
    int front;
    int rear;
    T[] queue;

    /**
     * Constructs an empty queue with a default capacity of 20.
     */
    public Queue() {
        front = 0;
        rear = -1;
        this.size = 0;
        queue = (T[]) new Comparable[20];
    }

    /**
     * Constructs a queue initialized with the elements of the given list.
     * @param int newsize to initialize the queue with
     */
    public Queue(int newsize) {
        size = 0;
        front = 0;
        rear = - 1;
        queue = (T[]) new Comparable[newsize * 2];
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
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * @return the element at the front of the queue, or null if the queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        } else {
            T item = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % queue.length;
            }
            size --;
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
        System.out.println("The size is: " + (size - 1));
        return size;
    }

    /**
     * Resizes the internal array of the queue to accommodate more elements.
     */
    public void resize() {
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
            int count = 0;
            int i = front;
            while (count < size) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % queue.length;
                count++;
            }
            System.out.println();
        }
    }
}
