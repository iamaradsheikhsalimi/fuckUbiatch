package Controller;
import Model.Map;
import Model.DefaultSettings;
import Model.User;

import javax.swing.*;
import java.util.ArrayList;

public class MapController {

    public static ArrayList<String> getDefaultMaps(){
        ArrayList<String> allMaps = new ArrayList<>();
        for (Map map : DefaultSettings.getDefaultMaps()) {
            allMaps.add(map.toString());
        }
        return allMaps;
    }

    public static Map createMap() {
        Map map = new Map();
        Map.addMap(map);
        return map;
    }

    public static void addToUserPreferredMap(String mapId) {
        boolean flag = false;
        for (Map map: UserController.getLoggedInUser().getUserPreferences().getPreferredMaps()) {
            if (map.getMapID() == Integer.parseInt(mapId)) {
                flag = true;
                break;
            }
        }
        if (flag) return;
        Map map = getMapById(mapId);
        UserController.getLoggedInUser().getUserPreferences().addMap(map);
    }

    private static Map getMapById(String mapId) {
        for (Map map: Map.getAllMaps()) {
            if (map.getMapID() == Integer.parseInt(mapId)) {
                return map;
            }
        }
        return null;
    }


    public static String addUserPreferredMap(String mapId) {
        for (Map map: DefaultSettings.getDefaultMaps()) {
            if (map.getMapID() == Integer.parseInt(mapId)) {
                addToUserPreferredMap(mapId);
                return "success";
            }
        }
        return "error";
    }

    public static String getRandomMap() {
        Map map = new Map();
        return map.toString();
    }

    public static Map getMapWithId(String mapId) {
        for (Map map: Map.getAllMaps()){
            if (map.getMapID() == Integer.parseInt(mapId)){
                return map;
            }
        }
        return null;
    }
}
