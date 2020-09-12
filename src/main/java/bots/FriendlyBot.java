package bots;

import java.util.Scanner;
import java.util.ArrayList;

public class FriendlyBot {

    public static void main(String[] args) {
        ArrayList<FriendlyBotTask> tasksTest = new ArrayList<>();

        System.out.println("Hello, I'm FriendlyBot, your Friendly To Do List! :)\n" +
                "Enter a To Do:\n");

        String line;
        Scanner in = new Scanner(System.in);

        // Create array to store Tasks
//        FriendlyBotTask[] tasks = new FriendlyBotTask[100];
        int taskCount = 0;

        while (in.hasNextLine()) {
            line = in.nextLine();

            // Create new array to check for 'done (no.)' input
            String[] checkDone = line.split(" ", 2);

            if (checkDone[0].equals("done")) {
                try {
                    Integer.parseInt(checkDone[1]);
                    int d = Integer.parseInt(checkDone[1]);
                    tasksTest.get(d - 1).markAsDone();
                    System.out.println("Good job! :) I've marked this task as complete:\n\n\t" +
                            tasksTest.get(d - 1).toString() + "\n");
                } catch (NumberFormatException nfe) {
                    System.out.println("Oops! Please indicate in NUMERALS, which task you've done! 😅\n");
                } catch (IndexOutOfBoundsException iofbe) {
                    System.out.println("Oops! It seems like the number of the task you're trying to set as done is " +
                            "invalid! 🤨\n");
                }
            } else if (checkDone[0].equals("delete")) {
                try {
                    Integer.parseInt(checkDone[1]);
                    int d = Integer.parseInt(checkDone[1]);
                    taskCount--;
                    System.out.println("Alrighttt, I've successfully removed this task:\n\t" +
                            tasksTest.get(d-1).toString() + "\n" + "Now you have a grand total of... " + taskCount +
                            " task(s) in your list! 👍🏼\n");
                    tasksTest.remove(d-1);
                } catch (NumberFormatException nfe) {
                    System.out.println("Oops! Please indicate in NUMERALS, which task you want to delete! 😅\n");
                } catch (IndexOutOfBoundsException iofbe) {
                    System.out.println("Oops! It seems like the number of the task you're trying to delete is " +
                            "invalid! 🤨\n");
                }
            } else {
                if (line.equals("list")) {
                    System.out.println("Here is/are the task(s) in your list:");
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + "." + tasksTest.get(i).toString());
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
                                tasksTest.add(new FriendlyBotTodo(line));
                                tasksTest.get(taskCount).description = line.substring(5);
                                taskCount = displayNewTask(taskCount, tasksTest.get(taskCount));
                                break;
                            } catch (NoTodoDescriptionException ntde) {
                                System.out.println("Oops! You can't leave the description of your Todo empty. 😞");
                            };
                            break;
                        case "deadline":
                            try {
                                checkForDescriptionAndDeadline(line);
                                int deadlineBy = line.indexOf("/by") + 4;
                                String by = line.substring(deadlineBy);
                                checkForDeadlineDescription(line, deadlineBy);
                                tasksTest.add(new FriendlyBotDeadline(line, by));
                                tasksTest.get(taskCount).description = line.substring(9, deadlineBy - 4);
                                taskCount = displayNewTask(taskCount, tasksTest.get(taskCount));
                                break;
                            } catch (NoDescriptionAndDeadlineException ndde) {
                                System.out.println("Oops! Are you missing a description AND a deadline?? 😱");
                            } catch (StringIndexOutOfBoundsException e) {
                                System.out.println("Oops! Are you missing a deadline? 🧐 (use '/by'!)");
                            } catch (NoDeadlineDescriptionException nde) {
                                System.out.println("Oops! Are you missing a description for your deadline? 🧐");
                            }
                            break;
                        case "event":
                            try {
                                checkForDescriptionAndEventAt(line);
                                int eventAt = line.indexOf("/at") + 4;
                                String at = line.substring(eventAt);
                                checkForEventDescription(line, eventAt);
                                tasksTest.add(new FriendlyBotEvent(line, at));
                                tasksTest.get(taskCount).description = line.substring(6, eventAt - 4);
                                taskCount = displayNewTask(taskCount, tasksTest.get(taskCount));
                                break;
                            } catch (NoDescriptionAndEventAtException ndaea) {
                                System.out.println("Oops! Are you missing a description AND a time/place for your " +
                                        "event? 😱");
                            } catch (StringIndexOutOfBoundsException e) {
                                System.out.println("Oops! Are you missing a time/place for your event? 🧐 (use '/at'!)");
                            } catch (NoEventDescriptionException nde) {
                                System.out.println("Oops! Are you missing a description for your event? 🧐");
                            }
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

    private static void checkForDescriptionAndEventAt(String line) throws NoDescriptionAndEventAtException {

        String lineWithoutSpaces = line.replaceAll("\\s", "");

        if (lineWithoutSpaces.length() == 5) {
            throw new NoDescriptionAndEventAtException();
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

    private static void checkForDeadlineDescription(String line, int deadlineBy) throws NoDeadlineDescriptionException {

        boolean containsLetter = line.substring(8, deadlineBy-4).matches(".*[a-zA-Z]+.*");

        if (!containsLetter) {
            throw new NoDeadlineDescriptionException();
        }
    }

    private static void checkForEventDescription(String line, int eventAt) throws NoEventDescriptionException {

        boolean containsLetter = line.substring(5, eventAt-4).matches(".*[a-zA-Z]+.*");

        if (!containsLetter) {
            throw new NoEventDescriptionException();
        }
    }

    // Refactored from main
    private static int displayNewTask(int taskCount, FriendlyBotTask task) {
        System.out.println("Great! I've added this task:\n\t" + task.toString() +
                "\nNow you have " + (taskCount + 1) + " task(s) in your list.");
        taskCount++;
        return taskCount;
    }

    // Refactored from main
    private static void invalidCommand() {
        System.out.println("Oops! I don't think I know what you mean. ☹");
    }
}