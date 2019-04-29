import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class WorldTournament {
    public static void main(String[] args) {
        Scanner ChooseWinner = new Scanner(System.in);
        String Winner;
        boolean NotFound = true;
        Random rand = new Random();
        String[] Fighters = {"Goku", "Chi Chi", "Chiaotzu", "Krillin", "Tien", "Ysmcha", "Piccolo", "Kami"};
        String[] QWinners = new String[4];
        String[] SWinners = new String[2];
        String WorldWinner;
        int NumberWorldTournaments = 1;

        System.out.println();
        System.out.println("Tournament Fighters: Goku, Krillin, Tien, Yamcha, Chiaotzu, Chi Chi, Piccolo, Kami");
        System.out.print("Choose who you believe will win the World Tournament: ");

        do {
            Winner = ChooseWinner.nextLine();
            for (int i = 0; i < Fighters.length; i++) {
                if (Fighters[i].equalsIgnoreCase(Winner)) {
                    NotFound = false;
                    break;
                }

            }
            if (NotFound) {
                System.out.print("Please enter a valid fighter:");
            }
        } while (NotFound);

        NotFound = true;
        do {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("\033[1mQUARTERFINAL FIGHTS BEGIN!\033[0m");
            System.out.println();

            for (int i = 0, z = 0; i < Fighters.length; i += 2, z++) {
                int BoutWinner = rand.nextInt(2);
                QWinners[z] = Fighters[i + BoutWinner];
                System.out.println(Fighters[i] + " VS " + Fighters[i + 1]);
                System.out.println();

            }
            System.out.print("\033[1mYOUR QUARTERFINAL WINNERS ARE:\033[0m");
            System.out.println(Arrays.toString(QWinners));
            System.out.println("Press enter to continue.");
            ChooseWinner.nextLine();

            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("\033[1mSEMIFINAL FIGHTS BEGIN!\033[0m");
            System.out.println();

            for (int i = 0, z = 0; i < QWinners.length; i += 2, z++) {
                int BoutWinner = rand.nextInt(2);
                SWinners[z] = QWinners[i + BoutWinner];
                System.out.println(QWinners[i] + " VS " + QWinners[i + 1]);
                System.out.println();

            }
            System.out.print("\033[1mYOUR SEMIFINAL WINNERS ARE:\033[0m");
            System.out.println(Arrays.toString(SWinners));
            System.out.println("Press enter to continue.");
            ChooseWinner.nextLine();

            int BoutWinner = rand.nextInt(2);
            WorldWinner = SWinners[BoutWinner];

            System.out.println("\033[1mYOUR WORLD TOURNAMENT WINNER IS \033[0m" + WorldWinner);

            if (WorldWinner.equalsIgnoreCase(Winner)) {
                NotFound = false;

            } else {
                System.out.println("Wow! You guessed wrong! It's Rewind Time.");
                System.out.println("Press enter to continue.");
                ChooseWinner.nextLine();
                NumberWorldTournaments++;
            }

        } while (NotFound);

        System.out.println("Wow! It only took " + Winner + " " + NumberWorldTournaments + " Tournaments to win for once!");
    }
}
