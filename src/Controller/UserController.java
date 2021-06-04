package Controller;

import Model.Map;
import Model.User;

import java.util.ArrayList;

public class UserController {

    private static User loggedInUser = null;

    public static void editUserPassword(String password) {
        loggedInUser.setPassword(password);
    }

    public static void saveUser(String username, String password, String maxScore) {
        User user = new User(username, password, maxScore);
        User.addUser(user);
//        User.saveUsersInFile();
    }

    public static boolean isUsernameExists(String username) {
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateIdentity(String username, String password) {
        for (User user: User.getAllUsers()){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public static boolean validateLoggedInUserIdentity(String password) {
        if (loggedInUser.getPassword().equals(password)){
            return true;
        }
        return false;
    }


    public static User getLoggedInUser() {
        return loggedInUser;
    }


    public static void setLoggedInUser(String username) {
        loggedInUser = getUserWithUsername(username);
    }

    public static void logoutUser() {
        loggedInUser = null;
    }

    private static User getUserWithUsername(String username) {
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void deleteLoggedInUser() {
        User.allUsers.remove(loggedInUser);
//        User.saveUsersInFile();
        loggedInUser = null;
    }


    public static ArrayList<String> getUserPreferredMaps() {
        ArrayList<String> maps = new ArrayList<>();
        for (Map map: loggedInUser.getUserPreferences().getPreferredMaps()){
            maps.add(map.toString());
        }
        return maps;
    }

    public static void selectMapWithId(String mapId) {
        Map map = MapController.getMapWithId(mapId);
        loggedInUser.getUserPreferences().setSelectedMap(map);
    }
}