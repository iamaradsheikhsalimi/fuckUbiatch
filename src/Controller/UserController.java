package Controller;

import Model.User;

public class UserController {

    private static User loggedInUser = null;

    public static void editUserPassword(String username, String password) {
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                user.setPassword(password);
                break;
            }
        }
    }

    public static void saveUser(String username, String password, String maxScore) {
        User user = new User(username, password, maxScore);
        User.addUser(user);
        User.saveUsersInFile();
    }

    public static boolean isUsernameExists(String username) {
        boolean isTaken = false;
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                isTaken = true;
                break;
            }
        }
        return isTaken;
    }

    public static boolean validateIdentity(String username, String password) {
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
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

    public static void deleteAccount(User username)throws Exception{
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username.getUsername()) && user.getPassword().equals(username.getPassword())){
                User.allUsers.remove(username);
                User.saveUsersInFile();
                System.out.println("account deleted successfully\n");
                throw new Exception("delete account");
            }
        }
    }
}