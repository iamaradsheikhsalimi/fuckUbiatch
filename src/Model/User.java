package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private UserPreferences userPreferences;
    public static ArrayList<User> allUsers = new ArrayList<>();
    private String username;
    private String password;
    private String maxScore;


    public User(String username, String password, String maxScore) {
        this.username = username;
        this.password = password;
        this.maxScore = maxScore;
        this.userPreferences = new UserPreferences(3, new ArrayList<Map>());
    }

    public UserPreferences getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(ArrayList<User> allUsers) {
        User.allUsers = allUsers;
    }

    public static void addUser(User user) {
        allUsers.add(user);
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void saveUsersInFile() {
        File file = new File("src/database/Users.txt");
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.write("");
            for (User user : allUsers) {
                String info = user.getUsername() + "##" + user.getPassword() + "##" + user.getMaxScore();
                writer.write(info);
                if (!user.equals(allUsers.get(allUsers.size() - 1))) {
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadUsers() {
        allUsers.clear();
        File file = new File("src/database/Users.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("##");
                User user = new User(data[0], data[1], data[2]);
                allUsers.add(user);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
