package manager;

import product.*;
import info.*;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

public class CollectionManager {
    private LinkedHashSet<LabWork> collection;
    private static final String ENV_VAR = "lab5_csv";
    private final String initTime;

    public CollectionManager() {
        this.collection = new LinkedHashSet<>();
        this.initTime = java.time.LocalDateTime.now().toString();
        loadFromFile();
    }

    // Загрузка из файла (вызывается автоматически в конструкторе)
    private void loadFromFile() {
        String path = getFilePath();
        if (path == null) return;

        try (Scanner scanner = new Scanner(new File(path))) {
            if (scanner.hasNextLine()) scanner.nextLine(); // Пропуск заголовка

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                if (data.length == 16) {
                    LabWork lab = parseLabWork(data);
                    if (lab != null) collection.add(lab);
                }
            }
            System.out.println("Коллекция загружена из " + path);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, создана новая коллекция");
        }
    }

    // Сохранение в файл
    public void saveToFile() {
        String path = getFilePath();
        if (path == null) return;

        try (PrintWriter writer = new PrintWriter(path)) {
            writer.println("id;name;coordinates_x;coordinates_y;creationDate;minimalPoint;maxPoint;"
                    + "difficulty;author_name;author_weight;author_eyeColor;author_hairColor;author_nationality;"
                    + "author_location_x;author_location_y;author_location_z");

            collection.forEach(lab -> writer.println(toCsvString(lab)));
            System.out.println("Коллекция сохранена в " + path);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    private String getFilePath() {
        String path = System.getenv(ENV_VAR);
        if (path == null || path.trim().isEmpty()) {
            System.err.println("Переменная окружения " + ENV_VAR + " не установлена");
            return null;
        }
        return path;
    }

    private LabWork parseLabWork(String[] data) {
        try {
            LabWork lab = new LabWork();
            Coordinates coords = new Coordinates();
            Person author = new Person();
            Location loc = new Location();

            // Установка основных полей
            lab.setId(Long.parseLong(data[0]));
            lab.setName(data[1]);

            coords.setX(Integer.parseInt(data[2]));
            coords.setY(Integer.parseInt(data[3]));
            lab.setCoordinates(coords);

            lab.setCreationDate(ZonedDateTime.parse(data[4]));
            lab.setMinimalPoint(Float.parseFloat(data[5]));
            lab.setMaxPoint(Float.parseFloat(data[6]));
            lab.setDifficulty(Difficulty.valueOf(data[7]));

            // Поля автора
            author.setName(data[8]);
            author.setWeight(Integer.parseInt(data[9]));
            author.setEyeColor(EyeColor.valueOf(data[10]));
            if (!data[11].isEmpty()) author.setHairColor(HairColor.valueOf(data[11]));
            author.setNationality(Country.valueOf(data[12]));

            // Локация
            loc.setX(Float.parseFloat(data[13]));
            loc.setY(Double.parseDouble(data[14]));
            loc.setZ(Float.parseFloat(data[15]));
            author.setLocation(loc);

            lab.setAuthor(author);
            return lab;
        } catch (Exception e) {
            System.err.println("Ошибка парсинга: " + e.getMessage());
            return null;
        }
    }

    private String toCsvString(LabWork lab) {
        Person a = lab.getAuthor();
        Location l = a.getLocation();

        return String.join(";",
                lab.getId().toString(),
                lab.getName(),
                lab.getCoordinates().getX().toString(),
                String.valueOf(lab.getCoordinates().getY()),
                lab.getCreationDate().toString(),
                String.valueOf(lab.getMinimalPoint()),
                String.valueOf(lab.getMaxPoint()),
                lab.getDifficulty().name(),
                a.getName(),
                String.valueOf(a.getWeight()),
                a.getEyeColor().name(),
                a.getHairColor().name(),
                a.getNationality().name(),
                String.valueOf(l.getX()),
                String.valueOf(l.getY()),
                String.valueOf(l.getZ())
        );
    }

    public LinkedHashSet<LabWork> getCollection() {
        return collection;
    }

    public void setCollection(LinkedHashSet<LabWork> collection) {
        this.collection = collection;
    }

    public void clearCollection() {
        collection.clear();
    }

    public String removeLabWorkById(long id) {
        if (collection.removeIf(lab -> lab.getId() == id)) {
            return "Элемент с id " + id + " успешно удален.";
        }
        return "Элемент с id " + id + " не найден.";
    }

    public String addIfMax(LabWork labWork) {
        if (collection.isEmpty()) {
            collection.add(labWork);
            return "Элемент добавлен (коллекция была пуста).";
        }

        LabWork max = Collections.max(collection);
        if (labWork.compareTo(max) > 0) {
            collection.add(labWork);
            return "Элемент добавлен.";
        }
        return "Элемент не добавлен - не является максимальным.";
    }

    public String addIfMin(LabWork labWork) {
        if (collection.isEmpty()) {
            collection.add(labWork);
            return "Элемент добавлен, так как коллекция была пуста.";
        }

        //минимальный элемент в коллекции
        LabWork minLabWork = collection.stream()
                .min(LabWork::compareTo)
                .orElse(null);

        if (minLabWork != null && labWork.compareTo(minLabWork) < 0) {
            collection.add(labWork);
            return "Элемент добавлен.";
        } else {
            return "Элемент не добавлен, так как его значение не меньше, чем у наименьшего элемента.";
        }
    }

}
