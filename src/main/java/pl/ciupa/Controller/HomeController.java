package pl.ciupa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.ciupa.Entity.Post;
import pl.ciupa.Service.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kamil on 2017-08-22.
 */

@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Post> latest5Posts = postService.findAll();
        List<Post> l5 = new ArrayList<>();
        for(int i = 0; i < 5 ; i++ ){
            l5.add(latest5Posts.get(latest5Posts.size()-1-i));
        }

        model.addAttribute("latest5posts", l5);
        List<Post> latest3Posts =new ArrayList<>();
        for(int i = 0 ; i < 3 ; i++){
            latest3Posts.add(l5.get(i));
        }
        model.addAttribute("latest3posts", latest3Posts);
        return "index";
    }
}


