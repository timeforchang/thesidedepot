package thesidedepot.app.model;

import thesidedepot.app.data.UserManager;

public class Model {
    private static Model _instance;
    final private UserManager um;

    private Model() {
        um = new UserManager();
    }

    public static synchronized Model getInstance() {
        if (_instance == null) {
            _instance = new Model();
        }
        return _instance;
    }

    public User getUser() {
        return um.getData();
    }

    public void setUser(User user) {
        um.setUser(user);
    }

    public boolean logIn(String email, String pass) {
        return um.logInUser(email, pass);
    }

    public boolean signUp(String email, String pass) {
        return um.registerUser(email, pass);
    }
}
