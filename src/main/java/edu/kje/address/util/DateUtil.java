package edu.kje.address.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helper function for handling dates
 * 
 * @author Kevin El-Saikali
 */

public class DateUtil {

    /**The date pattern that is used for conversion. Change as you wish */
    private static final String DATE_PATTERN = "dd/MM/yyyy";

    /**The date formatter */
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * Returns the given date as a well formatted String.
     * The above defined link 
     * {@link DateUtil#DATE_PATTERN} is used
     * 
     * @param date the date to be returned as a String
     * @return formatted String
     */

     public static String format(LocalDate date){
        if (date == null){
            return null;
        }

        return dtf.format(date);
     }

    /**
     * Checks the String to see if it is a valid Date
     * 
     * @param dateString the date as String
     * @return the date object or null if it could not be converted
     */

    public static LocalDate parse(String dateString){
        try{
            return dtf.parse(dateString, LocalDate::from);
        }
        catch (DateTimeParseException e){
            return null;
        }
    }

    /**Checks if the String is a valid date
     * 
     * @param dateString
     * @return true if the String is a valid Date
     */

     public static boolean validDate(String dateString){
        //Try to parse the String
        return DateUtil.parse(dateString) != null;
     }
    
}
