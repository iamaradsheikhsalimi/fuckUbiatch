package View;

import java.util.Scanner;
import View.MapSettings.*;

public class GameSettingsHandler {

    private static final Scanner scanner = Application.scanner;

    static void run() {
        String inputCommand;
        try {
            while (true) {
                System.out.println("please enter one of this commands");
                System.out.println("1 for choose map");
                System.out.println("2 for change pacman lives");
                System.out.println("3 for back");
                inputCommand = scanner.nextLine();
                if (Validator.stringIsNumber(inputCommand)) {
                    int menuNumber = Integer.parseInt(inputCommand);
                    switch (menuNumber) {
                        case 1:
                            ChooseMapHandler.run();
                            break;
                        case 2:
                            throw new Exception("back");
                        case 3:
                            throw new Exception("back");
                        default:
                            System.out.println("number should be between 1 and 2");

                    }
                } else {
                    System.out.println("invalid command");
                }
            }

        } catch (Exception e) {
            if (e.getMessage().equals("back")) {
                Application.run();
            }
        }
    }




}
