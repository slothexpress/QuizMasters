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
    String home(HttpSession session) {
        //Question q = new Question("","","","","","");
        Question q = QuizService.startPlay(repo);
        if(q==null) {
            return "end";
        }
        session.setAttribute("question", q);
        return "play";
    }

    @PostMapping("/play")
    String answer(HttpSession session, Model model, @RequestParam String answer) {
        Question q = (Question)session.getAttribute("question");
        System.out.println("Svaret från användaren: " + answer);
        if (QuizService.checkAnswer(q, answer)) {
            model.addAttribute("answer", "correct");
            System.out.println("Poängen: " + QuizService.getPoints());
            return "correct";
        } else {
            model.addAttribute("answer", "wrong");
            return "wrong";
        }
    }

}
