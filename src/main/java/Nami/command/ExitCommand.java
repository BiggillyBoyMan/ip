package Nami.command;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;
public class ExitCommand extends Command {

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        return ui.showGoodbye();
    }
    @Override
    public boolean isExit() {
        return true;
    }
}
