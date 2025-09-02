import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Tasks> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Tasks> tasks) {
        this.tasks = tasks;
    }

    public int size() {
        return tasks.size();
    }

    public Tasks get(int index) {
        return tasks.get(index);
    }

    public void add(Tasks t) {
        tasks.add(t);
    }

    public Tasks remove(int index) {
        return tasks.remove(index);
    }

    public ArrayList<Tasks> asList() {
        return tasks;
    }
}
