import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Events extends Tasks{

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public Events(String description, LocalDateTime startTime, LocalDateTime endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    @Override
    public String getType() {
        return "E";
    }

    public String getResult() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("d MMM yyyy h:mm a");
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.getDescription() + "by: " + this.startTime.format(outputFormat) + " to: " + this.endTime.format(outputFormat);
    }

    public String getList() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("d MMM yyyy h:mm a");
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.description + "( by: " + this.startTime.format(outputFormat) + " to: " + this.endTime.format(outputFormat) + " )";
    }

    @Override
    public String toStorageFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + startTime + " | " + endTime;
    }
}
