package com.example.daliahamed;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MolarMassActivity extends AppCompatActivity {
    private EditText editTextCompound;
    private Button buttonCalculate;
    private TextView textViewResult;
    private Button buttonSave;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_molar_mass);

        // Initialize views
        editTextCompound = findViewById(R.id.txtEnterid);
        buttonCalculate = findViewById(R.id.btncalculate);
        textViewResult = findViewById(R.id.txtresid);
        buttonSave = findViewById(R.id.btnsaveid);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Calculate button click listener
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMolarMass();
            }
        });

        // Save button click listener
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMolarMass();
            }
        });
    }

    private void calculateMolarMass() {
        String compound = editTextCompound.getText().toString().trim();
        // Perform molar mass calculation
        // You can implement the molar mass calculation logic here
        // For example:
        double molarMass = calculateMolarMassForCompound(compound);
        // Display the result
        textViewResult.setText("Molar Mass: " + molarMass);
    }

    private double calculateMolarMassForCompound(String compound) {
        // Initialize variables to store atomic symbols and their corresponding masses
        HashMap<String, Double> atomicMasses = new HashMap<>();
        atomicMasses.put("H", 1.008);
        atomicMasses.put("He", 4.0026);
        atomicMasses.put("Li", 6.94);
        atomicMasses.put("Be", 9.0122);
        atomicMasses.put("B", 10.81);
        atomicMasses.put("C", 12.01);
        atomicMasses.put("N", 14.01);
        atomicMasses.put("O", 16.00);
        atomicMasses.put("F", 19.00);
        atomicMasses.put("Ne", 20.1797);
        atomicMasses.put("Na", 22.9898);
        atomicMasses.put("Mg", 24.305);
        atomicMasses.put("Al", 26.9815);
        atomicMasses.put("Si", 28.0855);
        atomicMasses.put("P", 30.9738);
        atomicMasses.put("S", 32.06);
        atomicMasses.put("Cl", 35.45);
        atomicMasses.put("Ar", 39.948);
        atomicMasses.put("K", 39.0983);
        atomicMasses.put("Ca", 40.078);

        // Add more atomic masses as needed for other elements

        double molarMass = 0.0;
        int i = 0;
        while (i < compound.length()) {
            char currentChar = compound.charAt(i);
            double currentMass = 0.0;

            // Check if the current character is an element symbol
            if (Character.isLetter(currentChar)) {
                // Get the atomic mass for the current element
                String element = String.valueOf(currentChar);
                currentMass = atomicMasses.getOrDefault(element, 0.0);

                // Check if there is a numeric multiplier after the element symbol
                if (i + 1 < compound.length() && Character.isDigit(compound.charAt(i + 1))) {
                    // Calculate the multiplier
                    int multiplier = 0;
                    while (i + 1 < compound.length() && Character.isDigit(compound.charAt(i + 1))) {
                        multiplier = multiplier * 10 + (compound.charAt(i + 1) - '0');
                        i++;
                    }
                    if (multiplier == 0) {
                        multiplier = 1; // If no digit is found after the element symbol, consider it as 1
                    }
                    // Multiply the atomic mass by the multiplier
                    currentMass *= multiplier;
                }
                // Add the current mass to the total molar mass
                molarMass += currentMass;
            }
            i++;
        }
        return molarMass;
    }


    private void saveMolarMass() {
        String molarMassString = textViewResult.getText().toString();
        // Save the molar mass to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("molar_mass", molarMassString);
        editor.apply();



        Toast.makeText(this, "Molar Mass saved", Toast.LENGTH_SHORT).show();
    }




}
