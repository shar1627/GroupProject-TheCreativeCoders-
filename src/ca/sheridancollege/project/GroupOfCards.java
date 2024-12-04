/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.*;
/**
 *
 * @author Shivansh Sharma
 */
public class GroupOfCards {
    private List<Card> deck;
    private Player view;
    private Map<String, Integer> scores;

    public GroupOfCards(List<Card> deck,Player view) {
        this.deck = deck;
        this.view = view;
        this.scores = new HashMap<>();
    }

    public void addPlayer(String player) {
        scores.put(player, 0);
    }

    public void startGame() {
        Random random = new Random();
    int roundCount = 0; // Track the number of rounds

    while (roundCount < 3 && deck.size() > 1) {
        Card card1 = deck.remove(random.nextInt(deck.size()));
        Card card2 = deck.remove(random.nextInt(deck.size()));

        view.displayCards(card1, card2);

        String match = view.getMatchFromPlayer();

        if (validateMatch(card1, card2, match)) {
            String player = view.getPlayerInput("Who found the match? ");
            scores.put(player, scores.get(player) + 1);
            view.displayMessage("Correct! Point awarded to " + player);
        } else {
            view.displayMessage("Incorrect match!");
        }

        roundCount++; // Increment the round count
    }

    view.displayScores(scores);
    displayWinner(); // Display the winner
    view.displayMessage("Game Over!");
}

private void displayWinner() {
    // Find the player with the highest score
    String winner = null;
    int maxScore = 0;
    boolean tie = false;

    for (Map.Entry<String, Integer> entry : scores.entrySet()) {
        if (entry.getValue() > maxScore) {
            maxScore = entry.getValue();
            winner = entry.getKey();
            tie = false; // Reset tie if a new highest score is found
        } else if (entry.getValue() == maxScore) {
            tie = true; // If scores are equal, it's a tie
        }
    }

    // Display the result
    if (tie) {
        view.displayMessage("The game is a tie!");
    } else if (winner != null) {
        view.displayMessage("The winner is: " + winner + " with " + maxScore + " points!");
    } else {
        view.displayMessage("No winner! No points scored.");
    }

    }

    private boolean validateMatch(Card card1, Card card2, String match) {
        return card1.getRank().equalsIgnoreCase(match) || card1.getSuit().equalsIgnoreCase(match) ||
               card2.getRank().equalsIgnoreCase(match) || card2.getSuit().equalsIgnoreCase(match);
    }
    
    
}
