package Model;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Map {

    private static final char[][] currentMap = new char[15][15];
    private static final boolean[][] checkedCells = new boolean[15][15];
    private int mapID;

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    private static void startDfsMethod(int i, int j) {
        checkedCells[i][j] = true;
        int RandomNumber = (ThreadLocalRandom.current().nextInt() % 4), count = 0;
        if (RandomNumber < 0) RandomNumber -= RandomNumber;
        while (count < 4) {
            if (i - 2 >= 0 && RandomNumber == 0) {
                if (!checkedCells[i - 2][j]) {
                    currentMap[i - 1][j] = '0';
                    startDfsMethod(i - 2, j);
                }
            } else if (j + 2 <= currentMap[0].length - 1 && RandomNumber == 1) {
                if (!checkedCells[i][j + 2]) {
                    currentMap[i][j + 1] = '0';
                    startDfsMethod(i, j + 2);
                }
            } else if (i + 2 <= currentMap.length - 1 && RandomNumber == 2) {
                if (!checkedCells[i + 2][j]) {
                    currentMap[i + 1][j] = '0';
                    startDfsMethod(i + 2, j);
                }
            } else if (j - 2 >= 0 && RandomNumber == 3) {
                if (!checkedCells[i][j - 2]) {
                    currentMap[i][j - 1] = '0';
                    startDfsMethod(i, j - 2);
                }
            }
            count++;
            RandomNumber = (++RandomNumber) % 4;
        }
    }

    public static void generateMaze() {
        for (int i = 0; i < currentMap.length; i++) {
            Arrays.fill(checkedCells[i], false);
            Arrays.fill(currentMap[i], '1');
        }
        for (int starIndex = 1; starIndex < currentMap.length; starIndex += 2) {
            for (int starSecondIndex = 1; starSecondIndex < currentMap[0].length; starSecondIndex += 2) {
                currentMap[starIndex][starSecondIndex] = '*';
            }
        }
        startDfsMethod(1, 1);
    }

    public static void printGeneratedMaze() {
        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[0].length; j++) {
                System.out.print(currentMap[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}