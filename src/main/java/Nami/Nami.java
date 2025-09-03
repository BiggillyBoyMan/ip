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
/**
 * Entry point and coordinator for the Nami task manager.
 * Wires {@code Ui}, {@code Storage}, and {@code TaskList}, then runs the CLI loop.
 */
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

    /**
     * Starts the read–eval–print loop: reads input, parses into a command, executes it,
     * and exits when a terminating command is issued.
     */
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

    /**
     * Program entry point. Delegates to {@link #run()} and handles fatal startup errors.
     */
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
//
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            String input = sc.nextLine();

//            if(input.equalsIgnoreCase( "bye")) {
//                System.out.println("____________________________________________________________\n");
//                System.out.println(" Bye. Hope to see you again soon!\n");
//                System.out.println("____________________________________________________________");
//                break;
//            }

//            if(input.equalsIgnoreCase("list")) {
//                System.out.println("____________________________________________________________\n");
//                for (int i = 0; i < tasks.size(); i++) {
//                    System.out.println(i + 1 + ". " + tasks.get(i).getList());
//                }
//                System.out.println("\n____________________________________________________________");
//                continue;
//            }

//            if(input.toLowerCase().startsWith("mark")) {
//                String num_Str = input.substring(5).trim();
//                int num = Integer.parseInt(num_Str);
//                tasks.get(num - 1).markAsDone();
//                storage.save(tasks);
//                System.out.println("____________________________________________________________\n");
//                System.out.println("Nice! I have marked this task as done:\n");
//                System.out.println("[X] " + tasks.get(num - 1).getDescription());
//                System.out.println("____________________________________________________________");
//                continue;
//            }

//            if(input.toLowerCase().startsWith("unmark")) {
//                String num_Str = input.substring(7).trim();
//                int num = Integer.parseInt(num_Str);
//                tasks.get(num - 1).unmarkAsDone();
//                storage.save(tasks);
//                System.out.println("____________________________________________________________\n");
//                System.out.println("OK, I've marked this task as not done yet:\n");
//                System.out.println("[] " + tasks.get(num - 1).getDescription());
//                System.out.println("____________________________________________________________");
//                continue;
//            }

//            if(input.toLowerCase().startsWith("todo")) {
//                String result = input.substring(5).trim();
//                if(result.isEmpty()) {
//                    throw new DukeException("OOPS!!! the description of a todo cannot be empty.");
//                }
//                tasks.add(new toDo(result));
//                storage.save(tasks);
//                System.out.println("____________________________________________________________");
//                System.out.println("Got it. I've added this task:");
//                System.out.println(tasks.get(tasks.size() - 1).getResult());
//                System.out.println("Now you have " + tasks.size() + " tasks in this list.");
//                System.out.println("____________________________________________________________");
//                continue;
//            }
//
//            if(input.toLowerCase().startsWith("deadline")) {
//                try {
//                    String[] parts = input.split("/by");
//                    if (parts.length < 2) {
//                        throw new DukeException("OOPS!!! The deadline must have a /by date/time.");
//                    }
//
//                    String description = parts[0].substring(9).trim();
//                    String deadlineStr = parts[1].trim();
//
//                    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
//                    LocalDateTime deadline = LocalDateTime.parse(deadlineStr, inputFormat);
//
//                    tasks.add(new Deadlines(description, deadline));
//                    storage.save(tasks);
//
//                    System.out.println("____________________________________________________________");
//                    System.out.println("Got it. I've added this task:");
//                    System.out.println(tasks.get(tasks.size() - 1).getResult());
//                    System.out.println("Now you have " + tasks.size() + " tasks in this list.");
//                    System.out.println("____________________________________________________________");
//                } catch (DateTimeParseException e) {
//                    System.out.println("OOPS!!! Please enter the date/time in the format: d/M/yyyy HHmm");
//                }
//                continue;
//            }

//            if(input.toLowerCase().startsWith("event")) {
//                try {
//                    String[] part1 = input.split("/from");
//                    String result = part1[0].substring(6).trim();
//                    String[] part2 = part1[1].split("/to");
//                    String startDate = part2[0].trim();
//                    String endDate = part2[1].trim();
//
//                    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
//                    LocalDateTime start = LocalDateTime.parse(startDate, inputFormat);
//                    LocalDateTime end = LocalDateTime.parse(endDate, inputFormat);
//
//                    tasks.add(new Events(result, start, end));
//                    storage.save(tasks);
//
//                    System.out.println("____________________________________________________________");
//                    System.out.println("Got it. I've added this task:");
//                    System.out.println(tasks.get(tasks.size() - 1).getResult());
//                    System.out.println("Now you have " + tasks.size() + " tasks in this list.");
//                    System.out.println("____________________________________________________________");
//                    continue;
//                } catch (DateTimeParseException e){
//                    System.out.println("OOPS!!! Please enter the date and time in the format dd/mm/yyyy HHMM");
//                }
//            }

//            if(input.toLowerCase().startsWith("delete")) {
//                String num_Str = input.substring(7).trim();
//                int num = Integer.parseInt(num_Str);
//                System.out.println("____________________________________________________________\n");
//                System.out.println("Noted. I've removed this task:");
//                System.out.println("[X] " + tasks.get(num - 1).getResult());
//                System.out.println("____________________________________________________________");
//                tasks.remove(num - 1);
//                storage.save(tasks);
//                continue;
//            }

//            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
//
//        }
//        sc.close();
//    }
//}
