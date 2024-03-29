package QuizMasterAcademy3000;

public class QuizService {

    private static int totalPoints = 0;
    private static int points = 0;

    public static int getPoints() {
        return points;
    }

    public static void setPoints(int p) {
        points = p;
    }

    public static Question startPlay(QuestionRepository repo) {
        Question q = repo.generateRandomQuestion();
        return q;
    }

    public static boolean checkAnswer(Question q, String answer){
        if(answer.equals(q.getCorrectAnswer())) {
            points++;
            return true;
        } else {
            return false;
        }
    }

    public static int getTotalPoints() {
        return totalPoints;
    }

    public static void setTotalPoints(int totalPoints) {
        QuizService.totalPoints = totalPoints;
    }
}

