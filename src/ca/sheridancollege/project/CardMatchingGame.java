/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rishab
 */
public class CardMatchingGame extends Game {
    private List<PlayingCard> deck;
    private GroupOfCards groupOfCards;

    public CardMatchingGame(String name, List<PlayingCard> deck) {
        super(name);
        this.deck = deck;
        this.groupOfCards = new GroupOfCards(deck.size());
    }

    @Override
    public void play() {
        PlayerView playerView = new PlayerView();
        GroupOfCardsController controller = new GroupOfCardsController(deck, playerView);
        controller.addPlayer("Player 1");
        controller.addPlayer("Player 2");
        controller.startGame();
    }

    @Override
    public void declareWinner() {
        System.out.println("Winner will be displayed at the end of the game.");
    }
}