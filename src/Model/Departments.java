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

   


}
