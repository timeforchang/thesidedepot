package thesidedepot.app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import thesidedepot.app.R;
import thesidedepot.app.model.Build;
import thesidedepot.app.model.Model;

public class HowToActivity extends Activity {
    GridView materials;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);

        model = Model.getInstance();

        Intent i = getIntent();
        Build curBuild = (Build) i.getSerializableExtra("curBuild");

        String[] materialList = new String[curBuild.getMaterials().size()];

        materialList = (String[]) curBuild.getMaterials().toArray();

        materials = (GridView) findViewById(R.id.materials);

        GridAdapter gridAdapter = new GridAdapter(this, materialList);
        materials.setAdapter(gridAdapter);
    }
}
