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

        // A.b
        Departments computerScienceDepartment = new Departments(listOfProfs1);

        // A.c
        ReadCourse(computerScienceDepartment);

        // B.a
        
        // Start by examining the profProcessingQueue. 
        Comparator<Professors> seniorityComparator = Comparator.comparing(Professors::getSeniority);

        profProcessingQueue = new QueuePriority<>(seniorityComparator);

        // When you receive the first element, use their id to look up their profId_select.txt file. 
        for (int i = 0; i < listOfProfs1.size(); i++) {
            profProcessingQueue.enqueue(listOfProfs1.get(i));
        }
        // Build the file path by using string concatenation.
        int maxIterations = listOfProfs1.size(); // Define um limite máximo para evitar loops infinitos
        while (!profProcessingQueue.isEmpty() && maxIterations > 0) {
            Professors currentProfessor = (Professors) profProcessingQueue.dequeue();
            if (currentProfessor != null) {
                String professorId = Integer.toString(currentProfessor.getId());
                ReadProfessorSelection(professorId);
            }
            maxIterations--; // Reduz o número máximo de iterações em cada loop
        }

            // Aqui você processa as informações do professor, como ler o arquivo de seleção dele e verificar os requisitos.
            // Certifique-se de implementar a lógica necessária dentro da função ReadProfessorSelection.
        }

//        for (int i = 0; i < profProcessingQueue.getSize(); i++){
//
//            Professors firstProfessor = (Professors) profProcessingQueue.dequeue();
//            String professorId =  Integer.toString(firstProfessor.getId());
//            ReadProfessorSelection(i);
//            // Aqui a iteração passa por todos os professores, na ordem, e faz as atribuições nas listas ArrayList<Courses> listOfAffectedCourses de cada professor.
//            // chama uma nova função que recebe o professor, lê o id e abre o arquivo dele.
//            // Dentro da leitura, faz a verificação dos requisitos.
//        }
        // Open the file and read the first line: max requested hours. Subsequent line(s) contain(s) the selection.

       




      
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

    public static void ReadProfessorSelection(String professorId){
//        try {
//            File selectionFile = new File("src/Files/" + professorId + "_selection.txt");
//            Scanner scanner = new Scanner(selectionFile);
//            String line = scanner.nextLine();
//            int maxHour = Integer.parseInt(line);
//            while (scanner.hasNextLine()) {
//
//                // create an array of strings.
//                String[] fields = line.split(":");
//
//
//                Courses newCourse = new Courses(id, title, discipline, numberOfHours, numOfGroups);
//                department.setCourseMap(newCourse);
//            }
//
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Professor file not found: " + e.getMessage());
//        }
        Departments department = null;
        try {
            File selectionFile = new File("src/Files/" + professorId + "_selection.txt");
            Scanner scanner = new Scanner(selectionFile);
            int maxHour = Integer.parseInt(scanner.nextLine()); // Lendo a linha com o número máximo de horas

            // Supondo que você tenha uma instância do departamento disponível aqui
            department = new Departments(listOfProfs1);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(":");
                // Extrair os dados do curso do arquivo
                String courseId = fields[0].trim();
                String courseTitle = fields[1].trim();
                String courseDiscipline = fields[2].trim();
                short numberOfHours = Short.parseShort(fields[3].trim());
                short numOfGroups = Short.parseShort(fields[4].trim());
                // Criar uma instância de Courses
                Courses newCourse = new Courses(courseId, courseTitle, courseDiscipline, numberOfHours, numOfGroups);
                // Adicionar o curso ao mapa do departamento
                department.setCourseMap(newCourse);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Professor file not found: " + e.getMessage());
        }
    }

    

    /* 
    public static <T> void readFile(String pathFile, String type, List<T> ListOfSomething){

        try {
            File professorFile = new File(pathFile);
            Scanner scanner = new Scanner(professorFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                if (type.equals("professors")){
                    Professors professor = addProfessors(line);
                    ListOfSomething.add(professor);    //  Resolver a questão do tipo, enviando apenas a lista como argumento.
                }
                if (type.equals("course")){
                    Courses course = addCourse(line);
                    ListOfSomething.add((Course));

                }
            }


            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Professor file not found: " + e.getMessage());
        }
    }    
   */

   /* 
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

   */


        
        // read the line and create an course instance
    
/* 
    public static Professors addCourse(){
        // read the line and create an professor instance

        // initialize all the variables necessary to create a new instance of professor

        String id;                 // The course ID
        String title;           // The course title
        String discipline;      // The course discipline
        short numberOfHours;    // The number of hours for the course
        String prerequisite;                                                 /// implementar esse aqui.
        short numOfGroups;
        
        // create an array of strings.
        String[] fields = line.split(":");

        // Put each part of the string in the correct variable.
        id = (fields[0]);
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
*/
}
