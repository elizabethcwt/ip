public class friendlyBotDeadline extends friendlyBotTask {

    protected String by;

    public friendlyBotDeadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
