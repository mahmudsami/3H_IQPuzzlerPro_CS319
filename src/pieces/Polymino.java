import java.io.*; 
import java.util.*; 
/**
 * This class represents one piece of the game
 * @author Mahmud Sami Aydin
 * 13.11.2018
 */ 
class Polymino
{
  //attributes
  int size;
  int color;
  boolean isFixed;
  Node mainNode;
  Node[] relatives;
  
  boolean isValid;
  boolean diag;
  int lastAction;
  Node oldMainLocation;
  
  //Constructor
  public Polymino( int size, Node mainNode, Node[] relatives, int color )
  {
    if( size != relatives.length + 1 ) {isValid = false; this.color = -1; isFixed = true; return;}
    
    boolean[] validityCheck =  new boolean[ size - 1 ];
    
    diag = false;
    for(int i = 0; i < size - 1 ; i++)
    {
      if( relatives[i].getZ() != 0 ) diag = true; 
    }
      
    Node origin = new Node();
    Node temp;
    Stack s = new Stack();
    s.push( origin );
    while( !s.empty() )
    {
      temp = (Node)(s.pop());
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
    for(int i = 0; i < size - 1 ; i++)
    {
      this.relatives[i] = relatives[i];
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
    for(int i = 0; i < size - 1 ; i++)
    {
      relatives[i] = pl.relatives[i];
   }
    isValid = pl.isValid; 
    diag = pl.diag;
    lastAction = pl.lastAction;
    oldMainLocation = pl.oldMainLocation;
  }
  //getters
  boolean getValidity()
  {
   return isValid;
  }
  
  //setters
  void setFixed(){
   isFixed = true;
  }
  void setColor( int color)
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
   mainNode.setX(x);
   mainNode.setX(y);
   mainNode.setX(z);
   oldMainLocation = new Node (x,y,z);
   lastAction = 0;
   } 
  
  
  public void rotate( int numOfRotation ){
   numOfRotation = numOfRotation % 4;
   lastAction = numOfRotation;
   int tempCoor;
   for(int i = 0; i < size - 1 ; i++)
    {
      tempCoor = relatives[i].getX(); 
      relatives[i].setX( relatives[i].getY() );
      relatives[i].setY( - tempCoor ); 
    }
  } 
  
  
  public void flip( int numOfFlip){
   numOfFlip = numOfFlip % 4;
   lastAction = 4 * numOfFlip ;
   int tempx, tempy, tempz;
   for(int i = 0; i < size - 1 ; i++)
    {
      tempx = relatives[i].getX();
      tempy = relatives[i].getY();
      tempz = relatives[i].getZ();
      relatives[i].setX( tempy/2 + tempx/2 + tempz );
      relatives[i].setY( tempy/2 - tempx/2 - tempz  ); 
      relatives[i].setZ( tempy  - tempx ); 
    }
   } 
  
  public void restoreOld()
  {
   if(lastAction == 0) mainNode = oldMainLocation;
   else if( lastAction % 4 ==0 ) flip( lastAction / 4 );
   else rotate ( lastAction );
   lastAction = 0;
  }
  
  public boolean equalsTo( Polymino pl )
  {
   return false;
  }//TODO
  
}
