package pkg.spring.basic.controller;

/**
 * Created by ArIF on 14-Apr-17.
 */
import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pkg.spring.basic.model.auth.User;
import pkg.spring.basic.service.UserService;

@Controller
public class MainController {

    /*@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }*/

    @Autowired
    private Logger logger;

    /* Default controller */
    @RequestMapping("/*")
    public String index(Model model)
    {
        logger.trace("Redirecting to Root path");
        //return "index";
        return "loginPage"; //default page for now
    }


    /* Controllers below coordinates with Spring Security (WebSecurityConfig) */

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        return "products";
    }

    @GetMapping("/login")
    public String loginPage(Model model ) {
        return "loginPage";
        //return "index";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        logger.info("Log Out successful thus Redirecting");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // After user login successfully.
        //String userName = principal.getName();
        logger.info(principal.getName()+" with User Privilege is redirected to loginAfter URL");
        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            logger.warn("Insufficient Permission! Redirecting");
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            logger.warn("Access denied! Authorise first! Redirecting");
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "403Page";
    }





}