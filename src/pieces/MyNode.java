package pieces;
/**
 * This class represents nodes 
 * @author Mahmud Sami Aydin
 * 13.11.2018
 */ 
public class MyNode {
   
//attributes  
   private int x;
   private int y;
   private int z;
   private int color;
   
//constructors
   public MyNode(){
      
      this.x = 0;
      this.y = 0;
      this.z = 0;
      this.color = 0;
   }
   
   public MyNode( int x , int y , int z){
      this.x = x;
      this.y = y;
      this.z = z;
      this.color = 0;
   }
   
   public MyNode( int x , int y , int z , int color){
      this.x = x;
      this.y = y;
      this.z = z;
      this.color = color;
   }
   
   public MyNode( MyNode node){
      
      this.x = node.x;
      this.y = node.y;
      this.z = node.z;
      this.color = node.color;
   }
//setters
   public void setX( int x )
   {
      this.x = x;
   }
   
   public void setY( int y )
   {
      this.y = y;
   }
   
   public void setZ( int z )
   {
      this.z = z;
   }
   
   public void setColor( int color )
   {
      this.color = color;
   }
   
//getters
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
   
   public int getZ()
   {
      return z;
   }
   
   public int getColor()
   {
      return color;
   }
   
   
//methods
   public boolean isFlatNeigbor( MyNode neig )
   {
      return z == neig.z && ( ( Math.abs(x - neig.x) == 2 && y == neig.y  )||( x == neig.x && Math.abs(y - neig.y) == 2 ) );
   }
   
   public boolean isDiagNeigbor( MyNode neig )
   {
      return Math.abs(x - neig.x) == 1 && Math.abs(y - neig.y) == 1 && Math.abs(z - neig.z) == 1 ;
   }
   
   public boolean equalsTo( MyNode other)
   {
      return x == other.x && y == other.y && z == other.z;
   }
   
   public boolean isRegular()
   {
      return ((x + y) % 2 == 0) && ((x + z) % 2 == 0);
   }
   

}
