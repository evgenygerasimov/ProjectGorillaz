package com.javarush.gerasimov.controller;

import com.javarush.gerasimov.config.Winter;
import com.javarush.gerasimov.entity.Question;
import com.javarush.gerasimov.repository.QuestionRepository;
import com.javarush.gerasimov.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    private List<Question> questions;
    private int currentQuestion = 0;
    private boolean gameWon = true;
    private int score = 0;
    private int countGamePlayed = 0;
    private final QuestionService questionService = Winter.find(QuestionService.class);


    @Override
    public void init() {
        questions = questionService.getAllQuestions();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String clientIp = req.getRemoteAddr();
        String serverName = req.getServerName();

        if ("reset".equals(action)) {
            resetGame();
            resp.sendRedirect("/");
            return;
        }

        if (currentQuestion >= questions.size()) {
            countGamePlayed++;
            req.setAttribute("score", score);
            req.setAttribute("countGamePlayed", countGamePlayed);
            req.setAttribute("clientIp", clientIp);
            req.setAttribute("serverName", serverName);
            req.getRequestDispatcher("/WEB-INF/views/win-page.jsp").forward(req, resp);
        }
        if (!gameWon) {
            countGamePlayed++;
            req.setAttribute("score", score);
            req.setAttribute("countGamePlayed", countGamePlayed);
            req.setAttribute("clientIp", clientIp);
            req.setAttribute("serverName", serverName);
            req.getRequestDispatcher("/WEB-INF/views/lose-page.jsp").forward(req, resp);
        }

        req.setAttribute("question", questions.get(currentQuestion));
        req.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String selectedOption = req.getParameter("answer");
        int correctOption = questions.get(currentQuestion).getCorrectOption();
        if (Integer.parseInt(selectedOption) == correctOption) {
            score++;
            currentQuestion++;
        } else {
            gameWon = false;
        }
        resp.sendRedirect("/game");
    }

    private void resetGame() {
        currentQuestion = 0;
        score = 0;
        gameWon = true;
    }
}


