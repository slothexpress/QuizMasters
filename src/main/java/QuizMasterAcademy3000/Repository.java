package QuizMasterAcademy3000;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Repository {
    private List<Question>questionList = new ArrayList<>();
    private List<Question>askedQuestionList = new ArrayList<>();

    public Repository() {
        addQuestions();
    }

    public void addQuestions() {
        String question1Question = "Vilken är Sveriges huvudstad?";
        String question1A1 = "Stockholm";
        String question1A2 = "test";
        String question1A3 = "Göteborg";
        String question1A4 = "t";
        String question1Correct = "Stockholm";
        Question question1 =new Question(question1Question,question1A1,question1A2,question1A3,question1A4,question1Correct);
        questionList.add(question1);

        String question2Question = "Fråga 2";
        String question2A1 = "1";
        String question2A2 = "2";
        String question2A3 = "3";
        String question2A4 = "4";
        String question2Correct = "2";
        Question question2 =new Question(question2Question, question2A1,question2A2,question2A3,question2A4,question2Correct);
        questionList.add(question2);

        String question3Question = "Fråga 3";
        String question3A1 = "1";
        String question3A2 = "2";
        String question3A3 = "3";
        String question3A4 = "4";
        String question3Correct = "3";
        Question question3 =new Question(question3Question, question3A1,question3A2,question3A3,question3A4,question3Correct);
        questionList.add(question3);

        String question4Question = "Fråga 4";
        String question4A1 = "1";
        String question4A2 = "2";
        String question4A3 = "3";
        String question4A4 = "4";
        String question4Correct = "4";
        Question question4 =new Question(question4Question, question4A1,question4A2,question4A3,question4A4,question4Correct);
        questionList.add(question4);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public Question generateRandomQuestion() {
        if (this.questionList == null) {
            return null;
        }
        int randomNum = ThreadLocalRandom.current().nextInt(0, questionList.size());
        askedQuestionList.add(this.questionList.get(randomNum));
        return this.questionList.remove(randomNum);
    }
}
