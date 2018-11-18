package pieces;
import java.io.*; 
import java.util.*; 
/**
 * This class represents one piece of the game
 * @author Mahmud Sami Aydin
 * 13.11.2018
 */ 
public class Polymino
{
   //attributes
   int size;
   int color;
   boolean isFixed;
   MyNode mainNode;
   MyNode[] relatives;
   
   boolean isValid;
   boolean diag;
   int lastAction;
   MyNode oldMainLocation;
   
   //Constructor
   public Polymino( int size, MyNode mainNode, MyNode[] relatives, int color )
   {
      if( relatives == null && size == 1 ){this.size = size;this.mainNode = mainNode ;isValid = true; this.color = color; isFixed =false; return;}
      if( size != relatives.length + 1 ) {isValid = false; this.color = -1; isFixed = true; return;}
      
      boolean[] validityCheck =  new boolean[ size - 1 ];
      
      diag = false;
      for(int i = 0; i < size - 1 ; i++)
      {
         if( relatives[i].getZ() != 0 ) diag = true; 
      }
      
      MyNode origin = new MyNode();
      MyNode temp;
      Stack s = new Stack();
      s.push( origin );
      while( !s.empty() )
      {
         temp = (MyNode)(s.pop());
         for(int i = 0; i < size - 1 ; i++)
         {
            if( !validityCheck[i] && ((diag && temp.isDiagNeigbor( relatives[i] ) ) || (!diag && temp.isFlatNeigbor( relatives[i]   ) ) ) )
            {
               s.push( relatives[i] );
               validityCheck[i] = true;
            }
         }
      }
      
      isValid = true;
      for(int i = 0; i < size - 1 && isValid; i++)
      {
         if( !validityCheck[i] ) isValid = false; 
      }
      
      if( !isValid ){isValid = false; this.color = -1; isFixed = true; return;}
      
      this.color = color;
      this.mainNode = mainNode;
      this.mainNode.setColor(color);
      this.relatives = new MyNode[size -1 ];
      for(int i = 0; i < size - 1 ; i++)
      {
         
         this.relatives[i] =new MyNode();
         this.relatives[i] = new MyNode( relatives[i] );
         this.relatives[i].setColor(color);
      }
      isFixed = false;
      this.size = size;
      lastAction = 0;
      oldMainLocation = mainNode;
   }
   
   public Polymino( Polymino pl )
   {
      size  = pl.size;
      color = pl.color;
      isFixed = pl.isFixed;
      mainNode = pl.mainNode;
      if( pl.relatives == null) relatives = null;
      else{
         relatives = new MyNode[size -1];
         for(int i = 0; i < size - 1 ; i++)
         {
            relatives[i] = pl.relatives[i];
         }
      }
      isValid = pl.isValid; 
      diag = pl.diag;
      lastAction = pl.lastAction;
      oldMainLocation = pl.oldMainLocation;
   }
   //getters
   public boolean getValidity()
   {
      return isValid;
   }
   
   public boolean getIsFixed()
   {
      return isFixed;
   }
   
   public MyNode getMain()
   {
      return mainNode;
   }
   
   public MyNode[] getCoordinates()
   {
      MyNode[] temp = new MyNode[size];
      temp[0] = new MyNode();
      temp[0]. setX( mainNode.getX());
      temp[0]. setY(mainNode.getY());
      temp[0].setZ(mainNode.getZ());
      temp[0].setColor ( color);
      for( int i = 0; i < size - 1 ; i++)
      {
         temp[i+1] = new MyNode();
         temp[i+1].setX(mainNode.getX() + relatives[i].getX() );
         temp[i+1].setY(mainNode.getY() + relatives[i].getY() );    
         temp[i+1].setZ(mainNode.getZ() + relatives[i].getZ() );  
         temp[i+1].setColor ( color);
      }
      
      return temp;
   }
   //setters
   public void setFixed(){
      isFixed = true;
   }
   public void setColor( int color)
   {
      this.color = color;
      this.mainNode.setColor(color);
      for(int i = 0; i < size - 1 ; i++)
      {
         relatives[i].setColor(color);
      }
   }
   
   //methods
   public void move( int x, int y, int z){
      if( !isFixed)
      {
         oldMainLocation = new MyNode (mainNode);
         mainNode.setX(x);
         mainNode.setY(y);
         mainNode.setZ(z);
         lastAction = 0;
      }
   }
   
   public void shiftTo ( MyNode n )
   {
      if( !isFixed)
      {
         oldMainLocation = new MyNode ( mainNode );
         //oldMainLocation = new MyNode (mainNode.getX(),mainNode.getY(),mainNode.getZ());
         mainNode.setX( mainNode.getX() + n.getX() );
         mainNode.setY( mainNode.getY() + n.getY());
         mainNode.setZ( mainNode.getZ() + n.getZ());
         lastAction = 0;
      }
   }
   
   
   
   public void rotate( int numOfRotation ){
      if( !isFixed )
      {
         numOfRotation = numOfRotation % 4;
         lastAction = numOfRotation;
         int tempCoor;
         for( int j = 0; j < numOfRotation; j++ )
         {
            for(int i = 0; i < size - 1 ; i++)
            {
               tempCoor = relatives[i].getX(); 
               relatives[i].setX( - relatives[i].getY() );
               relatives[i].setY( tempCoor ); 
            }
         }
         oldMainLocation = new MyNode( mainNode );
         
      }
   } 
   
   
   public void flip( int numOfFlip){
      if( !isFixed )
      {
         numOfFlip = numOfFlip % 4;
         lastAction = 4 * numOfFlip ;
         int tempx, tempy, tempz;
         for( int j = 0; j < numOfFlip ; j++ ){ 
         for(int i = 0; i < size - 1 ; i++)
         {
            tempx = relatives[i].getX();
            tempy = relatives[i].getY();
            tempz = relatives[i].getZ();
            relatives[i].setX( (tempy + tempx)/2 - tempz/2 );
            relatives[i].setY( (tempx + tempy)/2 + tempz/2  ); 
            relatives[i].setZ( tempx  - tempy ); 
         }
         }
         diag = diag ^ ( numOfFlip % 2 == 1);
         
         oldMainLocation = new MyNode( mainNode );
      }
   } 
   
   public void restoreOld()
   {
      if(lastAction == 0) mainNode = oldMainLocation;
      else if( lastAction % 4 ==0 ) flip( 4 - lastAction / 4 );
      else rotate ( 4 - lastAction );
      lastAction = 0;
   }
   
   public boolean equalsTo( Polymino pl )
   {
      return false;
   }//TODO
   
   
}
