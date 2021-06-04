package Model;

import Controller.MapController;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultSettings {
    private static final Map map1 = MapController.createMap();
    private static final Map map2 = MapController.createMap();
    private static final Map map3 = MapController.createMap();
    static ArrayList<Map> defaultMaps = new ArrayList<>(Arrays.asList(map1, map2, map3));

    public static ArrayList<Map> getDefaultMaps() {
        return defaultMaps;
    }

    public static int getPacmanLives() {
        return 3;
    }
}
