package chattime.task;

import chattime.task.Task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toDataString() {
        return "T" + super.toDataString();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}