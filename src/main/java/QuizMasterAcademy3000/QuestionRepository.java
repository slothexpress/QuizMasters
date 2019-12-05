package QuizMasterAcademy3000;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class QuestionRepository {


    private List<Question>databaseQuestionsList= new ArrayList<>();
    private List<Question>questionList = new ArrayList<>();
    private List<Question>askedQuestionList = new ArrayList<>();
    private int questionsPerRound = 3; // TODO create a For loop in addQuestions to extract this amount of questions from database
    //private int progress;

    public QuestionRepository() {
        extractQuestionsFromDatabase();
        addQuestions();
        QuizService.setPoints(0);
        System.out.println("Setting points to 0\n");
    }

    public int getQuestionsPerRound() {
        return questionsPerRound;
    }



    public void extractQuestionsFromDatabase() {
        String question1Question = "Vilken är Sveriges huvudstad?";
        String question1A1 = "Stockholm";
        String question1A2 = "Malmö";
        String question1A3 = "Göteborg";
        String question1A4 = "Smålandsstenar";
        String question1Correct = "Stockholm";
        Question question1 =new Question(question1Question,question1A1,question1A2,question1A3,question1A4,question1Correct);

        String question2Question = "Vilken är Samis favoritpotatis?";
        String question2A1 = "Hederligt potatismos";
        String question2A2 = "Hasselbackspotatis";
        String question2A3 = "Friterad potatis";
        String question2A4 = "Vitlöksslungad färskpotatis";
        String question2Correct = "Friterad potatis";
        Question question2 =new Question(question2Question, question2A1,question2A2,question2A3,question2A4,question2Correct);

        String question3Question = "Vilket land tillhör ön Java?";
        String question3A1 = "Indonesien";
        String question3A2 = "Malaysia";
        String question3A3 = "Filipinerna";
        String question3A4 = "Kambodja";
        String question3Correct = "Indonesien";
        Question question3 =new Question(question3Question, question3A1,question3A2,question3A3,question3A4,question3Correct);

        String question4Question = "Vem kodade i mastern???";
        String question4A1 = "Hans";
        String question4A2 = "Robin";
        String question4A3 = "Johan";
        String question4A4 = "Sami";
        String question4Correct = "Robin";
        Question question4 =new Question(question4Question, question4A1,question4A2,question4A3,question4A4,question4Correct);

        String question5Question = "Hur många kanter har en kub?";
        String question5A1 = "12";
        String question5A2 = "8";
        String question5A3 = "6";
        String question5A4 = "None of the above";
        String question5Correct = "12";
        Question question5 =new Question(question5Question, question5A1,question5A2,question5A3,question5A4,question5Correct);

        String question6Question = "Hur många tangenter finns på ditt AW tangentbord?";
        String question6A1 = "98";
        String question6A2 = "102";
        String question6A3 = "114";
        String question6A4 = "None of the above";
        String question6Correct = "None of the above";
        Question question6 =new Question(question6Question, question6A1,question6A2,question6A3,question6A4,question6Correct);

        databaseQuestionsList.add(question1);
        databaseQuestionsList.add(question2);
        databaseQuestionsList.add(question3);
        databaseQuestionsList.add(question4);
        databaseQuestionsList.add(question5);
        databaseQuestionsList.add(question6);

        System.out.println("------\nExtracted questions from database\n-------");
    }

    public void addQuestions() {

        for (int i = 0 ; i < questionsPerRound; i++ ) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, databaseQuestionsList.size());
            Question q = databaseQuestionsList.get(randomNum);
            questionList.add(q);
            databaseQuestionsList.remove(randomNum);
        }

        System.out.println("*** Added " + questionsPerRound + " questions to this questionList ***\n");
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public Question generateRandomQuestion() {
        if (this.questionList.size() == 0) {
            return null;
        }
        int randomNum = ThreadLocalRandom.current().nextInt(0, questionList.size());
        askedQuestionList.add(this.questionList.get(randomNum));
        return this.questionList.remove(randomNum);
    }
}
