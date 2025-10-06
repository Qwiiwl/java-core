package quiz;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String title;
    private List<Question> questions = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void addTeam(Team t) {
        teams.add(t);
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
