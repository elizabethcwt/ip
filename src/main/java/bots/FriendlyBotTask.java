package bots;

import java.io.Serializable;

/**
 * Superclass of FriendlyBotTodo, FriendlyBotDeadline and FriendlyBotEvent.<br><br>
 * Contains constructor, getter, setter, {@code getStatusIcon()}, {@code markAsDone()} and original {@code toString()} methods.
 *
 * @see FriendlyBotTask#getStatusIcon()
 * @see FriendlyBotTask#markAsDone()
 * @see FriendlyBotTask#toString()
 */
public class FriendlyBotTask implements Serializable {
    protected boolean isDone;
    protected String description;

    public FriendlyBotTask(String description) {
        this.description = description;
    }

    public boolean getDone() {
        return isDone;
    }

    /**
     * @return tick or cross icon - based on boolean variable {@code isDone}.
     * @see FriendlyBotTask#markAsDone()
     */
    // Return tick or x symbols
    public String getStatusIcon() {
        return "[" + (isDone ? "\u2713" : "\u2718") + "] ";
    }

    /**
     * Sets {@code isDone} to true once method is called.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * @return status icon by calling {@code getStatusIcon()}and task description.<br><br>
     *
     * @see FriendlyBotTask#getStatusIcon()
     */
    @Override
    public String toString() {
        return getStatusIcon() + description;
    }
}
