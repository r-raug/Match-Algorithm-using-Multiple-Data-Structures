package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow.Processor;

public class Departments {
    private Map<String, Courses> courseMap;
    private List<Professors> listOfProfs;

    public Departments(List<Professors> listOfProfs) {
        this.listOfProfs = listOfProfs;
        this.courseMap = new HashMap<>();
    }

}
