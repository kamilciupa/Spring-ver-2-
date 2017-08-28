package pl.ciupa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ciupa.Forms.LoginForm;
import pl.ciupa.Service.NotificationService;
import pl.ciupa.Service.UserService;

import javax.validation.Valid;

/**
 * Created by Kamil on 2017-08-23.
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("users/login")
    public String login(LoginForm loginForm){
        return "users/login";
    }

    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            notifyService.addErrorMessage("Error");
            return "users/login";
        }
//        if(!userService.authenticate(
//                loginForm.getUsername(), loginForm.getPassword())){
//            notifyService.addErrorMessage("Invalid login or pass");
//            return "users/login";
//        }

        notifyService.addInfoMessage("Succes");
        return "redirect:/";



    }

}
