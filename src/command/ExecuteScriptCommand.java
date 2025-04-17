package command;

import manager.CollectionManager;
import manager.CommandManager;
import util.Reciever;
import product.*;
import info.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.Stack;

public class ExecuteScriptCommand implements BaseCommand {
    private static final Stack<File> fileStack = new Stack<>();

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла.";
    }

    @Override
    public String execute(CollectionManager manager, Reciever receiver, String[] args, CommandManager commandManager) {
        if (args.length < 1) {
            return "Ошибка: Не указан путь к файлу скрипта.";
        }

        String path = args[0];
        File file = new File(path);

        if (fileStack.contains(file)) {
            return "Ошибка: Обнаружена рекурсия. Файл уже выполняется.";
        }
        fileStack.push(file);

        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] commandParts = line.split(" ", 2);
                String command = commandParts[0];

                if ("add".equals(command) || "update".equals(command)) {
                    LabWork labWork = readLabWorkFromScript(scanner);
                    if (labWork != null) {
                        if ("add".equals(command)) {
                            manager.getCollection().add(labWork);
                            result.append("Добавлен новый элемент: ").append(labWork.getName()).append("\n");
                        } else {
                            result.append("Обновлен элемент: ").append(labWork.getName()).append("\n");
                        }
                    } else {
                        result.append("Ошибка: Не удалось создать LabWork из скрипта.\n");
                    }
                } else {
                    String commandResult = commandManager.doCommand(line, manager, receiver);// обработка через команд менеджер
                    result.append(commandResult).append("\n");
                }
            }
        } catch (FileNotFoundException e) {
            return "Ошибка: Файл скрипта не найден: " + path;
        } catch (Exception e) {
            return "Ошибка при выполнении скрипта: " + e.getMessage();
        } finally {
            fileStack.pop(); // удаление файла из стека
        }

        return result.toString();
    }

    private LabWork readLabWorkFromScript(Scanner scanner) {
        try {
            LabWork labWork = new LabWork();

            labWork.setId(Long.parseLong(scanner.nextLine().trim()));
            labWork.setName(scanner.nextLine().trim());

            Coordinates coordinates = new Coordinates();
            coordinates.setX(Integer.parseInt(scanner.nextLine().trim()));
            coordinates.setY(Integer.parseInt(scanner.nextLine().trim()));
            labWork.setCoordinates(coordinates);

            labWork.setMinimalPoint(Float.parseFloat(scanner.nextLine().trim()));
            labWork.setMaxPoint(Float.parseFloat(scanner.nextLine().trim()));
            labWork.setDifficulty(Difficulty.valueOf(scanner.nextLine().trim()));

            Person author = new Person();
            author.setName(scanner.nextLine().trim());
            author.setWeight(Integer.parseInt(scanner.nextLine().trim()));
            author.setEyeColor(EyeColor.valueOf(scanner.nextLine().trim()));
            author.setHairColor(HairColor.valueOf(scanner.nextLine().trim()));
            author.setNationality(Country.valueOf(scanner.nextLine().trim()));

            Location location = new Location();
            location.setX(Float.parseFloat(scanner.nextLine().trim()));
            location.setY(Double.parseDouble(scanner.nextLine().trim()));
            location.setZ(Float.parseFloat(scanner.nextLine().trim()));
            author.setLocation(location);

            labWork.setAuthor(author);
            labWork.setCreationDate(ZonedDateTime.now());

            return labWork;
        } catch (Exception e) {
            System.err.println("Ошибка при чтении LabWork из скрипта: " + e.getMessage());
            return null;
        }
    }
}