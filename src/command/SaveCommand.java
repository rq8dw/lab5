package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;
import product.LabWork;

import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand implements BaseCommand {

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "Сохранить коллекцию в CSV-файл. Использование: save <имя_файла>";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        if (args.length < 1) {
            return "Ошибка: Не указано имя файла. Использование: save <имя_файла>";
        }

        String fileName = args[0];

        try (FileWriter writer = new FileWriter(fileName)) {
            // Заголовок CSV-файла
            writer.write("id;name;coordinates_x;coordinates_y;creationDate;minimalPoint;maxPoint;difficulty;author_name;author_weight;author_eyeColor;author_hairColor;author_nationality;author_location_x;author_location_y;author_location_z\n");

            // Запись данных
            for (LabWork labWork : manager.getCollection()) {
                String locationX = (labWork.getAuthor().getLocation() != null)
                        ? String.valueOf(labWork.getAuthor().getLocation().getX())
                        : ""; // или другое значение по умолчанию

                String locationY = (labWork.getAuthor().getLocation() != null)
                        ? String.valueOf(labWork.getAuthor().getLocation().getY())
                        : ""; // или другое значение по умолчанию

                String locationZ = (labWork.getAuthor().getLocation() != null)
                        ? String.valueOf(labWork.getAuthor().getLocation().getZ())
                        : ""; // или другое значение по умолчанию

                writer.write(String.join(";",
                        String.valueOf(labWork.getId()),
                        labWork.getName(),
                        String.valueOf(labWork.getCoordinates().getX()),
                        String.valueOf(labWork.getCoordinates().getY()),
                        labWork.getCreationDate().toString(),
                        String.valueOf(labWork.getMinimalPoint()),
                        String.valueOf(labWork.getMaxPoint()),
                        labWork.getDifficulty().toString(),
                        labWork.getAuthor().getName(),
                        String.valueOf(labWork.getAuthor().getWeight()),
                        labWork.getAuthor().getEyeColor().toString(),
                        labWork.getAuthor().getHairColor().toString(),
                        labWork.getAuthor().getNationality().toString(),
                        locationX,
                        locationY,
                        locationZ
                ) + "\n");
            }
            return "Коллекция успешно сохранена в CSV-файл: " + fileName;
        } catch (IOException e) {
            return "Ошибка: Не удалось сохранить коллекцию в файл. Причина: " + e.getMessage();
        }
    }
}