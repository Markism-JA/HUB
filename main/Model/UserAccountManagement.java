package main.Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

public class UserAccountManagement {
    private List<User> users;

    public UserAccountManagement(List<User> users) {
        this.users = users;
    }

    public void registerUser(String username, String password) {
        // Check if the username already exists
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                return;
            }
        }

        // Create and add new user with preferences
        User newUser = new User(username, password, null);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }

    public boolean loginUser(String username, String password) {

      

        // Check if the username and hashed password match
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    public void saveUserPreferences(User user, UserPreferences preferences) {
        // Save user preferences
        user.setPreferences(preferences);
        System.out.println("User preferences saved successfully!");
    }

    public void saveUsersToCSV(String fileName) {
        User.writeUserToCSV(fileName, users);
    }
}
