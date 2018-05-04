package pkg.spring.basic.validator;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pkg.spring.basic.dto.RegistrationForm;
import pkg.spring.basic.model.auth.User;
import pkg.spring.basic.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Autowired
    Logger logger;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == RegistrationForm.class;
    }

    @Override
    public void validate(Object o, Errors errors) {

        logger.debug("Validating registration form");

        RegistrationForm form = (RegistrationForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Username is required !");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password is required !");

        if (errors.hasErrors()){
            return;
        }

        /*if (!emailValidator.isValid(form.getEmail())) {

            errors.rejectValue("email", "", "Email is not valid");
            return;
        }*/

        User user = null;

        try {
            user = userService.findUserByUsername(form.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null){
            if (form.getId() == null){
                errors.rejectValue("userName", "", "Username is not available");
                return;
            } else if (!form.getId().equals(user.getId())){
                errors.rejectValue("userName", "", "Username is not available");
                return;
            }
        }

    }
}
