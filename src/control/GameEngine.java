package control;
import pieces.*;
import view.GameView;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
public class GameEngine{
//constants 
public static final int HEIGHT = 50;
public static final int WIDTH = 20;
public static final int DEPTH = 10;

//attributes
   MyNode[] map;
   MyNode[] board;
   PolyminoList list;
   //Level level;
   //Level solution;
   Polymino activePolymino;
   GameView view;
   Color[] colors = { Color.TRANSPARENT,  Color. BLUE, Color. BROWN ,  Color.CHARTREUSE, 
      Color. CORAL, Color. CYAN, Color. DARKGREEN, Color. DARKORANGE, Color.DARKORCHID,
      Color. GOLD, Color. HOTPINK, Color. KHAKI, Color. RED
   };
   
   public GameEngine(  )
   {
      map = new MyNode[HEIGHT * WIDTH * DEPTH];
      for( int i = 0; i < HEIGHT; i++)
      {
         for( int j = 0; j < WIDTH; j++)
         {
            for( int k = 0; k < DEPTH; k++)
               map[ i +  HEIGHT * j + k *  HEIGHT * WIDTH ] = new MyNode( i , j, k, -1);
         }
      }
      
      board = new MyNode[ 9 ];
      for( int i = 0; i < 3; i++)
      {
         for( int j = 0; j < 3; j++ )
         {
             board[ i + j * 3 ] = map[ 6 +  2* i + 2*j * HEIGHT + 6 * HEIGHT * WIDTH];
         }
      }
      
      MyNode[] tempN = new MyNode[3];
      
      
      
      for( int i = 0 ; i < 3 ; i++)
         tempN[i] = new MyNode();
      (tempN[0]).setX(2);
      
      tempN[1].setX(2);
      tempN[2].setX(2);
      tempN[1].setY(2);
      tempN[2].setY(4);
      
      Polymino temp1 = new Polymino( 4, new MyNode( -1,-1,-1,1), tempN , 1 );
      Polymino temp2 = new Polymino( 4, new MyNode( -1,-1,-1,1), tempN, 2);
      Polymino temp3 = new Polymino( 1, new MyNode( 2,2,0,1), null , 3); 
      list = new PolyminoList(3);
      list.addPolymino( temp1 );
      list.addPolymino( temp2 );
      list.addPolymino( temp3 );
      
      for( int i = 0 ; i < 3; i++)
      {
         if( list.getPolymino(i).getCoordinates()[0].equalsTo( new MyNode(-1,-1,-1)) )
         {
            list.getPolymino(i).move( 6 + i * 4 ,6,6 );
         }
         else
         {
            list.getPolymino(i).shiftTo(board[0]);
            list.getPolymino(i).setFixed();
         }
      }
      updateMap();
      
   
      activePolymino = list.getPolymino(1);
      
   }
   
   public boolean isFinish()
   {
      boolean finish = true;
      for( MyNode n : board )
      {
         if( n.getColor() == -2 ) finish = false;
      }
      if( finish )
      {//TODO
         return true;
      }
      return false;
   }
   
   void updateMap()
   {
      for( int i = 0; i < HEIGHT * WIDTH * DEPTH; i++ )
      { 
         map[i].setColor(-1);
      }
      for( MyNode n : board )
		 n.setColor(-2);
      for( int i = 0; i < list.getSize(); i++ )
      {
         for ( MyNode n : list.getPolymino( i ). getCoordinates())
         {
            map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].setColor(n.getColor() );
         }
      }
      updateView();
   }
   
   public void move( int x, int y, int z )
   {
      activePolymino.move(x, y,z);
      
      MyNode[] poly =   activePolymino.getCoordinates() ;
      
      boolean succesful = activePolymino.getMain().isRegular() ;
      for( MyNode n : poly )
      {
         if( n.getX() >= HEIGHT || n.getY() >= WIDTH || n.getZ()  >=  DEPTH || n.getX()  < 0 ||  n.getY() < 0 || n.getZ()  < 0)
        {
           succesful = false;
           break;
        }
         
        if( map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].getColor() >= 0 &&
           map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].getColor() != n.getColor())
           succesful = false;
      }
      
      activePolymino.restoreOld();
      if(succesful)
      {
         poly =   activePolymino.getCoordinates() ;
         for( MyNode n : poly )
            map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].setColor(-1);
         activePolymino.move(x, y,z);
         updateMap();
      }
   }

   public void rotate( int numRot )
   {
      activePolymino.rotate( numRot );
      
      MyNode[] poly =   activePolymino.getCoordinates() ;
      boolean succesful = true;
      for( MyNode n : poly )
      {
          if( n.getX() >= HEIGHT || n.getY() >= WIDTH || n.getZ()  >=  DEPTH || n.getX()  < 0 ||  n.getY() < 0 || n.getZ()  < 0)
        {
           succesful = false;
           break;
        }
        
        if( map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].getColor() >= 0 &&
           map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].getColor() != n.getColor())
           succesful = false;
        
      }
      
      activePolymino.restoreOld();
      
      if(succesful)
      {
         poly =   activePolymino.getCoordinates() ;
         for( MyNode n :poly ){
           
            map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].setColor(-1);
         }
         activePolymino.rotate( numRot );
         updateMap();
      }
   }
   
   public void flip( int numFlip )
   {
      
      activePolymino.flip( numFlip );
      MyNode[] poly =   activePolymino.getCoordinates() ;
      
      boolean succesful = true;
      for( MyNode n : poly )
      { 
         if( n.getX() >= HEIGHT || n.getY() >= WIDTH || n.getZ()  >=  DEPTH || n.getX()  < 0 ||  n.getY() < 0 || n.getZ()  < 0)
        {
           succesful = false;
           break;
        }
        
        if( map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].getColor() >= 0 &&
           map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].getColor() != n.getColor())
           succesful = false;
      }
      
      activePolymino.restoreOld();
      if(succesful)
      {
         poly =   activePolymino.getCoordinates() ;
          for( MyNode n : poly )
            map[ n.getX() + n.getY() * HEIGHT + n.getZ() * HEIGHT * WIDTH].setColor(-1);
         activePolymino.flip( numFlip );
         updateMap( );
      }
   }

   public boolean setActive( int index )
   {
      if( list.getPolymino( index ).getIsFixed() )
         return false;
      activePolymino = list.getPolymino( index );
      return true;
   }
   
   public void xplus()
   {
      move(  activePolymino.getMain().getX()+ 2,activePolymino.getMain().getY(),activePolymino.getMain().getZ());
   }
   
   
   public void xminus()
   {
      move( activePolymino.getMain().getX()-2,activePolymino.getMain().getY(),activePolymino.getMain().getZ());
   }
   
   
   public void yplus()
   {
      move(activePolymino.getMain().getX(),activePolymino.getMain().getY() + 2,activePolymino.getMain().getZ());
   }
   
   
   public void yminus()
   {
      move( activePolymino.getMain().getX(),activePolymino.getMain().getY() -2,activePolymino.getMain().getZ());
   }

   public void zplus()
   {
      move(activePolymino.getMain().getX(),activePolymino.getMain().getY() ,activePolymino.getMain().getZ()+2);
   }
   
   
   public void zminus()
   {
      move( activePolymino.getMain().getX(),activePolymino.getMain().getY() ,activePolymino.getMain().getZ()-2);
   }


   public void updateView()
   { 
      int x,y,z, col;
      PhongMaterial temp;
      for( MyNode n : map )
      {
         x = n.getX();
         y = n.getY();
         z = n.getZ();
         col = n.getColor();
         temp = (PhongMaterial)(GameView.nodes[x][y][z].getMaterial());
         if( col != -2 )
         {
         	temp.setDiffuseColor(colors[col+1]);
         	temp.setSpecularColor(colors[col+1]);
         }
         else
         {
         	temp.setDiffuseColor( new Color(0.5,0.5,0.5,0.5 ));
         	temp.setSpecularColor( new Color(0.5,0.5,0.5,0.5 ));
         }
         GameView.nodes[x][y][z].setMaterial( temp );
         GameView.nodes[x][y][z].setDrawMode(DrawMode.FILL);
      }
   }






}
