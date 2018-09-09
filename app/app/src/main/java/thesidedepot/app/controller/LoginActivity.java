package thesidedepot.app.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.support.design.widget.Snackbar;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.util.ArrayList;
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
                if (isEmailValid(email.getText().toString())) {
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
                if (isEmailValid(email.getText().toString())) {
                    //String[] params = {email.getText().toString(), pass.getText().toString()};
                    //new createUserTask().execute(params);
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

    private class createUserTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            return createUser(strings);
        }

//        @Override
//        protected void onPostExecute(String s) {
//            final Toast toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
//            toast.show();
//            Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    toast.cancel();
//                }
//            }, 500);
//        }
    }

    public static boolean createUser(String[] params) {
        MongoClientURI connectionString = new MongoClientURI("mongodb+srv://admin:siderift@cluster0-1jnpy.mongodb.net/test?retryWrites=true");
        MongoClient mongoClient = new MongoClient(connectionString);
        DB database = mongoClient.getDB("database");
        DBCollection collection = database.getCollection("userNewA");
        BasicDBObject queryObj = new BasicDBObject();
        queryObj.put("username", params[0]);
        DBCursor results = collection.find(queryObj);


        if (results.size() == 0) {
            BasicDBObject document = new BasicDBObject();
            document.put("username", params[0]);
            document.put("password", params[1]);
            document.put("badges", new ArrayList<String>());
            document.put("projects", new ArrayList<String>());
            document.put("firstLogin", true);
            collection.insert(document);
            System.out.println("user made");
            return true;
        } else {
            System.out.println("user exists");
            while(results.hasNext()) {
                System.out.println(results.next());
            }
            return false;
        }
    }

    public static boolean loginUser(String username, String password) {
        MongoClientURI connectionString = new MongoClientURI("mongodb+srv://admin:siderift@cluster0-1jnpy.mongodb.net/test?retryWrites=true");
        MongoClient mongoClient = new MongoClient(connectionString);
        DB database = mongoClient.getDB("database");
        DBCollection collection = database.getCollection("userNewA");
        BasicDBObject queryObj = new BasicDBObject();
        queryObj.put("username", username);
        DBCursor results = collection.find(queryObj);

        if (results.size() == 0) {
            System.out.println("User does not exist");
            return false;
        } else {
            while(results.hasNext()) {

                BasicDBObject currDoc = (BasicDBObject) results.next();

                if (password.equals(currDoc.get("password"))) {
                    System.out.println("valid login");

                    //Set first login to FALSE
                    if ((boolean) (currDoc.get("firstLogin"))) {
                        System.out.println("firstLogin is true");

                        BasicDBObject newDocument = new BasicDBObject();
                        newDocument.put("firstLogin", false);

                        BasicDBObject updateObject = new BasicDBObject();
                        updateObject.put("$set", newDocument);

                        collection.update(queryObj, updateObject);

                        return true;

                    } else {
                        System.out.println("firstLogin is false");
                        return true;
                    }
                } else {
                    System.out.println("bad password");
                    return false;
                }
            }

            return false;
        }
    }
}
