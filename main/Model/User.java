package main.Model;

import java.util.List;

import main.Model.CSVUtil;

public class User extends CSVUtil {
  private String username;
  private String password;

  public User(String username, String password) {
  this.username = username;
  this.password = password;
  }

  public String getUserName() {
  return username;
  }

  public String getPassword() {
  return password;
  }

  //hash password
  private String hashPassword(String password) {

  }

  @Override
  public String toString() {
      return "User [username=" + username + ", password=" + password + "]";
      }

  public static List<User> readUsersFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new User(data[0], data[1]));
  }
}