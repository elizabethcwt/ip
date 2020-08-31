public class friendlyBotTodo extends friendlyBotTask {
    public friendlyBotTodo(String description) {
        super(description);
        this.description = description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
