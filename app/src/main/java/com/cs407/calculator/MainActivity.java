package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private String numCheck(String firstNum, String secondNum) {

        Pattern numPatten = Pattern.compile("-?[0-9]+\\.?[0-9]*");

        Matcher isNumFirst = numPatten.matcher(firstNum);
        Matcher isNumSecond = numPatten.matcher(secondNum);

        if (!isNumFirst.matches() && !isNumSecond.matches()) {
            return "Both Number inputted are not valid.";
        } else if (!isNumFirst.matches()) {
            return "First Number inputted are not valid.";
        } else if (!isNumSecond.matches()) {
            return "Second Number inputted are not valid.";
        } else {
            return "";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFunction(View view) {
        EditText firstNum = (EditText) findViewById(R.id.firstNumEditText);
        EditText secondNum = (EditText) findViewById(R.id.secondNumEditText);

        String numCheckResult = numCheck(firstNum.getText().toString(), secondNum.getText().toString());

        if (numCheckResult.length() != 0) {
            Toast.makeText(MainActivity.this, numCheckResult, Toast.LENGTH_LONG).show();
        } else {
            displayResult(firstNum.getText().toString() +
                    " + " + secondNum.getText().toString() +
                    " = " + (Double.parseDouble(firstNum.getText().toString()) + Double.parseDouble(secondNum.getText().toString())));
        }

    }

    public void minusFunction(View view) {
        EditText firstNum = (EditText) findViewById(R.id.firstNumEditText);
        EditText secondNum = (EditText) findViewById(R.id.secondNumEditText);

        double result;
        String numCheckResult = numCheck(firstNum.getText().toString(), secondNum.getText().toString());

        if (numCheckResult.length() != 0) {
            Toast.makeText(MainActivity.this, numCheckResult, Toast.LENGTH_LONG).show();
        } else {
            displayResult(firstNum.getText().toString() +
                    " - " + secondNum.getText().toString() +
                    " = " + (Double.parseDouble(firstNum.getText().toString()) - Double.parseDouble(secondNum.getText().toString())));
        }
    }

    public void mulFunction(View view) {
        EditText firstNum = (EditText) findViewById(R.id.firstNumEditText);
        EditText secondNum = (EditText) findViewById(R.id.secondNumEditText);

        double result;
        String numCheckResult = numCheck(firstNum.getText().toString(), secondNum.getText().toString());

        if (numCheckResult.length() != 0) {
            Toast.makeText(MainActivity.this, numCheckResult, Toast.LENGTH_LONG).show();
        } else {
            displayResult(firstNum.getText().toString() +
                    " * " + secondNum.getText().toString() +
                    " = " + (Double.parseDouble(firstNum.getText().toString()) * Double.parseDouble(secondNum.getText().toString())));
        }
    }

    public void divFunction(View view) {
        EditText firstNum = (EditText) findViewById(R.id.firstNumEditText);
        EditText secondNum = (EditText) findViewById(R.id.secondNumEditText);

        double result;
        String numCheckResult = numCheck(firstNum.getText().toString(), secondNum.getText().toString());

        if (numCheckResult.length() != 0) {
            Toast.makeText(MainActivity.this, numCheckResult, Toast.LENGTH_LONG).show();
        } else if (Double.parseDouble(secondNum.getText().toString()) == 0) {
            Toast.makeText(MainActivity.this, "The divisor cannot be 0.", Toast.LENGTH_LONG).show();
        } else {
            displayResult(firstNum.getText().toString() +
                    " / " + secondNum.getText().toString() +
                    " = " + (Double.parseDouble(firstNum.getText().toString()) / Double.parseDouble(secondNum.getText().toString())));
        }
    }

    public void displayResult(String result) {
        Intent intent = new Intent(this, CalculatorActivity.class);
        intent.putExtra("message", result);
        startActivity(intent);
    }
}