package QuizMasterAcademy3000;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
