package QuizMasterAcademy3000;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.validation.constraints.DecimalMax;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepository1 {

    @Autowired
    private DataSource dataSource;

        public boolean testDB() throws SQLException {
        int two = 0;
        try (Connection con = dataSource.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1+1")) {
             rs.next();
             two = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return two == 2;
    }

    public List<Question> extractQuestionsFromDb() throws SQLException {
        List<Question> questions = new ArrayList<>();
            try (Connection con = dataSource.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM QUESTIONS")){
                while (rs.next()) {
                    questions.add(rsQuestion(rs));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return questions;
    }

    public List<Answer> extractAnwersFromDb() throws SQLException {
        List<Answer> answers = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ANSWERS")) {

            while (rs.next()) {
                answers.add(rsAnswer(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private Question rsQuestion(ResultSet rs) throws SQLException {
        return new Question(rs.getInt(1),
                            rs.getString(2));
    }

    private Answer rsAnswer(ResultSet rs) throws SQLException {
            return new Answer(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getBoolean(4));
    }

}
