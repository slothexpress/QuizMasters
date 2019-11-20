package QuizMasterAcademy3000;

public class QuizService {

    private static int points = 0;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public static Question startPlay() {
        Repository repo = new Repository();
        repo.addQuestions();
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

}

