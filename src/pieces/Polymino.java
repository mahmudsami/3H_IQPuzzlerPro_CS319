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
   public Polymino(){
   		isValid = false;
   }
   
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
      mainNode = new MyNode(pl.mainNode);
      if( pl.relatives == null) relatives = null;
      else{
         relatives = new MyNode[size -1];
         for(int i = 0; i < size - 1 ; i++)
         {
            relatives[i] = new MyNode(pl.relatives[i]);
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
   
   public int getSize(){
   	return size;
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
            relatives[i].setX( (tempy + tempx)/2 - tempz );
            relatives[i].setY( (tempx + tempy)/2 + tempz  ); 
            relatives[i].setZ( (tempx  - tempy)/2 ); 
         }
         }
         diag = diag ^ ( numOfFlip % 2 == 1);
         
         oldMainLocation = new MyNode( mainNode );
      }
   } 
   
   public void restoreOld()
   {
   	  int temp = lastAction;
      if(lastAction == 0) mainNode = oldMainLocation;
      flip( 4 - temp / 4 );
      rotate( 4 - temp );
      lastAction = 0;
   }
   
   public void normalize()
   {
   		int index = -1;
		MyNode temp = new MyNode();
   		for( int i = 0; i < size-1; i++ )
   		{
   			if( relatives[i].getY() < temp.getY() )
   			{
   				index = i;
   				temp = new MyNode( relatives[i] );
   			}
   			else if( relatives[i].getY() == temp.getY() )
   			{
   				if( relatives[i].getX() < temp.getX() )
   				{
   					index = i;
   					temp = new MyNode( relatives[i] );
   				}
   			}
   		}
   		if( index > -1 )
   		{
   			for( int i = 0; i < size-1; i++ )
   			{
   				if( i != index )
   				{
   					relatives[i].setX( relatives[i].getX() - temp.getX());
   					relatives[i].setY( relatives[i].getY() - temp.getY());
   					relatives[i].setZ( relatives[i].getZ() - temp.getZ());
   				}else{
   					relatives[i].setX( - temp.getX());
   					relatives[i].setY( - temp.getY());
   					relatives[i].setZ( - temp.getZ());
   				}
   			}
   			
   			mainNode.setX( mainNode.getX() + temp.getX());
   			mainNode.setY( mainNode.getY() + temp.getY());
   			mainNode.setZ( mainNode.getZ() + temp.getZ());
   		}
   		 
   }
 
   public Polymino[] permute()
   {
   		Polymino[] permutations = new Polymino[16];
   		for( int i = 0; i < 16; i++ )
   		{
   			lastAction = i;
   			restoreOld();
 			permutations[i] = new Polymino( this );
 			permutations[i].normalize();
 			if( isFree() ) permutations[i].move(-1,-1,-1);
 			lastAction = -(i%4) + 4*(- (i/4));
   			restoreOld();
   		}
   		return permutations;
   } 
   
   public boolean[] uniquePermutation()
   {
   		boolean[] temp = new boolean[16];
   		boolean unique; 
   		Polymino[] permutations = permute();
   		for( int i = 0; i < 16; i++ )
   		{
   			unique = true;
   			for(int j=0 ;j < i && unique ; j++)
   			{
   				if( permutations[j].sameWith(permutations[i]) )
   				{
   					unique = false;
   				}
   			}
   			temp[i] = unique;
   		}
   		return temp;
   }
   
   public boolean sameWith( Polymino pl )
   {
   		if( size != pl.size )  return false;
   		boolean match;
   		for( int i = 0; i < size-1; i++)
   		{
   			match = false;
   			for( int j = 0; j < size-1 && !match ; j++ )
   			{
   				if( relatives[i].equalsTo(pl.relatives[j]))
   					match =true;
   			}
   			if(!match) return false;
   		}
   		return true;
   }
   
   public void print()
   {
   		MyNode[] temp = getCoordinates();
   		for( MyNode n : temp )
   		{
   			System.out.println("X: " + n.getX() +"Y: " + n.getY() +"Z: " + n.getZ());
   		}
   		System.out.println("--------------");
   }
   
   public boolean isFree( )
   {
   		return mainNode.equalsTo( new MyNode(-1,-1,0) );
   }
   
   public boolean equalsTo( Polymino pl )
   {
      return false;
   }//TODO
   
   
}
