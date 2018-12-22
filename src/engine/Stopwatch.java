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
	

}
