package Model;

import java.io.*;
import java.util.ArrayList;

public class UserDataAccess {
    public static void saveUsers(ArrayList<User> users) {
        try {
            OutputStream outputStream = new FileOutputStream("src/Database/users.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(users);
            objectOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            System.out.println("can't save users");
        }
    }
    public static ArrayList<User> loadUsers() {
        try {
            InputStream inputStream = new FileInputStream("src/Database/users.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            ArrayList<User> users = (ArrayList<User>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
            return users;

        } catch (Exception e) {
            System.out.println("can not load users");
            return new ArrayList<User>();
        }
    }
}
