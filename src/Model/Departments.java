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
