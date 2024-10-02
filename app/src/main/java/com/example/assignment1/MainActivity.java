package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;



import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText principalamt, interestamt, tenureamt;
    private TextView emiamt;
    private Button calculatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        principalamt = findViewById(R.id.principalEditText);
        interestamt = findViewById(R.id.interestRateEditText);
        tenureamt = findViewById(R.id.tenureEditText);
        emiamt = findViewById(R.id.resultingerror);
        calculatebtn = findViewById(R.id.calculateButton);

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateEMI();
            }
        });
    }

    private void calculateEMI() {
        String principalstring = principalamt.getText().toString();
        String interestRatestring = interestamt.getText().toString();
        String tenurestring = tenureamt.getText().toString();

        if (principalstring.isEmpty() || interestRatestring.isEmpty() || tenurestring.isEmpty()) {
            emiamt.setText("You have not filled in every category");
            emiamt.setVisibility(View.VISIBLE);
            return;
        }

        double P = Double.parseDouble(principalstring);
        double AIR = Double.parseDouble(interestRatestring);
        int n = Integer.parseInt(tenurestring);
        n = n * 12;
        double r = (AIR / 100) / 12;
        double E = (P * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        String formattedemi = String.format("%.2f", E);
        String finalEMI = "$ " + formattedemi;

        Intent intent = new Intent(MainActivity.this, EMI_Result.class);
        intent.putExtra("EMI_RESULT", finalEMI);
        startActivity(intent);
        finish();


    }

}