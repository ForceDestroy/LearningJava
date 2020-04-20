// -----------------------------------------------------
// Assignment 1
// Part: 1
// Written by: Sangeethan Thaventhiran (40125009)
// -----------------------------------------------------

/**
 * Sangeethan Thaventhiran (40125009) 
 * COMP 249
 * Assignment #1
 * Due January 31st 2020
 */

/** 
 * Represents an appliance in an inventory for example
 * Each appliance has multiple attributes
 */
public class Appliance {

	/**
	 * This is the type of the appliance, like a dishwasher or microwave for example.
	 * There is a fixed list of options for this attribute.
	 */
	private String Type;
	
	
	/**
	 * This is a String array of all possible appliance types.
	 */
	public final static String[] ListOfTypes = {"Fridge", "Air Conditioner", "Washer", "Dryer", "Freezer", "Stove",
									"Dishwasher", "Water Heater", "Microwave"};
	
	
	/**
	 * This is the brand of the appliance, like LG or Maytag for example.
	 * This can be any String.
	 */
	
	private String Brand;
	
	/**
	 * This is serial number that represents the tag for this specific unit
	 * It is s fixed value that relates to all other appliances created.
	 */
	private long SerialNumber;
	
	/**
	 * This is the price of the appliance, in Canadian Dollars : )
	 * It can be any double above 1.
	 */
	private double Price;
	
	/**
	 * This is a static counter used to determine the Serial Number of each new Appliance.
	 * It is a shared value in order to prevent multiple appliances sharing a serial number.
	 */
	private static long Counter = 1000000;

	/**
	 * This creates a default appliance with no type, no brand, a price of 1$ and a serial number
	 * It also increases the counter, in order to keep track of individual units.
	 */
	public Appliance() {
		this.Type = null;
		this.Brand = null;
		this.SerialNumber = Counter;
		this.Price = 1;
		
		Counter++;	
	}
	
	/**
	 * This creates an appliance using 3 inputed parameters
	 * @param Type This assigns the type
	 * @param Brand This assigns the brand
	 * @param Price This assigns the price
	 * This constructor also assigns a serial number in addition to incrementing the counter.
	 */
	public Appliance(String Type, String Brand, double Price) {
		this.Type = Type;
		this.Brand = Brand;
		this.SerialNumber = Counter;
		this.Price = Price;
		
		Counter++;
	}
	
	/**
	 * This gets the appliance's type
	 * @return The appliance's type
	 */
	public String getType() {
		return this.Type;
	}
	
	/**
	 * This gets the appliance's brand
	 * @return The appliances's brand
	 */
	public String getBrand() {
		return this.Brand;
	}
	
	/**
	 * This gets the appliance's serial number
	 * @return The appliance's serial number
	 */
	public long getSerialNumber() {
		return this.SerialNumber;
	}
	
	/**
	 * This gets the appliance's price
	 * @return The appliance's price
	 */
	public double getPrice() {
		return this.Price;
	}
	
	/**
	 * This changes the type of the appliance to the passed type
	 * @param Type The type passed into the method
	 */
	public void setType(String Type) {
		this.Type = Type;
	}
	
	/**
	 * This changes the brand of the appliance to the passed brand
	 * @param Brand The brand passed into the method
	 */
	public void setBrand(String Brand) {
		this.Brand = Brand;
	}
	
	/**
	 * This changes the price of the appliance to the passed price
	 * @param Price The price passed into the method
	 */
	public void setPrice(double Price) {
		this.Price = Price;
	}
	
	/**
	 * This converts the object into a String that can be printed onto the console.
	 * @return A message with details concerning a specific appliance
	 */
	public String toString() {
		return "\nAppliance Serial #" + this.getSerialNumber() + "\nBrand: " + this.getBrand() + "\nType: " + this.getType() + "\nPrice: " + this.getPrice() + "\n";
	}
	
	/**
	 * This finds the amount of appliances created using a basic calculation
	 * @return The number of appliances created
	 */
	public long findNumberofCreatedAppliances() {
		return Counter-1000000;
	}
	
	/**
	 * Compares two appliances based on type, brand and price in order to find out if they are the same
	 * @param B A second appliance to which we are comparing the first
	 * @return A boolean value as to if they are equal
	 */
	public boolean equals(Appliance B) {
		return this.getType() == B.getType() && this.getBrand() == B.getBrand() && this.getPrice() == B.getPrice();
	}
	
	/**
	 * Compares two brands from objects to see if they are the same
	 * @param brand The brand that the user is looking for
	 * @return A boolean value to say if it's the same brand
	 */
	public boolean findAppliancesBy(String brand) {
		return this.getBrand().equals(brand);
	}
	
	/**
	 * Compares two prices to see if the object is cheaper than the inputed price
	 * @param price
	 * @return A boolean value to say if it's cheaper
	 */
	public boolean findCheaperThan(double price) {
		return this.getPrice() < price;
	}
}
