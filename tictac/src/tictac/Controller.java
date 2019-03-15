package tictac;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The Controller class sets up and controls the window and other conditions necessary
 * for the application and its subclasses.
 */

public abstract class Controller{
    @FXML
    public Pane rootPane;
    /**
     * Close the window.
     */
    public void close(){
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

}
