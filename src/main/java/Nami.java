import java.util.Scanner;

public class Nami {
    private static String[] tasks = new String[100];
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
                System.out.println("____________________________________________________________");
                for(int i = 0; i < taskCount; i++) {
                    System.out.println(i + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
                continue;
            }

            tasks[taskCount] = input;
            taskCount++;
            System.out.println("____________________________________________________________");
            System.out.println("added " + input);
            System.out.println("____________________________________________________________");

        }
        sc.close();
    }
}
