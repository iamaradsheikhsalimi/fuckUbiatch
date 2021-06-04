package View;

import Controller.UserController;
import Controller.Validator;

import java.util.Scanner;

public class LoginHandler {
    private static final Scanner scanner = Application.scanner;

    static void run() {
        String inputCommand;
        try {
            while (true) {
                System.out.println("please enter one of this commands");
                System.out.println("1 for login");
                System.out.println("2 for back");
                inputCommand = scanner.nextLine();
                if (Validator.stringIsNumber(inputCommand)) {
                    int menuNumber = Integer.parseInt(inputCommand);
                    switch (menuNumber) {
                        case 1:
                            loginRun();
                            break;
                        case 2:
                            throw new Exception("back");
                        default:
                            System.out.println("number should be between 1 and 2");

                    }
                } else {
                    System.out.println("invalid command");
                }
            }

        } catch (Exception e) {

        }
    }


    private static void loginRun() {
        System.out.println("please enter your username:");
        String username;
        while (true) {
            username = scanner.nextLine();
            if (!UserController.isUsernameExists(username)) {
                System.out.println("there are no users with this username, try again");
                continue;
            }
            break;
        }
        System.out.println("please enter your password");
        while (true) {
            String password = scanner.nextLine();
            if (!UserController.validateIdentity(username, password)) {
                System.out.println("invalid password, try again");
                continue;
            }
            UserController.setLoggedInUser(username);
            break;
        }
        MainMenuHandler.run();
    }
}
