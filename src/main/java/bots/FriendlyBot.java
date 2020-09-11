package bots;

import java.util.Scanner;

public class FriendlyBot {

    public static void main(String[] args) {
        System.out.println("Hello, I'm FriendlyBot, your Friendly To Do List! :)\n" +
                "Enter a To Do:\n");

        String line;
        Scanner in = new Scanner(System.in);

        // Create array to store Tasks
        FriendlyBotTask[] tasks = new FriendlyBotTask[100];
        int taskCount = 0;

        while (in.hasNextLine()) {
            line = in.nextLine();

            // Create new array to check for 'done (no.)' input
            String[] checkDone = line.split(" ", 2);

            if (checkDone[0].equals("done")) {
                try {
                    Integer.parseInt(checkDone[1]);
                    int d = Integer.parseInt(checkDone[1]);
                    tasks[d - 1].markAsDone();
                    System.out.println("Good job! :) I've marked this task as complete:\n\n\t" +
                            tasks[d - 1].toString() + "\n");
                } catch (NumberFormatException nfe) {
                    System.out.println("Oops! Please indicate in NUMERALS, which task you've done! 😅\n");
                } catch (NullPointerException npe) {
                    System.out.println("Oops! It seems like the task you're trying to set as done is invalid! 🤨\n");
                }
            } else {
                if (line.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + "." + tasks[i].toString());
                    }
                    System.out.println();
                } else if (line.equals("bye")) {
                    System.out.println("\nHope you found this app useful! \n" +
                            "See you again! :)\n");
                    break;
                } else {
                    String lineWords[] = line.split(" ");

                    switch (lineWords[0]) {
                        case "todo":
                            try {
                                checkForTodoDescription(line);
                                tasks[taskCount] = new FriendlyBotTodo(line);
                                tasks[taskCount].description = line.substring(5);
                                taskCount = displayNewTask(taskCount, tasks[taskCount]);
                                break;
                            } catch (NoTodoDescriptionException ntde) {
                                System.out.println("Oops! You can't leave the description of your Todo empty. 😞");
                            };
                            break;
                        case "bots":
                            try {
                                checkForDescriptionAndDeadline(line);
                                int deadlineBy = line.indexOf("/by") + 4;
                                String by = line.substring(deadlineBy);
                                tasks[taskCount] = new FriendlyBotDeadline(line, by);
                                tasks[taskCount].description = line.substring(9, deadlineBy - 4);
                                checkForDescription(tasks, taskCount);
                                taskCount = displayNewTask(taskCount, tasks[taskCount]);
                                break;
                            } catch (NoDescriptionAndDeadlineException ndde) {
                                System.out.println("Oops! Are you missing a description AND a deadline?? 😱");
                            } catch (StringIndexOutOfBoundsException e) {
                                System.out.println("Oops! Are you missing a deadline? 🧐 (use '/by'!)");
                            } catch (NoDescriptionException nde) {
                                System.out.println("Oops! Are you missing a description for your deadline? 🧐");
                            }
                            break;
                        case "exceptions":
                            int eventAt = line.indexOf("/at") + 4;
                            String at = line.substring(eventAt);
                            tasks[taskCount] = new FriendlyBotEvent(line, at);
                            tasks[taskCount].description = line.substring(6, eventAt - 4);
                            taskCount = displayNewTask(taskCount, tasks[taskCount]);
                            break;
                        default:
                            invalidCommand();
                            break;
                    }
                }
                System.out.println();
            }
        }
    }

    private static void checkForDescriptionAndDeadline(String line) throws NoDescriptionAndDeadlineException {

        String lineWithoutSpaces = line.replaceAll("\\s", "");

        if (lineWithoutSpaces.length() == 8) {
            throw new NoDescriptionAndDeadlineException();
        }
    }

    private static void checkForTodoDescription(String line) throws NoTodoDescriptionException {

        String lineWithoutSpaces = line.replaceAll("\\s", "");

        if (lineWithoutSpaces.length() == 4) {
            throw new NoTodoDescriptionException();
        }
    }

    private static void checkForDescription(FriendlyBotTask[] tasks, int taskCount) throws NoDescriptionException {

        boolean containsLetter = tasks[taskCount].description.matches(".*[a-zA-Z]+.*");

        if (!containsLetter) {
            throw new NoDescriptionException();
        }
    }

    // Refactored from main
    private static void invalidCommand() {
        System.out.println("Oops! I don't think I know what you mean. ☹");
    }

    // Refactored from main
    private static int displayNewTask(int taskCount, FriendlyBotTask task) {
        System.out.println("Great! I've added this task:\n\t" + task.toString() +
                "\nNow you have " + (taskCount + 1) + " task(s) in your list.");
        taskCount++;
        return taskCount;
    }
}