package gameView;

import pieces.*;
import engine.*;
import level.*;
import gameView.*;
import userInterfaceController.*;

import java.lang.Exception;
import java.lang.Math;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.transform.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.stage.*;
import javafx.scene.transform.*;

public class MultiGameView extends GameView{
   
   public void start( Stage primaryStage ) throws Exception 
   {
 	  primaryStage.setResizable(false);
      //primaryStage.setScene( createScene() );
      Scene scene = createScene();
      primaryStage.setScene(scene);
      primaryStage.show();
      //System.out.println(GameView.levelX);
      
      MultiGameEngine game = new MultiGameEngine("level1", 0 ,"p1", "p2" );
      //GameEngine game = new GameEngine(GameView.levelX, 0 );
      
      //GameEngine game = new GameEngine( );
      primaryStage.addEventHandler( KeyEvent.KEY_PRESSED, event -> {
      switch (event.getCode()) {
        case UP:
          game.movement(0);
          break;
        case DOWN:
          game.movement(1);
          break;
        case LEFT:
          game.movement(2);
          break;
        case RIGHT:
          game.movement(3);
          break;
        case Q:
          game.movement(4);
          break;
        case E:
          game.movement(5);
          break;         
        case D:
          game.movement(6);
          break;
        case W:
          game.movement(7);
          break;
        case S:
          game.movement(8);
          break;
        case A:
          game.movement(9);
          break;
        case C:
          game.movement(10);
          break;
        case Z:
          game.movement(11);
          break;
        case TAB:
          game.movement(12);
          break;
         case X:
          game.movement(13);
         break;
         case O:
         try {
         primaryStage.close(); 
		        
        Stage stage = new Stage();
        stage.setTitle("UNIFICATION");
        
		Main main = new Main();
		main.start(stage);
		} catch (Exception e) { e.printStackTrace(); }
      }
      
      try {
		if(game.isFinish()) {
		primaryStage.close(); 
		        
        Stage stage = new Stage();
        stage.setTitle("UNIFICATION");
        
		Main main = new Main();
		main.start(stage);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    });
      
   }
}
