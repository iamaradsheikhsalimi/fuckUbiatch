package Model;
import Controller.MapController;
import java.util.ArrayList;

public class DefaultSettings {

    static ArrayList <Map> defaultMaps = new ArrayList<>();
    Map map1 = MapController.createMap();
    Map map2 = MapController.createMap();
    Map map3 = MapController.createMap();

    DefaultSettings.

    public static void addMap(Map map){
        defaultMaps.add(map);
    }

    public ArrayList<Map> getDefaultMaps() {
        return defaultMaps;
    }

    public static int getPacmanLives() {
        return 3;
    }
}
