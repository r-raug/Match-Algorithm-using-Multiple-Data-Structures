package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow.Processor;

public class Departments {
    
    // Variables od the class
    private List<Professors> listOfProfs;
    private Map<String, Courses> courseMap;

    public Map<String, Courses> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(Map<String, Courses> courseMap) {
        this.courseMap = courseMap;
    }

    public List<Professors> getListOfProfs() {
        return listOfProfs;
    }

    public void setListOfProfs(List<Professors> listOfProfs) {
        this.listOfProfs = listOfProfs;
    }

    public Departments(List<Professors> listOfProfs) {
        this.listOfProfs = listOfProfs;
        this.courseMap = new HashMap<>();
    }

   


}
