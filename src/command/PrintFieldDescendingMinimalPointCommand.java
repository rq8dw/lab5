package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;
import product.LabWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintFieldDescendingMinimalPointCommand implements BaseCommand {
    @Override
    public String getName() {
        return "print_field_descending_minimal_point";
    }

    @Override
    public String getDescription() {
        return "вывести значения поля minimalPoint всех элементов в порядке убывания";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        if (manager.getCollection().isEmpty()) {
            return "Коллекция пуста.";
        }

        List<Float> minimalPoints = new ArrayList<>();
        for (LabWork labWork : manager.getCollection()) {
            minimalPoints.add(labWork.getMinimalPoint());
        }

        minimalPoints.sort(Collections.reverseOrder());

        StringBuilder result = new StringBuilder("Значения поля minimalPoint в порядке убывания:\n");
        for (Float minimalPoint : minimalPoints) {
            result.append(minimalPoint).append("\n");
        }

        return result.toString();
    }
}