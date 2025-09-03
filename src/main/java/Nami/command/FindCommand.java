package Nami.command;
import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.exception.DukeException;
import java.util.ArrayList;
public class FindCommand extends Command {
    private final String Keyword;

    public FindCommand(String Keyword) {
        this.Keyword = Keyword;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if(Keyword == null || Keyword.isBlank()) {
            throw new DukeException("Please provide a keyword to find");
        }
        String word = Keyword.toLowerCase();

        ArrayList<Tasks> matches = new ArrayList<>();
        for(int i =0; i < tasks.size(); i++) {
            Tasks t = tasks.get(i);
            if(t.getDescription().toLowerCase().contains(word)) {
                matches.add(t);
            }
        }

        System.out.println("____________________________________________________________");
        if(matches.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for(int i = 0; i < matches.size(); i++) {
                System.out.println((i + 1) + ". " + matches.get(i).getList());
            }
        }
        System.out.println("____________________________________________________________");
    }
}
