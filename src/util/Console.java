package util;

import manager.CollectionManager;
import manager.CommandManager;

import java.util.Scanner;

public class Console {
    private final CommandManager commandManager;
    private final CollectionManager collectionManager;
    private final Reciever reciever;

    public Console() {
        commandManager = new CommandManager();
        collectionManager = new CollectionManager();
        reciever = new Reciever();
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            String out = commandManager.doCommand(input, collectionManager, reciever);
            System.out.println(out);
        }
    }
}
