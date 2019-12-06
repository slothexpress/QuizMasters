package QuizMasterAcademy3000;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (user.getName() == null || user.getName().equals("")) {
            errors.rejectValue("name", "name.empty");
        }

        if (user.getEmail() == null || user.getEmail().equals("")) {
            errors.rejectValue("email", "email.empty");

        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            errors.rejectValue("password", "password.empty");

        }
    }
}
