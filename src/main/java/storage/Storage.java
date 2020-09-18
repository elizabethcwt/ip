package storage;

import bots.FriendlyBot;
import bots.FriendlyBotTask;
import bots.FriendlyBotTaskManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Storage extends FriendlyBot {

    // Scanning/Reading info. into text file
    public static int readFile(ArrayList<FriendlyBotTask> tasks, int taskCount, File f) {
        try {
            taskCount = FriendlyBotTaskManager.readFile(tasks, taskCount, f);
        } catch (IOException e) {
            System.out.println("Oops! Looks like we were unable to read the task info. in the text file! 😭");
        }
        return taskCount;
    }


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
