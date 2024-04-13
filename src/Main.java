import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import DataStructure.Queue;
import DataStructure.QueueNode;
import DataStructure.QueueNodeGeneric;
import DataStructure.PriorityQueue;
import Model.Professors;

public class Main {
    public static void main(String[] args) {

        String pathfile = "Files/profs.txt";

        try {
            File professorFile = new File(pathfile);
            Scanner scanner = new Scanner(professorFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Professor file not found: " + e.getMessage());
        }

        


   //     List<Integer> myList = Arrays.asList(10,20,30,50,22);

   //     Queue<Integer> myQueue = new Queue<>(myList);

//        myQueue.displayQueue();
//        myQueue.enqueue(38);
//        myQueue.displayQueue();
//        myQueue.dequeue();
//        myQueue.enqueue(39);
//        myQueue.enqueue(36);
//        myQueue.displayQueue();
//        myQueue.getSize();
/* 
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
*/


        
    

    }
}