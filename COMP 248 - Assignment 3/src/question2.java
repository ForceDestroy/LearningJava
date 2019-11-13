// -------------------------------------------------------------------------
//Assignment Assignment 3 - Question 2 
//Written by Sangeethan Thaventhiran (40125009)
//For COMP 248 section EC
// -------------------------------------------------------------------------

// This program is a basic program that outputs information on CPU's using
// public methods that we created
public class question2 {

	public static void main(String[] args) {
		
	CPU CPU1 = new CPU();	//default constructor
	CPU CPU2 = new CPU(7, "i5", 250.00, 3.4, "Q1'17", true);	//2nd constructor
	
	System.out.println("Welcome to the simple class example!\n");
	
	System.out.println(CPU1.toString());	//output for cpu1
	System.out.println(CPU2.toString());	//output for cpu2
	
	System.out.println("CPU 2 Series: " + CPU2.getSeries());	//accessor
	System.out.println("CPU 2 Speed: "+CPU2.getSpeed());		//accessor
	
	System.out.println("CPU 2 Suggested Price (after mutator call): " + String.format( "%.2f", CPU2.setPrice(200.00))+" USD");	//mutator
	
	if(CPU1.equals(CPU2)){	//equals check
		System.out.println("Are CPU 1 AND CPU 2 equal? YES");	
	}
	else {
		System.out.println("Are CPU 1 AND CPU 2 equal? NO");
	}
	
	if(CPU1.isHigherGeneration(CPU2)) { //higher gen check
		System.out.println("Is CPU 1 of higher generation that CPU 2? YES");
	}else {
		System.out.println("Is CPU 1 of higher generation that CPU 2? NO");
	}


	
	System.out.println("CPU 1 Price at Q3'19 : " + String.format( "%.2f", CPU1.priceNow("Q3'19"))+" USD");	//lowered price
	System.out.println("CPU 2 Price at Q3'19 : " + String.format( "%.2f", CPU2.priceNow("Q3'19"))+" USD");	//lowered price
	
	System.out.println("\nThank you for testing the simple class example!");
}
	
}
