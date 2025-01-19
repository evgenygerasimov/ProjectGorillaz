package com.javarush.kuznetsov.model;

import java.io.Serializable;
import java.util.Random;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    private String currentStep;
    private boolean gameOver;
    private int choicesCount;
    private String playerName;
    private String questType;
    private int random;


    public GameState() {
        this.currentStep = "START";
        this.gameOver = false;
        this.choicesCount = 0;
    }

    public String getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getChoicesCount() {
        return choicesCount;
    }

    public void setChoicesCount(int choicesCount) {
        this.choicesCount = choicesCount;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setQuestType(String questType) {
        this.questType = questType;
    }

    public String getQuestType() {
        return questType;
    }
    public void setRandom() {
        this.random = new Random().nextInt(2);
    }
    public int getRandom() {
        return random;
    }
}
