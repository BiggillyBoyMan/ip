package Nami;

import Nami.ui.Ui;
import Nami.storage.Storage;
import Nami.task.TaskList;
import Nami.task.Tasks;
import Nami.parser.Parser;
import Nami.command.Command;
import Nami.exception.DukeException;

import java.io.IOException;
import java.util.ArrayList;

public class Nami {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Nami(String filePath) throws IOException, DukeException {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        ArrayList<Tasks> loaded = storage.load();  // uses your existing Storage
        this.tasks = new TaskList(loaded);
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String input = ui.readCommand();
            try {
                Command cmd = Parser.parse(input);
                cmd.execute(tasks, ui, storage);
                isExit = cmd.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("Unexpected error: " + e.getMessage());
            }
        }
        ui.close();
    }

    public static void main(String[] args) {
        try {
            new Nami("./data/duke.txt").run();
        } catch (IOException e) {
            System.out.println("Failed to load/save tasks: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}

