package ca.lambtoncollege;

public class PageCounter {

	private int pgcounter=0;
	
	//Method for autoincreament
	public void autoIncreamentOne()
	{
		this.pgcounter++;
		
	}
	
	public int getPageCount()
	{
		autoIncreamentOne();
		return pgcounter;
	}
}
