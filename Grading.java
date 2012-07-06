//
// Assignment 14, Computer-Assisted Instruction (Grading Class)
//
// This class handles the correct/incorrect numbers to grade the user
// to hide it from the CAIClass. Just to seperate it a bit.
//
// Author: David S. Egolf
// Creation date: July 5, 2012
// Initial coding completion date: July 6, 2012
//
// Dependencies
//
// N/A
//
// Bug Table
//
// N/A

public class Grading
{
	private int correct; // correct holds the number of correct answers
	private int incorrect; // incorrect holds the number of incorrect answers
	private int total; // total holds the total number of problems
	
	// constructor, one arguement that is the total
	//     number of problems
	Grading(int tempTotal)
	{
		correct = incorrect = 0; // zero the correct answers
		total = tempTotal; // set the total number of problems
	} // end constructor: Grading(int)
	
	// constructor, no arguements defaults to 10 problems
	Grading()
	{
		correct = incorrect = 0; // zero the correct answers
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
		incorrect++; // increment the incorrect answer variable by 1
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
		return 100.0 * correct / total; // multiply by 100 to get percent,
		                                // 100.0 to force double
	} // end getPercent()
	
	// reset() resets the correct/incorrect variables for next 'student'
	public void reset()
	{
		correct = 0; // zero correct
		incorrect = 0; // zero incorrect
	} // end reset()
} // end public class Grading
