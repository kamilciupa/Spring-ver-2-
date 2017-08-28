package pl.ciupa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.ciupa.Entity.Post;
import pl.ciupa.Service.PostService;

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
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);
        List<Post> latest3Posts = latest5Posts.stream()
                .limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        return "index";
    }
}


