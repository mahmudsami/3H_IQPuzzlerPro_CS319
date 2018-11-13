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
    for(int i = 0; i < size - 1 ; i++)
      this.relatives[i] = relatives[i];
    isFixed = false;
    this.size = size;
    lastAction = 0;
    oldMainLocation = mainNode;
  }
  //getters
  
  //setters
  
  //methods
  public boolean move( int x, int y, int z){return false;} //TODO
  
  
  public boolean rotate(){return false;} //TODO
  
  
  public boolean flip(){return false;} //TODO
  
}
