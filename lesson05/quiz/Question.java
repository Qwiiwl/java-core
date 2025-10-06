package quiz;

public class Question {
    private String questionText;
    private String correctAnswer;

    public Question(String text, String answer) {
        this.questionText = text;
        this.correctAnswer = answer.toLowerCase().trim();
    }

    public boolean checkAnswer(String answer) {
        return correctAnswer.equals(answer.toLowerCase().trim());
    }

    public String getText() {
        return questionText;
    }
}
