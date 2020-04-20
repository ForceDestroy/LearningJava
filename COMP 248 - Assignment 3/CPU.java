// -------------------------------------------------------------------------
//Assignment Assignment 3 - Question 2 
//Written by Sangeethan Thaventhiran (40125009)
//For COMP 248 section EC
// -------------------------------------------------------------------------

// THis is the java file that contains all the methods that were created

public class CPU {	//setting up the private variables

	private int gen;
	private String series;
	private double suggestedPrice;
	private double speed;
	private String launchDate;
	private boolean SGX;

	public CPU() {	//default for the constructor
		gen = 1;
		series = "i3";
		suggestedPrice = 117;
		speed = 2.93;
		launchDate = "Q1'10";
		SGX = false;
	}
	
	public CPU(int gen, String series, double suggestedPrice, double speed, String launchDate, boolean SGX) {//constructor setup to take input
		this.gen = gen;
		this.series = series;
		this.suggestedPrice = suggestedPrice;
		this.speed = speed;
		this.launchDate = launchDate;
		this.SGX = SGX;
	}
	
	public int getGen() { //accessor for the gen variable
		return gen;
	}
	
	public String getSeries() { //accessor for the series variable
		return series;
	}
	
	public double getPrice() { //accessor for the price variable
		return suggestedPrice;
	}
	public double getSpeed() {	//accessor for the speed variable
		return speed;
	}
	public String getLaunch() {	//accessor for the launchDate variable
		return launchDate;
	}
	public boolean getSGX() {	//accessor for the SGX variable
		return SGX;
	}
	
	
	public double setPrice(double Price) {	//mutator to change the suggestedPrice to Price
		this.suggestedPrice = Price;
		return suggestedPrice;
	}
	
	public double priceNow(String sQuarterYear) {	//method to calculate the drop in price
		double Price = this.suggestedPrice;	//starting price
		double currentPrice = 0;
		
		int qThen = (int) launchDate.charAt(1);	//find the quarter
		String year = "";//initialize the string
		
		year += launchDate.charAt(3); //add the first digit of the year
		year += launchDate.charAt(4); //add the second digit of the year
		
		int yearThen = Integer.parseInt(year);	//parse the string into a number
		
		int qNow = (int) sQuarterYear.charAt(1);	//find the quarter
		year = "";	//reset the string
		
		year += sQuarterYear.charAt(3);//add the first digit of the year
		year += sQuarterYear.charAt(4);//add the second digit of the year
		
		int yearNow = Integer.parseInt(year); //parse the string into a number
		
		int quarters = (4-qThen)+(yearNow-yearThen-1)*4+qNow+1;	//math for the number of quarters between Then and Now
		
		if(quarters>0) {	//check if Then is before Now
			currentPrice = Price*(1-(0.02*quarters));	//if so, then lower the price by 2% for each quarter
		}else {
			currentPrice = Price;	//if not, keep the same price
		}
		
		return currentPrice;	//return the current price
	}
	
	public String toString() {
		if(SGX == true) {	//if SGX is true, write out the following string
		return "This CPU is a " + gen +"th generation " + series + " (" + speed + "), launched: " + launchDate + " with price: "+suggestedPrice+" USD. SGX is supported.";
		}
		else {	//if SGX is false, write out the following string
		return "This CPU is a " + gen +"th generation " + series + " (" + speed + "), launched: " + launchDate + " with price: "+suggestedPrice+" USD. SGX is not supported. ";	
		}
	}
	
	public boolean equals(CPU Second) {	//boolean to check if all 3 variables are the same
	boolean equals = this.gen == Second.getGen() && this.series.equalsIgnoreCase(Second.getSeries()) && this.SGX == Second.getSGX();	//comparing the current variable to the called variable
	
	return equals;
	}
	
	public boolean isHigherGeneration(CPU Second) {	//boolean to check if its a higher generation
		boolean Higher = this.gen > Second.getGen();
		
		return Higher;
	}
}