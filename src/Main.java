import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import DataStructure.Queue;
import DataStructure.QueueNode;
import DataStructure.QueueNodeGeneric;
import DataStructure.QueuePriority;
import Model.Courses;
import Model.Departments;
import Model.Professors;

public class Main {

    

    public static void main(String[] args) {

        // Create the list of Professors in priority order.
        String typeOfFile = "professors";
        List<Professors> listOfProfs = new ArrayList<>(); 
        readFile("src/Files/profs.txt", typeOfFile, (List<Professors>) listOfProfs);  
        // add the listOfProfs to the QueuePriority list... implement it.   

        Departments computerScienceDepartment = new Departments(listOfProfs);
        
        // Create a list of courses.
        typeOfFile = "course";
        List<Courses> listOfCourses = new ArrayList<>();
        readFile("src/Files/courses_f22.txt", typeOfFile, (List<Courses>) listOfCourses);

        // add a set of courses to the professor list.
        typeOfFile = "selection";
        //readFile("src/Files/5999_selection.txt", typeOfFile);
        QueuePriority myList = new QueuePriority();
        for(int i = 0; i < listOfProfs.size();i++){
            myList.enqueue(listOfProfs.get(i));
        }
        myList.displayQueue();


    }

      

    public static <T> void readFile(String pathFile, String type, List<T> ListOfSomething){

        try {
            File professorFile = new File(pathFile);
            Scanner scanner = new Scanner(professorFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (type.equals("professors")){
                    Professors professor = addProfessors(line);
                    ListOfSomething.add((Professors) professor);    //  Resolver a questão do tipo, enviando apenas a lista como argumento.
                }
                if (type.equals("course")){
                    addCourse(line);
                }
            }


            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Professor file not found: " + e.getMessage());
        }
    }    
   
    public static Professors addProfessors(String line){
        // read the line and create an professor instance

        // initialize all the variables necessary to create a new instance of professor
        int id;              
        String lastName;
        String firstName;
        float seniority;    
        String hiringDate;
        Set<String> setOfDisciplines = new HashSet<>();
        
        // create an array of strings.
        String[] fields = line.split(":");

        // Put each part of the string in the correct variable.
        id = Integer.parseInt(fields[0]);
        String[] name = fields[1].split(" ");
        lastName = name[0];
        firstName = name[1];
        seniority = Float.parseFloat(fields[2]);
        hiringDate = fields[3];
        String[] disciplines = fields[4].split(",");
            for (String discipline : disciplines) {
                setOfDisciplines.add(discipline);
            }
        Professors newProfessor = new Professors(id, lastName, firstName, seniority, hiringDate, setOfDisciplines);
        return newProfessor;
    }

    public static void addCourse(String line){
        // read the line and create an course instance
    }

}
