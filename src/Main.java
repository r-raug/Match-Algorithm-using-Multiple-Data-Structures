import Queue.Queue;
import QueueNode.QueueNode;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,20,30,50,22);

        Queue<Integer> myQueue = new Queue<>(myList);

//        myQueue.displayQueue();
//        myQueue.enqueue(38);
//        myQueue.displayQueue();
//        myQueue.dequeue();
//        myQueue.enqueue(39);
//        myQueue.enqueue(36);
//        myQueue.displayQueue();
//        myQueue.getSize();

        QueueNode node = new QueueNode();

        node.displayElements();
        node.enqueue(15);
        node.displayElements();
        node.enqueue(22);
        node.enqueue(35);
        node.enqueue(12);
        node.displayElements();
        node.dequeue();
        node.displayElements();
        System.out.println(node.getSize());
        node.dequeue();
        node.dequeue();
        node.dequeue();
        node.displayElements();
        System.out.println(node.getSize());
        node.dequeue();

    }
}