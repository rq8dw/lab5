package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;


public class RemoveAllByMinimalPointCommand implements BaseCommand {
    @Override
    public String getName() {
        return "remove_all_by_minimal_point";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, значение поля minimalPoint которого эквивалентно заданному";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        if (args.length < 1) {
            return "Ошибка: Не указан аргумент minimalPoint.";
        }

        try {
            float minimalPoint = Float.parseFloat(args[0]); // Парсим аргумент в число
            int initialSize = manager.getCollection().size();

            manager.getCollection().removeIf(labWork -> labWork.getMinimalPoint() == minimalPoint);

            int removedCount = initialSize - manager.getCollection().size();
            return "Удалено элементов: " + removedCount;
        } catch (NumberFormatException e) {
            return "Ошибка: Аргумент minimalPoint должен быть числом.";
        }
    }
}