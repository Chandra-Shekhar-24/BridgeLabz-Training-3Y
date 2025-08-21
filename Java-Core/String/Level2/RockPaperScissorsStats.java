import java.util.Scanner;

public class RockPaperScissorsStats {

    static String getComputerChoice() {
        int rand = (int)(Math.random() * 3);
        return rand == 0 ? "Rock" : rand == 1 ? "Paper" : "Scissors";
    }

    static int decideWinner(String user, String computer) {
        if (user.equals(computer)) return 0; // tie
        if ((user.equals("Rock") && computer.equals("Scissors")) ||
            (user.equals("Paper") && computer.equals("Rock")) ||
            (user.equals("Scissors") && computer.equals("Paper")))
            return 1; // user win
        return 2; // computer win
    }

    static String[][] playGames(int numGames, Scanner sc) {
        int userWins = 0, compWins = 0, ties = 0;
        String[][] results = new String[numGames][3];
        for (int i = 0; i < numGames; i++) {
            System.out.print("Game " + (i+1) + " - Enter choice (Rock/Paper/Scissors): ");
            String user = sc.next();
            String comp = getComputerChoice();
            int winner = decideWinner(user, comp);
            if (winner == 1) userWins++;
            else if (winner == 2) compWins++;
            else ties++;
            results[i][0] = user;
            results[i][1] = comp;
            results[i][2] = winner == 1 ? "Player" : winner == 2 ? "Computer" : "Tie";
        }
        System.out.println("Game	User	Computer	Winner");
        for (int i = 0; i < numGames; i++)
            System.out.println((i+1) + "	" + results[i][0] + "	" + results[i][1] + "		" + results[i][2]);
        System.out.println("Player Wins: " + userWins + ", Computer Wins: " + compWins + ", Ties: " + ties);
        double playerPct = userWins * 100.0 / numGames;
        double compPct = compWins * 100.0 / numGames;
        System.out.println("Player Win %: " + playerPct);
        System.out.println("Computer Win %: " + compPct);
        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of games: ");
        int numGames = sc.nextInt();
        playGames(numGames, sc);
        sc.close();
    }
}
