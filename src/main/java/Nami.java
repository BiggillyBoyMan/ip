import java.util.Scanner;

public class Nami {


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

            System.out.println("____________________________________________________________");
            System.out.println(" " + input);
            System.out.println("____________________________________________________________");
        }
        sc.close();
    }
}
