package pieces;

import pieces.*;
import engine.*;
import level.*;
import engine.*;
import userInterfaceController.*;

import java.util.*;

public class Board{
	boolean[] filled;
	PolyminoList used;
	int type;
	public boolean stable;
	public Board( int type , PolyminoList used){
		filled = new boolean[55];
		this.type = type;
		for( int i = 0; i < 55; i++ )
			filled[i] = false;
		stable = true;
		this.used = used;
		for(  int i = 0; i < used.getSize(); i++  )
	  	{
	  		if( !used.getPolymino(i).isFree() )
	  		{	
	  			stable = stable & addPolymino(used.getPolymino(i));
	  		}
	  	}
	}
	
	public Board( Board copy )
	{
		type = copy.type;
		for( int i = 0; i < 55; i++)
			filled[i] = copy.filled[i];
		used = new PolyminoList(copy.used);
		stable = this.stable;
	}
		
	
	public PolyminoList getPolyminoList( ) {
		return used;
	}
	
	public void print()
	{
		for( int i = 0; i < 11; i++)
		{
			for( int j = 0; j < 5; j++)
				System.out.print("\t" + filled[i+11*j] );
			System.out.println( );
		}
	}
	
	public MyNode firstPoint()
	{
		MyNode result;
		int i;
		for( i = 0; filled[i]; i++ );
		result = new MyNode(i%11,i/11,0);
		return result;
	}
	
	public boolean addPolymino( int index )
	{
		int x=0;
		int y=0;
		int z=0;
		int i;
		for( i = 0; filled[i]; i++ );
		switch(type)
		{
			case 0:
			x = i % 11; y = i / 11; z = 0;
			break;
		}
		Polymino temp = used.getPolymino(index);
		temp.move(2*x,2*y,z);
		used.setPolymino( index, temp );
		addPolymino(temp);
		return stable;
	}
	
	public boolean isFilled()
	{
		for( int i = 0; i < 55; i++)
		{
			if( !filled[i] ) return false;
		}
		return true;
	}
	
	
	private boolean addPolymino( Polymino pl )
	{
		if(!stable) return false;
		switch(type)
		{
		case 0:
			int x,y,z;
			MyNode[] temp = pl.getCoordinates();
			for( int i = 0; i < temp.length; i++ )
			{
				x = temp[i].getX();
				y = temp[i].getY();
				z = temp[i].getZ();
				if( z == 0 && x < 21 && y < 9 && x >= 0 && y >= 0)
				{
					if( filled[x/2 + (y/2)*11 ] ) 
					{
						stable = false;
						return false;
					}
					else
					{
						filled[x/2 + (y/2)*11 ] = true;
					}	
				}else{
					stable = false;
					return false;
				}
			}
			return true;
		}
		
		stable = false;
		return false;
	}
	
}
