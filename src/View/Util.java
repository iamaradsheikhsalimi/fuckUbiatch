package View;

import Controller.UserController;
import Model.User;

import java.util.Scanner;

public class Util {

    static final Scanner scanner = Application.scanner;

    public static String getUsername() throws Exception {
        System.out.println("please enter your username");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("back")) {
                throw new Exception("back");
            }
            if (!UserController.isUsernameExists(input))
                return input;
            System.out.println("username is taken, try again");
        }
    }

    public static String getPassword() throws Exception {
        System.out.println("please enter your password");
        String firstAttemptPassword, finalPassword;

            firstAttemptPassword = scanner.nextLine();

            if (firstAttemptPassword.equals("back")) {
                throw new Exception("back");
            }

        System.out.println("confirm your current password");
        while (true) {
            finalPassword = scanner.nextLine();
            if (finalPassword.equals("back")) {
                throw new Exception("back");
            }
            if (finalPassword.equals(firstAttemptPassword))
                break;
            System.out.println("passwords does not match!");
        }
        return finalPassword;
    }

    public static String changePassword(String username) throws Exception {
            String currentPassword;
            System.out.println("please enter your current password");
            while (true) {
                currentPassword = scanner.nextLine();
                if (currentPassword.equals("back")) {
                    throw new Exception("back");
                }
                if (!UserController.validateIdentity(username, currentPassword)) {
                    System.out.println("invalid password, try again");
                    continue;
                }
                break;
            }
            System.out.println("please confirm your current password");
            while (true){
                String confirmCurrentPass = scanner.nextLine();
                if (confirmCurrentPass.equals("back")){
                    throw new Exception("back");
                }
                if (!currentPassword.equals(confirmCurrentPass)){
                    System.out.println("You didnt confirm your password correctly try again!");
                    continue;
                }
                break;
            }
            System.out.println("please enter your new password");
            String newPassword = scanner.nextLine();
            if (newPassword.equals("back")){
                throw new Exception("back");
            }
            return newPassword;
        }

    public static void deleteUsername(User username)throws Exception {
        String currentPassword;
        System.out.println("please enter your current password");
        while (true) {
            currentPassword = scanner.nextLine();
            if (currentPassword.equals("back")) {
                throw new Exception("back");
            }
            if (!UserController.validateIdentity(username.getUsername(), currentPassword)) {
                System.out.println("invalid password, try again");
                continue;
            }
            break;
        }
        System.out.println("please confirm your current password");
        while (true){
            String confirmCurrentPass = scanner.nextLine();
            if (confirmCurrentPass.equals("back")){
                throw new Exception("back");
            }
            if (!currentPassword.equals(confirmCurrentPass)){
                System.out.println("You didnt confirm your password correctly try again!");
                continue;
            }
            break;
        }
        System.out.println("if you are sure and you want to delete your account enter \"confirm\" or enter back if you regret");
        String input;
        while (true){
            input = scanner.nextLine();
            if (input.equals("back"))
                throw new Exception("back");
            if (input.equals("confirm"))
                break;
            System.out.println("invalid command");
        }
        UserController.deleteAccount(username);
    }
}
