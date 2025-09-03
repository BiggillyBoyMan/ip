package Nami.command;

import java.time.LocalDateTime;

import Nami.task.Events;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;

public class AddEventCommand extends Command {
    private final String description;
    private final LocalDateTime start;
    private final LocalDateTime end;

    public AddEventCommand(String description, LocalDateTime start, LocalDateTime end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Tasks t = new Events(description, start, end);
        tasks.add(t);
        storage.save(tasks.asList());

        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println(t.getResult());
        System.out.println("Now you have " + tasks.size() + " tasks in this list.");
        System.out.println("____________________________________________________________");
    }
}
