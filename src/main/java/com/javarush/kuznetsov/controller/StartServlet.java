package com.javarush.kuznetsov.controller;

import com.javarush.kuznetsov.model.GameState;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;



@WebServlet(urlPatterns = {"/start"})
public class StartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String playerName = request.getParameter("playerName");
        String questType = request.getParameter("questType");


        // Создаём новое состояние игры
        GameState gameState = new GameState();
        if (playerName != null && !playerName.isEmpty()) {
            gameState.setPlayerName(playerName);
        }

        gameState.setQuestType(questType);

        // Кладём в сессию
        HttpSession session = request.getSession();
        session.setAttribute("gameState", gameState);

        response.sendRedirect(request.getContextPath() + "/quest");
    }
}
