package Nami.task;
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
        assert index >= 0 && index < tasks.size() : "Index must be within the range of 0 to sizee";
        return tasks.get(index);
    }

    public void add(Tasks t) {
        assert t != null: "Cannot add null task";
        tasks.add(t);
    }

    public Tasks remove(int index) {
        assert index >= 0 && index < tasks.size() : "index out of bounds (remove)";
        return tasks.remove(index);
    }

    public ArrayList<Tasks> asList() {
        return tasks;
    }
}
