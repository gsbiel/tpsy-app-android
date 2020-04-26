package com.example.tipsy_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button recalculateBtn;
    TextView resultLabel;
    TextView infoLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


    }

    private void catchReferencesFromLayout(){
        this.recalculateBtn = findViewById(R.id.recalculateBtn);
        this.resultLabel = findViewById(R.id.resultLabel);
        this.infoLabel = findViewById(R.id.infoLabel);
    }
}
