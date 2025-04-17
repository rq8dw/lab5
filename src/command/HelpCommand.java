package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;

import java.util.Map;

public class HelpCommand implements BaseCommand {

    private final Map<String, BaseCommand> commands;

    public HelpCommand(Map<String, BaseCommand> commands) {
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Вывести справку по доступным командам";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        StringBuilder helpMessage = new StringBuilder("Доступные команды:\n");

        for (Map.Entry<String, BaseCommand> entry : commands.entrySet()) {
            helpMessage.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue().getDescription())
                    .append("\n");
        }

        return helpMessage.toString();
    }
}
