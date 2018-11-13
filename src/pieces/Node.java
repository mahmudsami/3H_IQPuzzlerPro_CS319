/**
 * This class represents nodes 
 * @author Mahmud Sami Aydin
 * 13.11.2018
 */ 
class Node{

//attributes  
private int x;
private int y;
private int z;
private int color;

//constructors
public Node(){
     this.x = 0;
     this.y = 0;
     this.z = 0;
     this.color = 0;
}

public Node( int x , int y , int z){
     this.x = x;
     this.y = y;
     this.z = z;
     this.color = 0;
}

public Node( int x , int y , int z , int color){
     this.x = x;
     this.y = y;
     this.z = z;
     this.color = color;
}
//setters
void setX( int x )
{
  this.x = x;
}

void setY( int y )
{
  this.y = y;
}

void setZ( int z )
{
  this.z = z;
}

void setColor( int color )
{
  this.color = color;
}

//getters
int getX()
{
  return x;
}

int getY()
{
  return y;
}

int getZ()
{
  return z;
}

int getColor()
{
  return color;
}


//methods
public boolean isFlatNeigbor( Node neig )
{
  return z == neig.z && ( ( Math.abs(x - neig.x) == 2 && y == neig.y  )||( x == neig.x && Math.abs(y - neig.y) == 2 ) );
}

public boolean isDiagNeigbor( Node neig )
{
  return Math.abs(x - neig.x) == 1 && Math.abs(y - neig.y) == 1 && Math.abs(z - neig.z) == 1 ;
}

}
