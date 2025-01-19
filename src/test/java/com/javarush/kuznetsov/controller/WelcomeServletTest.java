package com.javarush.kuznetsov.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WelcomeServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @InjectMocks
    private WelcomeServlet welcomeServlet;

    @Test
    void doGet_forwardsToIndexJsp() throws ServletException, IOException {
        when(request.getRequestDispatcher("/WEB-INF/index.jsp")).thenReturn(dispatcher);

        welcomeServlet.doGet(request, response);

        verify(dispatcher).forward(request, response);

        verify(response, never()).sendRedirect(anyString());
    }
}
