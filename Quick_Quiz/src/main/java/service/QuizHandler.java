package service;

import model.Question;
import util.FileHandler;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizHandler {
    private static final String QUESTION_FILE = "./src/main/resources/questions.json";
    private Scanner scanner = new Scanner(System.in);

    public void startQuiz() {
        List<Question> allQuestions = FileHandler.readQuestionsFromFile(QUESTION_FILE);
        Collections.shuffle(allQuestions);

        int score = 0;
        int questionsToAsk = Math.min(10, allQuestions.size());

        System.out.println("Welcome to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
        String start = scanner.nextLine();
        if (!"s".equalsIgnoreCase(start)) {
            return;
        }

        for (int i = 0; i < questionsToAsk; i++) {
            Question q = allQuestions.get(i);
            System.out.println("\n[Question " + (i + 1) + "] " + q.getQuestion());
            for (int j = 0; j < q.getOptions().length; j++) {
                System.out.println((j + 1) + ". " + q.getOptions()[j]);
            }

            System.out.print("Your answer: ");
            int answer = Integer.parseInt(scanner.nextLine());

            if (answer == q.getAnswerKey()) {
                score++;
            }
        }

        displayResult(score);
        askForRestart();
    }

    private void displayResult(int score) {
        if (score >= 8) {
            System.out.println("Excellent! You have got " + score + " out of 10");
        } else if (score >= 5) {
            System.out.println("Good. You have got " + score + " out of 10");
        } else if (score >= 2) {
            System.out.println("Very poor! You have got " + score + " out of 10");
        } else {
            System.out.println("Very sorry you are failed. You have got " + score + " out of 10");
        }
    }

    private void askForRestart() {
        System.out.println("Would you like to start again? Press 's' for start or 'q' for quit.");
        String input = scanner.nextLine();
        if ("s".equalsIgnoreCase(input)) {
            startQuiz();
        }
    }
}
