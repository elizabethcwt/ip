package storage;

import bots.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Stores user's tasks into text file.<br><br>
 * Specifically, contains readFile and writeFile methods to handle reading from and writing into text file.
 *
 * @see Storage#readFile
 * @see Storage#writeFile(ArrayList, int, File)
 */
public class Storage extends FriendlyBot {

    /**
     * Contains readFile method from FriendlyBotTaskManager.
     *
     * @param tasks arraylist containing all of the user's tasks.
     * @param taskCount to be updated after reading in the tasks in the text file.
     * @param f text file to read from.
     * @return taskCount - to update the number of tasks in the user's task list after reading from text file.
     *
     * @see FriendlyBotTaskManager#readFile(ArrayList, int, File)
     */
    // Scanning/Reading info. into text file
    public static int readFile(ArrayList<FriendlyBotTask> tasks, int taskCount, File f) {
        try {
            taskCount = FriendlyBotTaskManager.readFile(tasks, taskCount, f);
        } catch (IOException e) {
            System.out.println("Oops! Looks like we were unable to read the task info. in the text file! 😭");
        }
        return taskCount;
    }

    /**
     * Contains writeFile method from FriendlyBotTaskManager.
     *
     * @param tasks arraylist containing all of the user's tasks.
     * @param taskCount to keep the task list updated on the current number of tasks before writing into it.
     * @param f text file to write into.
     * @return taskCount - to update the number of tasks in the user's task list after writing into the text file.
     *
     * @see FriendlyBotTaskManager#writeToFileEvent(StringBuilder, FriendlyBotEvent)
     */
    // Writing updated info. into text file
    public static int writeFile(ArrayList<FriendlyBotTask> tasks, int taskCount, File f) {
        try {
            FriendlyBotTaskManager.writeToFile(tasks, taskCount, f);
        } catch (IOException e) {
            System.out.println("Oops! Looks like we were unable to write the new task info. to the text file! 😭");
        }
        return taskCount;
    }
}
