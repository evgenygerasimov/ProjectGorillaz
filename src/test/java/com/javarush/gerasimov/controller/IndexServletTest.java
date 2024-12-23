package com.javarush.gerasimov.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class IndexServletTest {

    @Mock
    private HttpServletRequest req;

    @Mock
    private HttpServletResponse resp;

    @Mock
    private RequestDispatcher dispatcher;

    @InjectMocks
    private IndexServlet indexServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldOpenIndexPage() throws ServletException, IOException {
        when(req.getRequestDispatcher("/WEB-INF/views/index.jsp")).thenReturn(dispatcher);

        indexServlet.doGet(req, resp);

        verify(req).getRequestDispatcher("/WEB-INF/views/index.jsp");
        verify(dispatcher).forward(req, resp);
    }
}
