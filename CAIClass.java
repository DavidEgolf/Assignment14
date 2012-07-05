import java.util.Random; // Random number class

public class CAIClass
{
	private int randomValue1, randomValue2;
	private boolean incorrect;
	private Random randomList = new Random();	
	
	CAIClass()
	{
		randomValue1 = 0;
		randomValue2 = 0;
		incorrect = true;
	}
	
	public boolean isIncorrect()
	{
		return incorrect;
	}
	
	public void setIncorrect(boolean isIncorrect)
	{
		incorrect = isIncorrect;
	}
	
	public void generateProblem()
	{
		randomValue1 = randomList.nextInt(10);
		randomValue2 = randomList.nextInt(10);
	}
	
	public boolean checkProblem(int answer)
	{
		return answer == randomValue1 * randomValue2;
	}
	
	public void printProblem()
	{
		System.out.printf("What is %d * %d: ", randomValue1, randomValue2);
	}
	
	public String generateCorrectMessage()
	{
		switch(randomList.nextInt(4))
		{
			case 0:
				return "Very good!";
			case 1:
				return "Excellent!";
			case 2:
				return "Nice work!";
			case 3:
				return "Keep up the good work!";
		}
		return "";
	}
	
	public String generateIncorrectMessage()
	{
		switch(randomList.nextInt(4))
		{
			case 0:
				return "No. Please try again.";
			case 1:
				return "Wrong. Try once more.";
			case 2:
				return "Don't give up!";
			case 3:
				return "No. Keep trying.";
		}
		return "";
	}
}
