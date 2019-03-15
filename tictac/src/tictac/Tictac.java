package tictac;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import java.lang.Exception;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.FileNotFoundException; 
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;

public class Tictac extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException,Exception{
 
        Parent root = FXMLLoader.load(getClass().getResource("/tictac/window.fxml"));
        primaryStage.setTitle("tictactoe");
        primaryStage.setScene(new Scene(root,600, 400));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
