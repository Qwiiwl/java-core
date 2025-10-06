package quiz;
import utils.InputHelper;

public class QuizManager {
    private Quiz quiz;
    private InputHelper input;

    public QuizManager(Quiz quiz, InputHelper input) {
        this.quiz = quiz;
        this.input = input;
    }

    public void start() {
        System.out.println("\n=== " + quiz.getTitle() + " ===");

        for (Question q : quiz.getQuestions()) {
            System.out.println("\nВопрос: " + q.getText());
            for (Team t : quiz.getTeams()) {
                System.out.print(t.getName() + ", ваш ответ: ");
                String ans = input.readLine();
                if (q.checkAnswer(ans)) {
                    t.addScore(10);
                    System.out.println("✅ Верно!");
                } else {
                    System.out.println("❌ Неверно!");
                }
            }
        }

        System.out.println("\n=== РЕЗУЛЬТАТЫ ===");
        for (Team t : quiz.getTeams()) {
            System.out.println(t.getName() + ": " + t.getScore() + " баллов");
        }
    }
}
