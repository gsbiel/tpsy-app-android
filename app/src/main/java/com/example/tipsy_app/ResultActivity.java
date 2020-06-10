package com.example.tipsy_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

//    private static DecimalFormat df = new DecimalFormat("0.00");
//
//    Button recalculateBtn;
//    TextView resultLabel;
//    TextView infoLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        this.catchReferencesFromLayout();
//        this.registerForUIEvents();
//        this.updateUI();
    }

//    private void catchReferencesFromLayout(){
//        this.recalculateBtn = findViewById(R.id.recalculateBtn);
//        this.resultLabel = findViewById(R.id.resultLabel);
//        this.infoLabel = findViewById(R.id.infoLabel);
//    }
//
//    private void registerForUIEvents(){
//        this.recalculateBtn.setOnClickListener(this);
//    }
//
//    private void updateUI(){
//        Bundle intentExtras = getIntent().getExtras();
//        int numberOfPersons = intentExtras.getInt(MainActivity.stepperValueId);
//        int tipValue = intentExtras.getInt(MainActivity.tipValueId);
//        double result = intentExtras.getDouble(MainActivity.resultId);
//
//        this.resultLabel.setText(df.format(result));
//        this.infoLabel.setText("Split between " + numberOfPersons + " people, with " + tipValue + "% tip.");
//    }
//
//    @Override
//    public void onClick(View v) {
//        if(R.id.recalculateBtn == v.getId()){
//            finish();
//        }
//    }
}
