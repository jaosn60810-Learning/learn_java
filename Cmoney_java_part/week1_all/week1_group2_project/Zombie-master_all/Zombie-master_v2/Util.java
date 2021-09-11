package project;

public class Util {
	//constants to be used in place of magic numbers
	public static int DAYS_TO_SURVIVE = 10;
	public enum Status{RUN, STOP}
	public static final int MIN_FIND_AMMO = 1, MAX_FIND_AMMO = 5;
	public static final int MIN_FIND_PEOPLE = 1, MAX_FIND_PEOPLE = 2;
	public static final int MIN_PEOPLE = 5, MAX_PEOPLE = 10;
	public static final int SCAVENGER_SUCCESS = 1;
	public static int SURVIVORS = 25;
	public static int WOOD = 0;
	public static int IRON = 0;
	public static int AMMO = 150;
	
	//static methods that will be used in Apocalypse
	public static int generateRandomInRange(int min, int max)
	{
		return min + (int)(Math.random()*((max-min)+1));
	}

}
