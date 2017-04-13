package pkg.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ArIF on 12-Apr-17.
 */
@Controller
public class DefaultController {
    @RequestMapping("/*")
    public String index(Model model)
    {
        System.out.println("- method invoked: DefaultController");
        return "index";
    }
}
