package thesidedepot.app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
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

        link = (TextView) findViewById(R.id.link);
        link.setText(cur.getWebCollection().get(cur.getWebCollection().size() - 1));
    }
}
