package bots;

import bots.*;
import exceptions.*;

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
                try {
                    Integer.parseInt(checkDone[1]);
                    int d = Integer.parseInt(checkDone[1]);
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
            } else if (checkDone[0].equals("delete")) {
                try {
                    Integer.parseInt(checkDone[1]);
                    int d = Integer.parseInt(checkDone[1]);
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
            } else if (checkDone[0].equals("find")) {
                ArrayList<FriendlyBotTask> findArray = new ArrayList<>();
                String lookFor = line.substring(5);
                for (FriendlyBotTask item : tasks) {
                    if (item.description.contains(lookFor)) {
                        findArray.add(item);
                    }
                }
                System.out.println("\nHere is/are the relevant task(s) in your list:");
                int findArrayCount = 1;
                for (FriendlyBotTask findArrayItem : findArray) {
                    System.out.println(findArrayCount + ". " + findArrayItem);
                }
                System.out.println();
            } else {
                if (line.equals("list")) {
                    System.out.println("Here is/are the task(s) in your list:");

                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + "." + tasks.get(i).toString());
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
                                tasks.add(new FriendlyBotTodo(line));
                                tasks.get(taskCount).description = line.substring(5);
                                taskCount = displayNewTask(taskCount, tasks.get(taskCount));
                                break;
                            } catch (NoTodoDescriptionException ntde) {
                                System.out.println("Oops! You can't leave the description of your Todo empty. 😞");
                            }
                            break;
                        case "deadline":
                            try {
                                checkForDescriptionAndDeadline(line);
                                int deadlineBy = line.indexOf("/by") + 4;
                                String by = line.substring(deadlineBy);
                                checkForDeadlineDescription(line, deadlineBy);
                                tasks.add(new FriendlyBotDeadline(line, by));
                                tasks.get(taskCount).description = line.substring(9, deadlineBy - 4);
                                taskCount = displayNewTask(taskCount, tasks.get(taskCount));
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
                                tasks.add(new FriendlyBotEvent(line, at));
                                tasks.get(taskCount).description = line.substring(6, eventAt - 4);
                                taskCount = displayNewTask(taskCount, tasks.get(taskCount));
                                break;
                            } catch (NoDescriptionAndEventAtException e) {
                                System.out.println("Oops! Are you missing a description AND a time/place for your " +
                                        "event? 😱");
                            } catch (StringIndexOutOfBoundsException e) {
                                System.out.println("Oops! Are you missing a time/place for your event? 🧐 (use '/at'!)");
                            } catch (NoEventDescriptionException e) {
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
        return taskCount;
    }
}
