package pieces;
/**
 * This class represents one piece of the game
 * @author Mahmud Sami Aydin
 * 13.11.2018
 */ 

import java.util.ArrayList;
import java.util.Arrays;

public class PolyminoList{
   
//attributes
   private int size;
   private int validSize;
   private Polymino[] list;
   
//constructor

   
   public PolyminoList()
   {
      size = 12;
      list = new Polymino[12];
      validSize = 0; 
   }
   
   public PolyminoList( PolyminoList copy)
   {
      size = copy.size;
      validSize = copy.validSize;
      list = new Polymino[size];
      for( int i = 0; i < validSize; i++)
      	list[i] = new Polymino(copy.list[i]);
   }
   
   public PolyminoList( int size )
   {
      this.size = size;
      list = new Polymino[size];
      validSize = 0; 
   }
   
   public PolyminoList( int size , Polymino[] list)
   {
      validSize = 0; 
      list = new Polymino[size]; 
      for( int i = 0; i < list.length ; i++ )
      {
         addPolymino( list[i] );
      }
   } 
   
   public Polymino getPolymino( int x )
   {
      return list[x];
   }
   
   public boolean setPolymino(int index, Polymino pl )
   {
   		if( index <= validSize )
   		{
   			list[index] = new Polymino(pl);
   			return true;
   		}
   		return false;
   }
   
   public int getSize()
   {
      return size;
   }
   
   public boolean getValidity()
   {
      return validSize == size;
   }
   
   public boolean addPolymino( Polymino pl )
   {
      if( size > validSize )
      {
         boolean notEq = true;
         for( int i = 0; i < validSize ; i++ )
         {
            if( list[i].equalsTo( pl ) ) notEq = false;
         }
         if( notEq && pl.getValidity() ) 
         {
            list[validSize] = new Polymino( pl );
            list[validSize].setColor( validSize );
            validSize++;
            System.out.println("added");
            return true;
         }
         System.out.println("not added");
      }
      return false;
   }
   

   
   public boolean notCollide( int index)
   {
   		MyNode[] nodesOf;
    	ArrayList<MyNode> temp = new ArrayList<MyNode>();
    	for( int i = 0; i < validSize; i++ )
    	{
			if( i != index )
			{
				nodesOf = list[i].getCoordinates();
				if(nodesOf[0].getX() != -1 || nodesOf[0].getY() != -1||nodesOf[0].getZ() != -1 )
				{
					temp.addAll(Arrays.asList(nodesOf));
				}
			}	    	
    	}
    	nodesOf = list[index].getCoordinates();    	
    	for( MyNode n : nodesOf )
    	{
    		if( n.getX() > 20 || n.getX() < 0 && n.getY() > 8 && n.getY() < 0 && n.getZ() != 0 )
    			return false;
    		for( MyNode m : temp )
    		{
    			if( n.equalsTo(m) )
    				return false;
    		}
    	}
    	return true;
    	
   }
   
  
   public ArrayList<MyNode> allCoordinates()
   {
   		MyNode[] nodesOf;
   		ArrayList<MyNode> temp = new ArrayList<MyNode>();
    	for( int i = 0; i < validSize; i++ )
    	{
			nodesOf = list[i].getCoordinates();
			if(nodesOf[0].getX() != -1 || nodesOf[0].getY() != -1||nodesOf[0].getZ() != -1 )
			{
				temp.addAll(Arrays.asList(nodesOf));
			}
	    	
    	}
    	return temp;
   }
   
   
}
