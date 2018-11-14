/**
 * This class represents one piece of the game
 * @author Mahmud Sami Aydin
 * 13.11.2018
 */ 
class PolyminoList{

//attributes
private int size;
private int validSize;
private Polymino[] list;

//constructor
PolyminoList()
{
	size = 0;
}

PolyminoList( int size )
{
	list = new Polymino[size];
	validSize = 0; 
}

PolyminoList( int size , Polymino[] list)
{
	list = new Polymino[size]; 
	for( int i = 0; i < list.length ; i++ )
	{
		addPolymino( list[i] );
	}
} 

Polymino getPolymino( int x )
{
	return list[x];
}

boolean getValidity()
{
	return validSize == size;
}

boolean addPolymino( Polymino pl )
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
