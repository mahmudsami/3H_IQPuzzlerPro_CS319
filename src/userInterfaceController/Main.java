package userInterfaceController;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

	public static int level = 0;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("IQ Puzzle Game");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        level++;

    }


    public static void main(String[] args) {
        launch(args);
    }
}
