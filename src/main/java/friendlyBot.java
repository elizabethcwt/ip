import java.util.Scanner;

public class friendlyBot {

    public static void main(String[] args) {
        System.out.println("Hello, I'm FriendlyBot, your Friendly To Do List! :)");
        System.out.println("Enter a To Do:\n");

        String line;
        Scanner in = new Scanner(System.in);

        // Create array to store Tasks
        friendlyBotTask[] tasks = new friendlyBotTask[100];
        int taskCount = 0;

        while (in.hasNextLine()) {
            line = in.nextLine();

            // Create new array to check for 'done (no.)' input
            String[] checkDone = line.split(" ", 3);

            if (checkDone[0].equals("done")) {
                int isInteger = 1;
                try {
                    Integer.parseInt(checkDone[1]);
                } catch (NumberFormatException nfe) {
                    isInteger = 0;
                }

                if (isInteger == 1) {
                    int d = Integer.parseInt(checkDone[1]);
                    tasks[d - 1].markAsDone();
                    System.out.println("Good job! :) I've marked this task as complete:\n");
                    System.out.println("\t" + tasks[d - 1].toString());
                    System.out.println();
                } else {
                    tasks[taskCount] = new friendlyBotTask(line);
                    System.out.println("added: " + tasks[taskCount].description);
                    System.out.println();
                    taskCount++;
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
                    String lineFirstWord = line.split(" ")[0];

                    switch (lineFirstWord) {
                        case "todo":
                            tasks[taskCount] = new friendlyBotTodo(line);
                            tasks[taskCount].description = line.substring(5);
                            taskCount = displayNewTask(taskCount, tasks[taskCount]);
                            break;
                        case "deadline":
                            int dlBy = line.indexOf("/by") + 4;
                            String by = line.substring(dlBy);
                            tasks[taskCount] = new friendlyBotDeadline(line, by);
                            tasks[taskCount].description = line.substring(9, dlBy - 4);
                            taskCount = displayNewTask(taskCount, tasks[taskCount]);
                            break;
                        case "event":
                            int eAt = line.indexOf("/at") + 4;
                            String at = line.substring(eAt);
                            tasks[taskCount] = new friendlyBotEvent(line, at);
                            tasks[taskCount].description = line.substring(6, eAt - 4);
                            taskCount = displayNewTask(taskCount, tasks[taskCount]);
                            break;
                        default:
                            System.out.println("You've entered an invalid command :(");
                            break;
                    }
                }
                System.out.println();
            }
        }
    }

    // Refactored from main
    private static int displayNewTask(int taskCount, friendlyBotTask task) {
        System.out.println("Great! I've added this task:\n\t" + task.toString() +
                "\nNow you have " + (taskCount + 1) + " task(s) in your list.");
        taskCount++;
        return taskCount;
    }
}