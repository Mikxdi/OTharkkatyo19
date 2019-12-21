/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.domain;

/**
 *
 * @author lehtmikk
 */
public class Player {
    private String name;
    private int levelsPassed;
    public Player(String name, int levelsPassed){
        this.name = name;
        this.levelsPassed = levelsPassed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelsPassed() {
        return levelsPassed;
    }

    public void setLevelsPassed(int levelsPassed) {
        this.levelsPassed = levelsPassed;
    }
}
