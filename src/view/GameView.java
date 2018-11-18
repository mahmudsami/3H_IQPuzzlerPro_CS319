package view;
import control.GameEngine;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.transform.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.stage.*;



public class GameView extends Application
{
   public static Sphere[][][] nodes = new Sphere [GameEngine.HEIGHT][GameEngine.WIDTH][GameEngine.DEPTH]  ;
   
   public Scene createScene() {
      
      Group root = new Group();
      Scene all = new Scene( root ,1000, 1000);
      
      
      //-----------------------------------------------------------------------------
      PhongMaterial tempMaterial;
      //-----------------------------------------------------------------------------       
      
      for( int i = 0; i < GameEngine.HEIGHT; i++)
      {
         for( int j = 0; j < GameEngine.WIDTH; j++)
         {
            for( int k = 0; k < GameEngine.DEPTH; k++)
            {
               tempMaterial = new PhongMaterial();
               
               tempMaterial.setDiffuseColor(Color.BLUE);
               tempMaterial.setSpecularColor(Color.BLUE);
               
               nodes[i][j][k] = new  Sphere( 1.1 ); 
               root.getChildren().add( nodes[i][j][k]);
               nodes[i][j][k].setTranslateX( i );
               nodes[i][j][k].setTranslateY( j );
               nodes[i][j][k].setTranslateZ( k );
               
               nodes[i][j][k].setMaterial( tempMaterial);
               nodes[i][j][k].setDrawMode(DrawMode.FILL);
            }
         }
      }
      
      
      PerspectiveCamera camera = new PerspectiveCamera(true);
      camera.getTransforms().addAll (
                                     new Rotate(30, Rotate.X_AXIS),
                                     //new Rotate(-20, Rotate.X_AXIS));
                                     new Translate(GameEngine.HEIGHT / 2 ,GameEngine.WIDTH /2 , -60));
      
      camera.setFieldOfView(40);
      
      all.setCamera(camera);
      return all;
   }
   
   public void start( Stage primaryStage ) 
   {
      primaryStage.setResizable(false);
      //primaryStage.setScene( createScene() );
      Scene scene = createScene();
      primaryStage.setScene(scene);
      primaryStage.show();
      
      GameEngine game = new GameEngine( );
      primaryStage.addEventHandler( KeyEvent.KEY_PRESSED, event -> {
      switch (event.getCode()) {
        case W:
          game.rotate(1);
          break;
        case S:
           game.flip(1);
          break;
        case RIGHT:
           game.xplus();
          break;
        case UP:
           game.yminus();
          break;
        case DOWN:
           game.yplus();
          break;
        case LEFT:
           game.xminus();
          break;
        case DIGIT1:
           game.setActive(1);
          break;
        case DIGIT0:
           game.setActive(0);
          break;
      }
      if(game.isFinish()) { System.exit(0);}
    });
      
   }
   
   
}
