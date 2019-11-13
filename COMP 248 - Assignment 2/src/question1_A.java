// -------------------------------------------------------------------------
//Assignment Assignment 2 - Question 1 (Version A)
//Written by Sangeethan Thaventhiran (40125009)
//For COMP 248 section EC
// -------------------------------------------------------------------------

// This program takes input from the user and turns it into the corresponding
// Persian month with the appropriate season. (with if/else statments)


import java.util.Scanner;
public class question1_A {

	public static void main(String[] args) {
	
	Scanner Input = new Scanner(System.in);
	int Month;
	int SeasonDigit;
	String Season="";
	String PersianMonth="";
	
	System.out.println("-------------------------------------------------------------------------");
	System.out.println("Welcome to the Persian Month Converter");
	System.out.println("-------------------------------------------------------------------------\n");
	System.out.print("Please enter the month as a number: ");
	
	Month=Input.nextInt(); //prompt user
	
	while(Month<1||Month>12) {
		System.out.println("That is not a valid number");					//validating input
		System.out.print("Please enter a valid number from 1 to 12: ");
		Month=Input.nextInt();
	}
	
	SeasonDigit=(Month-1)/3;												//math associated with finding the season
	
	if(SeasonDigit==0) Season="Happy Spring";								//checking the season
	else if(SeasonDigit==1) Season="Have Fun in Summer";
	else if(SeasonDigit==2) Season="Ready for Fall";
	else if (SeasonDigit==3) Season="Keep Yourself warm in Winter";
	
	if(Month==1) PersianMonth="Farvadin";									//checking the corresponding month
	else if(Month==2) PersianMonth="Ordibehesht";
	else if(Month==3) PersianMonth="Khordad";
	else if(Month==4) PersianMonth="Tir";
	else if(Month==5) PersianMonth="Mordad";
	else if(Month==6) PersianMonth="Shahrivar";
	else if(Month==7) PersianMonth="Mehr";
	else if(Month==8) PersianMonth="Aban";
	else if(Month==9) PersianMonth="Azar";
	else if(Month==10) PersianMonth="Dey";
	else if(Month==11) PersianMonth="Bahman";
	else if(Month==12) PersianMonth="Esfand";
	
	System.out.println("We are in "+PersianMonth+", "+Season);				//output
	
	
	Input.close();
	}

}
