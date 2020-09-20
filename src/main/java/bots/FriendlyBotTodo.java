package bots;

/**
 * Subclass of FriendlyBot that contains todo tasks.<br>
 * Contains constructor and overridden {@code toString()} method in FriendlyBot.java.
 *
 * @see FriendlyBotTodo#toString()
 */
public class FriendlyBotTodo extends FriendlyBotTask {

    public FriendlyBotTodo(String description){
        super(description);
    }

    public FriendlyBotTodo(String description, boolean isDone) {
        super(description);
        this.isDone = isDone;
    }

    String taskType = "[T]";

    @Override
    public String toString() {
        return taskType + super.toString();
    }
}
