package bots;

import exception_initialisations.NoDeadlineDescriptionException;
import exception_initialisations.NoDescriptionAndDeadlineException;
import exception_initialisations.NoDescriptionAndEventAtException;
import exception_initialisations.NoEventDescriptionException;
import exception_initialisations.NoTodoDescriptionException;

public class ExceptionAndCheckForMethods {
    private static final int lengthOfDeadline = 8;
    private static final int lengthOfEvent = 5;

    /**
     * Checks for BOTH presence of description and event location for an event task.
     *
     * @param line user's input
     * @throws NoDescriptionAndEventAtException if no description AND event location is found in user's event input.
     * @see NoDescriptionAndEventAtException
     */
    public static void checkForDescriptionAndEventAt(String line) throws NoDescriptionAndEventAtException {

        String lineWithoutSpaces = line.replaceAll("\\s", "");
        if (lineWithoutSpaces.length() == lengthOfEvent) {
            throw new NoDescriptionAndEventAtException();
        }
    }

    /**
     * Checks for BOTH presence of description and deadline date for a deadline task.
     *
     * @param line user's input
     * @throws NoDescriptionAndDeadlineException if no description AND deadline date is found in user's deadline input.
     * @see NoDescriptionAndDeadlineException
     */
    public static void checkForDescriptionAndDeadline(String line) throws NoDescriptionAndDeadlineException {

        String lineWithoutSpaces = line.replaceAll("\\s", "");
        if (lineWithoutSpaces.length() == lengthOfDeadline) {
            throw new NoDescriptionAndDeadlineException();
        }
    }

    /**
     * Checks for presence of description for a todo task.
     *
     * @param line user's input
     * @throws NoTodoDescriptionException if no description is found in user's todo input.
     * @see NoTodoDescriptionException
     */
    public static void checkForTodoDescription(String line) throws NoTodoDescriptionException {

        String lineWithoutSpaces = line.replaceAll("\\s", "");
        int lengthOfTodo = 4;
        if (lineWithoutSpaces.length() == lengthOfTodo) {
            throw new NoTodoDescriptionException();
        }
    }

    /**
     * Checks for presence of description for a deadline task.
     *
     * @param line user's input
     * @param deadlineBy end of description string of deadline
     * @throws NoDeadlineDescriptionException if no description is found in user's deadline input.
     * @see NoDeadlineDescriptionException
     */
    public static void checkForDeadlineDescription(String line, int deadlineBy) throws NoDeadlineDescriptionException {

        boolean containsLetter = line.substring(lengthOfDeadline, deadlineBy - 4).matches(".*[a-zA-Z]+.*");
        if (!containsLetter) {
            throw new NoDeadlineDescriptionException();
        }
    }

    /**
     * Checks for presence of description for a event task.
     *
     * @param line user's input
     * @param eventAt end of description string of event
     * @throws NoEventDescriptionException if no description is found in user's event input.
     * @see NoEventDescriptionException
     */
    public static void checkForEventDescription(String line, int eventAt) throws NoEventDescriptionException {

        boolean containsLetter = line.substring(lengthOfEvent, eventAt - 4).matches(".*[a-zA-Z]+.*");

        if (!containsLetter) {
            throw new NoEventDescriptionException();
        }
    }
}
