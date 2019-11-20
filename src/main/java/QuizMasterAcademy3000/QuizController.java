package QuizMasterAcademy3000;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {


    @GetMapping("/play")
    String home() {

        return "play";
    }


}
