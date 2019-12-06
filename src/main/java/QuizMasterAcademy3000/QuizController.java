package QuizMasterAcademy3000;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class QuizController {

    QuestionRepository repo = new QuestionRepository();


    public QuizController() throws SQLException {
    }


    @GetMapping("/play")
    String home(HttpSession session, Model model) throws SQLException {
        Question q = QuizService.startPlay(repo);
        System.out.println("Frågor kvar: " + ((repo.getQuestionList().size())+1));
        if(q==null) {
            QuizService.setTotalPoints(QuizService.getPoints());
            model.addAttribute("points", QuizService.getPoints());
            repo = new QuestionRepository();
            return "end";
        }
        session.setAttribute("question", q);
        session.setAttribute("totalquestions", repo.getQuestionsPerRound());
        session.setAttribute("questionnow", (repo.getQuestionsPerRound()-repo.getQuestionList().size()));
        return "play";
    }

    @PostMapping("/play")
    String answer(HttpSession session, Model model, @RequestParam String answer) {
        Question q = (Question)session.getAttribute("question");
        System.out.println("Svaret från användaren: " + answer);
        if (QuizService.checkAnswer(q, answer)) {
            model.addAttribute("answer", "correct");
            System.out.println("Rätt svar, poäng just nu: " + QuizService.getPoints());
            if(repo.getQuestionsPerRound()-repo.getQuestionList().size()==0) {
                int totalScore = QuizService.getPoints();
                System.out.println("TotalScore "+totalScore);
                session.setAttribute("totalScore", totalScore);
            }
            return "correct";

        } else {
            model.addAttribute("answer", "wrong");
            System.out.println("Rätt svar: " + q.getCorrectAnswer());
            return "wrong";
        }
    }


    @GetMapping ("/register")
    String register(Model model, HttpSession session){
        model.addAttribute("user", new User(null, "","",""));
        return "register";
    }

    @PostMapping ("/register")
    String registered(@Valid User userValidation, BindingResult result, HttpSession session, Model model, @ModelAttribute User user){
//        UserValidator uv = new UserValidator();
        if (result.hasErrors()) {
            return "register";
        }
        model.addAttribute("user", user);
        //return "../static/index";
        user.setMostRecentScore(QuizService.getTotalPoints());

        session.setAttribute("recentscore", user.getMostRecentScore());
        return "saved";
    }

}
