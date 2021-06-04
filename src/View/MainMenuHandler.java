package View;

import Controller.UserController;
import Controller.Validator;
import Model.User;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MainMenuHandler {
    private static final Scanner scanner = Application.scanner;
    private static User username = UserController.getLoggedInUser();
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
            }
        }
    }

    private static void deleteAccount() {
        try{
            Util.deleteUsername(username);
        }
        catch (Exception e){
            if (e.getMessage().equals("delete account"))
                Application.run();
            if (e.getMessage().equals("back")){

            }
        }
    }

    private static void changePasswordRun() throws Exception {
        try {
            while (true) {
                String password = Util.changePassword(username.getUsername());
                UserController.editUserPassword(username.getUsername(), password);
                break;
            }
            System.out.println("password changed successfully");
        }
        catch (Exception e){
        }
    }

    private static void logoutUser() throws Exception {
        UserController.logoutUser();
        System.out.println("logged out successfully");
        throw new Exception("back to welcome menu");
    }
}
