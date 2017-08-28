package pl.ciupa.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Kamil on 2017-08-28.
 */
public class CreatePostForm {

    @Size(min=5, max=30, message = "title should have 5-30 characters")
    private String title;



    @Size(min = 5, max = 350)
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
