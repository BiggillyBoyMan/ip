package Nami.command;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;
public class ListCommand extends Command {
    /**
     * Executes the task of listing all the task
     * @param tasks
     * @param ui
     * @param storage
     * @return
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        StringBuilder sb = new StringBuilder();
        sb.append("__________________________________\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1));
            sb.append(". ");
            sb.append(tasks.get(i).getList());
            sb.append("\n");
        }
        sb.append("__________________________________");
        return sb.toString();
    }
}
