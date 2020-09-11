package bots;

public class FriendlyBotTask {
    private boolean isDone;
    protected String description;

    public FriendlyBotTask(String description) {
        this.description = description;
        this.isDone = false;
    }

    public boolean getDone() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Return tick or x symbols
    public String getStatusIcon() {
        return "[" + (isDone ? "\u2713" : "\u2718") + "] ";
    }

    public String getTypeLetter() {
        return null;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return getStatusIcon() + description;
    }
}