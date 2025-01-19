package com.javarush.kuznetsov.logic;

import static org.junit.jupiter.api.Assertions.*;

import com.javarush.kuznetsov.model.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Artificial_intelligenceQuestLogicTest {
    private GameState gameState;

    @BeforeEach
    void setUp() {
        gameState = new GameState();

    }

    @Test
    @DisplayName("Проверка перехода из START при выборе next")
    void testStartNext() {
        gameState.setCurrentStep("START");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "next");
        assertEquals("APPLICATION", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());

    }

    @Test
    @DisplayName("Проверка перехода из START при выборе next")
    void testApplicationYes() {
        gameState.setCurrentStep("APPLICATION");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "yes");
        assertEquals("TRUE", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());

    }

    @Test
    @DisplayName("Проверка перехода из APPLICATION при выборе no")
    void testApplicationNo() {
        gameState.setCurrentStep("APPLICATION");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "no");
        assertEquals("FALSE", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());

    }

    @Test
    @DisplayName("Проверка перехода из TRUE при выборе yes")
    void testTrueYes() {
        gameState.setCurrentStep("TRUE");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "yes");
        assertEquals("YES?", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());

    }

    @Test
    @DisplayName("Проверка перехода из TRUE при выборе no")
    void testTrueNo() {
        gameState.setCurrentStep("TRUE");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "no");
        assertEquals("NO?", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FALSE при выборе yes")
    void testFalseYes() {
        gameState.setCurrentStep("FALSE");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "yes");
        assertEquals("YES?", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());

    }

    @Test
    @DisplayName("Проверка перехода из FALSE при выборе no")
    void testFalseNo() {
        gameState.setCurrentStep("FALSE");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "no");
        assertEquals("NO?", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }


    @Test
    @DisplayName("Проверка перехода из YES? при выборе next")
    void testYesNext() {
        gameState.setCurrentStep("YES?");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "next");
        assertEquals("DATING", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из NO? при выборе next")
    void testNoNext() {
        gameState.setCurrentStep("NO?");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "next");
        assertEquals("DATING", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из DATING при выборе next")
    void testDatingNext() {
        gameState.setCurrentStep("DATING");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "next");
        assertEquals("INFORMATION", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из INFORMATION при выборе yes")
    void testInformationYes() {
        gameState.setCurrentStep("INFORMATION");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "yes");
        assertEquals("WIN_LICE", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из INFORMATION при выборе no")
    void testInformationNo() {
        gameState.setCurrentStep("INFORMATION");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "no");
        assertEquals("CHECK", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из CHECK при выборе sorry")
    void testCheckSorry() {
        gameState.setCurrentStep("CHECK");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "sorry");
        assertEquals("TRAITOR", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из CHECK при выборе lie")
    void testCheckLie() {
        gameState.setCurrentStep("CHECK");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "lie");
        assertEquals("LOSE_LIE", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из TRAITOR при выборе next")
    void testTraitorNext() {
        gameState.setCurrentStep("TRAITOR");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "lie");
        assertEquals("FINAL", gameState.getCurrentStep());
        assertFalse(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FINAL при выборе true")
    void testFinalTrue() {
        gameState.setCurrentStep("FINAL");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "true");
        assertEquals("WIN_SPARK", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }

    @Test
    @DisplayName("Проверка перехода из FINAL при выборе false")
    void testFinalFalse() {
        gameState.setCurrentStep("FINAL");
        Artificial_intelligenceQuestLogic.handleChoice(gameState, "false");
        assertEquals("LOSE_SPARK", gameState.getCurrentStep());
        assertTrue(gameState.isGameOver());
    }
}