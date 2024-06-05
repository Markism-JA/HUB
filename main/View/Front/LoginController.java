package main.View.Front;

import javafx.fxml.FXML;
import main.Model.DataManager;
import main.View.Front.MainApp;

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
