package engine;

import pieces.*;
import engine.*;
import level.*;
import engine.*;
import userInterfaceController.*;

public class Player {

	//Attributes
	
	int score;
	String name;
	boolean isTurn;
	
	
	//Constructors
	
	Player(String nameOfPlayer)
	{
		name = nameOfPlayer;
		score = 0;
		isTurn = false;
	}
	
	//Methods

	public int getScore()
	{
		return score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setScore(int newScore)
	{
		score = newScore;
	}
	
	public void setName (String newName)
	{
		name = newName;
	}
	
	public void changeTurn ()
	{
		if (isTurn)
			isTurn = false;
		else
			isTurn = true;
	}
}
