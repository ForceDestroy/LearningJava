// -------------------------------------------------------------------------
//Assignment Assignment 3 - Question 1 
//Written by Sangeethan Thaventhiran (40125009)
//For COMP 248 section EC
// -------------------------------------------------------------------------

// This program is a basic password generator, using a chapter from Alice in Wonderland
//it uses arrays and keep creating password with specific conditions


import java.util.Random;
public class question1 {

	public static void main(String[] args) {
		final String[][][] book = 
			{
				{
					
					{
					"ALICE was beginning to get very tired of sitting by her sister on the\n",
					"bank, and of having nothing to do. Once or twice she had peeped into the\n",
					"book her sister was reading, but it had no pictures or conversations in\n",
					"it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
					"conversations?\"\n"
					},
					
					{
					"So she was considering in her OWN mind (as well as she could, for the\n",
					"day made her feel very sleepy and stupid), whether the pleasure of\n",
					"making a daisy-chain would be worth the trouble of getting up and\n",
						"picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
					"close by her.\n"
					},
					
					{
					"There was nothing so very remarkable in that, nor did Alice think it so\n",
					"very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
					"dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
					"out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
					"started to her feet, for it flashed across her mind that she had never\n",
					"before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
					"out of it, and, burning with curiosity, she ran across the field after\n",
					"it and was just in time to see it pop down a large rabbit-hole, under\n",
					"the hedge. In another moment, down went Alice after it!"
					}
					
				},
				
				{
					
					{
					"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
					"telescope!\"\n"
					},
					
					{
					"And so it was indeed! She was now only ten inches high, and her face\n",
					"brightened up at the thought that she was now the right size for going\n",
					"through the little door into that lovely garden.\n"
					},
					
					{
					"After awhile, finding that nothing more happened, she decided on going\n",
					"into the garden at once; but, alas for poor Alice! When she got to the\n",
					"door, she found she had forgotten the little golden key, and when she\n",
					"went back to the table for it, she found she could not possibly reach\n",
					"it: she could see it quite plainly through the glass and she tried her\n",
					"best to climb up one of the legs of the table, but it was too slippery,\n",
					"and when she had tired herself out with trying, the poor little thing\n",
					"sat down and cried.\n"
					},
					
					{
					"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
					"sharply. \"I advise you to leave off this minute!\" She generally gave\n",
					"herself very good advice (though she very seldom followed it), and\n",
					"sometimes she scolded herself so severely as to bring tears into her\n",
					"eyes.\n"
					},
					
					{
					"Soon her eye fell on a little glass box that was lying under the table:\n",
					"she opened it and found in it a very small cake, on which the words \"EAT\n",
					"ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
					"Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
					"makes me grow smaller, I can creep under the door: so either way I'll\n",
					"get into the garden, and I don't care which happens!\"\n"
					},
					
					{
					"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
					"way?\" holding her hand on the top of her head to feel which way she was\n",
					"growing; and she was quite surprised to find that she remained the same\n",
					"size. So she set to work and very soon finished off the cake."
					}
					
				},
				
				{
					
					{
					"The King and Queen of Hearts were seated on their throne when they\n",
					"arrived, with a great crowd assembled about them--all sorts of little\n",
					"birds and beasts, as well as the whole pack of cards: the Knave was\n",
					"standing before them, in chains, with a soldier on each side to guard\n",
					"him; and near the King was the White Rabbit, with a trumpet in one hand\n",
					"and a scroll of parchment in the other. In the very middle of the court\n",
					"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
					"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"
					},
					
					{
					"The judge, by the way, was the King and he wore his crown over his great\n",
					"wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
					"(some were animals and some were birds) I suppose they are the jurors.\"\n"
					},
					
					{
					"Just then the White Rabbit cried out \"Silence in the court!\"\n"
					},
					
					{
					"\"HERALD! read the accusation!\" said the King."
					}
					
				}
				
			};
		
		
		Random r = new Random();	//creating the random function

		final int MAX = 10000, WORDSPERPASSWORD=3;	//constants for the loops later
		int counter1 = 0, counter2 =1, counter3 = 0;	//counters for the loops later
		int NewLine=0, Single=0, Equal=0, Length=0, Upper=0, Lower=0, Special = 0;	//counters for the number of errors
		String Password = "";	//initialize the password

		System.out.println("Welcome to the password generator game!\n");	//introduction message
		
while(counter2 < MAX ||Lower!=0) {		//main loop to generate each Password
		
	while(counter1!=WORDSPERPASSWORD) //loop to get each word
		{
			int chosenPageValue = r.nextInt(book.length);	//random page
			int chosenParagraphValue = r.nextInt(book[chosenPageValue].length);	//random paragraph
			int chosenLineValue = r.nextInt(book[chosenPageValue][chosenParagraphValue].length);	//random line
	
			String[] chosenLine = book[chosenPageValue][chosenParagraphValue][chosenLineValue].split(" ");	//turning the line into an array
			int chosenWord = r.nextInt(chosenLine.length);	//random word in the array
			String Word = chosenLine[chosenWord];
			
			if(Word.contains("\n")) {	//check if it contains \n
				NewLine++;
				continue;
			}
			if(Word.length()<=1) {		//check if it's only 1 character
				Single++;
				continue;
			}
			if(Password.contains(Word)) {	//check if there's a duplicate word
				Equal++;
				continue;
			}
		
			Password = Password + Word;
			counter1 ++;
			
		}
	
	 for (int i = 0; i < Password.length(); i++) {	//loop to find the special characters using ASCII
         char c = Password.charAt(i);
         int ascii = (int) c;
         if(ascii > 122) {
        	 counter3++;
         }else if(ascii < 65) {
        	 counter3++;
         }else if(ascii > 90 && ascii <97) {
        	 counter3++;
         }
     } 
	if(Password.length()<8 || Password.length()>16) {	//check if it meets length requirements, reset the password and the counter3
		Length++;
		Password = "";
		counter1 = 0;
		counter3 = 0;
		continue;
		}
	if(Password.equals(Password.toLowerCase())) {	//check if it contains an Upper case character, reset the password and the counters
		Upper++;
		Password = "";
		counter1 = 0;
		counter3 = 0;
		continue;
	}
	if(Password.equals(Password.toUpperCase())) {	//check if it contains a Lower case character, reset the password and the counters
		Lower++;
		Password = "";
		counter1 = 0;
		counter3 = 0;
		continue;
	}
	if(counter3 != 1) {	//check if there's only 1 special character, reset the password and the counters
		Special++;
		Password = "";
		counter1 = 0;
		counter3 = 0;
		continue;
	}
	else {

	System.out.printf("%-40s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Password = " + Password,"Newline = " + NewLine,"Single = " + Single,"Equal = " + Equal,"Length = " + Length,"Upper = " + Upper,"Lower = " + Lower,"Special = " + Special);
	//print out the password and the counters
	
	Password = "";	//reset everything to restart the main loop, and add 1 to counter2 to track the number of password generated
	NewLine=0;
	Single=0;
	Equal=0;
	Length=0;
	Upper=0;
	Lower=0;
	Special = 0;
	counter1 = 0;
	counter3 = 0;
	counter2++;
	}

	}

	System.out.println("\nTotal passwords generated: "+counter2); //number of password generated
	System.out.println("Thanks for using the password generator game. Good bye.");	//outro message
	}
	}

