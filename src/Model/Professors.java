package Model;

import java.util.List;
import java.util.Set;

public class Professors {

    private int id;              // 4 digits
    private String lastName;
    private String firstName;
    private float seniority;    // 0,00 - 60,00
    private String hiringDate;  // dd-mm-yyyy date format
    private Set<String> setOfDiciplines;
    private List<Courses> listOfAffectedCourses;

    /**
     * Constructs a new Professors object with the specified attributes.
     *
     * @param id            The professor's ID (4 digits).
     * @param lastName      The professor's last name.
     * @param firstName     The professor's first name.
     * @param seniority     The professor's seniority (0,00 - 60,00).
     * @param hiringDate    The professor's hiring date (dd-mm-yyyy format).
     * @param setOfDiciplines The set of disciplines taught by the professor.
     */
    public Professors(int id, String lastName, String firstName, float seniority, String hiringDate, Set<String> setOfDiciplines) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.seniority = seniority;
        this.hiringDate = hiringDate;
        this.setOfDiciplines = setOfDiciplines;
    }

    /**
     * Constructs a new Professors object by copying another Professors object.
     *
     * @param professorToCopy The Professors object to copy.
     */
    public Professors(Professors professorToCopy) {
        this.id = professorToCopy.id;
        this.lastName = professorToCopy.lastName;
        this.firstName = professorToCopy.firstName;
        this.seniority = professorToCopy.seniority;
        this.hiringDate = professorToCopy.hiringDate;
        this.setOfDiciplines = professorToCopy.setOfDiciplines;
    }
}

