package main.Model;

import java.util.List;

public class UserAccountManagement {
    private List<User> users;

    public UserAccountManagement(List<User> users) {
        this.users = users;
    }

    public void registerUser(String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        int newUserID = getNextUserID();

        // Create and add new user with null preferences
        User newUser = new User(newUserID, username, password, null);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }

    public  boolean loginUser(String username, String password) {      
        // Check if the username and hashed password match
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void saveUserPreferences(User user, UserPreferences preferences) {
        user.setPreferences(preferences);
        System.out.println("User preferences saved successfully!");
    }

    public void saveUsersToCSV(String fileName) {
        User.writeUserToCSV(fileName, users);
    }

    public boolean isUsernameTaken(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private int getNextUserID() {
        int maxUserID = 0;
        for (User user : users) {
            if (user.getId() > maxUserID) {
                maxUserID = user.getId();
            }
        }
        return maxUserID + 1;
    }
}
