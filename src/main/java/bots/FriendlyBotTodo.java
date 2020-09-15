package bots;

public class FriendlyBotTodo extends FriendlyBotTask {

    public FriendlyBotTodo(String description){
        super(description);
    }

    public FriendlyBotTodo(String description, boolean isDone) {
        super(description);
        this.isDone = isDone;
    }

    String taskType = "[T]";

    @Override
    public String toString() {
        return taskType + super.toString();
    }
}
