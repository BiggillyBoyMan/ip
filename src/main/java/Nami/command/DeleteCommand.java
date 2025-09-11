package Nami.command;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;
public class DeleteCommand extends Command {
    private final int index; // 0-based
    public DeleteCommand(int index) { this.index = index; }

    /**
     * Executes command to return a String
     * @param tasks
     * @param ui
     * @param storage
     * @return String
     * @throws DukeException
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (index < 0 || index >= tasks.size()) {
            throw new DukeException("Task number out of range.");
        }
        Tasks removed = tasks.get(index);
        tasks.remove(index);
        storage.save(tasks.asList());
        return
        "_______________________________________\n" +
        "Noted. I've removed this task:\n" +
        "[X] " + removed.getResult() +
        "\n_____________________________________";

    }
}
