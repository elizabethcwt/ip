package bots;

/**
 * Subclass of FriendlyBot that contains event tasks.<br><br>
 * Contains constructor and overridden {@code toString()} method in FriendlyBot.java.
 *
 * @see FriendlyBotEvent#toString()
 */
public class FriendlyBotEvent extends FriendlyBotTask {
    protected String at;

    public FriendlyBotEvent(String description, String at){
        super(description);
        this.at = at;
    }

    public FriendlyBotEvent(String description, String at, boolean isDone) {
        super(description);
        this.at = at;
        this.isDone = isDone;
    }

    String taskType = "[E]";

    @Override
    public String toString() {
        return taskType + super.toString() + " (at: " + at + ")";
    }
}