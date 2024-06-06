package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class LoginController {
    private MainApp mainApp;
    private DataManager dataManager;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }
}
