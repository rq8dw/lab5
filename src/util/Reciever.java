package util;


import info.*;
import manager.CollectionManager;
import product.*;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static util.LabWorkCreater.createLabWork;

public class Reciever {

    public String showProducts(CollectionManager manager) {
        String labs = "";
        for (LabWork labWork : manager.getCollection()) {
            labs += labWork.getId() + " " + labWork.getName() + " " +labWork.getCoordinates() + " " + labWork.getCreationDate() + " " + labWork.getMinimalPoint() + " " + labWork.getMaxPoint() + " " + labWork.getDifficulty() + " " + labWork.getAuthor() + "\n";
        }
        return labs;
    }

    public String addLabWork(CollectionManager manager) {
        LabWork labWork = createLabWork(manager);
        manager.getCollection().add(labWork);
        return "Элемент был успешно добавлен";
    }




    public String updateLabWork(CollectionManager manager) {
        Scanner scanner = new Scanner(System.in);

        long id;
        while (true) {
            System.out.println("Введите id элемента, который хотите обновить: ");
            try {
                id = Long.parseLong(scanner.nextLine());
                if (id > 0) {
                    break;
                }
            } catch (NoSuchElementException e ) {
                System.exit(0);
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число");
            }
        }

        LabWork labWorkToUpdate = null;
        for (LabWork labWork : manager.getCollection()) {
            if (labWork.getId() == id) {
                labWorkToUpdate = labWork;
                break;
            }
        }

        if (labWorkToUpdate == null) {
            return "Элемент с id " + id + " не найден.";
        }

        System.out.println("Найден элемент: " + labWorkToUpdate.getName());

        LabWork uplabwork = createLabWork(manager);

        labWorkToUpdate.setName(uplabwork.getName());
        labWorkToUpdate.setCoordinates(uplabwork.getCoordinates());
        labWorkToUpdate.setMinimalPoint(uplabwork.getMinimalPoint());
        labWorkToUpdate.setMaxPoint(uplabwork.getMaxPoint());
        labWorkToUpdate.setDifficulty(uplabwork.getDifficulty());
        labWorkToUpdate.setAuthor(uplabwork.getAuthor());



        return "Элемент с id " + id + " успешно обновлен.";
    }

    public String removeLabWorkById(CollectionManager manager, long id) {
        return manager.removeLabWorkById(id);
    }

    public String addIfMax(CollectionManager manager, LabWork labWork) {
        return manager.addIfMax(labWork);
    }

    public String addIfMin(CollectionManager manager, LabWork labWork) {
        return manager.addIfMin(labWork);
    }
}



