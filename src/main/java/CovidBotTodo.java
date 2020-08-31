public class CovidBotTodo extends CovidBotTask {
    public CovidBotTodo (String description) {
        super(description);
        this.description = description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
