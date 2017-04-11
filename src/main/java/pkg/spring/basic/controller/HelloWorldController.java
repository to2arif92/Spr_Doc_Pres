package pkg.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ArIF on 11-Apr-17.
 */
@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public String hello (Model model){
        model.addAttribute("greeting", "Hello Someone");
        //
        return "helloWorld";
    }

}
