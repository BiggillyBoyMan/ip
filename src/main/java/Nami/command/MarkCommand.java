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
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (index < 0 || index >= tasks.size()) {
            throw new DukeException("Task number out of range.");
        }
        tasks.get(index).markAsDone();
        storage.save(tasks.asList());
        System.out.println("____________________________________________________________");
        System.out.println("Nice! I have marked this task as done:");
        System.out.println("[X] " + tasks.get(index).getDescription());
        System.out.println("____________________________________________________________");
    }
}
