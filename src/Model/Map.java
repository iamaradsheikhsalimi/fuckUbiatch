package Model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Map {

    private static ArrayList<Map> allMaps = new ArrayList<>();
    private String[][] currentMap;
    private int mapID;

    public static ArrayList<Map> getAllMaps() {
        return allMaps;
    }

    public static void addMap(Map map){
        allMaps.add(map);
    }

    public Map(int mapID) {
        this.mapID = mapID;
        this.currentMap = Map.generateMaze();
        allMaps.add(this);
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    private static void startDfsMethod(int i, int j, String[][] currentMap, boolean[][] checkedCells) {
        checkedCells[i][j] = true;
        int RandomNumber = (ThreadLocalRandom.current().nextInt() % 4), count = 0;
        if (RandomNumber < 0) RandomNumber -= RandomNumber;
        while (count < 4) {
            if (i - 2 >= 0 && RandomNumber == 0) {
                if (!checkedCells[i - 2][j]) {
                    currentMap[i - 1][j] = ",";
                    startDfsMethod(i - 2, j, currentMap, checkedCells);
                }
            } else if (j + 2 <= currentMap[0].length - 1 && RandomNumber == 1) {
                if (!checkedCells[i][j + 2]) {
                    currentMap[i][j + 1] = ",";
                    startDfsMethod(i, j + 2, currentMap, checkedCells);
                }
            } else if (i + 2 <= currentMap.length - 1 && RandomNumber == 2) {
                if (!checkedCells[i + 2][j]) {
                    currentMap[i + 1][j] = ",";
                    startDfsMethod(i + 2, j, currentMap, checkedCells);
                }
            } else if (j - 2 >= 0 && RandomNumber == 3) {
                if (!checkedCells[i][j - 2]) {
                    currentMap[i][j - 1] = ",";
                    startDfsMethod(i, j - 2, currentMap, checkedCells);
                }
            }
            count++;
            RandomNumber = (++RandomNumber) % 4;
        }
        for (int starIndex = 1; starIndex < currentMap.length; starIndex += 2) {
            for (int starSecondIndex = 1; starSecondIndex < currentMap[0].length; starSecondIndex += 2) {
                currentMap[starIndex][starSecondIndex] = ",";
            }
        }
    }

    public static String[][] generateMaze() {
        String[][] currentMap = new String[15][15];
        boolean[][] checkedCells = new boolean[15][15];
        for (int i = 0; i < currentMap.length; i++) {
            Arrays.fill(checkedCells[i], false);
            Arrays.fill(currentMap[i], "1");
        }
        for (int starIndex = 1; starIndex < currentMap.length; starIndex += 2) {
            for (int starSecondIndex = 1; starSecondIndex < currentMap[0].length; starSecondIndex += 2) {
                currentMap[starIndex][starSecondIndex] = "*";
            }
        }
        startDfsMethod(1, 1, currentMap, checkedCells);
        return currentMap;
    }

    public void printGeneratedMaze() {
        for (int i = 0; i < this.currentMap.length; i++) {
            for (int j = 0; j < this.currentMap[0].length; j++) {
                System.out.print(this.currentMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Map{" +
                "currentMap=" + Arrays.toString(currentMap) +
                ", mapID=" + mapID +
                '}';
    }

}