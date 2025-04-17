package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;

public class AddCommand implements BaseCommand{
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию";
    }

    @Override
    public String execute(CollectionManager manager, Reciever reciever, String[] args, CommandManager commandManager) {
        return reciever.addLabWork(manager);
    }
}
