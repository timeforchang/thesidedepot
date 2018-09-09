package thesidedepot.app.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import thesidedepot.app.R;
import thesidedepot.app.model.Build;
import thesidedepot.app.model.Model;
import thesidedepot.app.model.Project;

public class HowToActivity extends Activity {
    GridView materials;
    Model model;
    TextView desc, time, diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);

        Project cur = MainActivity.myProjectList.get(0);

        desc = (TextView) findViewById(R.id.desc);
        desc.setText(cur.getDescription());

        time = (TextView) findViewById(R.id.totProjTime);
        time.setText(cur.getTime());

        diff = (TextView) findViewById(R.id.diff);
        diff.setText(cur.getDifficulty());

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

    }
}
