import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Nami {
    private static ArrayList<Tasks> tasks = new ArrayList<>();
    private static int taskCount = 0;
    private static Storage storage = new Storage("./data/duke.txt");

    public static void main(String[] args) throws DukeException, IOException {
        Scanner sc = new Scanner(System.in);
        tasks = storage.load();

        System.out.println("____________________________________________________________\n");
        System.out.println(" Hello! I'm Nami\n");
        System.out.println("What can I do for you?\n");
        System.out.println("____________________________________________________________\n");

        while (true) {
            String input = sc.nextLine();

            if(input.equalsIgnoreCase( "bye")) {
                System.out.println("____________________________________________________________\n");
                System.out.println(" Bye. Hope to see you again soon!\n");
                System.out.println("____________________________________________________________");
                break;
            }

            if(input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________\n");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + ". " + tasks.get(i).getList());
                }
                System.out.println("\n____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("mark")) {
                String num_Str = input.substring(5).trim();
                int num = Integer.parseInt(num_Str);
                tasks.get(num - 1).markAsDone();
                storage.save(tasks);
                System.out.println("____________________________________________________________\n");
                System.out.println("Nice! I have marked this task as done:\n");
                System.out.println("[X] " + tasks.get(num - 1).getDescription());
                System.out.println("____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("unmark")) {
                String num_Str = input.substring(7).trim();
                int num = Integer.parseInt(num_Str);
                tasks.get(num - 1).unmarkAsDone();
                storage.save(tasks);
                System.out.println("____________________________________________________________\n");
                System.out.println("OK, I've marked this task as not done yet:\n");
                System.out.println("[] " + tasks.get(num - 1).getDescription());
                System.out.println("____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("todo")) {
                String result = input.substring(5).trim();
                if(result.isEmpty()) {
                    throw new DukeException("OOPS!!! the description of a todo cannot be empty.");
                }
                tasks.add(new toDo(result));
                storage.save(tasks);
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks.get(tasks.size() - 1).getResult());
                System.out.println("Now you have " + tasks.size() + " tasks in this list.");
                System.out.println("____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("deadline")) {
                String[] parts = input.split("/by");
                String result = parts[0].substring(9).trim();
                String deadline = parts[1].trim();
                tasks.add(new Deadlines(result, deadline));
                storage.save(tasks);
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks.get(tasks.size() - 1).getResult());
                System.out.println("Now you have " + tasks.size() + " tasks in this list.");
                System.out.println("____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("event")) {
                String[] part1 = input.split("/from");
                String result = part1[0].substring(6).trim();
                String[] part2 = part1[1].split("/to");
                String startDate = part2[0].trim();
                String endDate = part2[1].trim();
                System.out.println(startDate);


                tasks.add(new Events(result, startDate, endDate));
                storage.save(tasks);
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks.get(tasks.size() - 1).getResult());
                System.out.println("Now you have " + tasks.size() + " tasks in this list.");
                System.out.println("____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("delete")) {
                String num_Str = input.substring(7).trim();
                int num = Integer.parseInt(num_Str);
                System.out.println("____________________________________________________________\n");
                System.out.println("Noted. I've remove this task:");
                System.out.println("[X] " + tasks.get(num - 1).getResult());
                System.out.println("____________________________________________________________");
                tasks.remove(num - 1);
                storage.save(tasks);
                continue;
            }

            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");

        }
        sc.close();
    }
}
