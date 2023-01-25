package chattime.command;

import chattime.TaskList;
import chattime.storage.Storage;
import chattime.task.Task;
import chattime.ui.Ui;

/**
 * Represents DeleteCommand object that handles main logic of deleting task from task list.
 */
public class DeleteCommand extends Command {

    private int taskIndex;

    /**
     * Creates DeleteCommand object to execute the task deleting logic.
     *
     * @param index Index of task to be deleted.
     */
    public DeleteCommand(int index) {
        taskIndex = index;
    }

    /**
     * Implements and executes main logic of DeleteCommand object.
     * Gets specified task object from task list, reduces total object count and removes it from task list.
     * Deletes the task from storage file record.
     * Returns successful delete message to user.
     *
     * @param ui UI instance of bot.
     * @param taskList Current task list storing tasks.
     * @param storage Storage file to store current state items of task list.
     */
    @Override
    public void execute(Ui ui, TaskList taskList, Storage storage) {
        Task task = taskList.getTask(taskIndex);

        task.removeTask();
        taskList.removeListMember(taskIndex);
        storage.deleteFromFile(taskIndex);
        ui.replyRemoveTaskMsg(task, Task.printTotalTask());
    }

}
