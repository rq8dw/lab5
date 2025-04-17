package command;

import manager.CollectionManager;
import manager.CommandManager;
import product.LabWork;
import util.Reciever;

import java.util.ArrayList;

import static util.LabWorkCreater.createLabWork;

public class RemoveGreaterCommand implements BaseCommand {

    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }

    @Override
    public String execute(CollectionManager manager, Reciever reciever, String[] args, CommandManager commandManager) {
        if (args.length != 0) {
            return "Ошибка: не указан элемент. Использование: remove_greater {element}";
        }

        LabWork comparisonLabWork = createLabWork(manager);
        if (comparisonLabWork == null) {
            return "Ошибка: не удалось создать элемент для сравнения.";
        }
        ArrayList<Long> idForRemove = new ArrayList<>();
        for (LabWork labWork: manager.getCollection()){
            if (comparisonLabWork.compareTo(labWork) < 0 ){
                idForRemove.add(labWork.getId());
            }
        }
        for (Long id: idForRemove){
            reciever.removeLabWorkById(manager, id);
        }

        return " ";
    }
}