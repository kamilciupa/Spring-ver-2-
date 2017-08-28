package pl.ciupa.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Kamil on 2017-08-23.
 */
public class RegisterForm {

    @Size(min=5, max=30, message = "Username should have 5-30 characters")
    private String username;

    @NotNull
    @Size(min = 5, max = 50)
    private String password;

    @Size(min = 5, max = 30, message = "Fullname should have at least 5 characters")
    private String fullname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
