package service;

import model.Question;
import util.FileHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionInputHandler {
    private static final String QUESTION_FILE = "./src/main/resources/questions.json";
    private Scanner scanner = new Scanner(System.in);

    public void takeQuestionInput() {
        List<Question> questions = FileHandler.readQuestionsFromFile(QUESTION_FILE);

        if (questions == null) {
            questions = new ArrayList<>();
        }

        while (true) {
            System.out.print("Input your question: ");
            String questionText = scanner.nextLine();

            String[] options = new String[4];
            for (int i = 0; i < 4; i++) {
                System.out.print("Input option " + (i + 1) + ": ");
                options[i] = scanner.nextLine();
            }

            System.out.print("What is the answer key? ");
            int answerKey = Integer.parseInt(scanner.nextLine());

            questions.add(new Question(questionText, options, answerKey));
            System.out.println("Saved successfully! Do you want to add more questions? (press 'q' to quit or any other key to continue)");
            String input = scanner.nextLine();
            if ("q".equalsIgnoreCase(input)) {
                break;
            }
        }

        FileHandler.writeQuestionsToFile(questions, QUESTION_FILE);
    }
}
