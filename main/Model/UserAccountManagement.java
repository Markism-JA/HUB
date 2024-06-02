package main.Model;
import main.Model.DataManager.*;
import main.Model.User.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserAccountManagement {
    private List<User> users;

    public UserAccountManagement(List<User> users) {
        this.users = users;
    }

    public UserAccountManagement(String username, String password) {
        //TODO Auto-generated constructor stub
    }

    public void registerUser(String username, String password) {
        // Check if the username already exists
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                return;
            }
        }

        // Create and add new user
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }

    public void loginUser(String username, String password) {
        // Check if the username and password match
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    public void saveUserPreferences(User user, UserPreferences preferences) {
        // Implementation of saving user preferences
        user.setPreferences(preferences);
        System.out.println("User preferences saved successfully!");
    }
}