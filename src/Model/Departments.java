package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow.Processor;

public class Departments {
    private Map<String, Courses> courseMap;
    private List<Processor> listOfProfs;

    public Departments(List<Processor> listOfProfs) {
        this.listOfProfs = listOfProfs;
        this.courseMap = new HashMap<>();
    }

}
