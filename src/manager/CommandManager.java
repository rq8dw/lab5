package manager;

import command.*;
import util.Reciever;

import java.util.HashMap;

public class CommandManager {
    private final HashMap<String, BaseCommand> commands;

    public CommandManager() {
        commands = new HashMap<>();
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("clear", new ClearCommand());
        commands.put("update", new UpdateIdCommand());
        commands.put("remove", new RemoveByIdCommand());
        commands.put("help", new HelpCommand(commands));
        commands.put("exit", new ExitCommand());
        commands.put("add_if_max", new AddIfMaxCommand());
        commands.put("add_if_min", new AddIfMinCommand());
        commands.put("remove_greater", new RemoveGreaterCommand());
        commands.put("remove_all_by_minimal_point", new RemoveAllByMinimalPointCommand());
        commands.put("print_descending", new PrintDescendingCommand());
        commands.put("print_field_descending_minimal_point", new PrintFieldDescendingMinimalPointCommand());
        commands.put("save", new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand());


    }

    public String doCommand(String input, CollectionManager collectionManager, Reciever reciever) {
        String[] parts = input.split(" ", 2); //разделение на команду и агрумент
        String commandName = parts[0];
        String[] args = parts.length > 1 ? parts[1].split(" ") : new String[0]; // Аргументы
        CommandManager manager = new CommandManager();
        if (commands.containsKey(commandName)) {
            return commands.get(commandName).execute(collectionManager, reciever, args, manager );
        } else {
            return "Неизвестная команда: " + commandName;
        }
    }
}