package View;

import Controller.UserController;

import java.util.Scanner;

public class RegisterHandler {
    private static final Scanner scanner = Application.scanner;

    static void run() {
        try {
            String username = Util.getUsername();
            System.out.println();
            String password = Util.getPassword();
            System.out.println("registered successfully");
            UserController.saveUser(username, password, "");
        }
        catch (Exception e) {
            if (e.getMessage().equals("back")){
                Application.run();
            }
        }
    }
}
