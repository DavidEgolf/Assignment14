import java.util.Scanner; // Scanner class

public class CAI
{
	public static void main(String [] args)
	{
		final int numProblems = 10; // this is a "hack" for a "constant"
		Scanner in = new Scanner(System.in); // need to read information
		CAIClass assistance = new CAIClass(numProblems); // Computer-Assisted Instruction object
		
		while(true) // forever...
		{
			do // loop for getting dificulty till it's valid
			{
				System.out.print("What dificulty would you like (positive number only): "); // prompt for dificulty
			}while(!assistance.setDificulty(in.nextInt())); // read/send dificulty to assistance
			// the previous statement has the logical not so that it returns true when it works,
			// and false when it doesn't. it has to loop when true, thus not false
			
			do // loop for type of arithmetic getting till it's valid
			{
				System.out.println("\nWhat type of arithmetic would you like?"); // prompt
				System.out.println("[1]: Addition"); // for 
				System.out.println("[2]: Subtraction"); // the 
				System.out.println("[3]: Multiplication"); // different
				System.out.println("[4]: Integer Division"); // types
				System.out.println("[5]: Mixed/All"); // of 
				System.out.print("Selection (Valid Entry Only!): "); // arithmetic
			}while(!assistance.setProblemType(in.nextInt())); // while not failed
			// similar to setDificulty(in.nextInt())
			
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
			System.out.println(); // newline to clear stuff up
		} // end main while loop
	} // end main()
} // end public class CAI
