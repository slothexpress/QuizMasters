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
                ResultSet rs = stmt.executeQuery("SELECT * FROM QUESTIONS JOIN ANSWERS ON QUESTIONS.QUESTIONID=ANSWERS.QUESTIONID ORDER BY QUESTIONS.QUESTIONID")){
                Question question = new Question("", "","","","","");
                while (rs.next()) {
                    //Question question = new Question("", "","","","","");
                    if(!question.getQuestion().equalsIgnoreCase(rs.getString(2))) {
                        question.setQuestion(rs.getString(2));
                        question.setAnswer1(rs.getString(5));
                        question.setAnswer2("");
                        question.setAnswer3("");
                        question.setAnswer4("");
                        question.setCorrectAnswer("");
                        if(rs.getByte(6)==1) {
                            question.setCorrectAnswer(rs.getString(5));
                        }
                    } else {
                        if(question.getAnswer2().equalsIgnoreCase("")) {
                            question.setAnswer2(rs.getString(5));
                            if(rs.getByte(6)==1) {
                                question.setCorrectAnswer(rs.getString(5));
                            }

                        } else if(question.getAnswer3().equalsIgnoreCase("")) {
                            question.setAnswer3(rs.getString(5));
                            if(rs.getByte(6)==1) {
                                question.setCorrectAnswer(rs.getString(5));
                            }
                        } else if(question.getAnswer4().equalsIgnoreCase("")) {
                            question.setAnswer4(rs.getString(5));
                            if(rs.getByte(6)==1) {
                                question.setCorrectAnswer(rs.getString(5));
                            }
                            questions.add(question);
                        }
                    }
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

//    private Question rsQuestion(ResultSet rs) throws SQLException {
//        return new Question(rs.getInt(1),
//                            rs.getString(2));
//    }

    private Answer rsAnswer(ResultSet rs) throws SQLException {
            return new Answer(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getBoolean(4));
    }

}
