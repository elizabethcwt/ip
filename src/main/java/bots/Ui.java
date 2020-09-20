package bots;

import exception_initialisations.NoDeadlineDescriptionException;
import exception_initialisations.NoDescriptionAndDeadlineException;
import exception_initialisations.NoDescriptionAndEventAtException;
import exception_initialisations.NoEventDescriptionException;
import exception_initialisations.NoTodoDescriptionException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui extends FriendlyBot {
    public static int handleUi(ArrayList<FriendlyBotTask> tasks, int taskCount) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();

            // Create new array to check for 'done (no.)' input
            String[] checkDone = line.split(" ", 2);

            if (checkDone[0].equals("done")) {
                uiHandleDone(tasks, checkDone[1]);
            } else if (checkDone[0].equals("delete")) {
                taskCount = uiHandleDelete(tasks, taskCount, checkDone[1]);
            } else if (checkDone[0].equals("find")) {
                uiHandleFind(tasks, line);
            } else {
                if (line.equals("list")) {
                    uiHandleList(tasks, taskCount);
                } else if (line.equals("bye")) {
                    System.out.println("\nHope you found this app useful! \n" +
                            "See you again! :)\n");
                } else {
                    taskCount = uiHandleTask(tasks, taskCount, line);
                }
                System.out.println();
            }
        }
        return taskCount;
    }

    public static int uiHandleTask(ArrayList<FriendlyBotTask> tasks, int taskCount, String line) {
        String lineWords[] = line.split(" ");
        switch (lineWords[0]) {
            case "todo":
                taskCount = uiHandleTodo(tasks, taskCount, line);
                break;
            case "deadline":
                taskCount = uiHandleDeadline(tasks, taskCount, line);
                break;
            case "event":
                taskCount = uiHandleEvent(tasks, taskCount, line);
                break;
            default:
                invalidCommand();
                break;
        }
        return taskCount;
    }

    public static void uiHandleDone(ArrayList<FriendlyBotTask> tasks, String s) {
        try {
            Integer.parseInt(s);
            int d = Integer.parseInt(s);
            tasks.get(d - 1).markAsDone();
            System.out.println("Good job! :) I've marked this task as complete:\n\n\t" +
                    tasks.get(d - 1).toString() + "\n");
        } catch (NumberFormatException nfe) {
            System.out.println("Oops! Please indicate in NUMERALS, which task you've done! 😅\n");
        } catch (NullPointerException | ArrayIndexOutOfBoundsException npe) {
            System.out.println("Oops! It seems like the task you're trying to set as done is invalid! 🤨\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops! It seems like the number of the task you're trying to set as done is " +
                    "invalid! 🤨\n");
        }
    }

    public static int uiHandleDelete(ArrayList<FriendlyBotTask> tasks, int taskCount, String s) {
        try {
            Integer.parseInt(s);
            int d = Integer.parseInt(s);
            System.out.println("Alrighttt, I've successfully removed this task:\n\t" +
                    tasks.get(d - 1).toString() + "\n" + "Now you have a grand total of... " + (taskCount - 1) +
                    " task(s) in your list! 👍🏼\n");
            taskCount--;
            tasks.remove(d - 1);
        } catch (NumberFormatException nfe) {
            System.out.println("Oops! Please indicate in NUMERALS, which task you want to delete! 😅\n");
        } catch (IndexOutOfBoundsException iofbe) {
            System.out.println("Oops! It seems like the number of the task you're trying to delete is " +
                    "invalid! 🤨\n");
        }
        return taskCount;
    }

    public static void uiHandleFind(ArrayList<FriendlyBotTask> tasks, String line) {
        ArrayList<FriendlyBotTask> findArray = new ArrayList<>();
        String lookFor = line.substring(5);
        for (FriendlyBotTask item : tasks) {
            if (item.description.contains(lookFor)) {
                findArray.add(item);
            }
        }
        System.out.println("Here is/are the relevant task(s) in your list:");
        int findArrayCount = 1;
        for (FriendlyBotTask findArrayItem : findArray) {
            System.out.println(findArrayCount + ". " + findArrayItem);
        }
        System.out.println();
    }

    public static void uiHandleList(ArrayList<FriendlyBotTask> tasks, int taskCount) {
        System.out.println("Here is/are the task(s) in your list:");

        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + "." + tasks.get(i).toString());
        }
        System.out.println();
    }

    public static int uiHandleEvent(ArrayList<FriendlyBotTask> tasks, int taskCount, String line) {
        try {
            ExceptionAndCheckForMethods.checkForDescriptionAndEventAt(line);
            int eventAt = line.indexOf("/at") + 4;
            String at = line.substring(eventAt);
            ExceptionAndCheckForMethods.checkForEventDescription(line, eventAt);
            tasks.add(new FriendlyBotEvent(line, at));
            tasks.get(taskCount).description = line.substring(6, eventAt - 4);
            taskCount = displayNewTask(taskCount, tasks.get(taskCount));
        } catch (NoDescriptionAndEventAtException e) {
            System.out.println("Oops! Are you missing a description AND a time/place for your " +
                    "event? 😱");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Oops! Are you missing a time/place for your event? 🧐 (use '/at'!)");
        } catch (NoEventDescriptionException e) {
            System.out.println("Oops! Are you missing a description for your event? 🧐");
        }
        return taskCount;
    }

    public static int uiHandleDeadline(ArrayList<FriendlyBotTask> tasks, int taskCount, String line) {
        try {
            ExceptionAndCheckForMethods.checkForDescriptionAndDeadline(line);
            int deadlineBy = line.indexOf("/by") + 4;
            String by = line.substring(deadlineBy);
            ExceptionAndCheckForMethods.checkForDeadlineDescription(line, deadlineBy);
            by = DeadlineDate.checkForDateFormat(tasks, taskCount, by);
            tasks.add(new FriendlyBotDeadline(line, by));
            tasks.get(taskCount).description = line.substring(9, deadlineBy - 4);
            taskCount = displayNewTask(taskCount, tasks.get(taskCount));
        } catch (NoDescriptionAndDeadlineException ndde) {
            System.out.println("Oops! Are you missing a description AND a deadline?? 😱");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Oops! Are you missing a deadline? 🧐 (use '/by'!)");
        } catch (NoDeadlineDescriptionException nde) {
            System.out.println("Oops! Are you missing a description for your deadline? 🧐");
        }
        return taskCount;
    }

    public static int uiHandleTodo(ArrayList<FriendlyBotTask> tasks, int taskCount, String line) {
        try {
            ExceptionAndCheckForMethods.checkForTodoDescription(line);
            tasks.add(new FriendlyBotTodo(line));
            tasks.get(taskCount).description = line.substring(5);
            taskCount = displayNewTask(taskCount, tasks.get(taskCount));
        } catch (NoTodoDescriptionException ntde) {
            System.out.println("Oops! You can't leave the description of your Todo empty. 😞");
        }
        return taskCount;
    }
}
