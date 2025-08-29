import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Tasks> load() {
        ArrayList<Tasks> tasks = new ArrayList<>();
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs(); // create ./data if missing
                file.createNewFile(); // create duke.txt if missing
                return tasks;
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(" \\| ");

                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                switch (type) {
                    case "T":
                        Tasks todo = new toDo(description);
                        if (isDone) todo.markAsDone();
                        tasks.add(todo);
                        break;
                    case "D":
                        String deadline = parts[3];
                        Tasks d = new Deadlines(description, deadline);
                        if (isDone) d.markAsDone();
                        tasks.add(d);
                        break;
                    case "E":
                        String start = parts[3];
                        String end = parts[4];
                        Tasks e = new Events(description, start, end);
                        if (isDone) e.markAsDone();
                        tasks.add(e);
                        break;
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return tasks;
    }

    public void save(ArrayList<Tasks> tasks) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // ensure folder exists

            FileWriter fw = new FileWriter(filePath);
            for (Tasks t : tasks) {
                fw.write(t.toStorageFormat() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
