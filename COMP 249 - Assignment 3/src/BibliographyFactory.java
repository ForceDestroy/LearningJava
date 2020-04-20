import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BibliographyFactory{

	//Setting up the array of files & names
	private static File[] originalFiles = new File[10];
	private static String[] originalNames = new String[10];
	private static File[] ieeeFiles = new File[10];
	private static File[] acmFiles = new File[10];
	private static File[] njFiles = new File[10];

	/**
	 * This function attempts to generate the copies of the 10 files, in the approprirate format
	 */
	public static void processFilesForValidation() {

		//Setting up the writers to each file and a reader
		PrintWriter pwIEEE = null;
		PrintWriter pwACM = null;
		PrintWriter pwNJ = null;
		Scanner sc = null;

		//The amount of tokens, in order to setup a String array 
		int count = 0;

		//Main Loop to check each of the 10 given files
		for (int i = 0; i < originalFiles.length; i++) {
			
			//Setting up the arrays for the tags and content (like a dictionary) as well as a String containing the whole content of the file
			String[] value = null;
			String[] valueType = null;
			String fileContent = "";
			
			//Trying to open the file to read
			try {
				System.out.println("Working on " + originalFiles[i].getName());
				
				//Linking the scanner to read the current file in the loop
				sc = new Scanner(new FileInputStream(originalFiles[i].getName()));
				
				//Linking the print writers to new files named accordingly
				pwIEEE = new PrintWriter(new FileOutputStream(ieeeFiles[i].getName()));
				pwACM = new PrintWriter(new FileOutputStream(acmFiles[i].getName()));
				pwNJ = new PrintWriter(new FileOutputStream(njFiles[i].getName()));
				
				//Reading the whole file into a single string
				while (sc.hasNextLine())
					fileContent += sc.nextLine() + "\n";
				
				//Splitting the string into tokens based on the 'equal' sign 
				StringTokenizer stknzr1 = new StringTokenizer(fileContent, "=");

				//The loop to evaluate what each token is
				for (int j = 0; stknzr1.hasMoreTokens(); j++) {
					
					//If its the first line, setup the 'value' and 'valueType' array, else just append the value
					if (j == 0) {
						String s1 = stknzr1.nextToken("\n");

						count = stknzr1.countTokens() + 1;

						value = new String[count];
						valueType = new String[count];
						value[j] = s1;
					} else {
						value[j] = stknzr1.nextToken("\n");
					}
					
					//This determines the beginning of each article
					if (value[j].contains("@ARTICLE")) {
						value[j] = "@ARTICLE";
						valueType[j] = "@ARTICLE";
						
						continue;
					}

					//This determines the end of each article
					if (value[j].equals("}")) {
						value[j] = "EoA";
						valueType[j] = "EoA";
						
						continue;
					}
					
					//This determines the middle point between the tag and the content
					if (!value[j].contains("={")) {
						value[j] = "N/A";
						valueType[j] = "N/A";
						
						continue;
					}
					
					//This removes the equal sign from the 'valueType'
					String[] split = value[j].split("=");
					valueType[j] = split[0];
					
					//This removes the curly braces from the 'value'
					value[j] = split[1].substring(1, split[1].indexOf("}"));
					
					//Check if the field is empty and throw the appropriate exception
					if (value[j].equals("")) {
						System.out.println("Error: " + originalFiles[i].getName() + " is an invalid file.");
						pwIEEE.close();
						pwNJ.close();
						pwACM.close();
						sc.close();
						throw new FileInvalidException("Empty Field Detected: Input file cannot be parsed due to missing information at field "+ valueType[j] + "={}\n" + "There may be other empty fields as well!");
					}

				}
				
				//Setting up the required tags
				String author = "";
				String journal = "";
				String title = "";
				String volume = "";
				String pages = "";
				String month = "";
				String year = "";
				String number = "";
				String doi = "";
				
				//The value is required for the ACM format
				int artCnt = 0;

				//Used to rearrange the authors according to the format
				String stk2Array[];

				//Loop through the 'valueType' array and assign the values to the appropriate tag
				for (int h = 1; h < valueType.length - 1; h++) {
					
					//Check if null before anything else
					if (valueType[h] == null && value[h] == null)
						continue;
					
					//Check if the 'valueType' contains one of the tags
					if (valueType[h].contains("author")) {
						author = value[h];
					} else if (valueType[h].contains("journal")) {
						journal = value[h];
					} else if (valueType[h].contains("title")) {
						title = value[h];
					} else if (valueType[h].contains("volume")) {
						volume = value[h];
					} else if (valueType[h].contains("number")) {
						number = value[h];
					} else if (valueType[h].contains("pages")) {
						pages = value[h];
					} else if (valueType[h].contains("month")) {
						month = value[h];
					} else if (valueType[h].contains("doi")) {
						doi = value[h];
					} else if (valueType[h].contains("year")) {
						year = value[h];
					} else if (valueType[h].contains("EoA")) {
						artCnt++;
						stk2Array = author.split(" and ");
						String sIeee = "";
						String sNj = "";
						
						//Creating the appropriate style for the authors in each format
						for (int l = 0; l < stk2Array.length; l++) {
							sIeee += stk2Array[l] + ", ";
							sNj += stk2Array[l] + " & ";
						}
						
						//Reformat the previously created Strings 
						sIeee = sIeee.substring(0, sIeee.length() - 2);
						sNj = sNj.substring(0, sNj.length() - 3);
						
						//Write the appropriate format to each appropriate file
						pwACM.println(
								"[" + artCnt + "]\t" + stk2Array[0] + " et al. " + year + ". " + title + ". " + journal
										+ ". " + volume + ", " + number + "(" + year + "), " + pages + ". DOI:" + doi + ".");
						pwIEEE.println(sIeee + ". \"" + title + "\", " + journal + ", vol. " + volume + ", no. "
								+ number + ", p. " + pages + ", " + month + " " + year + ".");
						pwNJ.println(
								sNj + ". " + title + ". " + journal + ". " + volume + ", " + pages + "(" + year + ").");
					}

				}
				
				//Success message, closing everything in preparation for the next file
				System.out.println("File " + originalFiles[i] + " got successfully copied.");
				System.out.println();
				pwIEEE.close();
				pwNJ.close();
				pwACM.close();
				sc.close();

			} catch (FileInvalidException e) {
				System.out.println(e.getMessage());
				
				//Deleting the created files matching the invalid file
				ieeeFiles[i].delete();
				acmFiles[i].delete();
				njFiles[i].delete();

				System.out.println();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	public static void main(String[] args) {

		Scanner sc = null;
		PrintWriter pw = null;

		System.out.print("Welcome to BibliographyFactory!\n\n");
		
		//Initializing the file array
		originalFiles[0] = new File("Latex1.bib");
		originalFiles[1] = new File("Latex2.bib");
		originalFiles[2] = new File("Latex3.bib");
		originalFiles[3] = new File("Latex4.bib");
		originalFiles[4] = new File("Latex5.bib");
		originalFiles[5] = new File("Latex6.bib");
		originalFiles[6] = new File("Latex7.bib");
		originalFiles[7] = new File("Latex8.bib");
		originalFiles[8] = new File("Latex9.bib");
		originalFiles[9] = new File("Latex10.bib");
		
		//Initializing the names array
		for (int i = 0; i < 10; i++) {
			originalNames[i] = "latex" + (i + 1);
		}
		
		//Main loop to try to open the files
		for (int i = 0; i < 10; i++) {
			
			//Try opening the first file to be read
			try {
				sc = new Scanner(new FileInputStream(originalFiles[i]));
				
				//Closing it since the method opens it itself
				sc.close();

			} catch (FileNotFoundException e) {
				System.out.println("Could not open input file " + originalFiles[i]
						+ " for reading.\n\nPlease check if file exists! Program will terminate after closing any opened files.");
				sc.close();
				System.exit(0);
			}
			
			//Assigning value to the new files we want
			ieeeFiles[i] = new File("IEEE" + (i + 1) + ".json");
			acmFiles[i] = new File("ACM" + (i + 1) + ".json");
			njFiles[i] = new File("NJ" + (i + 1) + ".json");

			//Try writing to the IEEE format file
			try {
				pw = new PrintWriter(new FileOutputStream(ieeeFiles[i]));

				//Closing it since the method opens it itself
				pw.close();
			} catch (FileNotFoundException e) {
				System.out.println(ieeeFiles[i] + " cannot be opened/created");
				
				//Delete the unnecessary files since one of the files didn't work
				for (int j = 0; j <= i; j++) {
					if (ieeeFiles[i].exists())
						ieeeFiles[i].delete();
					if (acmFiles[i].exists())
						acmFiles[i].delete();
					if (njFiles[i].exists())
						njFiles[i].delete();
				}
				System.exit(0);
			}
			
			//Try writing to the ACM format file
			try {
				pw = new PrintWriter(new FileOutputStream(acmFiles[i]));
				
				//Closing it since the method opens it itself
				pw.close();

			} catch (FileNotFoundException e) {
				System.out.println(acmFiles[i] + " cannot be opened/created");
				
				//Delete the unnecessary files since one of the files didn't work
				for (int j = 0; j <= i; j++) {
					if (ieeeFiles[i].exists())
						ieeeFiles[i].delete();
					if (acmFiles[i].exists())
						acmFiles[i].delete();
					if (njFiles[i].exists())
						njFiles[i].delete();
				}
				System.exit(0);
			}

			//Try writing to the NJ format file
			try {
				pw = new PrintWriter(new FileOutputStream(njFiles[i]));
				
				//Closing it since the method opens it itself
				pw.close();

			} catch (FileNotFoundException e) {
				System.out.println(njFiles[i] + " cannot be opened/created");
				
				//Delete the unnecessary files since one of the files didn't work
				for (int j = 0; j <= i; j++) {
					if (ieeeFiles[i].exists())
						ieeeFiles[i].delete();
					if (acmFiles[i].exists())
						acmFiles[i].delete();
					if (njFiles[i].exists())
						njFiles[i].delete();
				}

				System.exit(0);
			}

		}
		
		//Using the method we created to copy over the files
		processFilesForValidation();
		
		//Setting up the components to ask the user 'which file to open'
		Scanner kb = new Scanner(System.in);
		BufferedReader br = null;
		String fileName = "";

		//Trying to open and read the inputed file, using a buffered reader
		try {
			System.out.println("Please enter the file that you want to open for reading:");
			fileName = kb.next();
			System.out.println("Attempting to open and display the contents of file: " + fileName + ".");
			
			//Setting up the buffered reader
			br = new BufferedReader(new FileReader(fileName));
			int x;
			x = br.read();
			
			//While character isn't the end of file character, print to the screen
			while (x != -1) {
				System.out.print((char) x);
				x = br.read();
			}
			
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening " + fileName + ". Please try to enter a valid file name again:");
			
			//Letting them try one more time
			try {
				fileName = kb.next();
				System.out.println("Attempting to open and display the contents of file: " + fileName + ".");
				br = new BufferedReader(new FileReader(fileName));
				int x;

				x = br.read();
				while (x != -1) {
					System.out.print((char) x);
					x = br.read();
				}
				br.close();

			} catch (FileNotFoundException e2) {
				System.out.println("Problem opening " + fileName
						+ ". The file name is invalid again. The program is terminating.");
				System.exit(0);

			} catch (IOException e2) {
				System.out.println("Error: An error has occurred while reading from the " + fileName + " file. ");
				System.out.println("Program will terminate.");
				System.exit(0);
			}

		} catch (IOException e) {
			System.out.println("Error: An error has occurred while reading from the " + fileName + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);
		}
		
		kb.close();

	}

}

