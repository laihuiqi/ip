package chattime.task;

import java.time.LocalDate;

/**
 * Represents task objects created by user's command.
 * Extended by Todo, Deadline and Event classes.
 */
public class Task {

    private static int tasksCount = 0;

    private String description;
    private boolean isDone;

    /**
     * Creates Task object with corresponding description.
     *
     * @param content Describes the task.
     */
    public Task(String content) {
        description = content;
        isDone = false;
        tasksCount++;
    }

    /**
     * Returns the symbol relevant to current task's done status.
     *
     * @return Symbol depends on done status of task.
     */
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    /**
     * Returns current task's done status.
     *
     * @return Done status of task.
     */
    public boolean getTaskStatus() {
        return isDone;
    }

    /**
     * Compares current task's description with the given keyword.
     *
     * @return Result of comparison, true if matched, false otherwise.
     */
    public boolean isMatchDescription(String keyword) {
        return description.contains(keyword);
    }

    /**
     * Sets done status of current task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Sets done status of current task as not done.
     */
    public void unmarkDone() {
        isDone = false;
    }

    /**
     * Gets total available tasks number.
     *
     * @return Total number of undeleted task.
     */
    public static int getCount() {
        return tasksCount;
    }

    /**
     * Reduces the total task number once a task is deleted.
     */
    public void removeTask() {
        tasksCount--;
    }

    /**
     * Returns conclusion message of current total number of tasks.
     *
     * @return Conclusion message indicates total number of tasks.
     */
    public static String printTotalTask() {
        return "Now you have " + tasksCount + " tasks in the list.";
    }

    /**
     * Generates a data string of task to be stored in storage file.
     *
     * @return Data string of task.
     */
    public String toDataString() {
        return String.format(" @ %d @ %s", isDone ? 1 : 0, description);
    }

    /**
     * Returns comparison result of input time with task relevant time.
     *
     * @param time User's input time.
     * @return false as default.
     */
    public boolean isOnDate(LocalDate time) {
        return false;
    }

    /**
     * Returns current data of task.
     *
     * @return Current situation of task.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), description);
    }

}
