package QuizMasterAcademy3000;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizMasterAcademy3000ApplicationTests {

    @Autowired
//    private QuestionRepository1 repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void nextQuestionNew() throws ExecutionException, SQLException {
        QuestionRepository sut = new QuestionRepository();
        int i = sut.getQuestionList().size();
        Assert.assertEquals(3, i);
    }}

    @Test
    public void testSQLServer() throws SQLException {
        Assert.assertTrue(repository.testDB());
    }

    @Test
    public void testQuestionsCount() throws SQLException {
        List<Question> questions = repository.extractQuestionsFromDb();
        Assert.assertEquals(10, questions.size());
    }

    @Test
    public void testJDBC() throws SQLException {
        List<Question> questions=repository.extractQuestionsFromDb();
        for (Question q : questions) {
            System.out.println(q.getQuestion());
            System.out.println(q.getAnswer1());
            System.out.println(q.getAnswer2());
            System.out.println(q.getAnswer3());
            System.out.println(q.getAnswer4());
        }

    }
}
    @Test
    public void testSQLServer() throws SQLException {
        Assert.assertTrue(repository.testDB());
    }

    @Test
    public void testQuestionsCount() throws SQLException {
        List<Question> questions = repository.extractQuestionsFromDb();
        Assert.assertEquals(10, questions.size());
    }
}
