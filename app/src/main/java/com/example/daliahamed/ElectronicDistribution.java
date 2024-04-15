package com.example.daliahamed;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ElectronicDistribution extends AppCompatActivity {
    private EditText txtName;
    private EditText txtNum;
    private Button btnShow;
    private TextView txtAns;
    private Button btnClear;
    private Button btnMolarMAss;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic);

        txtName = findViewById(R.id.txtnameid);
        txtNum = findViewById(R.id.txtnumid);
        btnShow = findViewById(R.id.btnshow);
        txtAns = findViewById(R.id.txtansid);
        btnClear = findViewById(R.id.btnclearid);
        sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        btnMolarMAss = findViewById(R.id.btnMassid);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                int atomicNum = Integer.parseInt(txtNum.getText().toString());

                // Calculate electronic distribution
                String electronicDistribution = calculateElectronicDistribution(atomicNum);

                // Display electronic distribution
                txtAns.setText(electronicDistribution);

                // Save entered data to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("element_name", name);
                editor.putInt("atomic_number", atomicNum);
                editor.apply();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName.setText("");
                txtNum.setText("");
                txtAns.setText("");

                // Clear SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
            }
        });

        // Restore data from SharedPreferences
        String savedName = sharedPreferences.getString("element_name", "");
        int savedAtomicNum = sharedPreferences.getInt("atomic_number", 0);
        txtName.setText(savedName);
        txtNum.setText(String.valueOf(savedAtomicNum));

        btnMolarMAss.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent4 = new Intent(ElectronicDistribution.this, MolarMassActivity.class);
                // Start the new activity
                startActivity(intent4);
            }
        });
    }


    private String calculateElectronicDistribution(int atomicNum) {
        StringBuilder distribution = new StringBuilder();

        // Iterate through electron shells
        int electronsRemaining = atomicNum;
        int shellNumber = 1;
        while (electronsRemaining > 0) {
            // Calculate maximum number of electrons in current shell
            int maxElectrons = 2 * shellNumber * shellNumber;

            // Determine number of electrons to fill in current shell
            int electronsInShell = Math.min(electronsRemaining, maxElectrons);

            // Append electrons in current shell to distribution string
            distribution.append("Shell ").append(shellNumber).append(": ").append(electronsInShell).append(" electrons\n");

            // Update remaining electrons
            electronsRemaining -= electronsInShell;

            // Move to next shell
            shellNumber++;
        }

        return distribution.toString();
    }


}
