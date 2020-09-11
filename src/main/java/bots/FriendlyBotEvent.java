package bots;

public class FriendlyBotEvent extends FriendlyBotTask {
    protected String at;

    public FriendlyBotEvent(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}