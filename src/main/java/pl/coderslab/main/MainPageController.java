package pl.coderslab.main;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainPageController {


    @RequestMapping("/mainPage")

    public String redirect() {
        return "mainPage";
    }

}
