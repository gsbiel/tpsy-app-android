package com.example.tipsy_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    private Button zeroTipBtn;
    private Button tenTipBtn;
    private Button twentyTipBtn;
    private Button plusStepBtn;
    private Button lessStepBtn;
    private Button calculateBtn;

    private EditText textField;
    private TextView stepperLabel;

    private int stepperValue = 0;

    private int currentTip = 0;

    private Button currentTipBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.catchReferencesFromLayout();
        this.registerForEvents();

        this.currentTipBtn = this.zeroTipBtn;

        this.updateUI();
    }

    private void catchReferencesFromLayout(){
        this.zeroTipBtn = findViewById(R.id.zeroTip);
        this.tenTipBtn = findViewById(R.id.tenTip);
        this.twentyTipBtn = findViewById(R.id.twentyTip);
        this.plusStepBtn = findViewById(R.id.stepper_plus_button);
        this.lessStepBtn = findViewById(R.id.stepper_less_button);
        this.calculateBtn = findViewById(R.id.calculateBtn);
        this.textField = findViewById(R.id.textField);
        this.stepperLabel = findViewById(R.id.stepper_label);
    }

    private void registerForEvents(){

        // Button events
        this.zeroTipBtn.setOnClickListener(this);
        this.tenTipBtn.setOnClickListener(this);
        this.twentyTipBtn.setOnClickListener(this);
        this.plusStepBtn.setOnClickListener(this);
        this.lessStepBtn.setOnClickListener(this);
        this.calculateBtn.setOnClickListener(this);
    }

    private void updateUI(){

        this.zeroTipBtn.setBackgroundColor(Color.rgb(226,251,243));
        this.zeroTipBtn.setTextColor(Color.rgb(73,181,131));
        this.tenTipBtn.setBackgroundColor(Color.rgb(226,251,243));
        this.tenTipBtn.setTextColor(Color.rgb(73,181,131));
        this.twentyTipBtn.setBackgroundColor(Color.rgb(226,251,243));
        this.twentyTipBtn.setTextColor(Color.rgb(73,181,131));

        this.currentTipBtn.setBackgroundColor(Color.rgb(73,181,131));
        this.currentTipBtn.setTextColor(Color.rgb(226,251,243));
        this.stepperLabel.setText("" + this.stepperValue);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zeroTip:
                this.currentTip = 0;
                this.currentTipBtn = this.zeroTipBtn;
                this.updateUI();
                break;
            case R.id.tenTip:
                this.currentTip = 10;
                this.currentTipBtn = this.tenTipBtn;
                this.updateUI();
                break;
            case R.id.twentyTip:
                this.currentTip = 20;
                this.currentTipBtn = this.twentyTipBtn;
                this.updateUI();
                break;
            case R.id.stepper_plus_button:
                this.stepperValue += 1;
                this.updateUI();
                break;
            case R.id.stepper_less_button:
                if(this.stepperValue > 0){
                    this.stepperValue -= 1;
                    this.updateUI();
                }
                break;
            case R.id.calculateBtn:
                break;
        }
    }
}
