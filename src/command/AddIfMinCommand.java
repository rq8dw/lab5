package command;

import manager.CollectionManager;
import manager.CommandManager;
import product.LabWork;
import util.Reciever;

import static util.LabWorkCreater.createLabWork;

public class AddIfMinCommand implements BaseCommand {

    @Override
    public String getName() {
        return "add_if_min";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        if (args.length < 1) {
            return "Ошибка: не указан элемент. Использование: add_if_min {element}";
        }

        LabWork newLabWork = createLabWork(manager);
        if (newLabWork == null) {
            return "Ошибка: не удалось создать элемент.";
        }
        return receiver.addIfMin(manager, newLabWork);
    }
}