import java.util.Scanner; // Scanner class

public class CAI
{
	public static void main(String [] args)
	{
		final int numProblems = 10; // constant number
		Scanner in = new Scanner(System.in); // need to read information
		CAIClass assistance = new CAIClass(numProblems); // Computer-Assisted Instruction object
		while(true) // forever...
		{
			for(int problemLoop = 0; problemLoop < numProblems; problemLoop++) // give student numProb problems
			{
				assistance.generateProblem(); // generate new problem
				while(assistance.isIncorrect()) // while incorrect (dep 6.37)
				{
					assistance.printProblem(); // print the problem
					int answer = in.nextInt(); // get answer
					if (assistance.checkProblem(answer)) // check answer
					{
						assistance.setIncorrect(false); // if correct, set incorrect to false
						System.out.println(assistance.generateCorrectMessage()); // print correct message
					} // end if(checkProblem)
					else // otherwise
						System.out.println(assistance.generateIncorrectMessage()); // print incorrect message
				} // end while(assistance.isIncorrect())
				assistance.setIncorrect(true); // set it to incorrect, prevent looping error
				// System.out.println(assistance.getPercent()); // debug statement
			} // end for(i = 0; i < 10; i++) problem presentation loop
			System.out.printf("You scored %d/%d, that's a %f%%.\n",
			                  assistance.getCorrect(),
			                  assistance.getTotal(),
			                  assistance.getPercent()); // print the score after 10 problems
			assistance.resetGrade(); // reset the grade for next 'student'
		} // end main while loop
	} // end main()
} // end public class CAI
