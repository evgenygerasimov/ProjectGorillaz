package com.javarush.kuznetsov.controller;

import com.javarush.kuznetsov.logic.Artificial_intelligenceQuestLogic;
import com.javarush.kuznetsov.logic.ForestQuestLogic;
import com.javarush.kuznetsov.model.GameState;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;


@WebServlet(urlPatterns = {"/quest"})
public class QuestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");

        if (gameState == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        request.setAttribute("gameState", gameState);
        request.getRequestDispatcher("/WEB-INF/quest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");

        if (gameState == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        String userChoice = request.getParameter("choice");
        String questType = gameState.getQuestType();
        if ("ARTIFICIAL INTELLIGENCE".equals(questType)) {
            Artificial_intelligenceQuestLogic.handleChoice(gameState, userChoice);
        } else if ("FOREST".equals(questType)) {
            ForestQuestLogic.handleChoice(gameState, userChoice);
        }



        // Если игра окончена -> result.jsp
        if (gameState.isGameOver()) {
            session.setAttribute("gameState", gameState);
            request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
        } else {
            // Иначе продолжаем квест
            response.sendRedirect(request.getContextPath() + "/quest");
        }
    }
}
