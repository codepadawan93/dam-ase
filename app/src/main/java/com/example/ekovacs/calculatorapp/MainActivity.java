package com.example.ekovacs.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private DecimalFormat decimalFormat;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private EditText inputBox;
    private TextView resultBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decimalFormat = new DecimalFormat("#.##########");
        setContentView(R.layout.activity_main);
        inputBox = findViewById(R.id.editText);
        resultBox = findViewById(R.id.infoTextView);
    }

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            try {
                String floatToParse = inputBox.getText().toString();
                if (!"".equals(floatToParse)){
                    valueTwo = Double.parseDouble(floatToParse);
                    inputBox.setText(null);

                    if (CURRENT_ACTION == ADDITION)
                        valueOne = this.valueOne + valueTwo;
                    else if (CURRENT_ACTION == SUBTRACTION)
                        valueOne = this.valueOne - valueTwo;
                    else if (CURRENT_ACTION == MULTIPLICATION)
                        valueOne = this.valueOne * valueTwo;
                    else if (CURRENT_ACTION == DIVISION)
                        valueOne = this.valueOne / valueTwo;
                    }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
                valueOne = Double.parseDouble(inputBox.getText().toString());
            }
            catch (Exception e){
               e.printStackTrace();
            }
        }
        resultBox.setText(decimalFormat.format(valueOne));
    }

    public void setOperation(char operation){
        this.CURRENT_ACTION = operation;
    }

    public void setOperand(String operand) {
        inputBox.setText(inputBox.getText() + operand);
    }

    public void onClickButtonOne(View v)
    {
        setOperand("1");
    }

    public void onClickButtonTwo(View v)
    {
        setOperand("2");
    }

    public void onClickButtonThree(View v)
    {
        setOperand("3");
    }

    public void onClickButtonFour(View v)
    {
        setOperand("4");
    }

    public void onClickButtonFive(View v)
    {
        setOperand("5");
    }

    public void onClickButtonSix(View v)
    {
        setOperand("6");
    }

    public void onClickButtonSeven(View v)
    {
        setOperand("7");
    }

    public void onClickButtonEight(View v)
    {
        setOperand("8");
    }

    public void onClickButtonNine(View v)
    {
        setOperand("9");
    }

    public void onClickButtonZero(View v)
    {
        setOperand("0");
    }

    public void onClickButtonAdd(View v)
    {
        computeCalculation();
        setOperation(ADDITION);
        resultBox.setText(decimalFormat.format(valueOne) + " " + ADDITION);
        inputBox.setText(null);
    }

    public void onClickButtonSubtract(View v)
    {
        computeCalculation();
        setOperation(SUBTRACTION);
        resultBox.setText(decimalFormat.format(valueOne) + " " + SUBTRACTION);
        inputBox.setText(null);
    }

    public void onClickButtonMultiply(View v)
    {
        computeCalculation();
        setOperation(MULTIPLICATION);
        resultBox.setText(decimalFormat.format(valueOne) + " " + MULTIPLICATION);
        inputBox.setText(null);
    }

    public void onClickButtonDivide(View v)
    {
        computeCalculation();
        setOperation(DIVISION);
        resultBox.setText(decimalFormat.format(valueOne) + " " + DIVISION);
        inputBox.setText(null);
    }

    public void onClickButtonEquals(View v)
    {
        computeCalculation();
    }

    public void onClickButtonClear(View v)
    {
       inputBox.setText(null);
       resultBox.setText(null);
       valueOne = Double.NaN;
       valueTwo = 0.0;
    }

    public void onClickButtonDot(View v) {
        inputBox.setText(inputBox.getText().toString().replace(".",""));
        setOperand(".");
    }
}
