package pl.ciupa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ciupa.Entity.Blogers;
import pl.ciupa.Forms.LoginForm;
import pl.ciupa.Forms.RegisterForm;
import pl.ciupa.Service.NotificationService;
import pl.ciupa.Service.UserService;

import javax.validation.Valid;

/**
 * Created by Kamil on 2017-08-23.
 */

@Controller
public class RegisterController {


    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;



    @RequestMapping("users/register")
    public String register(RegisterForm registerForm) {
        return "users/register";
    }

    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Error");
            return "users/register";
        }

        String a = registerForm.getUsername();
        String b= registerForm.getFullname();
        Blogers blogers = new Blogers(a,b);
        userService.create(blogers);
        notifyService.addInfoMessage("Succes");
        return "redirect:/";

    }
}
