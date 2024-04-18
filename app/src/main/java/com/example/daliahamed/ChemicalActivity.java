package com.example.daliahamed;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ChemicalActivity extends AppCompatActivity {
    private Spinner spnMenu;
    private Button btnSearch;
    private ListView lstItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical);

        setupViews();
        populateSpinner();

        btnSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DataBase db= new DataBase();
                String cat=spnMenu.getSelectedItem().toString();

                List<Menu> result=db.getMenuItems(cat);
                Menu[] arr= result.toArray(new Menu[result.size()]);
                ArrayAdapter<Menu>adapter=new ArrayAdapter<Menu>(ChemicalActivity.this, android.R.layout.simple_list_item_1,arr);
                lstItems.setAdapter(adapter);


            }
        });


    }

    private void setupViews() {
        spnMenu = findViewById(R.id.spnId);
        btnSearch = findViewById(R.id.btnsearch);
        lstItems = findViewById(R.id.listid1);
    }
    private void populateSpinner() {
        DataBase db=new DataBase();
        String[] symbol= db.getCategories();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, symbol);
        spnMenu.setAdapter(adapter);
    }
}



