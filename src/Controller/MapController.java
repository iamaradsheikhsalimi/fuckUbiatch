package Controller;
import Model.Map;

import java.util.ArrayList;

public class MapController {

    public static Map createMap() {
        Map map = new Map(MapController.getAllMaps().size());
        Map.addMap(map);
        return map;
    }

    public static ArrayList<String> getAllMaps() {
        ArrayList<String> allMaps = new ArrayList<>();
        for (Map map : Map.getAllMaps()) {
            allMaps.add(map.toString());
        }
        return allMaps;
    }
}
