package View.MapSettings;

import Controller.MapController;
import View.Application;
import View.MainMenuHandler;
import View.Validator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class DefaultMapHandler {
    private static final Scanner scanner = Application.scanner;

    public static void run() {
        String inputCommand;
        try {
            while (true) {
                System.out.println("please enter one of this commands");
                System.out.println("1 for see and select maps");
                System.out.println("2 for back");
                inputCommand = scanner.nextLine();
                if (Validator.stringIsNumber(inputCommand)) {
                    int menuNumber = Integer.parseInt(inputCommand);
                    switch (menuNumber) {
                        case 1:
                            showAndSelect();
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
                ChooseMapHandler.run();
            }
        }
    }

    private static void showAndSelect() throws Exception {
        ArrayList<String> defaultMaps = MapController.getDefaultMaps();
        System.out.println("choose one of these maps or enter back" + "\n");
        for (int i = 0; i < defaultMaps.size(); i++) {
            String[] printString = defaultMaps.get(i).split("###");
            System.out.println();
            System.out.println(printString[0]);
            System.out.println("Map Id: " + printString[1]);
        }
        String inputCommand;
        System.out.println("enter map Id:");
        while (true) {
            inputCommand = scanner.nextLine();
            if (inputCommand.equals("back")) {
                throw new Exception("back");
            }
            if (Validator.stringIsNumber(inputCommand)) {
                String response = MapController.addUserPreferredMap(inputCommand);
                if (response.equals("success")) {
                    System.out.println("map added successfully");
                    break;
                } else {
                    System.out.println("wrong map Id");
                }
            } else {
                System.out.println("there are no maps with this id");
            }
        }
    }
}
