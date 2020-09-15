package bots;

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
