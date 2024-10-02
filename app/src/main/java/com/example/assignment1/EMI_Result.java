package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EMI_Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_result);

        TextView resultTextView = findViewById(R.id.resultinganswer);
        Button resetButton = findViewById(R.id.resetButton);
        String emiResult = getIntent().getStringExtra("EMI_RESULT");
        resultTextView.setText(emiResult);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EMI_Result.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
