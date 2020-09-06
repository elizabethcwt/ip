public class FriendlyBotDeadline extends FriendlyBotTask {

    protected String by;

    public FriendlyBotDeadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
