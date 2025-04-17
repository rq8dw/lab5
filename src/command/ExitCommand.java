package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;

public class ExitCommand implements BaseCommand {

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Завершить программу (без сохранения в файл)";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        System.out.println("Завершение программы");
        System.exit(0);
        return "";
    }
}