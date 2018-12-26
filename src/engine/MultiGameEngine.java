package engine;
import pieces.*;
import java.io.File;
import java.lang.Exception;
import java.util.Optional;
public class MultiGameEngine extends GameEngine{

	Player[] players;
	Board solution;
	boolean moved;
	boolean firstTurn;
	MyNode oldMain;
	
	
	public MultiGameEngine( String levelName, int boardType, String p1, String p2  ) throws Exception
	{
		super(levelName, boardType);
		if( boardType != 0 ) return;
		if( level.getSolution() != 1 ) return;
		sw.stop();
		players = new Player[2];
		players[0] = new Player( p1 );
		players[1] = new Player( p2 );
		firstTurn = true;
		moved = false;
		solution = level.getSolBoard();
      	solution.print();
		oldMain = activePolymino.getMain();
		sw.turn( 0,players[0] );
	}
	
	public void movement( int moveType )
	{
		switch ( moveType )
		{
			case 0:
				moved = moved | rotate(1);
			break;
			case 1:
				moved = moved | rotate(3);
			break;
			case 2:
				moved = moved | flip(1);
			break;
			case 3:
				moved = moved | flip(3);
			break;
			case 4:
				moved = moved | zplus();
			break;
			case 5:
				moved = moved | zminus();
			break;
			case 6:
				moved = moved | xplus();
			break;
			case 7:
				moved = moved | yminus();
			break;
			case 8:
				moved = moved | yplus();
			break;
			case 9:
				moved = moved | xminus();
			break;
			case 10:
				moved = moved | mvdgl();
			break;
			case 11:
				moved = moved | mvdgr();
			break;
			case 12:
			if( moved )
				turned();
			else
				nextActive();
			break;
			case 13:
				turned();
			break;


		}
	}
	
	public void nextActive()
	{
		super.nextActive();
		oldMain = new MyNode(activePolymino.getMain());
	}
	
	public void turned()
	{
	  int remain = 0;
      for( MyNode n : board )
      {
         if( n.getColor() == -2 ) remain++;
      }
      double scoreFactor = remain * 1.0 / activePolymino.getSize();
      boolean inSolution = false;
      for( int i = 0; i < 12 ; i++)
      {
      	if( activePolymino.sameWith(solution.getPolyminoList().getPolymino(i)) && activePolymino.getMain().equalsTo(solution.getPolyminoList().getPolymino(i).getMain() ) )
      		inSolution = true;
      }
      if( !inSolution )
      {
      	activePolymino.move(oldMain.getX(),oldMain.getY(), oldMain.getZ() );
      }else
      {
      	activePolymino.setFixed();
      }
      
		if( firstTurn )
		{
			if( inSolution )
				sw.turn( scoreFactor , players[0]);	
			else
			{
				sw.turn( -scoreFactor , players[0]);
				firstTurn = false;
			}
		}
		else
		{
			if( inSolution )
				sw.turn( -scoreFactor , players[1]);	
			else
			{
				sw.turn( scoreFactor , players[1]);
				firstTurn = false;
			}
		}
		nextActive();
	    updateView();
	    
		moved = false;
	}
}
