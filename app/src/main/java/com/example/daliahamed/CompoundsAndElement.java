package com.example.daliahamed;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompoundsAndElement extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compounds);

        textView1 = findViewById(R.id.txtelemid);
        textView2 = findViewById(R.id.txtcomp2id);
        textView3 = findViewById(R.id.txt3solid);
        button1 = findViewById(R.id.btnelementid);
        button2 = findViewById(R.id.btncoid);
        button3 = findViewById(R.id.btnmid3);

        // Initially hide all TextViews
        textView1.setVisibility(View.GONE);
        textView2.setVisibility(View.GONE);
        textView3.setVisibility(View.GONE);

        // Set click listeners for buttons
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.GONE);
                textView3.setVisibility(View.GONE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setVisibility(View.GONE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.GONE);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setVisibility(View.GONE);
                textView2.setVisibility(View.GONE);
                textView3.setVisibility(View.VISIBLE);
            }
        });
    }
}
