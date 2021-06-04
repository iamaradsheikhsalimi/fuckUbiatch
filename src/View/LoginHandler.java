package View;

import Controller.UserController;

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
                            MainMenuHandler.run();
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
            if (e.getMessage().equals("back")) {
                Application.run();
            }
        }
    }


    private static void loginRun() throws Exception {
        System.out.println("please enter your username:");
        String username;
        while (true) {
            username = scanner.nextLine();
            if (username.equals("back")){
                throw new Exception("back");
            }
            if (!UserController.isUsernameExists(username)) {
                System.out.println("there are no users with this username, try again");
                continue;
            }
            break;
        }
        System.out.println("please enter your password");
        while (true) {
            String password = scanner.nextLine();
            if (password.equals("back")){
                throw new Exception("back");
            }
            if (!UserController.validateIdentity(username, password)) {
                System.out.println("invalid password, try again");
                continue;
            }
            UserController.setLoggedInUser(username);
            break;
        }
    }
}
