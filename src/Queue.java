import java.util.Arrays;
import java.util.List;

public class Queue<T> {
    int size;
    int front;
    int rear;
    T[] queue;

    public Queue(){
        front = -1;
        rear = -1;
        size = 0;
        queue = (T[]) new Object[20];
    }

    public Queue(List<T> list){
        size = list.size();
        front = 0;
        rear = size - 1;
        queue = (T[]) new Object[size * 2 ];
        int i = 0;
        for (T item : list) {
            this.queue[i++] = item;
        }
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return (rear + 1) % queue.length == front && size == queue.length;
    }

    public void enqueue(T item){
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

    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return null;
        }else{
            T item = queue[front];
            if(front == rear){
                front = -1;
                rear = -1;

            }else{
                front = (front + 1) % size;

            }
            size --;
            return item;
        }
    }

    public int getSize(){
        if(isEmpty()){
            return 0;
        }
        System.out.println("The size is: " + size);
        return size;
    }

    private void resize(){
        int temp = size * 2;
        T[] tempQueue = Arrays.copyOf(queue, temp);
        for (int i = 0; i < size; i++) {
            tempQueue[i] = queue[(front + i) % queue.length];
        }

        queue = tempQueue;
        front = 0;
        rear = size - 1;

    }

    public void displayQueue(){
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (int i = front; i != rear; i = (i + 1) % queue.length) {
                System.out.print(queue[i] + " ");
            }
            System.out.println(queue[rear]);
        }

    }










}
