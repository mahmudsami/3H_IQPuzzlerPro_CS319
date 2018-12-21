package userInterfaceController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("IQ Puzzle Game");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }

    public static void playClicked(String[] args) {
        launch(args);
    }
    public static void main(String[] args) {
        launch(args);
    }
}