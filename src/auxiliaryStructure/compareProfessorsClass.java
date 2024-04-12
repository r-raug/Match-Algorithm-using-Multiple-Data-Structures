package auxiliaryStructure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Model.Professors;

public class compareProfessorsClass {

    //private short compareResult; 

    public short compareProfessors (Professors a, Professors b) {
        // first compare the seniority.
        short seniorityCompare = compareSeniority(a.getSeniority(), b.getSeniority());
        if ( seniorityCompare != 0){
            return seniorityCompare;
        }  

        // if the seniority is the same, compare the hire date.
        short hireDateCompare = isOlder( a.getHiringDateString(), b.getHiringDateString() );
        if ( hireDateCompare != 0)  {
            return -1;
        }
        
        // if the hire date is the same, compare the ID number
        if( a.getId() > b.getId() ){
            return 1;
        }

        return -1;

    
    }
       
    private short compareSeniority (float seniorityA, float seniorityB) {
        if (seniorityA > seniorityB){
            return 1;
        }
        if (seniorityA == seniorityB){
            return 0; 
        }
        return -1;
    }

    /**
     * Compares two dates and determines which one is older.
     * 
     * @param hireDateA The current date in "dd/MM/yyyy" format.
     * @param hireDateB     The new date to compare in "dd/MM/yyyy" format.
     * @return 1 if the current date is older, 0 if the new date is older, -1 if they are equal.
     * @throws DateTimeParseException if the date format is incorrect.
     */
    private short isOlder(String hireDateA, String hireDateB) {
        // Create date formatters
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Parse the dates into LocalDate objects
        LocalDate hireDateAObj = LocalDate.parse(hireDateA, formatter);
        LocalDate hireDateBObj = LocalDate.parse(hireDateB, formatter);

        // Compare the dates
        if (hireDateAObj.isBefore(hireDateBObj)) {
            // Current date is older
            return 1;
        } else if (hireDateBObj.isBefore(hireDateAObj)) {
            // New date is older
            return 0;
        } else {
            // Dates are equal
            return -1;
        }
    } 
}



