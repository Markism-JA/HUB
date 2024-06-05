package main.Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Base64;

public class User extends CSVUtil {
    private String username;
    private String password;
    private UserPreferences preferences;

    public User(String username, String password, UserPreferences preferences) {
        this.username = username;
        this.password = hashPassword(password);
        this.preferences = preferences != null ? preferences : null;  // Set to null if not provided
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(UserPreferences preferences) {
        this.preferences = preferences;
    }

    // Hash password using SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", preferences=" + preferences + "]";
    }

    public static List<User> readUsersFromCSV(String fileName) {
        return readFromCSV(fileName, data -> {
            String[] prefs = data[2].split(";");
            UserPreferences preferences = new UserPreferences(prefs[0], prefs[1], prefs[2], prefs[3], Integer.parseInt(prefs[4]), Integer.parseInt(prefs[5]), prefs[6]);
            return new User(data[0], data[1], preferences);
        });
    }

    public String toCSVString() {
        return String.join(",", username, password, preferences.toCSVString());
    }

    public static void writeUserToCSV(String fileName, List<User> users) {
        writeToCSV(fileName, users, User::toCSVString);
    }
}
