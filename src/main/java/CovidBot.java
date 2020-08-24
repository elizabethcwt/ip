import java.sql.SQLOutput;
import java.util.Scanner;

public class CovidBot {
    public static void main(String[] args) {
        System.out.println("Hello, I'm CovidBot, your To Do List! :)");
        System.out.println("Enter a To Do:\n");

        String line;
        Scanner in = new Scanner(System.in);

        // Create array to store To Dos
        String[] toDos = new String[100];
        int toDosCount = 0;

        while (in.hasNextLine()) {
            line = in.nextLine();
            if (line.equals("list")) {
                for (int i=0; i<toDosCount; i++) {
                    System.out.println((i+1) + ". " + toDos[i]);
                }
                System.out.println();
            } else if (line.equals("bye")) {
                System.out.println("\nHope you found this To Do app useful :)\n" +
                        "See you again!\n");
            } else {
                toDos[toDosCount] = line;
                System.out.println("added: " + toDos[toDosCount]);
                System.out.println();
                toDosCount++;
            }
        }
    }
}
