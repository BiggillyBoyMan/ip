package Nami.command;
import Nami.task.toDo;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;
public class AddToDoCommand extends Command {
    private final String description;
    public AddToDoCommand(String description) {
        this.description = description;
    }
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (description == null || description.isEmpty()) {
            throw new DukeException("the description of a todo cannot be empty.");
        }
        Tasks t = new toDo(description);
        tasks.add(t);
        storage.save(tasks.asList());

        return
        "______________________________________ \n" +
        "Got it. I've added this task: \n" +
        t.getResult() +
        "\nNow you have " + tasks.size() + " tasks in this list. \n" +
        "______________________________________";
    }
}
