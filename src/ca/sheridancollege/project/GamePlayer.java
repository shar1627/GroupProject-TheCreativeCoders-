/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Rishab
 */
public class GamePlayer extends Player {
    public GamePlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + " is ready to play!");
    }
}
