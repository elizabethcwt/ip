package bots;

import exception_initialisations.NoDeadlineDescriptionException;
import exception_initialisations.NoDescriptionAndDeadlineException;
import exception_initialisations.NoDescriptionAndEventAtException;
import exception_initialisations.NoEventDescriptionException;
import exception_initialisations.NoTodoDescriptionException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that contains method to sort out different types of user inputs, and calls their corresponding methods.<br><br>
 *
 * @see Ui#handleUi(ArrayList, int)
 */
public class Ui extends FriendlyBot {

    /**
     * Method that scans user's inputs, then sorts out different types of user inputs.<br><br>
     * It then calls their corresponding methods.
     *
     * @param tasks array list containing all tasks thus far.
     * @param taskCount to track how many tasks there are in the user's task list thus far.
     *
     * @return taskCount - to be used in other methods so the full task list can be accessed.
     *
     * @see Ui#uiHandleDone(ArrayList, String) (ArrayList, String, String) (ArrayList, String) (ArrayList, int, String)
     * @see Ui#uiHandleFind(ArrayList, String) (ArrayList, int, String)
     * @see Ui#uiHandleList(ArrayList, int) (ArrayList, int, String)
     * @see Ui#uiHandleTask(ArrayList, int, String)
     */
    public static int handleUi(ArrayList<FriendlyBotTask> tasks, int taskCount) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();

            // Create new array to check for 'done (no.)' input
            String[] checkDone = line.split(" ", 2);

            if (checkDone[0].equals("done")) {
                try {
                    uiHandleDone(tasks, checkDone[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Oops! Please indicate which task, in your task list, you'd like to mark as" +
                            " done! 😊\n");
                }
            } else if (checkDone[0].equals("delete")) {
                try {
                    taskCount = uiHandleDelete(tasks, taskCount, checkDone[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Oops! Please indicate which task, in your task list, you'd like to delete! 😊\n");
                }
            } else if (checkDone[0].equals("find")) {
                try {
                    uiHandleFind(tasks, line);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Oops! Please include some keyword(s) you're trying to find in your task list!" +
                            " 😊\n");
                }
            } else {
                if (line.equals("list")) {
                    uiHandleList(tasks, taskCount);
                } else if (line.equals("bye")) {
                    System.out.println("\nHope you found this app useful! \n" +
                            "See you again! :)\n");
                    break;
                } else {
                    taskCount = uiHandleTask(tasks, taskCount, line);
                }
                System.out.println();
            }
        }
        return taskCount;
    }

    /**
     * Method that handle's user's tasks by sorting them into todos, deadline and events.<br><br>
     * It then calls the corresponding methods.
     *
     * @param tasks array list containing all tasks thus far.
     * @param taskCount to track how many tasks there are in the user's task list thus far.
     * @param line to check the first word of the user's input to determine task type.
     *
     * @return taskCount - to be used in other methods so the full task list can be accessed.
     *
     * @see Ui#uiHandleTodo(ArrayList, int, String) (ArrayList, String) (ArrayList, int, String)
     * @see Ui#uiHandleDeadline(ArrayList, int, String) (ArrayList, String) (ArrayList, int, String)
     * @see Ui#uiHandleEvent(ArrayList, int, String) (ArrayList, int) (ArrayList, int, String)
     */
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

    /**
     * Method that marks user's task as done.
     *
     * @param tasks array list containing all tasks thus far.
     * @param s task information (as a string) to be marked as done.
     *
     */
    public static void uiHandleDone(ArrayList<FriendlyBotTask> tasks, String s) {
        try {
            Integer.parseInt(s);
            int d = Integer.parseInt(s);
            tasks.get(d - 1).markAsDone();
            System.out.println("Good job! :) I've marked this task as complete:\n\n\t" +
                    tasks.get(d - 1).toString() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("Oops! Please indicate in NUMERALS, which task you've done! 😅\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops! It seems like the number of the task you're trying to set as done is " +
                    "invalid! 🤨\n");
        }
    }

    /**
     * Method that removes user's task from the user's task list.
     *
     * @param tasks array list containing all tasks thus far.
     * @param taskCount to update the new task list by decrementing the task count.
     * @param s task information (as a string) to be marked as deleted.
     *
     * @return taskCount - to be used in other methods so the full task list can be accessed.
     *
     */
    public static int uiHandleDelete(ArrayList<FriendlyBotTask> tasks, int taskCount, String s) {
        try {
            Integer.parseInt(s);
            int d = Integer.parseInt(s);
            System.out.println("Alrighttt, I've successfully removed this task:\n\t" +
                    tasks.get(d - 1).toString() + "\n" + "Now you have a grand total of... " + (taskCount - 1) +
                    " task(s) in your list! 👍🏼\n");
            taskCount--;
            tasks.remove(d - 1);
        } catch (NumberFormatException e) {
            System.out.println("Oops! Please indicate in NUMERALS, which task you want to delete! 😅\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops! It seems like the number of the task you're trying to delete is " +
                    "invalid! 🤨\n");
        }
        return taskCount;
    }

    /**
     * Method that looks for, and displays, user's relevant task(s) in user's task list, based on user's input
     * (keywords).
     *
     * @param tasks array list containing all tasks thus far.
     * @param line keyword user wants to look for in tasks.
     *
     */
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

    /**
     * Method that displays all the tasks in the user's task list.
     *
     * @param tasks array list containing all tasks thus far.
     * @param taskCount to track how many tasks there are in the user's task list thus far.
     *
     */
    public static void uiHandleList(ArrayList<FriendlyBotTask> tasks, int taskCount) {
        if(taskCount == 0) {
            System.out.println("Hmm, looks like your task list is currently still empty 😮. Try adding a todo, deadline " +
                    "or event!");
        } else {
            System.out.println("Here is/are the task(s) in your list:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + "." + tasks.get(i).toString());
            }
        }
        System.out.println();
    }

    /**
     * Method that handles user's event tasks by checking if user's event input is valid.<br><br>
     * If it is, then method adds new event to the user's task list, along with the event description and location.
     *
     * @param tasks array list containing all tasks thus far.
     * @param taskCount to track how many tasks there are in the user's task list thus far.
     * @param line to determine event details (description, location).
     *
     * @return taskCount - to update the user's task count.
     *
     * @see ExceptionAndCheckForMethods#checkForDescriptionAndEventAt(String) (String) (ArrayList, int, String)
     * (ArrayList, String) (ArrayList, int, String)
     * @see ExceptionAndCheckForMethods#checkForEventDescription(String, int) (String) (String) (ArrayList, int, String)
     *      * (ArrayList, String) (ArrayList, int, String)
     * @see FriendlyBot#displayNewTask(int, FriendlyBotTask)
     */
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

    /**
     * Method that handles user's deadline tasks by checking if user's deadline input is valid.<br><br>
     * If it is, then method adds new deadline to the user's task list, along with the event description and deadline
     * date.
     *
     * @param tasks array list containing all tasks thus far.
     * @param taskCount to track how many tasks there are in the user's task list thus far.
     * @param line to determine deadline details (description, deadline date).
     *
     * @return taskCount - to update the user's task count.
     *
     * @see ExceptionAndCheckForMethods#checkForDescriptionAndDeadline(String) (String) (String) (ArrayList, int,
     * String)
     * (ArrayList, String) (ArrayList, int, String)
     * @see ExceptionAndCheckForMethods#checkForDeadlineDescription(String, int) Description(String, int) (String)
     * (String) (ArrayList, int, String)
     *      * (ArrayList, String) (ArrayList, int, String)
     * @see DeadlineDate#checkForDateFormat(ArrayList, int, String)
     * @see FriendlyBot#displayNewTask(int, FriendlyBotTask)
     */
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
        } catch (NoDescriptionAndDeadlineException e) {
            System.out.println("Oops! Are you missing a description AND a deadline?? 😱");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Oops! Are you missing a deadline? 🧐 (use '/by'!)");
        } catch (NoDeadlineDescriptionException e) {
            System.out.println("Oops! Are you missing a description for your deadline? 🧐");
        }
        return taskCount;
    }

    /**
     * Method that handles user's todo tasks by checking if user's todo input is valid.<br><br>
     * If it is, then method adds new todo to the user's task list, along with the todo description.
     *
     * @param tasks array list containing all tasks thus far.
     * @param taskCount to track how many tasks there are in the user's task list thus far.
     * @param line to determine todo details (description).
     *
     * @return taskCount - to update the user's task count.
     *
     * @see ExceptionAndCheckForMethods#checkForTodoDescription(String) (String) (String) (ArrayList, int, String)
     * (ArrayList, String) (ArrayList, int, String)
     * @see FriendlyBot#displayNewTask(int, FriendlyBotTask)
     */
    public static int uiHandleTodo(ArrayList<FriendlyBotTask> tasks, int taskCount, String line) {
        try {
            ExceptionAndCheckForMethods.checkForTodoDescription(line);
            tasks.add(new FriendlyBotTodo(line));
            tasks.get(taskCount).description = line.substring(5);
            taskCount = displayNewTask(taskCount, tasks.get(taskCount));
        } catch (NoTodoDescriptionException e) {
            System.out.println("Oops! You can't leave the description of your Todo empty. 😞");
        }
        return taskCount;
    }
}
