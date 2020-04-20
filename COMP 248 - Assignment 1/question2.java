// -------------------------------------------------------------------------
//Assignment Assignment 1 - Question 2
//Written by Sangeethan Thaventhiran (40125009)
//For COMP 248 section EC
// -------------------------------------------------------------------------

// This program takes seconds in a day, and converts them to a valid time with corresponding hours, minutes and seconds, 
// if no valid time is found, it switches the first and last digit of the input, and finds the corresponding hours, minutes and seconds


import java.util.Scanner;
public class question2 {

	public static void main(String[] args) {
		
		Scanner Input = new Scanner(System.in); //setting up scanner for user input
		
		int MaxSeconds = 99999; // setting boundary for 5 digit number (not mandatory if user is perfect)
		int MinSeconds = 0; // setting boundary for 5 digit number (not mandatory if user is perfect)
		int MinInvalidTime = 86400; // this is the amount of seconds in 24 hours, a constant used to determine whether or not we need to
									// flip the first and last digit
		final int SECONDSINMINUTE = 60; // this constant will be used to calculate the number of minutes from the entered seconds
		final int SECONDSINHOUR = 3600; // this constant will be used to calculate the number of hours from the entered seconds
		
		System.out.println("*****************************************************");    
		System.out.println("Welcome to the Time Converter Program");
		System.out.println("*****************************************************\n");
		System.out.print("Please enter the seconds to be converted: ");
		
		int Seconds = Input.nextInt(); // asking user to give input
		
		while(Seconds>MaxSeconds || Seconds<MinSeconds){	// this loop will be used to make sure that the input is a valid positive 5 
															// digit number
			
			System.out.print("Please enter a valid 5 digit number: ");
			Seconds = Input.nextInt();
			
		}
		

		 if(Seconds>MinInvalidTime) { // this if statement is used when the number entered is higher than the number of seconds in a day
			 						  // we will invert the first and last digit in this area.
			 
			 int Hours = Seconds/SECONDSINHOUR; // this finds the number of hours of the original input
			 int Minutes = ((Seconds-(SECONDSINHOUR*Hours))/SECONDSINMINUTE); // this find the number of minutes of the original input
			 int Sec = Seconds - SECONDSINHOUR* Hours - SECONDSINMINUTE*Minutes; // this finds the number of seconds of the original input
			 
			 System.out.println("The corresponding hours, minutes & seconds is "+Hours+" hrs, "+Minutes+" mins, "+Sec+" secs.");
			 int n = 0; 				// This loop divides the number of seconds by 10 and adds + 1 to the counter n, which represents
			 int Seconds2 = Seconds; 	// the number of digits in the entered number. This will be used to to invert the number. 
		 	 while(Seconds2>0)			// Seconds2 will become obsolete after finding the number of digits
 			 {
		 		 Seconds2 /= 10;		// since the variable is in int, the final division will lead the 0 eventually
		 		 n++;					// this counter will tell the number of digits in the entered number
			 }
		 
			 int firstDigit = Seconds/(int)Math.pow(10,n-1); // this calculation divides the entered number by a power of 10, in order to discover
			 												 // the first digit
			 int lastDigit = Seconds%10; // this calculation finds the last digit of the input

			 Seconds = (Seconds%(int)Math.pow(10,n-1))+(lastDigit*(int)Math.pow(10,n-1)); // this changes the first digit to the last digit
			 Seconds = Seconds/10; // this, combined with the next step, removes the last digit, since its an int
			 Seconds = Seconds*10+firstDigit; // this removes the last digit, and adds the original first digit, as the last digit
		
			 
			 Hours = Seconds/SECONDSINHOUR; // this finds the number of hours
			 Minutes = ((Seconds-(SECONDSINHOUR*Hours))/SECONDSINMINUTE); // this find the number of minutes
			 Sec = Seconds - SECONDSINHOUR* Hours - SECONDSINMINUTE*Minutes; // this finds the number of seconds
			 
			 System.out.println("There is no valid time for your input.");
			 System.out.println("The swapped sequence for your input is "+Seconds);
			 System.out.println("The corresponding hours, minutes & seconds is "+Hours+" hrs, "+Minutes+" mins, "+Sec+" secs.");
			 System.out.println("Thank you for using the Time Converter Program");
			 Input.close();
		 }
		 else {
			 
			 int Hours = Seconds/SECONDSINHOUR; // this finds the number of hours
			 int Minutes = ((Seconds-(SECONDSINHOUR*Hours))/SECONDSINMINUTE); // this find the number of minutes
			 int Sec = Seconds - SECONDSINHOUR* Hours - SECONDSINMINUTE*Minutes; // this finds the number of seconds
			 
			 System.out.println("The corresponding hours, minutes & seconds is "+Hours+" hrs, "+Minutes+" mins, "+Sec+" secs.");
			 System.out.println("The valid time is "+String.format("%02d",Hours)+":"+String.format("%02d",Minutes)+":"+String.format("%02d",Sec));
			 System.out.println("Thank you for using the Time Converter Program");
			 Input.close();
			 
		 }
		
	}

}
