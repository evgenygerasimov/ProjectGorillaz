package com.javarush.gerasimov.controller;

import static org.mockito.Mockito.*;

import com.javarush.gerasimov.entity.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class GameServletTest {

    @Mock
    private HttpServletRequest req;

    @Mock
    private HttpServletResponse resp;

    @Mock
    private RequestDispatcher dispatcher;

    @InjectMocks
    private GameServlet gameServlet;

    @BeforeEach
    public void setUp() {
        gameServlet.init();
    }

    @Test
    public void shouldRenderFirstQuestionOnGameStart() throws ServletException, IOException {
        when(req.getRequestDispatcher("/WEB-INF/views/game.jsp")).thenReturn(dispatcher);

        gameServlet.doGet(req, resp);

        verify(req).setAttribute(eq("question"), any(Question.class));
        verify(req).getRequestDispatcher("/WEB-INF/views/game.jsp");
        verify(dispatcher).forward(req, resp);
    }

    @Test
    public void shouldMoveToSecondQuestionWhenCorrectAnswerProvided() throws IOException, ServletException {
        when(req.getParameter("answer")).thenReturn("1");

        gameServlet.doPost(req, resp);

        verify(resp).sendRedirect("/game");
    }

    @Test
    public void shouldResetGameAndRedirectToHomePage() throws IOException, ServletException {
        when(req.getParameter("action")).thenReturn("reset");

        gameServlet.doGet(req, resp);

        verify(resp).sendRedirect("/");
    }
}
