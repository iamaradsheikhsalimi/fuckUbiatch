package View.MapSettings;

import Controller.MapController;
import Controller.UserController;
import View.MapSettings.*;
import View.Application;
import View.Validator;
import sun.awt.X11.XInputMethod;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


public class ChooseMapHandler {
    private static final Scanner scanner = Application.scanner;

    public static void run() {
        String inputCommand;
        try {
            while (true) {
                System.out.println("please enter one of this commands");
                System.out.println("1 for choose from default map");
                System.out.println("2 for see random map and choose it");
                System.out.println("3 for see preferred maps and choose it");
                System.out.println("4 for back");
                inputCommand = scanner.nextLine();
                if (Validator.stringIsNumber(inputCommand)) {
                    int menuNumber = Integer.parseInt(inputCommand);
                    switch (menuNumber) {
                        case 1:
                            chooseDefaultMap();
                            break;
                        case 2:
                            chooseRandomMap();
                            break;
                        case 3:
                            seeAndChoosePreferredMap();
                            break;
                        case 4:
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

    private static void seeAndChoosePreferredMap() throws Exception {
        ArrayList<String> userMaps = UserController.getUserPreferredMaps();
        ArrayList<String> mapIds = new ArrayList<>();
        for (String mapData : userMaps) {
            String[] splitData = mapData.split("###");
            System.out.println();
            System.out.println(splitData[0]);
            System.out.println();
            System.out.println("map Id: " + splitData[1]);
            mapIds.add(splitData[1]);
        }
        while (true) {
            System.out.println("enter map Id to select it to your default map");
            String input = scanner.nextLine();

            if (mapIds.contains(input)) {
                UserController.selectMapWithId(input);
                System.out.println("map selected successfully");
                break;
            } else if (input.equals("back")) {
                throw new Exception("back");
            } else {

                System.out.println("wrong map Id");
                System.out.println("try again");
            }
        }
    }

    private static void chooseRandomMap() throws Exception {
        while (true) {
            String[] splitData = MapController.getRandomMap().split("###");
            System.out.println(splitData[0]);
            System.out.println();
            System.out.println("if you want to add this map to you preferred maps type \"confirm\" of \"choose again\" for see another random map");
            String input = scanner.nextLine();
            if (input.equals("back")) {
                throw new Exception("back");
            } else if (input.equals("confirm")) {
                MapController.addToUserPreferredMap(splitData[1]);
                System.out.println("map added successfully");
                break;
            } else if (input.equals("choose another")) {
                System.out.println("here you are");
            } else {
                break;
            }
        }


    }

    private static void chooseDefaultMap() {
        DefaultMapHandler.run();
    }
}
