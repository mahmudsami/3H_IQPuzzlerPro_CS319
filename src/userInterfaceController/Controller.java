package userInterfaceController;

import gameView.*;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.net.URL;
import javafx.geometry.Pos;

public class Controller {


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

//    private void musicAction(){
//        AudioClip[] music;
//        AudioClip current;
//        String[] musicNames;
//
//        URL url1, url2, url3, url4, url5, url6,url7, url8;
//        url1 = url2 = url3 = url4 = url5 = url6 = url7 = url8 = null;
//        try
//        {
//            url1 = new URL ("file", "localhost", "musics\\Uzeyir_Mehdizade-Sene_ne.wav");
//            url2 = new URL ("file", "localhost", "musics\\Hey_Brother.wav");
//            url3 = new URL ("file", "localhost", "musics\\Je_Veux.wav");
//            url4 = new URL ("file", "localhost", "musics\\The_Mamas_The_Papas.wav");
//            url5 = new URL ("file", "localhost", "musics\\Dream_is_Collapsing_Hans_Zimmer.wav");
//            url6 = new URL ("file", "localhost", "musics\\eightiesJam.wav");
//            url7 = new URL ("file", "localhost", "musics\\hitchcock.wav");
//            url8 = new URL ("file", "localhost", "musics\\classical.wav");
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//
//        music = new AudioClip[9];
//        music[0] = null;  // Corresponds to "Make a Selection..."
//        music[1] = JApplet.newAudioClip (url1);
//        music[2] = JApplet.newAudioClip (url2);
//        music[3] = JApplet.newAudioClip (url3);
//        music[4] = JApplet.newAudioClip (url4);
//        music[5] = JApplet.newAudioClip (url5);
//        music[6] = JApplet.newAudioClip (url6);
//        music[7] = JApplet.newAudioClip (url7);
//        music[8] = JApplet.newAudioClip (url8);
//
//        musicNames = new String[] {"...", "Uzeyir Mehdizade - Sene ne",
//                "Avicii - Hey Brother", "Zaz - Je Veux", "California Dreamin - The Mamas & The Papas",
//                "Dream is Collapsing - Hans Zimmer", "Alfred Hitchcock's Theme"};
//
//        current = music[5];
//        current.loop();
//
//    }

    // This code part uses for AWT object and Swing object.
    private void createAndSetSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SettingsMenuu settingsMenuu = new SettingsMenuu();
                swingNode.setContent((settingsMenuu.returnPanel()));
            }
        });
    }

    @FXML
    private void settingsButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SettingsScreen.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Sound Settings");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
//        final SwingNode swingNode = new SwingNode();
//        createAndSetSwingContent(swingNode);
//
//        StackPane pane = new StackPane();
//        pane.getChildren().add(swingNode);
//        stage.setScene(new Scene(pane, 800, 600));
//        stage.show();

        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void mainButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

        Stage stage = new Stage();
        stage.setTitle("UNIFICATION");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void createButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CreateLevel.fxml"));

        Stage stage = new Stage();
        stage.setTitle("CREATION MODE");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

//        final SwingNode swingNode = new SwingNode();
//        createAndSetSwingContent(swingNode);
//
//        StackPane pane = new StackPane();
//        pane.getChildren().add(swingNode);
//        stage.setScene(new Scene(pane, 800, 600));
//        stage.show();

        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void levelsClicked(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Levels.fxml"));

        Stage stage = new Stage();
        stage.setTitle("UNIFICATION");
        stage.setScene(new Scene(root, 800, 600));
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
    private void achievementScoresButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AchievementsHighScores.fxml"));

        Stage stage = new Stage();
        stage.setTitle("High Scores");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void quitButtonAction(ActionEvent event) throws Exception {

        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    // Mahmud oyun buradaki grid panele eklenecek!
    @FXML
    private void playSinglePlayerButtonAction(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("PlayingGameScreen.fxml"));

        
        Stage stage = new Stage();
        stage.setTitle("UNIFICATION");
        stage.setScene(new Scene(root, 1024, 500));
        
        GameView game = new GameView();
        game.start( stage );
        stage.show();

        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void multiplayerButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MultiplayerScreen.fxml"));

        Stage stage = new Stage();
        stage.setTitle("UNIFICATION");
        stage.setScene(new Scene(root, 800, 600));


        stage.show();
        // Hide this current window (if this is what you want)
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
}
