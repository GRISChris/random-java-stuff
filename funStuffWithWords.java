/**
*	FINALLY AN IDEA FROM MY HEAD
*	its very simple word manipulation stuff
*	but hey its better than another calculator
*	
*	TODO:
*	comments, comments, comments, comments, comments........
**/

import java.util.*;

public class funStuffWithWords
{
	public static final Scanner input = new Scanner(System.in);

	static void caesarEncrypt(String[] text)
	{
		int[] textInt = new int[text.length];
		char textChar;
		int shiftBy, asciiNumber, parsedString;

		do
		{
			try
			{
				System.out.println("Please input number to shift the string by");
				shiftBy = input.nextInt();

				for(int i = 0; i < text.length; i++)
				{
					/**
					*	LONG STUPID EXPLANATION INCOMING BECAUSE IM DUMB AND IS TRYING TO MAKE MY OWN (CRAPPY) ALGORITHM FOR THE CIPHER
					*	So basically how this works
					*	when the ASCII number hits less than 32 (space), it will go back up to 126 (~) and is decremented by the needed amount
					*	vice versa for 126, when it hits over 126 it will go down to 32 and is incremented by the needed amount
					*	
					*	for example:
					*	124 + 5 = 129, we dont want that, so when it hits 126 which basically means,
					*	126 + 3
					*	we loop the number back to 32
					*	32 + 3 = 35,
					*	which is the ASCII code for #
					**/

					textChar = text[i].charAt(0);
					parsedString = (int) textChar;

					textInt[i] = parsedString + shiftBy;
					if(textInt[i] < 32)
					{
						//assume shiftBy is negative (-1 ~ -infinity or something)
						asciiNumber = (parsedString - 32) + shiftBy;
						textInt[i] = 126 + asciiNumber;
					}
					else if(textInt[i] > 126)
					{
						//assume shiftBy is positive (1 ~ infinity or smth)
						asciiNumber = (parsedString + shiftBy) - 126;
						textInt[i] = 32 + asciiNumber;
					}

					text[i] = Character.toString((char) textInt[i]);
				}

				break;
			}
			catch(InputMismatchException notInteger)
			{
				System.out.println("Wrong input (input only accepts numbers!)");
				continue;
			}
		}
		while(true);

		for(String j: text)
		{
			System.out.print(j);
		}
	}

	static void caesarDecrypt(String[] text)
	{
		/**
		*
		*	This is literally the same code but instead of doing addition, it does subtraction to the ASCII code
		*
		**/

		int[] textInt = new int[text.length];
		char textChar;
		int shiftBy, asciiNumber, parsedString;

		do
		{
			try
			{
				System.out.println("Please input decode number/key");
				shiftBy = input.nextInt();

				for(int i = 0; i < text.length; i++)
				{
					textChar = text[i].charAt(0);
					parsedString = (int) textChar;

					textInt[i] = parsedString - shiftBy;
					if(textInt[i] < 32)
					{
						//assume shiftBy is negative (-1 ~ -infinity or something)
						asciiNumber = (parsedString - 32) - shiftBy;
						textInt[i] = 126 + asciiNumber;
					}
					else if(textInt[i] > 126)
					{
						//assume shiftBy is positive (1 ~ infinity or smth)
						asciiNumber = (parsedString - shiftBy) - 126;
						textInt[i] = 32 + asciiNumber;
					}

					text[i] = Character.toString((char) textInt[i]);
				}

				break;
			}
			catch(InputMismatchException notInteger)
			{
				System.out.println("Wrong input (input only accepts numbers!)");
				continue;
			}
		}
		while(true);

		for(String j: text)
		{
			System.out.print(j);
		}
	}

	//this function reverses the string and prints it out
	static void reverser(String[] text)
	{
		String[] desrever = new String[text.length];
		int k = 0;

		for(int i = text.length-1; i >= 0 ; i--)
		{
			desrever[k] = text[i];
			k++;
		}

		//print array
		for(String j: desrever)
		{
			System.out.print(j);
		}
	}

	static String[] splitter(String text)
	{
		String[] textArray = new String[text.length()];

		for (int i = 0; i < text.length(); i++)
		{
			textArray[i] = text.substring(i, i+1);
		}

		return textArray;
	}

	public static void main(String[] args)
	{
		String text;
		int option;

		System.out.println("Input text");
		text = input.nextLine();

		do
		{
			try
			{
				System.out.println("Input an option: \n1. Reverse \n2. Encrypt (Caesar) \n3. Decrypt (Caesar)");
				option = input.nextInt();
			
				switch(option)
				{
					case 1:
					reverser(splitter(text));
					break;

					case 2:
					caesarEncrypt(splitter(text));
					break;

					case 3:
					caesarDecrypt(splitter(text));
					break;

					default:
					throw new InputMismatchException();
				}

				break;
			}
			catch(InputMismatchException falseInput)
			{
				System.out.println("Input not recognized, please try again");
				continue;
			}
		}
		while(true);
	}
}