import java.util.Scanner;

public class DeckOfCards {
    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    static String[] initializeDeck() {
        String[] deck = new String[suits.length * ranks.length];
        int count = 0;
        for(String suit : suits) {
            for(String rank : ranks) {
                deck[count++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for(int i=0; i<n; i++) {
            int randomIndex = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    static String[][] distributeCards(String[] deck, int cardsPerPlayer, int numPlayers) {
        if(cardsPerPlayer * numPlayers > deck.length) {
            System.out.println("Not enough cards to distribute.");
            return null;
        }
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int index = 0;
        for(int i=0; i<numPlayers; i++) {
            for(int j=0; j<cardsPerPlayer; j++) {
                players[i][j] = deck[index++];
            }
        }
        return players;
    }

    static void printPlayersCards(String[][] players) {
        for(int i=0; i<players.length; i++) {
            System.out.print("Player " + (i+1) + ": ");
            for(String card : players[i]) {
                System.out.print(card + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        System.out.print("Enter number of players: ");
        int numPlayers = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();
        String[][] players = distributeCards(deck, cardsPerPlayer, numPlayers);
        if (players != null) {
            printPlayersCards(players);
        }
        sc.close();
    }
}
