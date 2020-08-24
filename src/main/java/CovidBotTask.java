public class CovidBotTask {
    private boolean isDone;
    protected String description;

    public CovidBotTask(String description) {
        this.description = description;
        isDone = false;
    }

    // Return tick or x symbols
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public void markAsDone() {
        this.isDone = true;
    }
}
