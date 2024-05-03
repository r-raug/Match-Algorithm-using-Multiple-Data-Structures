import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
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
        listOfProfs1 = new ArrayList<>();

        readProfs();
        System.out.println(listOfProfs1.toString());

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

        profProcessingQueue.displayQueue();

        // Build the file path by using string concatenation.
        while (!profProcessingQueue.isEmpty()) {
            Professors currentProfessor = (Professors) profProcessingQueue.dequeue();

            if (currentProfessor != null) {
                ReadProfessorSelection(currentProfessor, computerScienceDepartment);
            }
        }

        showProfessorsWithCourses(listOfProfs1);
    }

    // All the functions.

    public static void showProfessorsWithCourses(List<Professors> professors) {
        for (Professors professor : professors) {
            System.out.println(professor.toString());
        }
    }

    public static void readProfs() {
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
                listOfProfs1.add(newProfessor); // This line add the object type Professors to the list
            }
            scanner.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void ReadCourse(Departments department) {
        try {
            File courseFile = new File("src/Files/courses_f22.txt");
            Scanner scanner = new Scanner(courseFile);
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String id; // The course ID
                String title; // The course title
                String discipline; // The course discipline
                short numberOfHours; // The number of hours for the course
                String prerequisite; // To implement.
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

    public static void ReadProfessorSelection(Professors professor, Departments department) {
        if (department == null) {
            System.out.println("Department doesn't exist: ");
            return;
        }
        try {
            File selectionFile = new File("src/Files/" + professor.getId() + "_selection.txt");
            Scanner scanner = new Scanner(selectionFile); // open the selection file.
            int maxHour = Integer.parseInt(scanner.nextLine());

            while (scanner.hasNextLine() && maxHour > 0) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                String courseId = fields[0].trim();
                int totalModules = Integer.parseInt(fields[1].trim());

                if (department.getCourseMap() != null && department.getCourseMap().containsKey(courseId)) {
                    int courseHours = department.getCourseMap().get(courseId).getNumberOfHours();
                    int modulesToAssign = Math.min(totalModules, maxHour / (courseHours / 15));
                    for (int i = 0; i < modulesToAssign; i++) {
                        maxHour -= courseHours / 15;
                        Courses course = department.getCourseMap().get(courseId);
                        if (course != null) {
                            professor.appendListOfAffectedCourses(course);
                            //System.out.println("Course " + course.getId() + " assigned to Professor " + professor.getId());
                        }
                    }
                } else {
                    System.out.println("Course " + courseId + " not found in department's course map.");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Selection file not found: " + e.getMessage());
        }
    }
}
