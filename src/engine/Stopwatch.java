package engine;

public class Stopwatch {
	
	//Attributes
	
	long startTime;
	
	//Constructor
	
	public Stopwatch()
	{
		startTime = 0;
	}
	
	//Methods
	
	public void start()
	{
		startTime = System.currentTimeMillis();
	}
	
	public double stop()
	{
		int temp = 0;
		temp = (int) ( System.currentTimeMillis() - startTime );
		startTime = 0;
		return temp / 1000.0;
	}
	
	public int turn(double turnStatus, Player player)
	{
		double time = stop();
		
		int rawScore = (int)(100000 / time);
		int score = 0;
		
		if (turnStatus > 0)
		{
			score = (int) (rawScore * turnStatus);
		}
		else
		{
			score = (int) (rawScore / turnStatus);
		}
		
		int newScore = player.getScore() + score;
		
		player.setScore(newScore);
		
		start();		
		return newScore;
		
	}
	

}
