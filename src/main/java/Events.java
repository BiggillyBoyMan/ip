public class Events extends Tasks{

    private String startTime;
    private String endTime;
    public Events(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime.trim();
        this.endTime = endTime.trim();
    }
    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    @Override
    public String getType() {
        return "E";
    }

    public String getResult() {
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.getDescription() + "by: " + this.startTime + "to: " + this.endTime;
    }

    public String getList() {
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.description + "( by: " + this.startTime + " to: " + this.endTime + " )";
    }
}
