package bots;

import exceptions.NoDeadlineDescriptionException;
import exceptions.NoDescriptionAndDeadlineException;
import exceptions.NoDescriptionAndEventAtException;
import exceptions.NoEventDescriptionException;
import exceptions.NoTodoDescriptionException;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1>Welcome to FriendlyBot!</h1>
 * <h2>FriendlyBot is a program that helps manage users' task lists.</h2>
 * <h3>Here are FriendlyBot's Features:</h3>
 *
 * <ul>
 *     <li>Stores todos</li>
 *     <li>Stores deadlines with deadline date (Can read yyyy-mm-dd format)</li>
 *     <li>Stores events with event location</li>
 * </ul>
 *
 * @author ElizabethChan
 * @version 1.0
 * @since 2020-08-24
 */
public class FriendlyBot {

    // Creating a new text file to store task list
    private static String PATH = new File("").getAbsolutePath();
    static File f = new File(PATH + "/friendlyBot.txt");
    private static int taskCount = 0;

    /**
     * Creates a new text file to store users' tasks.<br>
     * Calls the the methods to read and write to the text file, and handles the UI.
     * @param args
     * @throws IOException happens when there is a failure during reading, writing and searching file or directory
     * operations.
     * @see Storage
     * @see Ui
     */
    public static void main(String[] args) throws IOException {

        f.createNewFile();
        ArrayList<FriendlyBotTask> tasks = new ArrayList<>();

        // Storage deals with loading tasks from the file and saving tasks in the file
        taskCount = Storage.readFile(tasks, taskCount, f);
        greetUser();

        // Calls Ui class to handle user inputs
        Ui.handleUi(tasks, taskCount);

        Storage.writeFile(tasks, taskCount, f);
    }

    public static void greetUser() {
        System.out.println("Hello, I'm FriendlyBot, your Friendly To Do List! :)\n" +
                "Enter a To Do:\n");
    }

    public static void checkForDescriptionAndEventAt(String line) throws NoDescriptionAndEventAtException {

        String lineWithoutSpaces = line.replaceAll("\\s", "");

        if (lineWithoutSpaces.length() == 5) {
            throw new NoDescriptionAndEventAtException();
        }
    }

    public static void checkForDescriptionAndDeadline(String line) throws NoDescriptionAndDeadlineException {

        String lineWithoutSpaces = line.replaceAll("\\s", "");

        if (lineWithoutSpaces.length() == 8) {
            throw new NoDescriptionAndDeadlineException();
        }
    }

    public static void checkForTodoDescription(String line) throws NoTodoDescriptionException {

        String lineWithoutSpaces = line.replaceAll("\\s", "");

        if (lineWithoutSpaces.length() == 4) {
            throw new NoTodoDescriptionException();
        }
    }

    public static void checkForDeadlineDescription(String line, int deadlineBy) throws NoDeadlineDescriptionException {

        boolean containsLetter = line.substring(8, deadlineBy - 4).matches(".*[a-zA-Z]+.*");

        if (!containsLetter) {
            throw new NoDeadlineDescriptionException();
        }
    }

    public static void checkForEventDescription(String line, int eventAt) throws NoEventDescriptionException {

        boolean containsLetter = line.substring(5, eventAt - 4).matches(".*[a-zA-Z]+.*");

        if (!containsLetter) {
            throw new NoEventDescriptionException();
        }
    }

    // Refactored from main
    public static void invalidCommand() {
        System.out.println("Oops! I don't think I know what you mean. ☹");
    }

    // Refactored from main
    public static int displayNewTask(int taskCount, FriendlyBotTask task) {
        System.out.println("Great! I've added this task:\n\t" + task.toString() +
                "\nNow you have " + (taskCount + 1) + " task(s) in your list.");
        taskCount++;
        return taskCount;
    }
}