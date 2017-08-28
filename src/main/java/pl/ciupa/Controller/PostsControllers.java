package pl.ciupa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ciupa.Entity.Post;
import pl.ciupa.Forms.CreatePostForm;
import pl.ciupa.Service.NotificationService;
import pl.ciupa.Service.PostService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kamil on 2017-08-22.
 */
@Controller
public class PostsControllers {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("posts/view/{id}")
    public String  view(@PathVariable("id") Long id, Model model){
        Post post = postService.findById(id);
        if(post == null){
            notificationService.addErrorMessage("Cannot find post " + id);;
            return "redirect:/";
        }
        model.addAttribute(post);
        return "posts/view";

    }


    /*

     */

    @RequestMapping("posts/viewAll")
    public String viewAll(Model model){
       List<Post> allPosts = postService.findAll();
       if(allPosts.isEmpty()) {
           notificationService.addErrorMessage("You have no entries");
           return "redirect:/";
       }
       //for(Post post : allPosts) {
           model.addAttribute("allPosts",allPosts);
       //}
       return "posts/viewAll";
       }

       @RequestMapping("posts/create")
       public String createPostPage(CreatePostForm createPostForm){
        return "posts/create";
       }

       @RequestMapping(value = "posts/create", method = RequestMethod.POST)
        public String createPost(@Valid CreatePostForm createPostForm, BindingResult bindingResult){
           if(bindingResult.hasErrors()){
               notificationService.addErrorMessage("Error");
               return "post/create";
           }
           String title = createPostForm.getTitle();
           String body = createPostForm.getBody();
           Post post = new Post(title, body, null);
           post = postService.create(post);
           return "posts/viewAll";
       }

       @RequestMapping(value = "posts/view/{id}/delete")
       public String  delete(@PathVariable("id") Long id, Model model){
            Post post = postService.findById(id);
            if(post == null){
                notificationService.addErrorMessage("Cannot find post " + id);;
                return "redirect:/";
            }
            postService.deleteById(id);
            return "posts/viewAll";
       }
    }

