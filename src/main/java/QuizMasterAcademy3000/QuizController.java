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

    @GetMapping("/play")
    String home(HttpSession session) {
        Question q = QuizService.startPlay();
        session.setAttribute("question", q);
        return "play";
    }

    @PostMapping("/play")
    String answer(HttpSession session, Model model, @RequestParam String answer) {
        Question q = (Question)session.getAttribute("question");
        if (QuizService.checkAnswer(q, answer)) {
            model.addAttribute("answer", "correct");
        } else {
            model.addAttribute("answer", "wrong");
        }
        return "play";
    }




}
