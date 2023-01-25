package chattime.command;

import chattime.TaskList;
import chattime.storage.Storage;
import chattime.task.Task;
import chattime.ui.Ui;

/**
 * Represents MarkCommand object that handles main logic of marking a task as done or not done.
 */
public class MarkCommand extends Command {
    private int taskIndex;
    private boolean isDone;

    /**
     * Creates MarkCommand object to execute the task marking logic.
     *
     * @param index Index of the task in task list.
     * @param taskIsDone true if mark as done, false if mark as undone.
     */
    public MarkCommand(int index, boolean taskIsDone) {
        taskIndex = taskIndex;
        isDone = taskIsDone;
    }

    /**
     * Implements and executes main logic of MarkCommand object.
     * Gets task from task list.
     * Executes task status marking and returns UI message respectively to user.
     * Updates data in storage file.
     *
     * @param ui UI instance of bot.
     * @param taskList Current task list storing tasks.
     * @param storage Storage file to store current state items of task list.
     */
    public void execute(Ui ui, TaskList taskList, Storage storage) {
        Task target = taskList.getTask(taskIndex);

        if (isDone) {
            target.markAsDone();
            ui.replyDoneMessage(target);
        } else {
            target.unmarkDone();
            ui.replyNotDoneMessage(target);
        }

        storage.updateFile(taskIndex, taskList.getTask(taskIndex));
    }

}
