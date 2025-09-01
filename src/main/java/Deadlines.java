import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Tasks {
    private LocalDateTime deadline;
    public Deadlines(String description, LocalDateTime deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String getType() {
        return "D";
    }

    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    public String getResult() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.getDescription() + " by: " + this.deadline.format(outputFormat);
    }

    public String getList() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.description + " ( by: " + this.deadline.format(outputFormat) + " )";
    }

    @Override
    public String toStorageFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + deadline;
    }
}
