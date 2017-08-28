package pl.ciupa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ciupa.Entity.Blogers;
import pl.ciupa.Entity.Post;
import pl.ciupa.Forms.CreatePostForm;
import pl.ciupa.Forms.RegisterForm;
import pl.ciupa.Service.NotificationService;
import pl.ciupa.Service.PostService;
import pl.ciupa.Service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kamil on 2017-08-22.
 */
@Controller
public class BlogerControllers {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("users/viewAll")
    public String  view(Model model){
        List<Blogers> blogers = userService.findAll();

        model.addAttribute("bloggers",blogers);
        return "users/viewAll";
    }
/*
    @RequestMapping("users/register")
    public String createPage(){
        return "users/register";
    }

    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public String create(@Valid RegisterForm registerForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            notificationService.addErrorMessage("Error");
            return "post/create";
        }

        String username = registerForm.getUsername();
        String fullname = registerForm.getFullname();
        Blogers blogers = new Blogers(username, fullname);
        userService.create(blogers);
        return "users/viewAll";
    }*/

    }

