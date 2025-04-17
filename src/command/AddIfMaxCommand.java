package command;

import manager.CollectionManager;
import manager.CommandManager;
import product.LabWork;
import util.Reciever;

import static util.LabWorkCreater.createLabWork;

public class AddIfMaxCommand implements BaseCommand {

    @Override
    public String getName() {
        return "add_if_max";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }

    @Override
    public String execute(CollectionManager manager, Reciever reciever, String[] args, CommandManager commandManager) {
        if (args.length < 1) {
            return "Ошибка: не указан элемент. Использование: add_if_max {element}";
        }

        LabWork newLabWork = createLabWork(manager);//новый
        if (newLabWork == null) {
            return "Ошибка: не удалось создать элемент.";
        }

        return reciever.addIfMax(manager, newLabWork);//максимален?
    }
}