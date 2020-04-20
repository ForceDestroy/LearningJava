// -----------------------------------------------------
// Assignment 1
// Part: 2
// Written by: Sangeethan Thaventhiran (40125009)
// -----------------------------------------------------
import java.util.Scanner;
public class InventoryTracker extends Appliance{
	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);		// A scanner in order to take user input
		int inventoryLimit;							// A value that represents the max amount of units that can be stored
		int userInput = 0;							// A value that represents the user's choice for menu option (1-5)
		
		int retryChoice;							// A value used in order to break out of loop later in the code
		boolean typeCheckerCounter = false;			// A value to see if the entered string matches a possible appliance type
		
		final String PASSWORD = "c249";				// The password to access option 1 and option 2
		int failedAttempts = 0;						// A tracker for the number of failed attempts before an exit
		int failedExits = 0;						// A tracker for the number of exits before a shutdown
		String passwordInput = "";					// The user's password attempt
		
		System.out.println("*******************************************");
		System.out.println("Welcome to the Appliance Inventory Tracker!");
		System.out.println("*******************************************\n");
		
		System.out.print("Please enter the maximum amount of units that can be housed in your warehouse: ");
		inventoryLimit = keyb.nextInt();			// Assigning the max number of units
		
		Appliance[] Inventory = new Appliance[inventoryLimit];		// Creating an array for housing the unit details
		
		do{											// The main loop where all the options are housed
			
			if(failedExits == 4) {					// Loop when 4 exits are detected, resulting in a system shutdown
				System.out.println("Program detected suspicious activities and will terminate immediately!");
				System.exit(0);
			}
			
			int emptyInventorySlots = 0;			// A value for the available spots to house units
			for(int i = 0; i < Inventory.length; i++ ) {			// A loop to find the number of empty slots in the array
				if(Inventory[i] == null) {
					emptyInventorySlots++;
				}
			}
			
			int inventorySlotCounter = Inventory.length - emptyInventorySlots;	// A value where the next unit can be inserted
			
			System.out.println("\nWhat do you want to do?");
			System.out.println("1. Enter new appliances (Password required)");
			System.out.println("2. Change information on existing appliances (Password required)");
			System.out.println("3. Display all appliances from a certain brand");
			System.out.println("4. Display all appliances below a certain price");
			System.out.println("5. Quit");
			System.out.print("Please enter your choice: ");
			userInput = keyb.nextInt();

			option1: if(userInput == 1) {			// If the user want to add appliances
				passwordInput = "";					// Resetting the password attempt (from option 2)
				int newUnits;						// The number of appliances the user wants to add
				String typeInput="";				// The inputed type
				String brandInput="";				// The inputed brand
				double priceInput=0;				// The inputed price
				
				while(passwordInput.equals(PASSWORD) == false) {				//The loop to check the password
					System.out.print("Please enter the password to proceed: ");
					passwordInput = keyb.next();
					failedAttempts++;
					
					if(failedAttempts == 3) {		// Check if the loop needs to exit
						failedExits++;
						failedAttempts = 0;
						break option1;
					}
					
				}
				
				failedAttempts = 0;					// Reset the attempts if successful
				failedExits = 0;					// Reset the exits counter if successful
				
				System.out.print("\nPlease enter how many units you would like to add: ");
				newUnits = keyb.nextInt();			// Assigning the number of new units
				
				if(newUnits > emptyInventorySlots) {						// Check if there's enough space	
					System.out.println("Error! There are only " + emptyInventorySlots + " slots left!");
					break option1;						
				}else {
					for(int j = 0; j < newUnits; j++) {						// For each new unit, ask the details and store them
						System.out.println("");
						do {
							
							typeCheckerCounter = false;
							
							System.out.println("Your options are: Fridge, Air Conditioner, Washer, Dryer, Freezer, Stove, Dishwasher, Water Heater, Microwave");
							System.out.print("Please enter the type of unit #" + (j+1) + ": ");
							typeInput = keyb.nextLine();
							

							for(int k = 0; k < ListOfTypes.length;k++) {	// Check if the type matches one of the possibilities
								if(typeInput.equals(ListOfTypes[k])) {
									typeCheckerCounter = true;
								}
							}
						}while(typeCheckerCounter == false);
						
						System.out.print("Please enter the brand of unit #" + (j+1) + ": ");
						brandInput = keyb.nextLine();
						
						do {
							System.out.print("Please enter the price of unit #" + (j+1) + ": ");
							priceInput = keyb.nextDouble();
						}while(priceInput < 1);
						
						Appliance Unit = new Appliance(typeInput, brandInput, priceInput);	// Creating the object
						Inventory[inventorySlotCounter + j] = Unit;							// Storing the unit in the array
					}
				}
				
			}
			
			option2: if(userInput == 2) {		// If the user wants to edit an appliance
				passwordInput = "";				// Resetting the password attempt (from option 1)
						
				long serialInput = 0;			// The inputed serial number
				boolean serialLocated = false;	// A boolean to see if it matches any stored appliances
				int modifyChoice;				// A value representing the choices in the inner menu (1-4)
				
				String newBrand = "";			// The new brand value
				String newType = "";			// The new type value	
				double newPrice = 0;			// The new Price value
				
				while(passwordInput.equals(PASSWORD) == false) {	// Same password check
					System.out.print("Please enter the password to proceed: ");
					passwordInput = keyb.next();
					failedAttempts++;
					
					if(failedAttempts == 3) {	// Same exit loop, but does shutdown system after 4 exits
						failedAttempts = 0;
						break option2;
					}
					
				}
				
				failedAttempts = 0;				// Reset if successful
				failedExits = 0;				//Reset if successful
				
				while(serialLocated == false) {		// Main loop to check for serial numbers
					System.out.print("Please enter the serial number of the unit you would like to modify: ");
					serialInput = keyb.nextInt();
					
					for(int k = 0; k < Inventory.length; k++) {	// Loop through the array to see if anything matches
						if(Inventory[k] != null && serialInput == Inventory[k].getSerialNumber()) {	//If it matches
							serialLocated = true;
							
							System.out.println(Inventory[k]);
							
							System.out.println("What information would you like to change?");
							System.out.println("1. Change the Brand");
							System.out.println("2. Change the type");
							System.out.println("3. Change the price");
							System.out.println("4. QUIT");
							System.out.print("Please enter your choice: ");
							
							modifyChoice = keyb.nextInt();
							
							if(modifyChoice == 1) {		// Change brand
								System.out.print("Please enter the new Brand for this appliance: ");
								newBrand = keyb.next();
								Inventory[k].setBrand(newBrand);
							}
							
							if(modifyChoice == 2) {		// Change type
								typeCheckerCounter = false;
								do {
									System.out.print("Please enter the new Type for this appliance: ");
									newType = keyb.next();
									
									for(int j = 0; j < ListOfTypes.length;j++) {	// Check if valid type
										if(newType.equals(ListOfTypes[j])) {
											typeCheckerCounter = true;
										}
									}
									
									Inventory[k].setType(newType);
									
									
								}while(typeCheckerCounter== false);
							}
							
							if(modifyChoice == 3) {		// Change price
								do {
									System.out.print("Please enter the new Price for this appliance: ");
									newPrice = keyb.nextDouble();
									Inventory[k].setPrice(newPrice);
								}while(newPrice < 1);
							}
							
							if(modifyChoice == 4) {
								break option2;
							}
						}
					}
					
					if(serialLocated == false) {	//If nothing matches
						System.out.print("Error! No unit was found with this serial number. Would you like to try again? [Enter 0 to try again/Enter any other number to quit this menu]: ");
						retryChoice = keyb.nextInt();
						
						if(retryChoice != 0) {		// Retry with different serial number or leave
							break option2;
						}
					}

				}
			}
			
			option3: if(userInput == 3) {		// If user wants to see all products from a specific brand
				String brandSearch = "";		// The search input
				boolean searchPositive = false;	// If the input matches a brand in the array
			
				do{		
					System.out.print("Please enter the name of the brand you are looking for: ");
					brandSearch = keyb.next();
				
					for(int i=0; i<Inventory.length;i++) {	//Use the static method to check if the brand matches any in the array
						if(Inventory[i] != null && Inventory[i].findAppliancesBy(brandSearch)) { //if anything matches
							searchPositive = true;
							System.out.print(Inventory[i]);
						}
					}
					if(searchPositive == false) {	//If nothing matches, it asks if they want to retry or leave
						System.out.print("Error! No unit was found with this brand. Would you like to try again? [Enter 0 to try again/Enter any other number to quit this menu]: ");
						retryChoice = keyb.nextInt();
						
						if(retryChoice != 0) {
							break option3;
						}
					}
	
				}while(searchPositive == false); 
			}
				
			
			option4: if(userInput == 4){		// If user wants to sort under a specific price
				double priceSearch = 0;			// The input for the max price they are looking for
				boolean searchPositive = false;	// Boolean to show if the reach 
			
				do{		
					System.out.print("Please enter your upper bound for price: ");
					priceSearch = keyb.nextDouble();
				
					for(int i=0; i<Inventory.length;i++) {			// Print out all the appliances that match the price range
						if(Inventory[i] != null && Inventory[i].findCheaperThan(priceSearch)) {
							searchPositive = true;
							System.out.print(Inventory[i]);
						}
					}
					if(searchPositive == false) {					// Message if nothing is found below the inputed price
						System.out.print("Error! No unit was found below that price. Would you like to try again? [Enter 0 to try again/Enter any other number to quit this menu]: ");
						retryChoice = keyb.nextInt();
						
						if(retryChoice != 0) {
							break option4;
						}
					}
			}while(searchPositive == false); 
			}
			}while(userInput != 5);
			
		keyb.close();
		System.out.println("Thank you for using the Appliance Inventory Tracker! Your inventory will not be saved for privacy reasons.");	// Exit statement
		System.exit(0);
	}

}
