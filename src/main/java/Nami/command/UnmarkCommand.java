package Nami.command;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;
public class UnmarkCommand extends Command {
    private final int index; // 0-based

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (index < 0 || index >= tasks.size()) {
            throw new DukeException("Task number out of range.");
        }
        tasks.get(index).unmarkAsDone();
        storage.save(tasks.asList());
        System.out.println("____________________________________________________________\n");
        System.out.println("OK, I've marked this task as not done yet:\n\n");
        System.out.println("[] " + tasks.get(index).getDescription());
        System.out.println("____________________________________________________________");
    }
}
