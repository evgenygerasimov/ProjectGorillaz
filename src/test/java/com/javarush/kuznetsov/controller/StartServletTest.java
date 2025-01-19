package com.javarush.kuznetsov.controller;

import com.javarush.kuznetsov.model.GameState;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.eq;

/**
 * Тесты для StartServlet.doPost(...)
 */
@ExtendWith(MockitoExtension.class)
class StartServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @InjectMocks
    private StartServlet startServlet;  // Тестируемый класс

    @BeforeEach
    void setUp() {
        // Мокаем, что request.getSession() возвращает session
        when(request.getSession()).thenReturn(session);
        // Чтобы sendRedirect(...) в сервлете не получил "null" контекст, укажем ""
        when(request.getContextPath()).thenReturn("");
    }

    @Test
    void doPost_withPlayerNameAndQuestType_setsGameStateAndRedirects() throws ServletException, IOException {
        // Подготавливаем входные данные
        when(request.getParameter("playerName")).thenReturn("Alice");
        when(request.getParameter("questType")).thenReturn("FOREST");

        // Вызываем doPost
        startServlet.doPost(request, response);

        // Проверим, что создался gameState и положился в сессию
        // Для этого "схватим" аргумент, который кладётся
        ArgumentCaptor<GameState> captor = ArgumentCaptor.forClass(GameState.class);
        verify(session).setAttribute(eq("gameState"), captor.capture());

        GameState savedState = captor.getValue();
        assertNotNull(savedState);
        assertEquals("Alice", savedState.getPlayerName(),
                "Player name должен быть установлен, если был передан");
        assertEquals("FOREST", savedState.getQuestType(),
                "QuestType должен быть установлен согласно параметру");

        // Проверяем, что после установки gameState идёт redirect на "/quest"
        verify(response).sendRedirect("/quest");
    }

    @Test
    void doPost_withNoPlayerName_setsEmptyName() throws ServletException, IOException {
        // playerName пустой
        when(request.getParameter("playerName")).thenReturn("");
        when(request.getParameter("questType")).thenReturn("ARTIFICIAL INTELLIGENCE");

        startServlet.doPost(request, response);

        ArgumentCaptor<GameState> captor = ArgumentCaptor.forClass(GameState.class);
        verify(session).setAttribute(eq("gameState"), captor.capture());

        GameState savedState = captor.getValue();
        assertNotNull(savedState);
        // Поскольку playerName пуст, в GameState.name не должно ничего записаться
        assertNull(savedState.getPlayerName(),
                "Если playerName пустой, поле playerName должно остаться null");
        assertEquals("ARTIFICIAL INTELLIGENCE", savedState.getQuestType());

        verify(response).sendRedirect("/quest");
    }

    // Можно добавить ещё тест, если contextPath не пуст.
    // Но обычно проверка, что redirect'ит на <contextPath> + "/quest",
    // достаточно аналогична примеру выше.
}
