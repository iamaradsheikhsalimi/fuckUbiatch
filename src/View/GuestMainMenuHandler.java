package View;
import java.util.Scanner;

public class GuestMainMenuHandler {
    private static final Scanner scanner = Application.scanner;
    static void run() {
        String inputCommand;
        try {
            while (true) {
                System.out.println("please enter one of this commands");
                System.out.println("1 too see scoreboard");
                System.out.println("2 for game settings");
                System.out.println("3 for play game");
                System.out.println("4 for log out");
                inputCommand = scanner.nextLine();
                if (Validator.stringIsNumber(inputCommand)) {
                    int menuNumber = Integer.parseInt(inputCommand);
                    switch (menuNumber) {
                        case 1:
//                            showScoreboard();
                            break;
                        case 2:
//                            gameSettings();
                            break;
                        case 3:
//                             playGame();
                            break;
                        case 4:
                            logoutGuest();
                        default:
                            System.out.println("number should be between 1 and 4");

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

    private static void logoutGuest() throws Exception{
        System.out.println("logged out successfully");
        throw new Exception("back to welcome menu");
    }
}
