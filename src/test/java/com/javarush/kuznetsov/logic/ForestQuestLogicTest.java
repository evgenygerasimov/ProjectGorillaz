package com.javarush.kuznetsov.logic;

import com.javarush.kuznetsov.model.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ForestQuestLogicTest {
    private GameState gameState;
    @BeforeEach
    void setUp() {
        gameState = new GameState();
    }

    @Test
    @DisplayName("Проверка перехода из START при выборе choice1")
    void testStartChoice1() {
        gameState.setCurrentStep("START");
        ForestQuestLogic.handleChoice(gameState, "choice1");
        assertEquals("FOREST_CHOICE_1", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из START при выборе choice2")
    void testStartChoice2() {
        gameState.setCurrentStep("START");
        ForestQuestLogic.handleChoice(gameState, "choice2");
        assertEquals("FOREST_CHOICE_2", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из START при выборе choice3")
    void testStartChoice3() {
        gameState.setCurrentStep("START");
        ForestQuestLogic.handleChoice(gameState, "choice3");
        assertEquals("FOREST_CHOICE_3", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_CHOICE_1 при выборе path2_1")
    void testForestChoice1Path21() {
        gameState.setCurrentStep("FOREST_CHOICE_1");
        ForestQuestLogic.handleChoice(gameState, "path2_1");
        assertEquals("FOREST_PATH_2_1", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_CHOICE_1 при выборе path2_2")
    void testForestChoice1Path22() {
        gameState.setCurrentStep("FOREST_CHOICE_1");
        ForestQuestLogic.handleChoice(gameState, "path2_2");
        assertEquals("FOREST_PATH_2_2", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_CHOICE_2 при выборе wolf3_1")
    void testForestChoice2Wolf31() {
        gameState.setCurrentStep("FOREST_CHOICE_2");
        ForestQuestLogic.handleChoice(gameState, "wolf3_1");
        assertEquals("FOREST_WOLF_3_1", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_CHOICE_2 при выборе wolf3_2")
    void testForestChoice2Wolf32() {
        gameState.setCurrentStep("FOREST_CHOICE_2");
        ForestQuestLogic.handleChoice(gameState, "wolf3_2");
        assertEquals("FOREST_WOLF_3_2", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_CHOICE_3 при выборе stranger4_1")
    void testForestChoice3Stranger41() {
        gameState.setCurrentStep("FOREST_CHOICE_3");
        ForestQuestLogic.handleChoice(gameState, "stranger4_1");
        assertEquals("END_FOREST_STRANGER_4_1", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_CHOICE_3 при выборе stranger4_2")
    void testForestChoice2Stranger42() {
        gameState.setCurrentStep("FOREST_CHOICE_3");
        ForestQuestLogic.handleChoice(gameState, "stranger4_2");
        assertEquals("FOREST_STRANGER_4_2", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_2_1 при выборе stranger4_2")
    void testForestPath21Map51() {
        gameState.setCurrentStep("FOREST_PATH_2_1");
        ForestQuestLogic.handleChoice(gameState, "map5_1");
        assertEquals("FOREST_PATH_5_1", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_2_1 при выборе stranger4_2")
    void testForestPath21Map52() {
        gameState.setCurrentStep("FOREST_PATH_2_1");
        ForestQuestLogic.handleChoice(gameState, "map5_2");
        assertEquals("FOREST_PATH_5_2", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_2_2 при выборе cave6_1")
    void testForestPath22Cave61() {
        gameState.setCurrentStep("FOREST_PATH_2_2");
        ForestQuestLogic.handleChoice(gameState, "cave6_1");
        assertEquals("FOREST_PATH_6_1", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_2_2 при выборе cave6_2")
    void testForestPath22Cave62() {
        gameState.setCurrentStep("FOREST_PATH_2_2");
        ForestQuestLogic.handleChoice(gameState, "cave6_2");
        assertEquals("FOREST_PATH_6_2", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_WOLF_3_1 при выборе bandage7_1")
    void testForestWolf31Bandage71() {
        gameState.setCurrentStep("FOREST_WOLF_3_1");
        ForestQuestLogic.handleChoice(gameState, "bandage7_1");
        assertEquals("END_FOREST_WOLF_7_1", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_WOLF_3_1 при выборе help7_2")
    void testForestWolf31Help72() {
        gameState.setCurrentStep("FOREST_WOLF_3_1");
        ForestQuestLogic.handleChoice(gameState, "help7_2");
        assertEquals("END_FOREST_WOLF_7_2", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_WOLF_3_2 при выборе ravine8_1")
    void testForestWolf32Ravine81() {
        gameState.setCurrentStep("FOREST_WOLF_3_2");
        ForestQuestLogic.handleChoice(gameState, "ravine8_1");
        assertEquals("FOREST_RAVINE_8_1", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_WOLF_3_2 при выборе climb8_2")
    void testForestWolf32Climb82() {
        gameState.setCurrentStep("FOREST_WOLF_3_2");
        ForestQuestLogic.handleChoice(gameState, "climb8_2");
        assertEquals("FOREST_RAVINE_8_2", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_STRANGER_4_2 при выборе climb8_2")
    void testForestStranger42Continue() {
        gameState.setCurrentStep("FOREST_STRANGER_4_2");
        ForestQuestLogic.handleChoice(gameState, "continue");
        assertEquals("FOREST_PATH_5_1", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_5_1 при выборе end_saved")
    void testForestPath51EndSaved() {
        gameState.setCurrentStep("FOREST_PATH_5_1");
        ForestQuestLogic.handleChoice(gameState, "end_saved");
        assertEquals("END_SAVED_1", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_5_1 при выборе end_secret")
    void testForestPath51EndSecret() {
        gameState.setCurrentStep("FOREST_PATH_5_1");
        ForestQuestLogic.handleChoice(gameState, "end_secret");
        assertEquals("END_SECRET_1", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_5_2 при выборе end_saved")
    void testForestPath52EndSaved() {
        gameState.setCurrentStep("FOREST_PATH_5_2");
        ForestQuestLogic.handleChoice(gameState, "end_saved");
        assertEquals("END_SAVED_2", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_5_2 при выборе end_secret")
    void testForestPath52EndSecret() {
        gameState.setCurrentStep("FOREST_PATH_5_2");
        ForestQuestLogic.handleChoice(gameState, "end_secret");
        assertEquals("END_SECRET_2", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_6_1 при выборе end_captured")
    void testForestPath61EndCaptured() {
        gameState.setCurrentStep("FOREST_PATH_6_1");
        ForestQuestLogic.handleChoice(gameState, "end_captured");
        assertEquals("END_CAPTURED", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_6_1 при выборе end_saved")
    void testForestPath61EndSaved() {
        gameState.setCurrentStep("FOREST_PATH_6_1");
        ForestQuestLogic.handleChoice(gameState, "end_saved");
        assertEquals("END_SAVED_3", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_6_2 при выборе end_dead")
    void testForestPath62EndDead() {
        gameState.setCurrentStep("FOREST_PATH_6_2");
        ForestQuestLogic.handleChoice(gameState, "end_dead");
        assertEquals("END_DEAD_1", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_PATH_6_2 при выборе end_saved")
    void testForestPath62EndSaved() {
        gameState.setCurrentStep("FOREST_PATH_6_2");
        ForestQuestLogic.handleChoice(gameState, "end_saved");
        assertEquals("END_SAVED_4", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_RAVINE_8_1 при выборе end_secret")
    void testForestRavine81EndSecret() {
        gameState.setCurrentStep("FOREST_RAVINE_8_1");
        ForestQuestLogic.handleChoice(gameState, "end_secret");
        assertEquals("END_SECRET_3", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }
    @Test
    @DisplayName("Проверка перехода из FOREST_RAVINE_8_1 при выборе end_saved")
    void testForestRavine81EndSaved() {
        gameState.setCurrentStep("FOREST_RAVINE_8_1");
        ForestQuestLogic.handleChoice(gameState, "end_saved");
        assertEquals("END_SAVED_5", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FOREST_RAVINE_8_2 при выборе next")
    void testForestRavine82Next() {
        gameState.setCurrentStep("FOREST_RAVINE_8_2");
        ForestQuestLogic.handleChoice(gameState, "next");
        assertEquals("END_SAVED_RANDOM", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }








}