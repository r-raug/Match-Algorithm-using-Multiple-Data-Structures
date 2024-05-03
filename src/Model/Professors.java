package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import auxiliaryStructure.compareProfessorsClass;


public class Professors implements Comparable<Professors> {

    private int id;              // 4 digits
    private String lastName;
    private String firstName;
    private float seniority;    // 0,00 - 60,00
    private String hiringDate;  // dd-mm-yyyy date format
    private Set<String> setOfDisciplines;
    private ArrayList<Courses> listOfAffectedCourses;
    private int weeklyHours;



    /**
     * Constructs a new Professors object with the specified attributes.
     *
     * @param id            The professor's ID (4 digits).
     * @param lastName      The professor's last name.
     * @param firstName     The professor's first name.
     * @param seniority     The professor's seniority (0,00 - 60,00).
     * @param hiringDate    The professor's hiring date (dd-mm-yyyy format).
     * @param setOfDisciplines The set of disciplines taught by the professor.
     */
    public Professors(int id, String lastName, String firstName, float seniority, String hiringDate, Set<String> setOfDisciplines) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.seniority = seniority;
        this.hiringDate = hiringDate;
        this.setOfDisciplines = setOfDisciplines;
        this.listOfAffectedCourses = new ArrayList<>();
        this.weeklyHours = 0;
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
        this.setOfDisciplines = professorToCopy.setOfDisciplines;
        this.weeklyHours = professorToCopy.weeklyHours;
    }

    //  int id

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

//    public int getWeeklyHours() {
//        return weeklyHours;
//    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }
    // String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    // String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // float seniority;    // 0,00 - 60,00

    public float getSeniority () {
        return seniority;
    }

    public void setSeniority (float seniority) {
        this.seniority = seniority;
    }

    // String hiringDate;  // dd-mm-yyyy date format

    public String getHiringDateString () {
        return this.hiringDate;
    }

    public void setHiringDateString (String hireDate){
        this.hiringDate = hireDate;
    }

    // Set<String> setOfDiciplines;

    public Set<String> getSetOfDisciplines() {
        return setOfDisciplines;
    }

    public void setSetOfDisciplines(Set<String> setOfDiciplines) {
        this.setOfDisciplines = setOfDiciplines;
    }

    // List<Courses>

    public ArrayList<Courses> getListOfAffectedCourses() {
        return listOfAffectedCourses;
    }

    public void setListOfAffectedCourses(ArrayList<Courses> listOfAffectedCourses) {
        this.listOfAffectedCourses = listOfAffectedCourses;
    }

    public void appendListOfAffectedCourses(Courses courseToAdd) {
        if (this.listOfAffectedCourses == null) {
            this.listOfAffectedCourses = new ArrayList<>();
        }
        this.listOfAffectedCourses.add(courseToAdd);
    }
/* 
    /**
     * Compares this professor with another professor based on their seniority.
     *
     * @param other The other professor to compare.
     * @return A negative integer, zero, or a positive integer as this professor is less than, equal to, or greater than the other professor.
     */
   /*  public int compareTo (Professors other) {
        
        compareProfessorsClass compare = new compareProfessorsClass ();
        
        return compare.compareProfessors(this, other);
    }
*/




    /**
     * Returns a string representation of the professor.
     *
     * @return A string representation of the professor.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Last Name: ").append(lastName).append("\n");
        sb.append("First Name: ").append(firstName).append("\n");
        sb.append("Seniority: ").append(seniority).append("\n");
        sb.append("Hiring Date: ").append(hiringDate).append("\n");
        sb.append("Set of Disciplines: ").append(setOfDisciplines).append("\n");
        sb.append("List of Affected Courses: ");
        if (listOfAffectedCourses != null) {
            for (Courses course : listOfAffectedCourses) {
                sb.append(course.getId()).append(", ");
            }
        }
        sb.append("\n");
        sb.append("Total Weekly Hours: ").append(getWeeklyHours()).append("\n");
        return sb.toString();
    }
    

    @Override
    public int compareTo(Professors o) {
        
        if (this.seniority == o.getSeniority())
            return 0;

        return 0;
    }

    public float getWeeklyHours() {
        float totalHours = 0;
        if (listOfAffectedCourses != null) {
            for (Courses course : listOfAffectedCourses) {
                totalHours += course.getNumberOfHours()/15;
            }
        }
        return totalHours;
    }

    

}

