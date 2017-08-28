package pl.ciupa.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Kamil on 2017-08-23.
 */
public class LoginForm {

    @Size(min=5, max=30, message = "Username should have 5-30 characters")
    private String username;

    @NotNull
    @Size(min = 5, max = 50)
    private String password;

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
}
