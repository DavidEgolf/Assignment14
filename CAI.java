import java.util.Scanner; // Scanner class

public class CAI
{
	public static void main(String [] args)
	{
		final int numProblems = 10;
		Scanner in = new Scanner(System.in); // need to read information
		CAIClass assistance = new CAIClass(numProblems);
		while(true)
		{
			for(int problemLoop = 0; problemLoop < numProblems; problemLoop++)
			{
				assistance.generateProblem();
				while(assistance.isIncorrect())
				{
					assistance.printProblem();
					int answer = in.nextInt();
					if (assistance.checkProblem(answer))
					{
						assistance.setIncorrect(false);
						System.out.println(assistance.generateCorrectMessage());
					}
					else
						System.out.println(assistance.generateIncorrectMessage());
				}
				assistance.setIncorrect(true);
				System.out.println(assistance.getPercent());
			}
			System.out.printf("You scored %d/%d, that's a %f%%.\n",
			                  assistance.getCorrect(),
			                  assistance.getTotal(),
			                  assistance.getPercent());
			assistance.resetGrade();
		}
	}
}
