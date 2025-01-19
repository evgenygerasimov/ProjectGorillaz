package com.javarush.kuznetsov.logic;

import com.javarush.kuznetsov.model.GameState;

public class Artificial_intelligenceQuestLogic {

    public static void handleChoice(GameState gameState, String userChoice) {
        String currentStep = gameState.getCurrentStep();

        gameState.setChoicesCount(gameState.getChoicesCount() + 1);

        switch (currentStep) {
            case "START":
                if ("next".equals(userChoice)) {
                    gameState.setCurrentStep("APPLICATION");
                }
                break;

            case "APPLICATION":
                if ("yes".equals(userChoice)) {
                    gameState.setCurrentStep("TRUE");
                } else if ("no".equals(userChoice)) {
                    gameState.setCurrentStep("FALSE");
                }
                break;

            case "TRUE":

            case "FALSE":
                if ("yes".equals(userChoice)) {
                    gameState.setCurrentStep("YES?");
                } else if ("no".equals(userChoice)) {
                    gameState.setCurrentStep("NO?");
                }
                break;

            case "YES?":
            case "NO?":
                gameState.setCurrentStep("DATING");
                break;

            case "DATING":
                gameState.setCurrentStep("INFORMATION");
                break;
            case "INFORMATION":
                if ("yes".equals(userChoice)) {
                    gameState.setCurrentStep("WIN_LICE");
                    gameState.setGameOver(true);
                }else if ("no".equals(userChoice)) {
                    gameState.setCurrentStep("CHECK");
                }
                break;

            case "CHECK":
                if ("sorry".equals(userChoice)) {
                    gameState.setCurrentStep("TRAITOR");
                }else if ("lie".equals(userChoice)) {
                    gameState.setCurrentStep("LOSE_LIE");
                    gameState.setGameOver(true);
                }
                break;

            case "TRAITOR":
                gameState.setCurrentStep("FINAL");
                break;

            case "FINAL":
                if ("true".equals(userChoice)) {
                    gameState.setCurrentStep("WIN_SPARK");
                    gameState.setGameOver(true);
                } else if ("false".equals(userChoice)) {
                    gameState.setCurrentStep("LOSE_SPARK");
                    gameState.setGameOver(true);
                }
                break;
            default:
                break;
        }
    }
}
