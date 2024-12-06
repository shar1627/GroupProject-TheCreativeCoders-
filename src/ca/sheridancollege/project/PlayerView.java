/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Shivansh
 */
public class PlayerView {
    private Scanner scanner = new Scanner(System.in);

    public void displayCards(PlayingCard card1, PlayingCard card2) {
        System.out.println("Card 1: " + card1);
        System.out.println("Card 2: " + card2);
    }

    public String getMatchFromPlayer(String playerName) {
        Scanner scanner = new Scanner(System.in);
        displayMessage(playerName + ", enter the matching rank or suit:");
        return scanner.nextLine();
    }

    public String getPlayerInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayScores(Map<String, Integer> scores) {
        System.out.println("Scores:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public void displayRemainingCards(int remainingCards) {
        System.out.println("Remaining cards in the deck: " + remainingCards);
    }
}
