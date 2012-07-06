import java.util.Random; // Random number class

public class CAIClass
{
	private int randomValue1; // the first random number for problem
	private int randomValue2; // the second random numbers for problem
	private int dificulty; // dificulty of problem
	private boolean incorrect; // this variable depreciated,
	                           // previously used to loop until correct answer
	                           // presented, as per 6.35. unused as of 6.37
	private Random randomList = new Random(); // random number generator object
	private Grading gradeBook; // Grading object to measure student performance, as per 6.37
	
	// default constructor, zeroes stuff, and defautls a new gradebook
	CAIClass()
	{
		initStatic();
		gradeBook = new Grading(10); // default to 10 grades
	} // end constructor: CAIClass()
	
	// bonus constructor! specify number of problems
	CAIClass(int numProb)
	{
		initStatic();
		gradeBook = new Grading(numProb); // if CAIClass is called with an arguement,
		                                  // pass it on to gradeBook() as this is num of problems
	} // end constructor: CAIClass(int)
	
	// added as per 6.38, called in both constructors, easier to manage if seperate method
	// intiStatic() initializes the variables that aren't different between constructors
	private void initStatic()
	{
		randomValue1 = 0; // set default to 0
		randomValue2 = 0; // set default to 0
		dificulty = 0; // set default to 0
		incorrect = true; // incorrect to prevent looping, depreciated 6.37
	} // end initStatic()
	
	// isIncorrect is getter for whether the answer was incorrect
	public boolean isIncorrect() // depreciated as of 6.37
	{
		return incorrect; // this returns whether the last answer was correct or not
	} // end isIncorrect()
	
	// setIncorrect is used for setting the incorrect variable
	public void setIncorrect(boolean isIncorrect) // depreciated as of 6.37
	{
		incorrect = isIncorrect; // set the incorrectness
	} // end setIncorrect
	
	// generateProblem() generates two random integers for the problem
	public void generateProblem()
	{
		Double tempD;
		tempD = new Double(Math.pow(10, dificulty));
		randomValue1 = randomList.nextInt(tempD.intValue()); // generate the first random int
		randomValue2 = randomList.nextInt(tempD.intValue()); // generate the second random int
	} // end generateProblem()
	
	// checkProblem() check the answer given against the actual answer
	// returns true for correct, false for incorrect
	public boolean checkProblem(int answer)
	{
		if(answer == randomValue1 * randomValue2) // if the answer is correct
		{
			gradeBook.markCorrect(); // mark correct
			return true;
		} // end if(answer == realAnswer)
		gradeBook.markIncorrect(); // mark incorrect
		return false;
	} // end checkProblem()
	
	// printProblem() sends the problem to stdout
	public void printProblem()
	{
		System.out.printf("What is %d * %d: ", randomValue1, randomValue2); // simple, straightforward
	} // end printProblem()
	
	// generateCorrectMessage() returns a String containing
	// a message that the answer was correct
	public String generateCorrectMessage()
	{
		switch(randomList.nextInt(4)) // pick one randomly
		{
			case 0:
				return "Very good!";
			case 1:
				return "Excellent!";
			case 2:
				return "Nice work!";
			case 3:
				return "Keep up the good work!";
		} // end switch(randomList.nextInt(4)
		return ""; // compile error if no 'catch all' return isn't presented
	}
	
	// generateIncorrectMessage() returns a String containing
	// a message that the answer was incorrect
	public String generateIncorrectMessage()
	{
		switch(randomList.nextInt(4)) // pick one randomly
		{ // list of 4 random messages as per 6.36
			case 0:
				return "No. Please try again.";
			case 1:
				return "Wrong. Try once more.";
			case 2:
				return "Don't give up!";
			case 3:
				return "No. Keep trying.";
		} // end switch(randomList.nextInt(4)
		return ""; // compile error if no 'catch all' return isn't presented
	}
	
	// resetGrade() resets the gradeBook object for new 'student'
	public void resetGrade()
	{
		gradeBook.reset(); // reset
	} // end resetGrade()
	
	// getCorrect is getter for the number correct answers
	public int getCorrect()
	{
		return gradeBook.getCorrect(); // return it
	} // end getCorrect()
	
	// getTotal() is getter for the total number of problems
	public int getTotal()
	{
		return gradeBook.getTotal(); // returns the total number of problems in gradeBook
	} // end getTotal()
	
	// getPercent gets the percent correct/total from gradebook
	public double getPercent()
	{
		return gradeBook.getPercent(); // pass it back up through
	} // end getPercent()
	
	// setDificulty sets the dificulty of problems
	// returns boolean as to whether successful or not
	public boolean setDificulty(int dif)
	{
		if(dif > 0) // if acceptable
		{
			dificulty = dif; // set it
			return true; // let the caller know
		}
		return false; // otherwise, didn't work
	} // end setDificulty(int)
} // end public class CAIClass
