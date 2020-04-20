// -------------------------------------------------------------------------
//Assignment Assignment 2 - Question 1 (Version B)
//Written by Sangeethan Thaventhiran (40125009)
//For COMP 248 section EC
// -------------------------------------------------------------------------

// This program takes input from the user and turns it into the corresponding
// Persian month with the appropriate season. (with switches)

import java.util.Scanner;
public class question1_B {

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
		
		Month=Input.nextInt();
		
		while(Month<1||Month>12) {						// validating input
			System.out.println("That is not a valid number");
			System.out.print("Please enter a valid number from 1 to 12: ");
			Month=Input.nextInt();
		}
		
		SeasonDigit=(Month-1)/3;						//math for finding the season
		
		switch(SeasonDigit) {							//associating the proper season
		case 0: Season = "Happy Spring";
		break;
		case 1: Season = "Have Fun in Summer";
		break;
		case 2: Season = "Ready for Fall";
		break;
		case 3: Season = "Keep Yourself warm in Winter";
		break;
		default:;
		}
		
		switch(Month) {									//associating the corresponding month
		case 1: PersianMonth="Farvadin";
		break;
		case 2: PersianMonth="Ordibehesht";
		break;
		case 3: PersianMonth="Khordad";
		break;
		case 4: PersianMonth="Tir";
		break;
		case 5: PersianMonth="Mordad";
		break;
		case 6: PersianMonth="Shahrivar";
		break;
		case 7: PersianMonth="Mehr";
		break;
		case 8: PersianMonth="Aban";
		break;
		case 9: PersianMonth="Azar";
		break;
		case 10: PersianMonth="Dey";
		break;
		case 11: PersianMonth="Bahman";
		break;
		case 12: PersianMonth="Esfand";
		break;
		default:;
		}
		
		System.out.println("We are in "+PersianMonth+", "+Season);	//output
		
		Input.close();

	}

}
