package Model;

import java.util.ArrayList;

public class UserPreferences {
    private int packmanLives;
    private ArrayList<Map> preferredMaps;
    private Map selectedMap;

    public UserPreferences(int packmanLives, ArrayList<Map> preferredMaps, Map selectedMap) {
        this.packmanLives = packmanLives;
        this.preferredMaps = new ArrayList<>();
        for (Map map : preferredMaps) {
            this.preferredMaps.add(map);
        }
        this.selectedMap = selectedMap;
    }

    public Map getSelectedMap() {
        return selectedMap;
    }

    public void setSelectedMap(Map selectedMap) {
        this.selectedMap = selectedMap;
    }

    public void removeMap(Map map) {
        this.preferredMaps.remove(map);
    }

    public void addMap(Map map) {
        this.preferredMaps.add(map);
    }

    public int getPackmanLives() {
        return packmanLives;
    }

    public void setPackmanLives(int packmanLives) {
        this.packmanLives = packmanLives;
    }

    public ArrayList<Map> getPreferredMaps() {
        return preferredMaps;
    }

    public void setPreferredMaps(ArrayList<Map> preferredMaps) {
        this.preferredMaps = preferredMaps;
    }
}
