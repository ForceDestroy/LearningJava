// -------------------------------------------------------------------------
//Assignment Assignment 2 - Question 3 
//Written by Sangeethan Thaventhiran (40125009)
//For COMP 248 section EC
// -------------------------------------------------------------------------

// This program is a basic mini-calculator that performs the basic operations
// It asks for user input and analyzes it char by char to extrapolate the equation

import java.util.Scanner;
public class question3 {

	public static void main(String[] args) {
		
		Scanner UserInput = new Scanner(System.in);
		
		  String input;
	      double answer = 0.0; //the answer is a double while the nums are ints
	      String num1, num2, operation;
	      int value1, value2;
	      System.out.println("-------------------------------------------------------------------------");
			System.out.println("Welcome to the Mini-Calculator");
			System.out.println("-------------------------------------------------------------------------\n");
			
		do {			//main loop used to run the calculator repeatedly until the user presses q
            System.out.print("Please enter the numbers along operation (press q to exit): ");

           input = UserInput.next();
           
            if (!(input.equals("q"))) {	//check if the input is 'q'
                int length = input.length(); //length of the input from the user
                int leftside = 0; //the number before the operand

                char left = input.charAt(leftside); //checking the character in the designated slot
                while (Character.isDigit(left)) { //checks until the char is not a digit
                    leftside++; //counter to check the next character
                    left = input.charAt(leftside);
                }
                num1 = input.substring(0, leftside); //the numbers before the operand as a String
                value1 = Integer.parseInt(num1); //parsing num1 into an integer
                num2 = input.substring(leftside + 1, length); //the numbers after the operand as a String
                value2 = Integer.parseInt(num2); //parsing num2 into an integer
                operation = Character.toString(left); //finding the char for the operator

                switch (operation) { //calculation based on the type of operator

                case "+":
                    answer = value1 + value2;
                    break;

                case "-":
                    answer = value1 - value2;
                    break;

                case "*":
                    answer = value1 * value2;
                    break;

                case "/": {
                    double value1d = value1;
                    double value2d = value2;

                    answer = value1d / value2d;
                    break;
                }
                }

                System.out.println("The answer is: " + answer + "\n"); //output

            }
           
        } while (!(input.equalsIgnoreCase("q"))); //part of the main loop at the top
		
		System.out.println("Thanks for using mini calculator."); //message when they press q
		
		UserInput.close();
}
}