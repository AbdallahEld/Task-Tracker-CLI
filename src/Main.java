import Domain.Task;

void main() {
    IO.println(String.format("Hello and welcome!"));
    List<Task> tasks = new ArrayList<Task>();


    String command = "";

    while (!command.equals("exit"))
    {
        IO.println("type command: add, update, delete, list, exit");

        command = IO.readln();
        if(command.equals("add")){
            IO.println(String.format("Type Task Name"));
            String taskName = IO.readln();
            Task newTask = new Task();
            newTask.description = taskName;
            tasks.add(newTask);
            IO.println(String.format("Tasks Added!!"));
        }

        else if (command.equals("update"))
        {
            IO.println(String.format("Type Task Name To Search for it"));
            String taskName = IO.readln();
            tasks.stream()
                    .filter(t -> t.description.equals(taskName))
                    .findFirst()
                    .ifPresentOrElse(
                            t ->
                            {
                                IO.println(String.format("Type New Task Name"));
                                String newTaskName = IO.readln();
                                t.setDescription(newTaskName);
                            },
                            () ->
                            {
                                IO.println(String.format("Not Found"));
                            }
                    );
        }
        else if (command.equals("delete"))
        {
            IO.println(String.format("Type Task Name To Search for it"));
            String taskName = IO.readln();
            tasks.stream()
                    .filter(t -> t.description.equals(taskName))
                    .findFirst()
                    .ifPresentOrElse(
                            t ->
                            {
                                tasks.remove(t);
                            },
                            () ->
                            {
                                IO.println(String.format("Not Found"));
                            }
                    );
        }
        else if (command.equals("list"))
        {
            for (Task task : tasks)
            {
                IO.println(task.description);
            }
            IO.println(String.format("Tasks Retrieved!!"));
        }
        else
        {
            IO.println("unknown command try again");
        }
    }

    IO.println("Program Exit");

}
