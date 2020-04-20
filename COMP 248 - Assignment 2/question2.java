// -------------------------------------------------------------------------
//Assignment Assignment 2 - Question 2 
//Written by Sangeethan Thaventhiran (40125009)
//For COMP 248 section EC
// -------------------------------------------------------------------------

// This program calculates the circumference of square from side length
// It also depicts a square with the given side length made with x's
// the square also has a \ running through the diagonal

import java.util.Scanner;
public class question2 {

	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		
		int length, circumference;
		int counter1, counter2, counter3, counter4;
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Circumference Calculator");
		System.out.println("-------------------------------------------------------------------------\n");
		System.out.print("Please enter the length of a side: ");
		
		
		
		length = Input.nextInt();	//user prompt
		circumference = length * 4;		//calculating the circumference
		
		System.out.println("The circumference of the Square is " + circumference); //output
		
		counter1 = 0;
		counter2 = length - 1;
		counter3 = length;
		counter4 = 0;
		
		
		while(counter3!=0) {				//loop for the rows
			while(counter1>0) {				//loop for x's before the \
			
				System.out.print("x ");
				counter1--;
			}
		
			System.out.print("\\ ");		//outputting the \
		
			while(counter2>0) {				//loop for the x's after the \
			
				System.out.print("x ");
				counter2--;
			}
		
			System.out.println("");
			
			counter4++;						//resetting some counters for the next row
			counter1 = counter1+counter4;
			counter2 = length -1- counter4;
			counter3--; 					//adding to the row count
	}
		
		Input.close();
}}
