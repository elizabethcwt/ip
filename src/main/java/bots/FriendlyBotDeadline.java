package bots;

import exception_initialisations.NoDeadlineDescriptionException;

/**
 * Subclass of FriendlyBot that contains deadline tasks.<br><br>
 * Contains constructor and overridden {@code toString()} method in FriendlyBot.java.
 *
 * @see FriendlyBotDeadline#toString()
 */
public class FriendlyBotDeadline extends FriendlyBotTask {
    protected String by;

    public FriendlyBotDeadline(String description, String by){
        super(description);
        this.by = by;
    }

    public FriendlyBotDeadline(String description, String by, boolean isDone) {
        super(description);
        this.by = by;
        this.isDone = isDone;
    }

    String taskType = "[D]";

    @Override
    public String toString() {
        return taskType + super.toString() + " (by: " + by + ")";
    }
}
