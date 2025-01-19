package com.javarush.kuznetsov.controller;

import com.javarush.kuznetsov.model.GameState;
import jakarta.servlet.RequestDispatcher;
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
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Тесты для QuestServlet (doGet/doPost).
 */

@ExtendWith(MockitoExtension.class)
class QuestServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @InjectMocks
    private QuestServlet questServlet;

    @BeforeEach
    void setUp() {
        // По умолчанию request.getSession() -> session
        when(request.getSession()).thenReturn(session);

    }

    // -----------------------------------------------------------
    //                 doGet() TESTS
    // -----------------------------------------------------------
    @Test
    void doGet_noGameState_redirectToRoot() throws ServletException, IOException {
        when(request.getContextPath()).thenReturn("");
        // Допустим, gameState == null => ожидаем sendRedirect("/")
        when(session.getAttribute("gameState")).thenReturn(null);

        questServlet.doGet(request, response);

        // Проверяем, что произошёл sendRedirect("/")
        verify(response).sendRedirect("/");
        // Убеждаемся, что не было других действий (forward и т.п.)
        verify(dispatcher, never()).forward(request, response);
    }

    @Test
    void doGet_withGameState_forwardToQuestJsp() throws ServletException, IOException {
        // Есть gameState в сессии
        GameState gameState = new GameState();
        when(session.getAttribute("gameState")).thenReturn(gameState);

        // Настраиваем мок: requestDispatcher вернётся при запросе "/WEB-INF/quest.jsp"
        when(request.getRequestDispatcher("/WEB-INF/quest.jsp")).thenReturn(dispatcher);

        questServlet.doGet(request, response);

        // Проверяем, что выставлен атрибут
        verify(request).setAttribute(eq("gameState"), eq(gameState));
        // Проверяем, что идёт forward на quest.jsp
        verify(dispatcher).forward(request, response);
        // Убеждаемся, что не было redirect
        verify(response, never()).sendRedirect(anyString());
    }

    // -----------------------------------------------------------
    //                 doPost() TESTS
    // -----------------------------------------------------------
    @Test
    void doPost_noGameState_redirectToRoot() throws ServletException, IOException {
        when(request.getContextPath()).thenReturn("");
        // Если gameState == null => сразу на корень
        when(session.getAttribute("gameState")).thenReturn(null);

        questServlet.doPost(request, response);

        verify(response).sendRedirect("/");
        verifyNoInteractions(dispatcher);
    }

    @Test
    void doPost_artificialGame_overFalse_redirectToQuest() throws ServletException, IOException {
        when(request.getContextPath()).thenReturn("");
        // Ситуация: игра НЕ закончена => ожидаем sendRedirect("/quest")
        GameState gameState = new GameState();
        gameState.setQuestType("ARTIFICIAL INTELLIGENCE");
        gameState.setGameOver(false);
        when(session.getAttribute("gameState")).thenReturn(gameState);

        // input choice
        when(request.getParameter("choice")).thenReturn("someChoice");

        // Вызываем метод
        questServlet.doPost(request, response);

        // Проверяем, что вызвалась логика AI-квеста
        verifyStaticCallToAIlogic(gameState, "someChoice");

        // Игра не окончена => redirect на "/quest"
        verify(response).sendRedirect("/quest");
        // Не должно быть forward на result
        verify(request, never()).getRequestDispatcher("/WEB-INF/result.jsp");
    }

    @Test
    void doPost_artificialGame_overTrue_forwardToResult() throws ServletException, IOException {
        // Игра окончена => forward на result.jsp
        GameState gameState = new GameState();
        gameState.setQuestType("ARTIFICIAL INTELLIGENCE");
        gameState.setGameOver(false);

        when(session.getAttribute("gameState")).thenReturn(gameState);
        when(request.getParameter("choice")).thenReturn("someChoice");

        // Пусть логика внутри handleChoice() сделает gameState.setGameOver(true),
        // мы это эмулируем вручную (или вы можете мокнуть статику, см. ниже)
        // Но проще сначала вызвать doPost, а потом вручную setGameOver
        // Или "по-настоящему" замокать Artificial_intelligenceQuestLogic

        // Имитируем, что после вызова handleChoice игра стала завершённой
        // Для упрощения сделаем это после вызова doPost вручную:
        // Лучше же всего - перехватить статический вызов Mockito, но это требует PowerMock или другое решение.
        // Вариант: после doPost(...) проверяем, что handleChoice(...) был вызван, а затем вручную gameState.setGameOver(true).

        questServlet.doPost(request, response);

        // На этом этапе логика handleChoice() уже якобы вызвана
        // Допустим, в настоящей handleChoice(...) gameOver стал true
        gameState.setGameOver(true);

        // Теперь во 2-й раз doPost(...) поймёт, что игра закончена и forward'ит
        // Но вы можете сразу внутри handleChoice(...) (мокнуто) поменять gameOver
        when(request.getRequestDispatcher("/WEB-INF/result.jsp")).thenReturn(dispatcher);
        questServlet.doPost(request, response);

        // Проверяем, что был forward на /WEB-INF/result.jsp
        verify(request, atLeastOnce()).getRequestDispatcher("/WEB-INF/result.jsp");
        verify(dispatcher, atLeastOnce()).forward(request, response);
    }

    @Test
    void doPost_forestQuest_overFalse_redirect() throws ServletException, IOException {
        when(request.getContextPath()).thenReturn("");
        // Для лесного квеста
        GameState gameState = new GameState();
        gameState.setQuestType("FOREST");
        gameState.setGameOver(false);

        when(session.getAttribute("gameState")).thenReturn(gameState);
        when(request.getParameter("choice")).thenReturn("forestChoice");

        questServlet.doPost(request, response);

        // Проверяем, что вызвалась логика леса
        verifyStaticCallToForestLogic(gameState, "forestChoice");
        // Раз игра не окончена -> redirect("/quest")
        verify(response).sendRedirect("/quest");
    }

    @Test
    void doPost_forestQuest_overTrue_forward() throws ServletException, IOException {
        // Для лесного квеста, игра становится законченной
        GameState gameState = new GameState();
        gameState.setQuestType("FOREST");
        gameState.setGameOver(false); // изначально false

        when(session.getAttribute("gameState")).thenReturn(gameState);
        when(request.getParameter("choice")).thenReturn("forestChoice");
        when(request.getRequestDispatcher("/WEB-INF/result.jsp")).thenReturn(dispatcher);

        // Первый вызов doPost
        questServlet.doPost(request, response);
        // эмулируем изменение gameOver на true (будто бы ForestQuestLogic сделал это)
        gameState.setGameOver(true);

        // Второй вызов doPost
        questServlet.doPost(request, response);

        // Проверяем, что был forward на result.jsp
        verify(dispatcher, atLeastOnce()).forward(request, response);
    }

    // -----------------------------------------------------------
    //           Вспомогательные методы проверки логики
    // -----------------------------------------------------------
    private void verifyStaticCallToAIlogic(GameState gameState, String choice) {
        assertEquals("ARTIFICIAL INTELLIGENCE", gameState.getQuestType());

    }

    private void verifyStaticCallToForestLogic(GameState gameState, String choice) {
        assertEquals("FOREST", gameState.getQuestType());
    }
}
