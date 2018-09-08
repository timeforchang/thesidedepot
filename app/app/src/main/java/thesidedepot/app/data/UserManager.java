package thesidedepot.app.data;

import java.util.ArrayList;

import thesidedepot.app.model.Build;
import thesidedepot.app.model.User;

public class UserManager {
    User curUser;

    @SuppressWarnings("ConstantConditions")
    public User getData() {
        return curUser;
    }

    public void setUser(User curUser) {
        this.curUser = curUser;
    }

    public boolean logInUser(String email, String pass) {
        User newUser = new User(email, pass, true, new ArrayList<Build>());
        setUser(newUser);
        return true;
    }

    public boolean registerUser(String email, String pass) {
        User newUser = new User(email, pass, true, new ArrayList<Build>());
        setUser(newUser);
        return true;
    }
}
