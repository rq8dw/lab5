package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;

public class ShowCommand implements BaseCommand{
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        return receiver.showProducts(manager);
    }
}
