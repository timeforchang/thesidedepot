package thesidedepot.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.support.design.widget.Snackbar;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText email, pass;
        CardView login;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snack = Snackbar.make(findViewById(), "logging you in...", Snackbar.LENGTH_LONG);
                System.out.println("logged in");
                snack.show();
                loginUser(loginEmail.getText().toString(), loginPass.getText().toString());
            }
        });
    }
}
