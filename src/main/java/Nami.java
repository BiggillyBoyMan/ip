import java.util.Scanner;

public class Nami {
    private static Tasks[] tasks = new Tasks[100];
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
                for(int i = 0; i < taskCount; i++) {
                    System.out.println(tasks[i].getList());
                }
                System.out.println("\n____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("mark")) {
                String num_Str = input.substring(5).trim();
                int num = Integer.parseInt(num_Str);
                tasks[num].markAsDone();
                System.out.println("____________________________________________________________\n");
                System.out.println("Nice! I have marked this task as done:\n");
                System.out.println("[X] " + tasks[num].getDescription());
                System.out.println("____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("unmark")) {
                String num_Str = input.substring(7).trim();
                int num = Integer.parseInt(num_Str);
                tasks[num].unmarkAsDone();
                System.out.println("____________________________________________________________\n");
                System.out.println("OK, I've marked this task as not done yet:\n");
                System.out.println("[] " + tasks[num].getDescription());
                System.out.println("____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("todo")) {
                String result = input.substring(5).trim();
                tasks[taskCount] = new toDo(result);
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1].getResult());
                System.out.println("Now you have " + taskCount + " tasks in this list.");
                System.out.println("____________________________________________________________");
                continue;
            }

            if(input.toLowerCase().startsWith("deadline")) {
                String[] parts = input.split("/by");
                String result = parts[0].substring(9).trim();
                String deadline = parts[1].trim();
                tasks[taskCount] = new Deadlines(result, deadline);
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1].getResult());
                System.out.println("Now you have " + taskCount + " tasks in this list.");
                System.out.println("____________________________________________________________");
            }

            if(input.toLowerCase().startsWith("event")) {
                String[] part1 = input.split("/from");
                String result = part1[0].substring(6).trim();
                String[] part2 = part1[1].split("/to");
                String startDate = part2[0].trim();
                String endDate = part2[1].trim();
                System.out.println(startDate);


                tasks[taskCount] = new Events(result, startDate, endDate);
                taskCount++;

                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1].getResult());
                System.out.println("Now you have " + taskCount + " tasks in this list.");
                System.out.println("____________________________________________________________");
            }
        }
        sc.close();
    }
}
