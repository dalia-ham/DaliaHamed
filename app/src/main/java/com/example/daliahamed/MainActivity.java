package com.example.daliahamed;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1id);
        btn2 = findViewById(R.id.btn2id);
        btn3 = findViewById(R.id.btn3id);

        // Set onClickListener for the button
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(MainActivity.this, ChemicalActivity.class);
                // Start the new activity
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent2 = new Intent(MainActivity.this, CompoundsAndElement.class);
                // Start the new activity
                startActivity(intent2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent3 = new Intent(MainActivity.this,ElectronicDistribution.class);
                // Start the new activity
                startActivity(intent3);
            }
        });




    }
}
