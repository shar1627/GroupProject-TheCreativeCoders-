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
 * @author Simarpartap Singh Jaura 
 */
public class Game {
    public static void main(String[] args) {
        Player view = new Player();

        // Generate a deck of cards
        List<Card> deck = generateDeck();

        GroupOfCards controller = new GroupOfCards(deck, view);

        controller.addPlayer("Player 1");
        controller.addPlayer("Player 2");

        controller.startGame();
    }

    private static List<Card> generateDeck() {
        List<String> ranks = Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King");
        List<String> suits = Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades");

        List<Card> deck = new ArrayList<>();
        for (String rank : ranks) {
            for (String suit : suits) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }
    
}
