/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jaspreet
 */
public class Main {
    public static void main(String[] args) {
        List<PlayingCard> deck = generateDeck();
        CardMatchingGame game = new CardMatchingGame("Card Matching Game", deck);
        game.play();
    }

    private static List<PlayingCard> generateDeck() {
        List<String> ranks = Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King");
        List<String> suits = Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades");

        List<PlayingCard> deck = new ArrayList<>();
        for (String rank : ranks) {
            for (String suit : suits) {
                deck.add(new PlayingCard(rank, suit));
            }
        }
        return deck;
    }
}