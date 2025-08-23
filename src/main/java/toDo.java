public class toDo extends Tasks {
    public toDo(String description) {
        super(description);
    }

    @Override
    public String getType() {
        return "T";
    }
    public String getResult() {
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.getDescription();
    }
    public String getList() {
        return "[" + this.getType() + "] [" + this.getStatusIcon() + "] " + this.description;
    }
}
