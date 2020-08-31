public class CovidBotDeadline extends CovidBotTask{

    protected String by;

    public CovidBotDeadline (String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
