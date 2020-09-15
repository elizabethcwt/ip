package bots;

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