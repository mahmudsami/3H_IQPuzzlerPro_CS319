package pieces;
/**
 * This class represents one piece of the game
 * @author Mahmud Sami Aydin
 * 13.11.2018
 */ 
public class PolyminoList{
   
//attributes
   private int size;
   private int validSize;
   private Polymino[] list;
   
//constructor
   public PolyminoList()
   {
      size = 0;
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
            return true;
         }
      }
      return false;
   }
}
