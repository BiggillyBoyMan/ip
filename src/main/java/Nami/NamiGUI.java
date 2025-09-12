package Nami;

import Nami.command.Command;
import Nami.exception.DukeException;
import Nami.parser.Parser;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class NamiGUI {
    private final Storage storage;
    private final TaskList tasks;
    private boolean exit;
    private final Ui ui;

    /**
     * Constructor for NamiGUI Class
     * @throws IOException
     */
    public NamiGUI() throws IOException {
        this.ui = new Ui();
        storage = new Storage("./data/duke.txt");
        ArrayList<Tasks> loaded = storage.load();
//        assert loaded != null : "Storage.load() must return a non-null list";
        tasks = new TaskList(loaded);
    }

    /**
     * gets the response when user inputs a command
     * @param input
     * @return
     */
    public String getResponse(String input) {
        try {
            Command cmd = Parser.parse(input);
            String msg = cmd.execute(tasks, ui,storage);   // <-- get message directly
            exit = cmd.isExit();
            return msg;
        } catch (DukeException e) {
            return "☹ OOPS!!! " + e.getMessage();
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }

    public boolean shouldExit() { return exit; }
}
