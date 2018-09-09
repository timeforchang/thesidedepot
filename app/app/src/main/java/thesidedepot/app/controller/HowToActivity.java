package thesidedepot.app.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
<<<<<<< HEAD
import android.view.View;
import android.widget.Button;
=======
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
>>>>>>> 5a9b29de60ad8178b2935ab51a06f278f1c43e0c
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import thesidedepot.app.R;
import thesidedepot.app.model.Build;
import thesidedepot.app.model.Model;
import thesidedepot.app.model.Project;

public class HowToActivity extends AppCompatActivity {
    GridView materials;
    Model model;
    TextView desc, time, diff, link;
    ListView lv;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);

        Project cur = MainActivity.myProjectList.get(0);
        cur = MainActivity.projectList.get(cur.getTitle());

        Toolbar toolbar = (Toolbar) findViewById(R.id.howtoToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(cur.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        image = (ImageView) findViewById(R.id.howto_image);
        Picasso.get().load(cur.getImage()).into(image);

        desc = (TextView) findViewById(R.id.desc);
        desc.setText(cur.getDescription());

        time = (TextView) findViewById(R.id.totProjTime);
        time.setText(cur.getTime());

        diff = (TextView) findViewById(R.id.diff);
        diff.setText(cur.getDifficulty());

<<<<<<< HEAD
        String[] materialList = new String[cur.getToolsAndMaterials().size()];

        materialList = (String[]) cur.getToolsAndMaterials().toArray(materialList);

        materials = (GridView) findViewById(R.id.materials);

        GridAdapter gridAdapter = new GridAdapter(this, materialList);
        materials.setAdapter(gridAdapter);

        Button completionButton = (Button) findViewById(R.id.completionButton);

        completionButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);

        builder.setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

=======
        link = (TextView) findViewById(R.id.link);
        link.setText(cur.getWebCollection().get(cur.getWebCollection().size() - 1));
>>>>>>> 5a9b29de60ad8178b2935ab51a06f278f1c43e0c
    }
}
