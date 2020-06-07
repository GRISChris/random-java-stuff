/**
*	Not really FAQ:
*
*	WHY DID YOU MAKE ANOTHER CALCULATOR?
*	i'm not the best at ideas ok
*
*	TODO:
*	rewrite some code maybe if possible
**/

import java.util.*;

public class calculatorInRealLoife
{
	public static final Scanner input = new Scanner(System.in);

	//this function does that it says
	public static Boolean checkIfDone(Boolean isDone, String nag)
	{
		String yeahImDone;
		Boolean noMismatch = false;

		do
		{
			try
			{
				System.out.println(nag);

				yeahImDone = input.next();
				if(yeahImDone.equals("y"))
				{
					isDone = true;
				}
				else if(yeahImDone.equals("n"))
				{
					isDone = false;
				}
				else
				{
					throw new InputMismatchException();
				}

				noMismatch = true;
			}
			catch (InputMismatchException smh)
			{
				smh.printStackTrace();
				System.out.println("Error. Please input again!");
			}
		}
		while(!noMismatch);

		return isDone;
	}

	/**
	* 	top text
	*	I DONT KNOW HOW TO MAKE THESE FUNCTIONS LESS REPETITIVE HELP
	*	bottom text
	**/
	public static ArrayList<Double> add(ArrayList<Double> a)
	{
		double result = 0;

		//get every element in arraylist
		for (double i: a)
		{
			//...and smash them together
			result = result + i;
		}

		//Clears content of a and add result in a[0]
		a.clear();
		a.add(result);

		//return the entire arrayList
		return a;
	}

	public static ArrayList<Double> subtract(ArrayList<Double> a)
	{
		double result = a.get(0);

		//use normal for loop...
		for (int i = 1; i < a.size(); i++)
		{
			//... so i can subtract index 0 with the next index
			result = result - a.get(i);
		}

		//Clears content of a...
		a.clear();
		a.add(result);

		//return entire array
		return a;
	}

	public static ArrayList<Double> multiply(ArrayList<Double> a)
	{
		double result = a.get(0);

		//use normal for loop...
		for (int i = 1; i < a.size(); i++)
		{
			//... so i can multiply index 0
			result = result * a.get(i);
		}

		//...and add result in a[0]
		a.clear();
		a.add(result);

		//return
		return a;
	}

	public static ArrayList<Double> divide(ArrayList<Double> a)
	{
		//get first index
		double result = a.get(0);

		//use normal for loop...
		for (int i = 1; i < a.size(); i++)
		{
			//...so i can-- you know what im tired of copy pasting this
			result = result / a.get(i);
		}

		//i dont want to explain this again smh
		a.clear();
		a.add(result);

		//ye
		return a;
	}

	public static void actualCalculation(int choice)
	{
		//im using arraylist so multiple numbers can be calculated without hassle
		//i'd also love another solution for multiple inputs though
		//sorry for the variable naming i cant think up of a good name
		Double string2Double;
		String stringInput;
		ArrayList<Double> number = new ArrayList<Double>();
		boolean check = false, validNumber = false;

		/**
		*	I decided to make the input string
		*	and to convert it to double if input is a number
		*	use string as confirmation to disable the checkIsDone function being called everytime they type something
		**/
			do
			{
				do
				{
					try
					{
						System.out.println("Input a number, or type 'ex' if you're done typing numbers");
						stringInput = input.next();

						//try to convert the string to double
						try
						{
							string2Double = Double.valueOf(stringInput);
							number.add(string2Double);
						}
						catch (NumberFormatException notNumber) //this basically just means if the String variable is not a number
						{
							//we check if the user inputted ex 
							if(stringInput.matches("(?i)ex"))
							{
								check = true;
							}
							else
							{
								System.out.println("Error, unrecognizable command");
								continue;
							}
						}

						validNumber = true;
					}
					catch (InputMismatchException bruh)
					{
						bruh.printStackTrace();
						System.out.println("Error, please re-input");
					}
				}
				while(!validNumber);

				//if not finished, set all boolean back to false
				//prevents try catch loop to fail and it skipping to checkIfDone function call
				if(!check)
				{
					validNumber = false;
				}
			}
			while(!check);

		switch(choice)
		{
			//probably self-explanatory
			case 1:
			number = add(number);
			break;

			case 2:
			number = subtract(number);
			break;

			case 3:
			number = multiply(number);
			break;

			case 4:
			number = divide(number);
			break;

			//if this happens idk what i'd do tbh
			default:
			System.err.println("Special Error occured");
		}

		System.out.println("Calculation done! result : " + number.get(0));
	}

	public static void main(String[] args)
	{
		String choice;
		int choiceConfirm = 0;
		Boolean valid = false, finished = false;
		
		//purpose of this is so that it'd loop till the people that tries out my program gets bored of laughing at my code and ends the program
		do
		{
			do
			{
				//makes a loop everytime an oopsie happens until properly inputted
				try
				{
					System.out.println("Please insert your command,\nyou can put symbols (+, -, *, /) or type in add/subtract/multiply/divide");
					choice = input.next();
					if (choice.matches("(?i)add|\\+"))
					{
						choiceConfirm = 1;
					}
					else if (choice.matches("(?i)subtract|\\-"))
					{
						choiceConfirm = 2;
					}
					else if (choice.matches("(?i)multiply|\\*"))
					{
						choiceConfirm = 3;
					}
					else if (choice.matches("(?i)divide|/"))
					{
						choiceConfirm = 4;
					}
					else
					{
						throw new InputMismatchException();
					}

					//if no errors happens
					valid = true;
				}
				catch (InputMismatchException abc)
				{
					abc.printStackTrace();
					System.out.println("Input unrecognizable, please try again");
				}

				//if everything is set, set this to true
			}
			while(!valid);

			//call function for number inputting
			actualCalculation(choiceConfirm);

			//call function for finish checking
			finished = checkIfDone(finished, "Are you finished using the calculator? y/n");

			//if not finished, set valid to false so everything loops again
			if (!finished)
			{
				valid = false;
			}
		}
		while(!finished);
	}
}