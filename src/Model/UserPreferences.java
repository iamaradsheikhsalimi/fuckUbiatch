package Model;

import java.util.ArrayList;

public class UserPreferences {
    private int packmanLives;
    private ArrayList<Map> preferredMaps;

    public UserPreferences(int packmanLives, ArrayList<Map> preferredMaps) {
        this.packmanLives = packmanLives;
        this.preferredMaps = new ArrayList<>();
        for (Map map : preferredMaps) {
            this.preferredMaps.add(map);
        }
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
