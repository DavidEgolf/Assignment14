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
				assistance.printProblem(); // print the problem
				int answer = in.nextInt(); // get answer
				
				if (assistance.checkProblem(answer)) // check answer
				{
					System.out.println(assistance.generateCorrectMessage()); // print correct message
				} // end if(checkProblem)
				else
				{ // otherwise
					System.out.println(assistance.generateIncorrectMessage()); // print incorrect message
				}
					
				// System.out.println(assistance.getPercent()); // debug statement
			} // end for(i = 0; i < 10; i++) problem presentation loop
			
			System.out.printf("You scored %d/%d, that's a %f%%.\n",
			                  assistance.getCorrect(),
			                  assistance.getTotal(),
			                  assistance.getPercent()); // print the score after 10 problems
			                  
			if(assistance.getPercent() < 75)
				System.out.println("Please ask your teacher for extra help.");
			else
				System.out.println("Congratulations, you are ready to move on to the next level!");
			                  
			assistance.resetGrade(); // reset the grade for next 'student'
		} // end main while loop
	} // end main()
} // end public class CAI
