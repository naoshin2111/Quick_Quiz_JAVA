package model;

public class Question {
    private String question;
    private String[] options;
    private int answerKey;

    public Question(String question, String[] options, int answerKey) {
        this.question = question;
        this.options = options;
        this.answerKey = answerKey;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswerKey() {
        return answerKey;
    }
}
