package thesidedepot.app.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.support.design.widget.Snackbar;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import thesidedepot.app.R;
import thesidedepot.app.model.Model;
import thesidedepot.app.model.User;

public class LoginActivity extends AppCompatActivity {
    Model model = Model.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText email, pass;
        CardView login;
        TextView signup;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);
        signup = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snack = Snackbar.make(findViewById(R.id.loginScreen), "logging you in...", Snackbar.LENGTH_LONG);
                System.out.println("logged in");
                snack.show();
                if (isEmailValid(email.getText().toString()) && model.logIn(email.getText().toString(), pass.getText().toString())) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    snack = Snackbar.make(findViewById(R.id.loginScreen), "Something went wrong!", Snackbar.LENGTH_LONG);
                    snack.show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snack = Snackbar.make(findViewById(R.id.loginScreen), "signing you up...", Snackbar.LENGTH_LONG);
                System.out.println("signed up");
                snack.show();
                if (isEmailValid(email.getText().toString()) && model.signUp(email.getText().toString(), pass.getText().toString())) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    snack = Snackbar.make(findViewById(R.id.loginScreen), "Something went wrong!", Snackbar.LENGTH_LONG);
                    snack.show();
                }
            }
        });

    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
