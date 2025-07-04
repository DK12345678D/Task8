package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) {
        List<QuizQuestion> questions = new ArrayList<>();

        questions.add(new QuizQuestion(
            "What are Java loops?",
            new String[]{"Decision structures", "Repetition structures", "Objects", "Classes"},
            2
        ));

        questions.add(new QuizQuestion(
            "What is an enhanced for-loop?",
            new String[]{"A loop using 'while'", "A loop using 'goto'", "A simplified for-each loop", "A do-while loop"},
            3
        ));

        questions.add(new QuizQuestion(
            "How do you handle multiple user inputs?",
            new String[]{"Using Scanner and loops", "Using only BufferedReader", "Using PrintWriter", "Manually parsing files"},
            1
        ));

        questions.add(new QuizQuestion(
            "How is switch-case different from if-else?",
            new String[]{"It uses classes", "It is faster and cleaner for fixed values", "It replaces loops", "It handles runtime errors"},
            2
        ));

        questions.add(new QuizQuestion(
            "What are collections in Java?",
            new String[]{"Tools to manage input", "Libraries for math", "Framework to store/manipulate data", "None"},
            3
        ));

        // Shuffle questions
        Collections.shuffle(questions);

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (QuizQuestion q : questions) {
            q.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong. Correct answer: " + q.options[q.correctAnswerIndex - 1] + "\n");
            }
        }

        System.out.println("🎯 Quiz Completed! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}
