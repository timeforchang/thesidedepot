package thesidedepot.app.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import thesidedepot.app.R;
import thesidedepot.app.model.Project;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        Button back_button = (Button) findViewById(R.id.back_button);

        back_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button confirm_button = (Button) findViewById(R.id.button_confirm);

        confirm_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
