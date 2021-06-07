package View;

import java.util.Scanner;

import Controller.UserController;
import View.MapSettings.*;

public class GameSettingsHandler {

    private static final Scanner scanner = Application.scanner;

    public static void run() {
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
                            GameSettingsHandler.choosePacmanLife();
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
                MainMenuHandler.run();
            }
            else if (e.getMessage().equals("back to game settings")){
                GameSettingsHandler.run();
            }
        }
    }

    private static void choosePacmanLife() throws Exception {
        System.out.println("witch life would you prefer for pacman(default life is 3)");
        System.out.println("2   3   4   5");
        String input;
        while (true){
            input = scanner.nextLine();
            if (input.equals("back"))
                throw new Exception("back to game settings");
            else if (Validator.stringIsNumber(input)){
                if (Integer.parseInt(input) >= 2 && Integer.parseInt(input) <= 5){
                    UserController.setPacmanLife(input);
                    System.out.println("pacman life changed successfully");
                    break;
                }
                else
                    System.out.println("pacman life should be between 2 and 5 try again");
            }
            else {
                System.out.println("invalid command try again");
            }
        }
    }
}
