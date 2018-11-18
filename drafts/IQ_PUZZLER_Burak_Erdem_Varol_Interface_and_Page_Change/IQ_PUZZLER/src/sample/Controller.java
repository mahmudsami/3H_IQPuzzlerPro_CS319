package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
public class Controller {
    @FXML
    private Button Play;


    @FXML
    private void playButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Play.fxml"));

            Stage stage = new Stage();
            stage.setTitle("Play");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void mainButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

        Stage stage = new Stage();
        stage.setTitle("IQ Puzzle Game");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void createButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CreateLevel.fxml"));

        Stage stage = new Stage();
        stage.setTitle("How To Play");
        stage.setScene(new Scene(root, 800, 700));
        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void levelsClicked(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Levels.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Levels");
        stage.setScene(new Scene(root, 800, 700));
        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }


    @FXML
    private void creditsButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CreditsTo.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Credits To");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void howToButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HowToPlay.fxml"));

        Stage stage = new Stage();
        stage.setTitle("How To Play");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }



    @FXML
    private void achievenmtScoresButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AchievementsHighScores.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Achievements and High Scores");
        stage.setScene(new Scene(root, 800, 700));
        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
    @FXML
    private void quitButtonAction(ActionEvent event) throws Exception {

        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
}
