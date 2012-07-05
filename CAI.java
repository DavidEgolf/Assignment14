import java.util.Scanner; // Scanner class

public class CAI
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in); // need to read information
		CAIClass assistance = new CAIClass();
		while(true)
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
		}
	}
}
