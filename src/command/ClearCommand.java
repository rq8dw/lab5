package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;


public class ClearCommand implements BaseCommand {
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "Очищает коллекцию.";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        manager.clearCollection(); // Предположим, что в CollectionManager есть метод clearCollection
        return "Коллекция успешно очищена.";
    }
}

