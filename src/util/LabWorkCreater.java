package util;

import info.*;
import manager.CollectionManager;
import product.LabWork;
import product.Person;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LabWorkCreater {






    public static LabWork createLabWork(CollectionManager manager) {
        LabWork product = new LabWork();
        Scanner scanner = new Scanner(System.in);

        long id = generateSequentialId(manager);
        product.setId(id);

        String name = " ";
        while (true) {
            System.out.println("Введите название лабораторной работы: ");
            try {
                name = scanner.nextLine();
                if (!name.isEmpty()) {
                    break;
                }

            }
            catch (NoSuchElementException e ) {
                System.exit(0);
            } catch ( Exception e) {
                System.out.println(e.getMessage());
            }
        }
        product.setName(name);

        Coordinates coordinates = new Coordinates();

        while (true) {
            System.out.println("Введите координаты X " + product.getName() + ": ");
            try {
                coordinates.setX(Integer.parseInt(scanner.nextLine()));
                break;
            } catch(NoSuchElementException e ){
                System.exit(0);
            } catch(Exception e){
                System.out.println("Введите корректное число");
            }


        }
        while (true) {
            System.out.println("Введите координаты Y " + product.getName() + ": ");
            try {
                coordinates.setY(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Введите корректное число");
            }
        }
        product.setCoordinates(coordinates);


        float minimalPoint = 0;
        while (true) {
            System.out.println("Введите минимальный балл для " + product.getName() + ": ");
            try {
                minimalPoint = Float.parseFloat(scanner.nextLine());
                if (minimalPoint > 0) {
                    break;
                }
            } catch (NoSuchElementException e ) {
                System.exit(0);

            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число");
            }
        }
        product.setMinimalPoint(minimalPoint);

        float maxPoint = 0;
        while (true) {
            System.out.println("Введите максимальный балл для " + product.getName() + ": ");
            try {
                maxPoint = Float.parseFloat(scanner.nextLine());
                if (maxPoint > 0) {
                    break;
                }
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число");
            }
        }
        product.setMaxPoint(maxPoint);

        Difficulty difficulty;
        while (true) {
            System.out.println("Введите сложность работы (VERY_EASY, NORMAL, VERY_HARD, INSANE): ");
            String difficultyInput = scanner.nextLine();
            try {
                difficulty = Difficulty.valueOf(difficultyInput);
                product.setDifficulty(difficulty);
                System.out.println("Сложность успешно установлена: " + difficulty);
                break;
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: введена некорректная сложность. Введите один из вариантов: VERY_EASY, NORMAL, VERY_HARD, INSANE.");
            }
        }
        product.setDifficulty(difficulty);


        Person author = new Person();
        while (true) {
            System.out.println("Введите имя автора работы: ");
            try {
                name = scanner.nextLine();
                if (!name.isEmpty()) {
                    break;
                }
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        author.setName(name);
        while (true) {
            System.out.println("Введите вес автора: ");
            try {
                author.setWeight(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println("Введите корректное число");
            }
        }
        while (true) {
            System.out.println("Введите цвет глаз автора (GREEN, RED, BLUE, ORANGE, BROWN): ");
            String eyeColorInput = scanner.nextLine();
            try {
                EyeColor eyeColor = EyeColor.valueOf(eyeColorInput);
                author.setEyeColor(eyeColor);
                System.out.println("Цвет глаз успешно установлен: " + eyeColor);
                break;
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: введен некорректный цвет глаз. Введите один из вариантов: GREEN, RED, BLUE, ORANGE, BROWN.");
            }
        }
        while (true) {
            System.out.println("Введите цвет волос автора (BLACK, YELLOW, WHITE): ");
            String hairColorInput = scanner.nextLine();
            try {
                HairColor hairColor = HairColor.valueOf(hairColorInput);
                author.setHairColor(hairColor);
                System.out.println("Цвет волос успешно установлен: " + hairColorInput);
                break;
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: введен некорректный цвет волос. Введите один из вариантов: BLACK, YELLOW, WHITE.");
            }
        }
        while (true) {
            System.out.println("Введите страну автора (FRANCE, SPAIN, ITALY, RUSSIA, GERMANY): ");
            String NationalityInput = scanner.nextLine();
            try {
                Country country = Country.valueOf(NationalityInput);
                author.setNationality(country);
                System.out.println("Страна успешно установлен: " + NationalityInput);
                break;
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: введена некорректная страна. Введите один из вариантов: vFRANCE, SPAIN, ITALY, RUSSIA, GERMANY.");
            }
        }
        Location location = new Location();
        while (true) {
            System.out.println("Введите координаты X для " + author.getName() + ": ");
            try {
                location.setX(Float.parseFloat(scanner.nextLine()));
                break;
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Введите корректное число");
            }
        }
        while (true) {
            System.out.println("Введите координаты Y для " + author.getName() + ": ");
            try {
                location.setY(Double.parseDouble(scanner.nextLine()));
                break;
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Введите корректное число");
            }
        }
        while (true) {
            System.out.println("Введите координаты Z для " + author.getName() + ": ");
            try {
                location.setZ(Float.parseFloat(scanner.nextLine()));
                break;
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Введите корректное число");
            }
        }
        author.setLocation(location);

        product.setAuthor(author);

        product.setCreationDate(ZonedDateTime.now());

        return product;
    }


    private static long generateSequentialId(CollectionManager manager) {
        long maxId = manager.getCollection().stream()
                .mapToLong(LabWork::getId)
                .max()
                .orElse(0);

        return maxId + 1;
    }
}
