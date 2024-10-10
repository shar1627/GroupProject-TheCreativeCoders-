/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * @author Shivansh Sharma 10-09-2024
 */
package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    private final String name; 
    private ArrayList<Player> players;
    private GroupOfCards deck; 
    private Scanner scanner;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.deck = new GroupOfCards(55); 
        this.scanner = new Scanner(System.in);
        initializeDeck();
    }

    private void initializeDeck() {
        deck.addCard(new Card(List.of("A", "B", "C")));
        deck.addCard(new Card(List.of("A", "D", "E")));
        deck.addCard(new Card(List.of("C", "E", "F"))); 
        deck.addCard(new Card(List.of("D", "E", "C")));
        deck.addCard(new Card(List.of("D", "A", "G")));
        deck.shuffle(); 
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void dealCards(int cardsPerPlayer) {
        for (Player player : players) {
            for (int i = 0; i < cardsPerPlayer; i++) {
                if (!deck.getCards().isEmpty()) {
                    player.addCard(deck.getCards().remove(0)); 
            }
        }
    }

    public void play() {
        System.out.println("Starting the game: " + name);
        for (Player player : players) {
            System.out.println(player.getName() + ", it's your turn! Choose a card from your hand:");
            for (int i = 0; i < player.getHand().size(); i++) {
                System.out.println(i + 1 + ": " + player.getHand().get(i));
            }
            System.out.print("Enter the number of the card you want to play: ");
            int choice = scanner.nextInt();
            // Perform action based on player's choice
            if (choice > 0 && choice <= player.getHand().size()) {
                Card selectedCard = player.getHand().get(choice - 1);
                System.out.println(player.getName() + " has chosen: " + selectedCard);
                player.incrementCardsPlayed(); 
            } else {
                System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    public void declareWinner() {
        // Determine the winner based on cards played
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getCardsPlayed() > winner.getCardsPlayed()) {
                winner = player; 
            }
        }
        System.out.println("Winner is: " + winner.getName() + " with " + winner.getCardsPlayed() + " cards played!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game("Spot It!");

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            game.addPlayer(new Player(playerName));
        }

        game.dealCards(3);

        game.play();
        game.declareWinner();
    }
}

