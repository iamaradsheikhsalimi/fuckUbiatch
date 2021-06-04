package View;

import Controller.UserController;
import Model.User;
import jdk.jfr.internal.tool.Main;

import java.util.Scanner;

public class MainMenuHandler {
    private static final Scanner scanner = Application.scanner;

    static void run() {
        String inputCommand;
        try {
            while (true) {
                System.out.println("please enter one of this commands");
                System.out.println("1 too see scoreboard");
                System.out.println("2 for change your password");
                System.out.println("3 for delete your account");
                System.out.println("4 for game settings");
                System.out.println("5 for play game");
                System.out.println("6 for log out");
                inputCommand = scanner.nextLine();
                if (Validator.stringIsNumber(inputCommand)) {
                    int menuNumber = Integer.parseInt(inputCommand);
                    switch (menuNumber) {
                        case 1:
//                            showScoreboard();
                            break;
                        case 2:
                            changePasswordRun();
                            break;
                        case 3:
                            deleteAccount();
                            break;
                        case 4:
//                            gameSettings();
                            break;
                        case 5:
//                             playGame();
                            break;
                        case 6:
                            logoutUser();
                        default:
                            System.out.println("number should be between 1 and 6");

                    }
                } else {
                    System.out.println("invalid command");
                }
            }

        } catch (Exception e) {
            if (e.getMessage().equals("back to welcome menu")) {
                Application.run();
            } else if (e.getMessage().equals("back")) {
                MainMenuHandler.run();
            } else if (e.getMessage().equals("delete account")) {
                Application.run();
            }

        }
    }

    private static void deleteAccount() throws Exception {
        Util.deleteUser();
    }

    private static void changePasswordRun() throws Exception {
        while (true) {
            String password = Util.changePassword();
            UserController.editUserPassword(password);
            break;
        }
        System.out.println("password changed successfully");
    }


    private static void logoutUser() throws Exception {
        UserController.logoutUser();
        System.out.println("logged out successfully");
        throw new Exception("back to welcome menu");
    }
}


