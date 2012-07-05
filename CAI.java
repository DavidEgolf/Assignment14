import java.util.Scanner; // Scanner class

public class CAI
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in); // need to read information
		CAIClass assistance = new CAIClass();
		assistance.generateProblem();
		while(assistance.isIncorrect())
		{
			assistance.printProblem();
			int answer = in.nextInt();
			if (assistance.checkProblem(answer))
			{
				assistance.setIncorrect(false);
				System.out.println("Very good!");
			}
			else
				System.out.println("No. Please try again.");
		}
	}
}
