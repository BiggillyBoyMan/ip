package Nami.command;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;
public abstract class Command {

    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    public boolean isExit() {
        return false;
    }
}

