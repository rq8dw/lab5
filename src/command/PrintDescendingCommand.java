package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;
import product.LabWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintDescendingCommand implements BaseCommand {
    @Override
    public String getName() {
        return "print_descending";
    }

    @Override
    public String getDescription() {
        return "вывести элементы коллекции в порядке убывания";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        if (manager.getCollection().isEmpty()) {
            return "Коллекция пуста.";
        }

        // Создаем копию коллекции для сортировки
        List<LabWork> sortedList = new ArrayList<>(manager.getCollection());
        // Сортируем в порядке убывания
        sortedList.sort(Collections.reverseOrder());

        // Формируем результат
        StringBuilder result = new StringBuilder("Элементы коллекции в порядке убывания:\n");
        for (LabWork labWork : sortedList) {
            result.append(labWork).append("\n");
        }

        return result.toString();
    }
}