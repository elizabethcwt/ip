package bots;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Contains checkForDateFormat and convertDate methods.
 *
 * @see DeadlineDate#checkForDateFormat
 * @see DeadlineDate#convertDate
 */
public class DeadlineDate {

    /**
     * Checks if user's deadline date input contains date in the form: 'yyyy-mm-dd'. If present, calls the convertDate
     * method.
     *
     * @param tasks arraylist containing all of the user's tasks.
     * @param taskCount number of tasks in the updated list after the user has entered a new task.
     * @param by string containing the deadline date details entered by user (string after '/by').
     * @return by - be it updated into new format or kept as the same format if date in 'yyyy-mm-dd' format was not
     * found.
     *
     * @see DeadlineDate#convertDate
     */
    public static String checkForDateFormat(ArrayList<FriendlyBotTask> tasks, int taskCount, String by) {

        String[] checkForDate = by.split(" ");
        String dateString = null;
        String newDateFormat = null;
        try {
            // Looks for format yyyy-mm-dd in /by string
            for (String item : checkForDate) {
                if ((item.matches(".*\\d.*")) && (item.contains("-"))) {
                    dateString = item;
                    newDateFormat = convertDate(dateString);

                    // Replacing original date format (yyyy-mm-dd) to new one in original task list
                    by = by.replace(dateString, newDateFormat);
                    return by;
                }
            }
            return by;
        } catch (DateTimeParseException e) {
            return by;
        }
    }

    /**
     * Converts deadline date in 'yyyy-mm-dd' format to '[month in letters] [date] [year]' format.
     *
     * @param dateString part of user's deadline date input in 'yyyy-mm-dd' format.
     * @return newDateFormat - the new date in '[month in letters] [date] [year]' format.
     * found.
     */
    public static String convertDate(String dateString) {

        // Creates dates from strings
        LocalDate date = LocalDate.parse(dateString);

        // Print reformat dates
        String newDateFormat = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return newDateFormat;
    }
}