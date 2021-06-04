package View;

import java.util.Scanner;

public class Application {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("welcome");
        Application.run();
    }

    static void run() {
        String inputCommand;
        try {
            while (true) {
                System.out.println("*** type back or follow instructions whenever you want to go to last menu ***");
                System.out.println("please enter one of this commands");
                System.out.println("1 for register");
                System.out.println("2 for login");
                System.out.println("3 for login as a guest");
                System.out.println("4 for exit");

                inputCommand = scanner.nextLine();
                if (Validator.stringIsNumber(inputCommand)) {
                    int menuNumber = Integer.parseInt(inputCommand);
                    switch (menuNumber) {
                        case 1:
                            RegisterHandler.run();
                            break;
                        case 2:
                            LoginHandler.run();
                            break;
                        case 3:
                            GuestMainMenuHandler.run();
                        case 4:
                            throw new Exception("exit");
                        default:
                            System.out.println("number should be between 1 and 3");
                    }
                }
                else {
                    System.out.println("invalid command");
                }
            }

        }
        catch (Exception e) {
            System.out.println("exited successfully");
            System.exit(0);
        }
    }
}
