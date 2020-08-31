public class CovidBotEvent extends CovidBotTask{
    protected String at;

    public CovidBotEvent (String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}