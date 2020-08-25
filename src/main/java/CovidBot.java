import java.util.Scanner;

public class CovidBot {
    public static void main(String[] args) {
        System.out.println("Hello, I'm CovidBot, your To Do List! :)");
        System.out.println("Enter a To Do:\n");

        String line;
        Scanner in = new Scanner(System.in);

        // Create array to store To Dos
        CovidBotTask[] toDos = new CovidBotTask[100];
        int toDosCount = 0;

        while (in.hasNextLine()) {
            line = in.nextLine();

            // Create new array to check for 'done (no.)' input
            String[] checkDone = line.split(" ", 3);

            if (checkDone[0].equals("done")) {
                int isInteger = 1;
                try {
                    int d = Integer.parseInt(checkDone[1]);
                } catch (NumberFormatException nfe) {
                    isInteger = 0;
                }

                if(isInteger == 1) {
                    int d = Integer.parseInt(checkDone[1]);
                    toDos[d-1].markAsDone();
                    System.out.println("Good job! :) I've marked this task as complete:\n");
                    System.out.println("\t[" + toDos[d-1].getStatusIcon() + "] " + toDos[d-1].description);
                    System.out.println();
                } else {
                    toDos[toDosCount] = new CovidBotTask(line);
                    System.out.println("added: " + toDos[toDosCount].description);
                    System.out.println();
                    toDosCount++;
                }
            } else {
                if (line.equals("list")) {
                    System.out.println("Here are the tasks in your To Do list:");
                    for (int i = 0; i < toDosCount; i++) {
                        System.out.println((i + 1) + ".[" + toDos[i].getStatusIcon() + "] " + toDos[i].description);
                    }
                    System.out.println();
                } else if (line.equals("bye")) {
                    System.out.println("\nHope you found this To Do app useful :)\n" +
                            "See you again!\n");
                    break;
                } else {
                    toDos[toDosCount] = new CovidBotTask(line);
                    System.out.println("added: " + toDos[toDosCount].description);
                    System.out.println();
                    toDosCount++;
                }
            }
        }
    }
}
