public class FriendlyBotTodo extends FriendlyBotTask {
    public FriendlyBotTodo(String description) {
        super(description);
        this.description = description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
