// -------------------------------------------------------------------------
//Assignment Assignment 4
//Written by Sangeethan Thaventhiran (40125009)
//For COMP 248 section EC
// -------------------------------------------------------------------------

// This is a turn based game in the console using multiple different classes

import java.util.Scanner;
import java.util.Random;

public class LetUsPlay {

	public static void main(String[] args) {

		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * *\n"
				+ " - - - - - - - - - - - - - - - - - - - - - - - - - \n\n" + "\tWelcome to Nancy's 3D Warrior Game\n\n"		//welcome banner
				+ " - - - - - - - - - - - - - - - - - - - - - - - - - \n"
				+ "* * * * * * * * * * * * * * * * * * * * * * * * * *\n");

		System.out.print("The default game board has 3 levels and each level has a 3x3 board.\n"
				+ "You can use this default board size or change the size.\n" + "\t0 to use the default board size\n"
				+ "\t-1 to enter your own size\n" + "==> What do you want to do? ");

		Scanner keyb = new Scanner(System.in);
		String input = "";			
		int input2 = 0;
		int size = 0;
		int level = 0;
		final int MIN_LEVEL = 3;
		final int MAX_LEVEL = 10;
		final int MIN_SIZE = 4;
		final int MAX_SIZE = 10;
		Board board = null;

		do {				//loop for the board size
			input = keyb.next();
			if (input.equals("0")) {
				board = new Board();
				System.out.println("\n\n" + board);
				break;
			}

			else if (input.equals("-1")) {
				System.out.print("How many levels would you like? (minimum size 3, max 10) ");

				do {
					input2 = keyb.nextInt();

					if (input2 >= MIN_LEVEL && input2 <= MAX_LEVEL) {
						level = input2;
					}

					else {
						System.out.println("Sorry but " + input + " is not a legal choice.");
						continue;
					}
					while (input2 < MIN_LEVEL || input2 > MAX_LEVEL)
						;

					System.out.print("What size do you want the nxn boards on each level to be?\n"
							+ "Minimum size is 4x4, max is 10x10.\n" + "==> Enter the value of n: ");

					do {
						input2 = keyb.nextInt();

						if (input2 >= MIN_SIZE && input2 <= MAX_SIZE) {
							size = input2;
						}

						else {
							System.out.println("Sorry but " + input2 + " is not a legal choice.");
							continue;
						}
					} while (input2 < MIN_SIZE || input2 > MAX_SIZE);

					board = new Board(level, size);
					System.out.println("\n\n" + board);
					break;

				} while (input != "0" && input != "-1");
				break;
			}

			else
				System.out.println("Sorry but " + input + " is not a legal choice.");

		} while (input != "0" || input != "-1");

		Player[] player = new Player[2];	//setting up the players

		System.out.print("What is player 0's name? (one word only): ");
		player[0] = new Player();
		player[0].setName(keyb.next());

		System.out.print("\nWhat is player 1's name? (one word only): ");
		player[1] = new Player();
		player[1].setName(keyb.next());

		System.out.print("\nThe game has started, and ");

		Random r = new Random();
		int beginning = r.nextInt(2);

		int f = 0;
		int l = 0;

		if (beginning == 0) {	//deciding who goes first
			System.out.print(player[0].getName());
			f = 0;
			l = 1;
		}

		else if (beginning == 1) {
			System.out.print(player[1].getName());
			f = 1;
			l = 0;
		}

		System.out.print(" goes first. \n" + "===================================\n\n");

		// Start of game
		Dice dice = new Dice();
		int dieR = 0;

		do {
			int count = 0;
			int temp = 0;
			int other = 0;
			while (count <= 2) {
				other = 0;

				if (count == 2) {
					count = 0;
					l = f;
					f = temp;

					break;
				}

				else if (count == 1) {
					temp = f;
					f = l;
					l = temp;
					count++;
				}

				else if (count == 0) {
					count++;
				}

				// Player energy = 0
				if (player[f].getEnergy() <= 0) {
					System.out.println("\t"+player[f].getName()
							+ "\t does not have enough energy to move and rolls the dices three time.\n"
							+ "\tIf you get a double, you gain 2 energy units.");
					dice.rollDice();
					if (dice.isDouble())
						player[f].setEnergy(player[f].getEnergy() + 2);
					System.out.println("\tDie roll 1 ---> " + dice);

					dice.rollDice();
					if (dice.isDouble())
						player[f].setEnergy(player[f].getEnergy() + 2);
					System.out.println("\tDie roll 2 ---> " + dice);

					dice.rollDice();
					if (dice.isDouble())
						player[f].setEnergy(player[f].getEnergy() + 2);
					System.out.println("\tDie roll 3 ---> " + dice);
				}

				// Player energy still 0
				if (player[f].getEnergy() <= 0) {
					System.out.println("\t"+player[f].getName() + " is too weak to move and skips a turn.\n");
					continue;
				}

				// Die roll
				System.out.println("It is "+player[f].getName()+"'s turn!");
				dice.rollDice();
				dieR = dice.getDie1() + dice.getDie2();
				System.out.println("\t"+player[f].getName() + "'s dice roll---> " + dice);

				// If roll is a double
				if (dice.isDouble()) {
					player[f].setEnergy(player[f].getEnergy() + 2);
					System.out.println("\tCongrats, you rolled a double!!!");
				}

				// Player potential location calculation

				int xInit = player[f].getX();
				int yInit = player[f].getY();
				int levelInit = player[f].getLevel();

				int yPot = player[f].getY() + dieR % board.getSize();
				int xPot = player[f].getX() + dieR / board.getSize();
				int levelPot = player[f].getLevel();

				while (yPot >= board.getSize()) {
					yPot = yPot - board.getSize();
					xPot++;
				}

				while (xPot >= board.getSize()) {
					xPot = xPot - board.getSize();
					levelPot++;
				}

				if (levelPot >= board.getLevel() || (player[f].getLevel() == board.getLevel() - 1
						&& board.getSize() - yPot == 2 && board.getSize() - 1 == xPot)) {
					if (player[f].getLevel() == board.getLevel() - 1 && board.getSize() - yPot == 2
							&& board.getSize() - 1 == xPot) {
						yPot = player[f].getY() - dieR % board.getSize();
						xPot = player[f].getX() - dieR / board.getSize();

						while (yPot < 0) {
							yPot = yPot + board.getSize();
							xPot--;
						}

						while (xPot < 0) {
							xPot = xPot + board.getSize();
							levelPot--;
						}
						

						System.out.println("\tYou landed too close to the finish square and got set backwards your dice amount.");

					}

					else {
						xPot = xInit;
						yPot = yInit;
						levelPot = levelInit;
						player[f].setEnergy(player[f].getEnergy() - 2);
						System.out.println("\tYou didn't land perfectly, so you lost 2 energy");
						other++;
					}
					
				}

				player[f].setX(xPot);
				player[f].setY(yPot);
				player[f].setLevel(levelPot);

				// Challenge

				if (player[f].equals(player[l])) {

					System.out.println("Player " + player[l].getName() + " is at your new location.\n"
							+ "\tWhat do you want to do?\n"
							+ "\t0 - Challenge and risk losing 50% of your energy units if you lose\n"
							+ "\t\tor move to the new location and get 50% of your opponent's energy units.\n"
							+ "\t1 - Move down one level or move to (0,0) if at level 0 and lose 2 energy units.");
					String junk = keyb.nextLine();
					do {
						System.out.println("What will be your move?");
						input = "";
						input = keyb.nextLine();
						if (input.equals("0")) {
							
							int dieC = (int) (Math.random()*10);
							
							System.out.println("\tIf the generated number is smaller than 6 not included, you lose the challenge.");
							
							if (dieC < 6) {
								System.out.println("\tResult---> " + dieC + ". You lost, so your energy will be halved.");

								player[f].setX(xInit);
								player[f].setY(yInit);
								player[f].setLevel(levelInit);

								player[f].setEnergy((int) (player[f].getEnergy() / 2));
								other++;

							} else if (dieC >= 6) {
								System.out.println("\tResult---> " + dieC + ". You won, so you swap locations with "
										+ player[l].getName() + ", who's energy will be halved.");
								player[f].setX(xInit);
								player[f].setY(yInit);
								player[f].setLevel(levelInit);
								
								player[f].moveTo(player[l]);
								player[l].setEnergy((int) player[l].getEnergy() / 2);
								System.out.println(player[l]);

							}
						}

						else if (input.equals("1")) {
							if (player[f].getLevel() == 0) {
								player[f].setX(0);
								player[f].setY(0);
							} else {
								player[f].setLevel(player[f].getLevel() - 1);
								
							}
							other++;
							player[f].setEnergy(player[f].getEnergy() - 2);
						}

						else {
							System.out.println("Sorry but " + input + " is not a legal choice.");
							continue;
						}
					} while (!input.contentEquals("0")&& !input.contentEquals("1"));

				}

				if (other == 0) {
					player[f].setEnergy(player[f].getEnergy()
							+ board.getEnergyAdj(player[f].getLevel(), player[f].getX(), player[f].getY()));

					System.out.println("\tYou landed on a "
							+ board.getEnergyAdj(player[f].getLevel(), player[f].getX(), player[f].getY()));
				}

				System.out.println("\t"+player[f] + "\n");

				if (player[f].won(board) || player[l].won(board)) {
					break;
				}
			}

			if (!player[f].won(board) && !player[l].won(board)) {
				System.out.println("Press any key and enter to continue...");
				input = keyb.next();
				System.out.println("===================================");
			}

		} while (!player[f].won(board) && !player[l].won(board));

		if (player[f].won(board))
			System.out.print("The winner is " + player[f].getName() + ". Well done!!!!");
		else if (player[l].won(board))
			System.out.print("The winner is " + player[l].getName() + ". Well done!!!!");
		keyb.close();
	}

}
