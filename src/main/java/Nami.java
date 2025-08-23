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
                    System.out.println(i + ". [" + tasks[i].getStatusIcon() + "] " + tasks[i].getDescription());
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

            tasks[taskCount]  = new Tasks(input);
            taskCount++;
            System.out.println("____________________________________________________________");
            System.out.println("added " + input);
            System.out.println("____________________________________________________________");

        }
        sc.close();
    }
}
