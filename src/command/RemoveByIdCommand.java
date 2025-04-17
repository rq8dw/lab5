package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;

public class RemoveByIdCommand implements BaseCommand {

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его id (использование: remove id)";
    }

    public String execute(CollectionManager manager, Reciever reciever, String[] args, CommandManager commandManager) {
        if (args.length < 1) {
            return "Ошибка: не указан id. Использование: remove id";
        }

        try {
            long id = Long.parseLong(args[0]);
            return reciever.removeLabWorkById(manager, id);
        } catch (NumberFormatException e) {
            return "Ошибка: id должен быть числом.";
        }
    }
}