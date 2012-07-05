import java.util.Scanner; // Scanner class
import java.util.Random; // Random number class

public class CAI
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in); // need to read information
		boolean incorrect = true;
		Random randomList = new Random();
		int randomValue1 = randomList.nextInt(10);
		int randomValue2 = randomList.nextInt(10);
		while(incorrect)
		{
			System.out.printf("What is %d * %d: ", randomValue1, randomValue2);
			int answer = in.nextInt();
			if (answer == randomValue1 * randomValue2)
			{
				incorrect = false;
				System.out.println("Very good!");
			}
			else
				System.out.println("No. Please try again.");
		}
	}
}
