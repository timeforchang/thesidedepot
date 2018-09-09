package thesidedepot.app.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import thesidedepot.app.R;
import thesidedepot.app.model.Build;
import thesidedepot.app.model.Model;
import thesidedepot.app.model.Project;

public class ProjectActivity extends AppCompatActivity {
    Model model;
    private ListView lv;
    ArrayList<Build> builds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        model = Model.getInstance();

        lv = (ListView) findViewById(R.id.projectList);

        List<String> buildnames = new ArrayList<String>();
        builds = new ArrayList<Build>();

        for (Build b : builds) {
            buildnames.add(b.get_name());
        }

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                buildnames);

        lv.setAdapter(arrayAdapter);

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
                model.setBuildList(builds);
                Intent intent = new Intent(ProjectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
