package chattime.task;

import chattime.task.Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalTime fromTime;
    private LocalTime toTime;

    public Event(String description, LocalDate fromDate, LocalTime fromTime, LocalDate toDate, LocalTime toTime) {
        super(description);
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    @Override
    public String toDataString() {
        return "E" + super.toDataString() + " @ " + this.fromDate + " @ " + this.fromTime
                + " @ " + this.toDate + " @ " + this.toTime;
    }

    @Override
    public boolean onDate(LocalDate time) {
        return this.fromDate.isEqual(time) || this.toDate.isEqual(time) ||
                (this.fromDate.isBefore(time) && this.toDate.isAfter(time));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " +
                this.fromDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy ")) +
                (this.fromTime == null ? "" : this.fromTime.format(DateTimeFormatter.ofPattern("hh:mm a "))) +
                "to: " + this.toDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy ")) +
                (this.toTime == null ? "" : this.toTime.format(DateTimeFormatter.ofPattern("hh:mm a"))) + ")";
    }
}