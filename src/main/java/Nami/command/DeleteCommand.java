package Nami.command;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;
public class DeleteCommand extends Command {
    private final int index; // 0-based
    public DeleteCommand(int index) { this.index = index; }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (index < 0 || index >= tasks.size()) {
            throw new DukeException("Task number out of range.");
        }
        Tasks removed = tasks.get(index);

        System.out.println("____________________________________________________________");
        System.out.println("Noted. I've removed this task:");
        System.out.println("[X] " + removed.getResult());
        System.out.println("____________________________________________________________");

        tasks.remove(index);
        storage.save(tasks.asList());
    }
}
