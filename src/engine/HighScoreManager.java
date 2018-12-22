package engine;

import pieces.*;
import engine.*;
import level.*;
import engine.*;
import userInterfaceController.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class HighScoreManager {
	
	// Attributes
	
	File highScores;
	String [] names;
	int [] scores;
	
	// Constructors
	
	public HighScoreManager (String fileName) throws FileNotFoundException
	{
		highScores = new File(fileName);
		Scanner reader = new Scanner(highScores);
		
		names = new String [11];
		scores = new int [11];
		
		int counter = 0;
		
		while(reader.hasNextLine())
		{
			String line = reader.nextLine();
			
			while(line.charAt(0) != '$' && line.charAt(0) != '#')
				line = reader.nextLine();
			
			if(line.charAt(0) == '$')
			{
				names[counter] = line.substring(1);
			}
			
			if (line.charAt(0) == '#')
			{
				scores[counter] = Integer.parseInt(line.substring(1));
				counter++;
			}
		}
		
	}
	
	// Methods
	
	public boolean checkIfHighScore (int score)
	{
		if (scores[9] == 0)
		{
			return true;
		}
		else
		{
			if(score > scores[9])
				return true;
			else
				return false;
		}
	}
	
	public String[] getHighScoreNames ()
	{
		return names;
	}
	
	public int[] getHighScores()
	{
		return scores;
		
	}
	
	public void addHighScore(String name, int score) throws FileNotFoundException
	{
		
		if(checkIfHighScore(score))
		{
			int placeOfNewScore = 10;
			
			for(int i = 0; i < 10; i++)
			{
				if(scores[i] < score)
				{
					placeOfNewScore = i;
					for(int j = 9; j > placeOfNewScore; j--)
					{
						scores [j] = scores[j - 1];
					}
					scores[placeOfNewScore] = score;
					break;
				}
			}
		
			for(int i = 9; i > placeOfNewScore; i--)
			{
				names[i] = names[i-1];
			}
			names[placeOfNewScore] = name;
		
		}
		
		PrintWriter writer = new PrintWriter(highScores);
		writer.print("");
		
		for(int i = 0; i < 10; i++)
		{
			writer.println("$" + names[i]);
			writer.println("#" + scores[i]);
		}
		
		writer.close();
		
	}
	
	
	
	
	
	
	
}
