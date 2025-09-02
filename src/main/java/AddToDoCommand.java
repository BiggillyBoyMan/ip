public class AddToDoCommand extends Command {
    private final String description;
    public AddToDoCommand(String description) {
        this.description = description;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (description == null || description.isEmpty()) {
            throw new DukeException("the description of a todo cannot be empty.");
        }
        Tasks t = new toDo(description);
        tasks.add(t);
        storage.save(tasks.asList());

        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println(t.getResult());
        System.out.println("Now you have " + tasks.size() + " tasks in this list.");
        System.out.println("____________________________________________________________");
    }
}
