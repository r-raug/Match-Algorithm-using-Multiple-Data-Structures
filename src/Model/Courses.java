package Model;

/**
 * Represents a course with its attributes.
 */
public class Courses {

    private String id;                 // The course ID
    private String title;           // The course title
    private String discipline;      // The course discipline
    private short numberOfHours;    // The number of hours for the course
    private String prerequisite;                                                 /// implementar esse aqui.
    private short numOfGroups;      // The number of groups for the course

    /**
     * Constructs a new Courses object with the specified attributes.
     *
     * @param id            The course ID.
     * @param title         The course title.
     * @param discipline    The course discipline.
     * @param numberOfHours The number of hours for the course.
     * @param numOfGroups   The number of groups for the course.
     */
    public Courses(String id, String title, String discipline, short numberOfHours, short numOfGroups){
        this.id = id;
        this.title = title;
        this.discipline = discipline;
        this.numberOfHours = numberOfHours;
        this.numOfGroups = numOfGroups;
    }

    /**
     * Constructs a new Courses object by copying another Courses object.
     *
     * @param CourseToCopy The Courses object to copy.
     */
    public Courses(Courses CourseToCopy){
        this.id = CourseToCopy.id;
        this.title = CourseToCopy.title;
        this.discipline = CourseToCopy.discipline;
        this.numberOfHours = CourseToCopy.numberOfHours;
        this.numOfGroups = CourseToCopy.numOfGroups;
    }


    
    public void setId(String id) {
        this.id = id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getId() {
        return id;
    }

    public short getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(short numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public short getNumOfGroups() {
        return numOfGroups;
    }

    public void setNumOfGroups(short numOfGroups) {
        this.numOfGroups = numOfGroups;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
