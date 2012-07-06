public class Grading
{
	private int correct; // correct holds the number of correct answers
	private int total; // total holds the total number of problems
	
	// constructor, one arguement that is the total
	//     number of problems
	Grading(int tempTotal)
	{
		correct = 0; // zero the correct answers
		total = tempTotal; // set the total number of problems
	} // end constructor: Grading(int)
	
	// constructor, no arguements defaults to 10 problems
	Grading()
	{
		correct = 0; // zero the correct answers
		total = 10; // set the total number of problems, default
	} // end constructor: Grading()
	
	// this method is called when a correct answer is presented
	public void markCorrect()
	{
		correct++; // increment the correct answer variable by 1
	} // end markCorrect()
	
	// this method is called when an incorrect answer is presented
	public void markIncorrect()
	{
		// does nothing since correct doesn't get incrememtned.
		// this method is mostly placeholder for potential future use.
	} // end markIncorrect()
	
	// getCorrect returns the total number of correct answers
	public int getCorrect()
	{
		return correct;
	} // end getCorrect()
	
	// getTotal returns the total number of problems
	public int getTotal()
	{
		return total;
	} // end getTotal()
	
	// returns the percentage correct answers
	public double getPercent()
	{
		return 100.0 * correct / total; // multiply by 100 to get percent, 100.0 to force double
	} // end getPercent()
	
	public void reset()
	{
		correct = 0;
	}
} // end public class Grading
