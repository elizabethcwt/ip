import java.sql.SQLOutput;
import java.util.Scanner;

public class CovidBot {
    public static void main(String[] args) {
        System.out.println("Hello, I'm CovidBot! :)");
        System.out.println("Since it's Covid and we don't get to see each other face to face (how sad),\n" +
                "I'm here to entertain you a little!" +
                "Type whatever you want and I'll echo you :P\n" +
                "Once you've realise you're annoyed, simply type 'bye' and I'll stop disturbing you!\n");

        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();

            if (line.equals("bye")) {
                System.out.println("Oh no, guess you're officially annoyed, I'm sorry...\n" +
                        "Perhaps when you're bored again one day, you'll come back to chat with me though! Bye for now!:D\n");
                break;
            } else {
                System.out.println(line);
                System.out.println();
            }
        }
    }
}
