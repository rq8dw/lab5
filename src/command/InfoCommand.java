package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;

import java.time.LocalDateTime;

public class InfoCommand implements BaseCommand{
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции";
    }

    @Override
    public String execute(CollectionManager manager, Reciever reciever, String[] args, CommandManager commandManager) {
        System.out.println("Время: " + LocalDateTime.now());
        System.out.println("Количество элементов: " + manager.getCollection().size());
        return "";
    }
}
