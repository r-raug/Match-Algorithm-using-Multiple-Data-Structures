package auxiliaryStructure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utility class to compare dates and determine which one is older.
 */
public class CompareDate {

    /**
     * Compares two dates and determines which one is older.
     * 
     * @param currentDate The current date in "dd/MM/yyyy" format.
     * @param newDate     The new date to compare in "dd/MM/yyyy" format.
     * @return 1 if the current date is older, 0 if the new date is older, -1 if they are equal.
     * @throws DateTimeParseException if the date format is incorrect.
     */
    public static int isOlder(String currentDate, String newDate) {
        // Create date formatters
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Parse the dates into LocalDate objects
        LocalDate currentDateObj = LocalDate.parse(currentDate, formatter);
        LocalDate newDateObj = LocalDate.parse(newDate, formatter);

        // Compare the dates
        if (currentDateObj.isBefore(newDateObj)) {
            // Current date is older
            return 1;
        } else if (newDateObj.isBefore(currentDateObj)) {
            // New date is older
            return 0;
        } else {
            // Dates are equal
            return -1;
        }
    } 
}


