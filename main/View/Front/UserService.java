package main.View.Front;

import main.Model.DataManager;
import main.Model.User;
import main.Model.UserAccountManagement;

public class UserService {
    private static UserService instance;
    private DataManager dataManager;
    private UserAccountManagement userAccountManagement;
    private User currentUser;

    private UserService(DataManager dataManager) {
        this.dataManager = dataManager;
        this.userAccountManagement = new UserAccountManagement(dataManager.getUsers());
    }

    public static UserService getInstance(DataManager dataManager) {
        if (instance == null) {
            instance = new UserService(dataManager);
        }
        return instance;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public UserAccountManagement getUserAccountManagement() {
        return userAccountManagement;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
