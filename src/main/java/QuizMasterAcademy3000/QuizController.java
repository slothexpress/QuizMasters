package QuizMasterAcademy3000;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class QuizController {

    Repository repo = new Repository();


    @GetMapping("/play")
    String home(HttpSession session, Model model) {
        Question q = QuizService.startPlay(repo);
        System.out.println("Frågor kvar: " + ((repo.getQuestionList().size())+1));
        if(q==null) {
            model.addAttribute("points", QuizService.getPoints());
            repo = new Repository();
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
            return "correct";
        } else {
            model.addAttribute("answer", "wrong");
            System.out.println("Rätt svar: " + q.getCorrectAnswer());
            return "wrong";
        }
    }


    @GetMapping ("/register")
    String register(Model model){
        model.addAttribute("user", new User(null, "","",""));
        return "register";
    }

    @PostMapping ("/register")
    String registered(Model model, @ModelAttribute User user){
        model.addAttribute("user", user);
        return "../static/index";
    }


}
