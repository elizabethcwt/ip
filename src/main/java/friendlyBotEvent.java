public class friendlyBotEvent extends friendlyBotTask {
    protected String at;

    public friendlyBotEvent(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}