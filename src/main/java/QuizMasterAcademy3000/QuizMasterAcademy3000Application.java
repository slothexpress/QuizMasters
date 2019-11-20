package QuizMasterAcademy3000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizMasterAcademy3000Application {

	public static void main(String[] args) {

		SpringApplication.run(QuizMasterAcademy3000Application.class, args);
		System.out.println("HELLO WORLD");

		//Testing repository
		Repository repository=new Repository();
		repository.addQuestions();
		Question q = repository.generateRandomQuestion();
		System.out.println(q.getCorrectAnswer());
		//End of testing repository
	}

}
