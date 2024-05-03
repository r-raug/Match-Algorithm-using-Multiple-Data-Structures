package Model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Departments {
    
    // Variables od the class
    private List<Professors> listOfProfs;
    private Map<String, Courses> courseMap;

    /**
     * Constructs a new Departments object with the specified list of professors.
     *
     * @param listOfProfs The list of professors in the department.
     */
    public Departments(List<Professors> listOfProfs) {
        this.listOfProfs = listOfProfs;
        this.courseMap = new HashMap<>();
    }

    public Map<String, Courses> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(Courses newCourse) {
        this.courseMap.put(newCourse.getId(), newCourse);
    }

    public List<Professors> getListOfProfs() {
        return listOfProfs;
    }

    public void setListOfProfs(List<Professors> listOfProfs) {
        this.listOfProfs = listOfProfs;
    }

}
