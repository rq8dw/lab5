package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;

public interface BaseCommand {
    String getName();
    String getDescription();
    String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager);
}
