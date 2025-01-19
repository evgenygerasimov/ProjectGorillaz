package com.javarush.kuznetsov.logic;

import com.javarush.kuznetsov.model.GameState;

public class ForestQuestLogic {

    public static void handleChoice(GameState gameState, String userChoice) {
        String currentStep = gameState.getCurrentStep();
        gameState.setChoicesCount(gameState.getChoicesCount() + 1);

        switch (currentStep) {
            // Начало квеста
            case "START":
                if ("choice1".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_CHOICE_1");
                } else if ("choice2".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_CHOICE_2");
                } else if ("choice3".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_CHOICE_3");
                }
                break;

            case "FOREST_CHOICE_1":
                if ("path2_1".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_PATH_2_1");
                } else if ("path2_2".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_PATH_2_2");
                }
                break;

            case "FOREST_CHOICE_2":
                if ("wolf3_1".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_WOLF_3_1");
                } else if ("wolf3_2".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_WOLF_3_2");
                }
                break;

            case "FOREST_CHOICE_3":
                if ("stranger4_1".equals(userChoice)) {
                    gameState.setCurrentStep("END_FOREST_STRANGER_4_1");
                    gameState.setGameOver(true);
                } else if ("stranger4_2".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_STRANGER_4_2");
                }
                break;

            case "FOREST_PATH_2_1":
                if ("map5_1".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_PATH_5_1");
                } else if ("map5_2".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_PATH_5_2");
                }
                break;

            case "FOREST_PATH_2_2":
                if ("cave6_1".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_PATH_6_1");
                } else if ("cave6_2".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_PATH_6_2");
                }
                break;

            case "FOREST_WOLF_3_1":
                if ("bandage7_1".equals(userChoice)) {
                    gameState.setCurrentStep("END_FOREST_WOLF_7_1");
                    gameState.setGameOver(true);
                } else if ("help7_2".equals(userChoice)) {
                    gameState.setCurrentStep("END_FOREST_WOLF_7_2");
                    gameState.setGameOver(true);
                }
                break;

            case "FOREST_WOLF_3_2":
                if ("ravine8_1".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_RAVINE_8_1");
                } else if ("climb8_2".equals(userChoice)) {
                    gameState.setCurrentStep("FOREST_RAVINE_8_2");
                }
                break;

            case "FOREST_STRANGER_4_2":
                gameState.setCurrentStep("FOREST_PATH_5_1");
                break;

            case "FOREST_PATH_5_1":
                if ("end_saved".equals(userChoice)) {
                    gameState.setCurrentStep("END_SAVED_1");
                    gameState.setGameOver(true);
                } else if ("end_secret".equals(userChoice)) {
                    gameState.setCurrentStep("END_SECRET_1");
                    gameState.setGameOver(true);
                }
                break;

            case "FOREST_PATH_5_2":
                if ("end_saved".equals(userChoice)) {
                    gameState.setCurrentStep("END_SAVED_2");
                    gameState.setGameOver(true);
                } else if ("end_secret".equals(userChoice)) {
                    gameState.setCurrentStep("END_SECRET_2");
                    gameState.setGameOver(true);
                }
                break;

            case "FOREST_PATH_6_1":
                if ("end_captured".equals(userChoice)) {
                    gameState.setCurrentStep("END_CAPTURED");
                    gameState.setGameOver(true);
                } else if ("end_saved".equals(userChoice)) {
                    gameState.setCurrentStep("END_SAVED_3");
                    gameState.setGameOver(true);
                }
                break;

            case "FOREST_PATH_6_2":
                if ("end_dead".equals(userChoice)) {
                    gameState.setCurrentStep("END_DEAD_1");
                    gameState.setGameOver(true);
                } else if ("end_saved".equals(userChoice)) {
                    gameState.setCurrentStep("END_SAVED_4");
                    gameState.setGameOver(true);
                }
                break;

            case "FOREST_RAVINE_8_1":
                if ("end_secret".equals(userChoice)) {
                    gameState.setCurrentStep("END_SECRET_3");
                    gameState.setGameOver(true);
                } else if ("end_saved".equals(userChoice)) {
                    gameState.setCurrentStep("END_SAVED_5");
                    gameState.setGameOver(true);
                }
                break;

            case "FOREST_RAVINE_8_2":
                gameState.setRandom();
                gameState.setCurrentStep("END_SAVED_RANDOM");
                gameState.setGameOver(true);
                break;

            default:
                break;
        }
    }

}
