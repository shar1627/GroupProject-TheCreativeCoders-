/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.*;

/**
 *
 * @author Simarpartap
 */
public class GroupOfCardsController {
    private List<PlayingCard> deck;
    private PlayerView playerView;
    private List<String> players;
    private Map<String, Integer> scores;

    public GroupOfCardsController(List<PlayingCard> deck, PlayerView playerView) {
        this.deck = deck;
        this.playerView = playerView;
        this.players = new ArrayList<>();
        this.scores = new HashMap<>();
    }

    public void addPlayer(String playerName) {
        players.add(playerName);
        scores.put(playerName, 0);
    }

    public void startGame() {
        Random random = new Random();
        int roundCount = 0;

        while (roundCount < 5 && deck.size() > 1) {  // Limit rounds to 5
            PlayingCard card1 = deck.remove(random.nextInt(deck.size()));
            PlayingCard card2 = deck.remove(random.nextInt(deck.size()));

            // Show the cards to both players
            playerView.displayMessage("Card 1: " + card1);
            playerView.displayMessage("Card 2: " + card2);

            // Player 1's turn
            String matchPlayer1 = playerView.getMatchFromPlayer(players.get(0));  // Player 1 guesses
            if (validateMatch(card1, card2, matchPlayer1)) {
                scores.put(players.get(0), scores.get(players.get(0)) + 1);
                playerView.displayMessage("Player 1 guessed correctly!");
            } else {
                playerView.displayMessage("Player 1's guess was incorrect.");
            }

            // Player 2's turn
            String matchPlayer2 = playerView.getMatchFromPlayer(players.get(1));  // Player 2 guesses
            if (validateMatch(card1, card2, matchPlayer2)) {
                scores.put(players.get(1), scores.get(players.get(1)) + 1);
                playerView.displayMessage("Player 2 guessed correctly!");
            } else {
                playerView.displayMessage("Player 2's guess was incorrect.");
            }

            roundCount++;
             playerView.displayRemainingCards(deck.size());
        }

        // Display final scores after 5 rounds
        playerView.displayMessage("Scores: " + scores);
        declareWinner();
    }

    private boolean validateMatch(PlayingCard card1, PlayingCard card2, String match) {
        return card1.getRank().equalsIgnoreCase(match) ||
               card2.getRank().equalsIgnoreCase(match) ||
               card1.getSuit().equalsIgnoreCase(match) ||
               card2.getSuit().equalsIgnoreCase(match);
    }

    private void declareWinner() {
        // Determine the winner based on the highest score
        String winner = null;
        int highestScore = -1;

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > highestScore) {
                highestScore = entry.getValue();
                winner = entry.getKey();
            }
        }

        playerView.displayMessage("The winner is: " + winner + " with " + highestScore + " points!");
    }
}