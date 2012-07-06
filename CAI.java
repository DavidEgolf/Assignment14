//
// Assignment 14, Computer-Assisted Instruction
//
// This class is the main program designed to quiz students on different
// types of math probems
//
// Author: David S. Egolf
// Creation date: July 4, 2012
// Initial coding completion date: July 6, 2012
//
// Dependencies
//
// CAIClass
//
// Bug Table
//
// N/A

import java.util.Scanner; // Scanner class

public class CAI // open the CAI class up
{
	public static void main(String [] args)
	{
		final int numProblems = 10; // this is a "hack" for a "constant"
		Scanner in = new Scanner(System.in); // need to read information
		CAIClass assistance = new CAIClass(numProblems); // Computer-Assisted Instruction object
		
		while(true) // forever...
		{
			promptDificulty(assistance, in); // get the dificulty they should expect

			promptProblemType(assistance, in); // get the type of problem they should expect
		
			quiz(assistance, in); // quiz them

			printGrade(assistance); // print their grade
			                  
			printMessage(assistance); // print the 'move on' or 'get assistance from teacher' message
		
			assistance.resetGrade(); // reset the grade for next 'student'

		} // end main while loop
	} // end main()
	
	private static void promptDificulty(CAIClass assistance, Scanner in)
	{
		do // loop for getting dificulty till it's valid
			System.out.print("What dificulty would you like (positive number only): "); // prompt for dificulty
		while(!assistance.setDificulty(in.nextInt())); // read/send dificulty to assistance
		// the previous statement has the logical not so that it returns true when it works,
		// and false when it doesn't. it has to loop when true, thus not false
	} // end promptDificulty(CAIClass, Scanner)
	
	private static void promptProblemType(CAIClass assistance, Scanner in)
	{	
		do // loop for type of arithmetic getting till it's valid
		{
			System.out.println("\nWhat type of arithmetic would you like?"); // prompt
			System.out.println("[1]: Addition"); // for 
			System.out.println("[2]: Subtraction"); // the 
			System.out.println("[3]: Multiplication"); // different
			System.out.println("[4]: Integer Division"); // types
			System.out.println("[5]: Mixed/All"); // of 
			System.out.print("Selection (Valid Entry Only!): "); // arithmetic
		}
		while(!assistance.setProblemType(in.nextInt())); // while not failed
		// similar to setDificulty(in.nextInt())
	} // end promptProblemType(CAIClass, Scanner)
	
	private static void quiz(CAIClass assistance, Scanner in)
	{
		for(int problemLoop = 0; problemLoop < assistance.getTotal(); problemLoop++) // give student numProb problems
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
				} // end if(!checkProblem)
			} // end for(i = 0; i < 10; i++) problem presentation loop
	} // end quiz(CAIClass, Scanner)
	
	private static void printGrade(CAIClass assistance)
	{
		System.out.printf("You scored %d/%d, that's a %f%%.\n",
					  assistance.getCorrect(),
					  assistance.getTotal(),
					  assistance.getPercent()); // print the score after 10 problems
	} // end printGrade(CAIClass)
	
	private static void printMessage(CAIClass assistance)
	{
		if(assistance.getPercent() < 75) // if they got less then a 75%
			System.out.println("Please ask your teacher for extra help."); // they need help
		else // otherwise, greater then or equal to
			System.out.println("Congratulations, you are ready to move on to the next level!"); // move on
		System.out.println(); // newline to clear stuff up
	} // end printMessage(CAIClass)
} // end public class CAI
