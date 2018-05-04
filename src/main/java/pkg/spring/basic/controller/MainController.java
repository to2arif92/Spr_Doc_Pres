package pkg.spring.basic.controller;

/**
 * Created by ArIF on 14-Apr-17.
 */

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pkg.spring.basic.dto.RegistrationForm;
import pkg.spring.basic.model.auth.User;
import pkg.spring.basic.security.SecurityUtil;
import pkg.spring.basic.service.UserService;

import java.security.Principal;

@Controller
@EnableWebMvc
public class MainController {

    /*@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }*/
    private final String loginPage = "loginPage";
    private final String signupPage = "signup";

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

    // User login via Social,
    // but not allow access basic info.
    // webapp will redirect to /signin.
    @RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
    public String signInPage(Model model) {
        return "redirect:/login";
    }

    @Autowired
    ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    UsersConnectionRepository connectionRepository;

    @Autowired
    UserService userService;

    /**
     * Renders the registration page.
     */
    @GetMapping("/signup")
    public String showRegistrationForm(WebRequest request, Model model){
        logger.debug("Rendering registration page");

        ProviderSignInUtils providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);

        RegistrationForm form;
        if (connection != null){
            form = new RegistrationForm(connection);
        } else {
            form = new RegistrationForm();
        }
        logger.debug("Rendering registration form with: {}", form);

        model.addAttribute("userForm", form);
        return signupPage;
    }

    /**
     * Processes the form submissions of the registration form.
     */
    @PostMapping("/signup")
    public String registerUser(WebRequest request, Model model,
                               @ModelAttribute("userForm") @Validated RegistrationForm form,
                               BindingResult result, final RedirectAttributes redirectAttributes){

        logger.debug("Registering user with data: {}", form);
        if (result.hasErrors()){
            logger.debug("Validation error! Redirecting form view");
            return signupPage;
        }

        logger.debug("No validation error found. Continuing registration process.");

        try{
            userService.registerNewUser(form);
        } catch (Exception e){
            logger.error("Unable to register!");
            model.addAttribute("errorMessage", "Error "+e.getMessage());
            return signupPage;
        }

        User registered = userService.findUserByUsername(form.getUserName());
        if (form.getSignInProvider() != null) {
            ProviderSignInUtils providerSignInUtils //
                    = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);

            // If the user is signing in by using a social provider, this method
            // call stores the connection to the UserConnection table.
            // Otherwise, this method does not do anything.
            providerSignInUtils.doPostSignUp(registered.getId(), request);
        }
        // After register, Logs the user in.
        SecurityUtil.logInUser(registered);

        return "redirect:/userInfo";
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