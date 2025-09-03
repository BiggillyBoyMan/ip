package Nami.command;
import java.time.LocalDateTime;

import Nami.task.Deadlines;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;

public class AddDeadlineCommand extends Command {
    private final String description;
    private final LocalDateTime by;

    public AddDeadlineCommand(String description, LocalDateTime by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Tasks t = new Deadlines(description, by);
        tasks.add(t);
        storage.save(tasks.asList());

        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println(t.getResult());
        System.out.println("Now you have " + tasks.size() + " tasks in this list.");
        System.out.println("____________________________________________________________");
    }
}
