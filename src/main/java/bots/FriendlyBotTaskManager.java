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
                        isDone = Boolean.parseBoolean(taskListData[1]);
                        taskDescription = taskListData[2];
                        tasks.add(new FriendlyBotTodo(taskDescription, isDone));
                        taskCount++;
                        break;
                    case "[D]":
                        isDone = Boolean.parseBoolean(taskListData[1]);
                        String[] deadlineInfo = taskListData[2].trim().split("\\|", 2);
                        taskDescription = deadlineInfo[0];
                        String by = deadlineInfo[1];
                        tasks.add(new FriendlyBotDeadline(taskDescription, by, isDone));
                        taskCount++;
                        break;
                    case "[E]":
                        isDone = Boolean.parseBoolean(taskListData[1]);
                        String[] eventInfo = taskListData[2].trim().split("\\|", 2);
                        taskDescription = eventInfo[0];
                        String at = eventInfo[1];
                        tasks.add(new FriendlyBotEvent(taskDescription, at, isDone));
                        taskCount++;
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
                FriendlyBotTodo todo = (FriendlyBotTodo) task;
                String todoString = todo.taskType + "|" + todo.getDone() + "|" + todo.description +
                        System.lineSeparator();
                dataString.append(todoString);
            } else if (task instanceof FriendlyBotDeadline) {
                FriendlyBotDeadline deadline = (FriendlyBotDeadline) task;

//                // Converts date if UI contains 'yyyy-mm-dd' format in /by
//                // Assume UI does not contain any other '-' that does not refer to date in this format
//                String[] deadlineDateString = deadline.by.trim().split(" ");
//                for (String entry : deadlineDateString) {
//                    if (entry.contains("-")) {
//                        String[] yyyymmdd = entry.trim().split("-", 3);
//                        int year = Integer.parseInt(yyyymmdd[0]);
//                        int date = Integer.parseInt(yyyymmdd[2]);
//                    }
//                }

                String deadlineString = deadline.taskType + "|" + deadline.getDone() + "|" + deadline.description
                        + "|" + deadline.by + System.lineSeparator();
                dataString.append(deadlineString);
            } else if (task instanceof FriendlyBotEvent) {
                FriendlyBotEvent event = (FriendlyBotEvent) task;
                String eventString = event.taskType + "|" + event.getDone() + "|" + event.description + "|" +
                        event.at + System.lineSeparator();
                dataString.append(eventString);
            }
        }

        FileWriter fw = new FileWriter(f);
        fw.write(String.valueOf(dataString));
        fw.close();
    }
}

