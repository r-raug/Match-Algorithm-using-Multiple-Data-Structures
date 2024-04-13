import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import DataStructure.Queue;
import DataStructure.QueueNode;
import DataStructure.QueueNodeGeneric;
import Model.Professors;

public class Main {
    public static void main(String[] args) {

        // Create the list of Professors in priority order.
        String typeOfFile = "professors";
        readFile("src/Files/profs.txt", typeOfFile);
        
        // Creat list of departments.
        typeOfFile = "department";
        readFile("src/Files/department.txt", typeOfFile);

        // add a list of courses to an department.
        typeOfFile = "course";
        readFile("src/Files/courses_f22.txt", typeOfFile);

        // add a set of courses to the professor list.
        typeOfFile = "selection";
        readFile("src/Files/5999_selection.txt", typeOfFile);

    }

      

    public static void readFile(String pathfile, String type){

        try {
            File professorFile = new File(pathfile);
            Scanner scanner = new Scanner(professorFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

               
                if (type == "professors"){
                    addProfessors(line);
                }
                if (type == "course"){
                    addCourse(line);
                }
                

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Professor file not found: " + e.getMessage());
        }
    }    

    public static void addProfessors(String line){
        // read the line and create an professor instance
    }

    public static void addCourse(String line){
        // read the line and create an course instance
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
