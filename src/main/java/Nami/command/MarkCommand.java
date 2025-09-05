package Nami.command;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;
public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (index < 0 || index >= tasks.size()) {
            throw new DukeException("Task number out of range.");
        }
        tasks.get(index).markAsDone();
        storage.save(tasks.asList());
        return
        "____________________________________\n" +
        "Nice! I have marked this task as done: \n" +
        "[X] " + tasks.get(index).getDescription() +
        "\n__________________________________";
    }
}
