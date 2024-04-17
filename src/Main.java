import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//import java.util.Arrays;

import DataStructure.Queue;
import DataStructure.QueueNode;
import DataStructure.QueueNodeGeneric;
import DataStructure.QueuePriority;
import Model.Courses;
import Model.Departments;
import Model.Professors;

public class Main {


    public static List<Professors> listOfProfs1;
    public static HashMap<String, Courses> courseMap1;
    public static QueuePriority profProcessingQueue;

    public static void main(String[] args) {

        // A.a
        listOfProfs1 = new ArrayList(); 
        readProfs();
        System.out.println(listOfProfs1.toString());

        // A.b
        Departments computerScienceDepartment = new Departments(listOfProfs1);
        System.out.println(computerScienceDepartment.getListOfProfs());

        // A.c
        ReadCourse(computerScienceDepartment);

        // B.a
        
        // Start by examining the profProcessingQueue. 
        Comparator<Professors> seniorityComparator = Comparator.comparing(Professors::getSeniority);

        profProcessingQueue = new QueuePriority<>(seniorityComparator);
        System.out.println(listOfProfs1.size());

        // When you receive the first element, use their id to look up their profId_select.txt file. 
        for (int i = 0; i < listOfProfs1.size(); i++) {
            profProcessingQueue.enqueue(listOfProfs1.get(i));
        }

       
        profProcessingQueue.displayQueue();
        
        
        // Build the file path by using string concatenation.


        while (!profProcessingQueue.isEmpty()) {
            
            Professors currentProfessor = (Professors) profProcessingQueue.dequeue();
            
            if (currentProfessor != null) {
                ReadProfessorSelection(currentProfessor, computerScienceDepartment);
            }
            
        }
        //

            // Aqui você processa as informações do professor, como ler o arquivo de seleção dele e verificar os requisitos.
            // Certifique-se de implementar a lógica necessária dentro da função ReadProfessorSelection.
        }



// All the functions.

      
    public static void readProfs(){
        try {
            File professorFile = new File("src/Files/profs.txt");
            Scanner scanner = new Scanner(professorFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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
                listOfProfs1.add(newProfessor);  // This line add the object type Professors to the list
            }
        }   catch(Exception exception) {
            System.out.println(exception);
        }
           
    }


    public static void ReadCourse(Departments department){
        try {
            File courseFile = new File("src/Files/courses_f22.txt");
            Scanner scanner = new Scanner(courseFile);
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();


                String id;                 // The course ID
                String title;           // The course title
                String discipline;      // The course discipline
                short numberOfHours;    // The number of hours for the course
                String prerequisite;                                                 /// implementar esse aqui.
                short numOfGroups;

                // create an array of strings.
                String[] fields = line.split(":");

                // Put each part of the string in the correct variable.
                id = (fields[0].trim());
                title = fields[1].trim();
                discipline = fields[2].trim();
                numberOfHours = Short.parseShort(fields[3].trim());
                prerequisite = fields[4].trim();
                numOfGroups = Short.parseShort(fields[5].trim());

                Courses newCourse = new Courses(id, title, discipline, numberOfHours, numOfGroups);
                department.setCourseMap(newCourse);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Professor file not found: " + e.getMessage());
        }

    }

    public static void ReadProfessorSelection(Professors professor, Departments department){
        if(department == null){
            System.out.println("Department doesn''t exist: ");
            return;
        }
        try {  
            System.out.println("=====1======");
            File selectionFile = new File("src/Files/" + professor.getId() + "_selection.txt"); 
            System.out.println("src/Files/" + professor.getId() + "_selection.txt");
            Scanner scanner = new Scanner(selectionFile);                                    // open the selection file.
            int maxHour = Integer.parseInt(scanner.nextLine());
            int count = 0;

            while (scanner.hasNextLine()) {                // line by line, until the last one or hour reached.
                System.out.println("=====2======");
                String line = scanner.nextLine();

                String[] fields = line.split(",");
                String courseId = fields[0].trim();
                int TotalModules = Integer.parseInt(fields[1].trim());
                System.out.println("Total modules: " + TotalModules );

                //   if department has any course in it,    if the course in asked is in the department
                if (department.getCourseMap() != null && department.getCourseMap().containsKey(courseId) && maxHour > 0) {
                    System.out.println("=====3======");
                    
                    int hourPerWeek = department.getCourseMap().get(courseId).getNumberOfHours()/15; // hours per week.
                    while (TotalModules != 0){           // The 
                        if (hourPerWeek < maxHour) {
                            maxHour -= hourPerWeek;
    
                            Courses course = department.getCourseMap().get(courseId);
                            if (course != null){
                                professor.appendListOfAffectedCourses(course);
                                System.out.println("=====5======");
                            }
                        }
                        TotalModules --;
                    }
                    
                }
                
                List<Professors> testing = department.getListOfProfs();
                System.out.println(testing.get(count).getLastName());
                System.out.println(testing.get(count).toString());
                count ++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Selection file not found: " + e.getMessage());
        }

        

    }


 

}
