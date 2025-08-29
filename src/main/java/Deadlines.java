public class Deadlines extends Tasks {
    private String deadline;
    public Deadlines(String description, String deadline) {
        super(description);
        this.deadline = deadline.trim();
    }

    @Override
    public String getType() {
        return "D";
    }

    public String getDeadline() {
        return this.deadline;
    }

    public String getResult() {
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.getDescription() + "by: " + this.deadline;
    }

    public String getList() {
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.description + " ( by: " + this.deadline + " )";
    }

    @Override
    public String toStorageFormat() {
        return " D | " + (isDone ? "1" : "0") + " | " + description + " | " + deadline;
    }
}
