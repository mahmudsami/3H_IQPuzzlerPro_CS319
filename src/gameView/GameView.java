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


public class GameView extends Application
{
	public static String levelX;
	public GameView( )
	{
		super();
	}
	public GameView( String levelX )
	{
		super();
		this.levelX = levelX;
	}

   public static Sphere[][][] nodes = new Sphere [GameEngine.HEIGHT][GameEngine.WIDTH][GameEngine.DEPTH]  ;
   
   public Scene createScene() {
      
      Group root = new Group();
      Scene all = new Scene( root ,1900, 1000);
      Rectangle bound = new Rectangle( 0, 0, GameEngine.HEIGHT, GameEngine.WIDTH );
      bound.setFill(Color.BEIGE);
      
      Rectangle bound2 = new Rectangle( 0, 0, GameEngine.DEPTH, GameEngine.WIDTH );      
      bound2.setFill(Color.BEIGE);
      bound2.getTransforms().add(new Rotate(90,Rotate.Y_AXIS));
      
      Rectangle bound3 = new Rectangle( 0, 0, GameEngine.DEPTH, GameEngine.HEIGHT );      
      bound3.setFill(Color.AQUA);
      bound3.getTransforms().add(new Rotate(90,Rotate.X_AXIS));
      bound3.getTransforms().add(new Rotate(270,Rotate.Z_AXIS));
      root.getChildren().add(bound);
      root.getChildren().add(bound2);
      root.getChildren().add(bound3);
      //-----------------------------------------------------------------------------
      PhongMaterial tempMaterial;
      //-----------------------------------------------------------------------------       
      
      for( int k = GameEngine.DEPTH - 1; k >=0 ; k--)
      {
         for( int j = 0; j < GameEngine.WIDTH; j++)
         {
            for( int i = GameEngine.HEIGHT - 1 ; i >= 0 ; i-- )
            {
            	if( (k + i) % 2 == 0 && ( j+i ) % 2 == 0 ){
               tempMaterial = new PhongMaterial();
               
               tempMaterial.setDiffuseColor(Color.BLUE);
               tempMaterial.setSpecularColor(Color.BLUE);
               
               nodes[i][j][k] = new  Sphere( 1.1 ); 
               root.getChildren().add( nodes[i][j][k]);
               nodes[i][j][k].setTranslateX( i -2);
               nodes[i][j][k].setTranslateY( j -2);
               nodes[i][j][k].setTranslateZ( (k -2)*Math.sqrt(2));
               
               nodes[i][j][k].setMaterial( tempMaterial);
               nodes[i][j][k].setDrawMode(DrawMode.FILL);
            	}
            }
         }
      }
      
      
      
      PerspectiveCamera camera = new PerspectiveCamera(true);
      camera.getTransforms().addAll (
                                     new Rotate(45, Rotate.X_AXIS),
                                     //new Rotate(-20, Rotate.X_AXIS));
                                     new Translate(GameEngine.HEIGHT/2  ,GameEngine.WIDTH/3  , -60));
      
      camera.setFieldOfView(35);
      
      all.setCamera(camera);
      return all;
   }
   
   public void start( Stage primaryStage ) throws Exception 
   {
      primaryStage.setResizable(false);
      //primaryStage.setScene( createScene() );
      Scene scene = createScene();
      primaryStage.setScene(scene);
      primaryStage.show();
      //System.out.println(GameView.levelX);
      
      GameEngine game = new GameEngine("level" + Main.level, Main.level-1 );
      //GameEngine game = new GameEngine(GameView.levelX, 0 );
      
      //GameEngine game = new GameEngine( );
      primaryStage.addEventHandler( KeyEvent.KEY_PRESSED, event -> {
      switch (event.getCode()) {
        case UP:
          game.rotate(1);
          break;
        case DOWN:
          game.rotate(3);
          break;
        case LEFT:
          game.flip(1);
          break;
        case RIGHT:
           game.flip(3);
          break;
        case Q:
           game.zplus();
          break;
        case E:
           game.zminus();
          break;          
        case D:
           game.xplus();
          break;
        case W:
           game.yminus();
          break;
        case S:
           game.yplus();
          break;
        case A:
           game.xminus();
          break;
        case C:
        	game.mvdgl();
          break;
        case Z:
        	game.mvdgr();
          break;
        case TAB:
        	game.nextActive();
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
