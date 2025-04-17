package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;

public class UpdateIdCommand implements BaseCommand {

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "Обновить значение элемента коллекции, id которого равен заданному. Использование: update id {element}";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        // Логика выполнения команды
        return receiver.updateLabWork(manager);
    }
}