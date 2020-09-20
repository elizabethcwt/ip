package bots;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendlyBotTaskManager extends FriendlyBot {

    public static int readFile(ArrayList<FriendlyBotTask> tasks, int taskCount, File f) throws FileNotFoundException {
        try {
            // Using scanner object that uses text file object as source of data to READ (SCAN) from the text file
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String line = s.nextLine();
                System.out.println(line);
                final String[] taskListData = line.trim().split("\\|", 3);
                boolean isDone;
                String taskDescription;

                switch (taskListData[0]) {
                    case "[T]":
                        taskCount = readFileTodo(tasks, taskCount, taskListData);
                        break;
                    case "[D]":
                        taskCount = readFileDeadline(tasks, taskCount, taskListData);
                        break;
                    case "[E]":
                        taskCount = readFileEvent(tasks, taskCount, taskListData);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Oops! Looks like that file couldn't be found! 🙃");
        }
        return taskCount;
    }

    public static void writeToFile(ArrayList<FriendlyBotTask> tasks, int taskCount, File f) throws IOException {

        StringBuilder dataString = new StringBuilder();

        for (FriendlyBotTask task : tasks) {
            if (task instanceof FriendlyBotTodo) {
                writeToFileTodo(dataString, (FriendlyBotTodo) task);
            } else if (task instanceof FriendlyBotDeadline) {
                writeToFileDeadline(dataString, (FriendlyBotDeadline) task);
            } else if (task instanceof FriendlyBotEvent) {
                writeToFileEvent(dataString, (FriendlyBotEvent) task);
            }
        }

        FileWriter fw = new FileWriter(f);
        fw.write(String.valueOf(dataString));
        fw.close();
    }

    public static int readFileEvent(ArrayList<FriendlyBotTask> tasks, int taskCount, String[] taskListData) {
        boolean isDone;
        String taskDescription;
        isDone = Boolean.parseBoolean(taskListData[1]);
        String[] eventInfo = taskListData[2].trim().split("\\|", 2);
        taskDescription = eventInfo[0];
        String at = eventInfo[1];
        tasks.add(new FriendlyBotEvent(taskDescription, at, isDone));
        taskCount++;
        return taskCount;
    }

    public static int readFileDeadline(ArrayList<FriendlyBotTask> tasks, int taskCount, String[] taskListData) {
        boolean isDone;
        String taskDescription;
        isDone = Boolean.parseBoolean(taskListData[1]);
        String[] deadlineInfo = taskListData[2].trim().split("\\|", 2);
        taskDescription = deadlineInfo[0];
        String by = deadlineInfo[1];
        tasks.add(new FriendlyBotDeadline(taskDescription, by, isDone));
        taskCount++;
        return taskCount;
    }

    public static int readFileTodo(ArrayList<FriendlyBotTask> tasks, int taskCount, String[] taskListData) {
        boolean isDone;
        String taskDescription;
        isDone = Boolean.parseBoolean(taskListData[1]);
        taskDescription = taskListData[2];
        tasks.add(new FriendlyBotTodo(taskDescription, isDone));
        taskCount++;
        return taskCount;
    }

    public static void writeToFileEvent(StringBuilder dataString, FriendlyBotEvent task) {
        FriendlyBotEvent event = task;
        String eventString = event.taskType + "|" + event.getDone() + "|" + event.description + "|" +
                event.at + System.lineSeparator();
        dataString.append(eventString);
    }

    public static void writeToFileDeadline(StringBuilder dataString, FriendlyBotDeadline task) {
        FriendlyBotDeadline deadline = task;
        String deadlineString = deadline.taskType + "|" + deadline.getDone() + "|" + deadline.description
                + "|" + deadline.by + System.lineSeparator();
        dataString.append(deadlineString);
    }

    public static void writeToFileTodo(StringBuilder dataString, FriendlyBotTodo task) {
        FriendlyBotTodo todo = task;
        String todoString = todo.taskType + "|" + todo.getDone() + "|" + todo.description +
                System.lineSeparator();
        dataString.append(todoString);
    }
}

