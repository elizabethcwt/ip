package bots;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DeadlineDate {

    public static String checkForDateFormat(ArrayList<FriendlyBotTask> tasks, int taskCount, String by) {

        String[] checkForDate = by.split(" ");
        String dateString = null;
        String newDateFormat = null;

        // Looks for format yyyy-mm-dd in /by string
        for (String item : checkForDate) {
            if ((item.matches(".*\\d.*")) && (item.contains("-"))) {
                dateString = item;
                newDateFormat = convertDate(dateString);

                // Replacing original date format (yyyy-mm-dd) to new one in original task list
                by = by.replace(dateString , newDateFormat);
                return by;
            }
        }
        return by;
    }

    public static String convertDate(String dateString) {

            // Creates dates from strings
            LocalDate date = LocalDate.parse(dateString);

            // Print reformat dates
            String newDateFormat = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            return newDateFormat;
        }
    }