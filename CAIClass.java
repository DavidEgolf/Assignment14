import java.util.Random; // Random number class

public class CAIClass
{
	int randomValue1, randomValue2;
	
	CAIClass()
	{
		randomValue1 = 0;
		randomValue2 = 0;
	}
	
	public void generateProblem()
	{
		Random randomList = new Random();
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
}
