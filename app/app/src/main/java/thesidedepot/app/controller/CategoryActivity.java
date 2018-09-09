package thesidedepot.app.controller;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import thesidedepot.app.R;
import thesidedepot.app.model.Project;

public class CategoryActivity extends AppCompatActivity {

    ListView myList;
    Button makePlan;
    Button back_button;

    String[] listContent = {
            //"Home Renovation", "Home Maintenance", "Garden & Outdoor", "DIY, Decor, & Fun"
            "", "", "", ""
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        myList = (ListView)findViewById(R.id.list);

        makePlan = (Button)findViewById(R.id.getchoice);

        back_button = (Button) findViewById(R.id.back_button);

        back_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                listContent) {
            int count = 0;
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the current item from ListView
                View view = super.getView(position,convertView,parent);

                // Get the Layout Parameters for ListView Current Item View
                ViewGroup.LayoutParams params = view.getLayoutParams();

                // Set the height of the Item View
                count+= 20;
                params.height = 300 + count;
                view.setLayoutParams(params);

                return view;
            }
        };

        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        myList.setAdapter(adapter);



        makePlan.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub

                String selected = "";
                int cntChoice = myList.getCount();
                SparseBooleanArray sparseBooleanArray = myList.getCheckedItemPositions();
                for (int i = 0; i < cntChoice; i++) {
                    if (sparseBooleanArray.get(i)) {
                        selected += myList.getItemAtPosition(i).toString() + "\n";
                    }

                }
                Intent intent = new Intent(CategoryActivity.this, ProjectActivity.class);
                startActivity(intent);
            }
        });


    }

}
