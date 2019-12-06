package QuizMasterAcademy3000;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key
    private Long id;
    @Size(min=4, max=8)
    private String name;
    @Email
    private String email;
    @Size(min=8, max = 80)
    private String password;
    private int highScore;
    private int mostRecentScore;

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getMostRecentScore() {
        return mostRecentScore;
    }

    public void setMostRecentScore(int mostRecentScore) {
        this.mostRecentScore = mostRecentScore;
    }

    public User() {

    }


}
