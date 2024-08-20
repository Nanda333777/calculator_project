package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private float valueOne = Float.NaN;
    private float valueTwo;
    private char currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonEquals = findViewById(R.id.buttonEquals);

        button0.setOnClickListener(view -> appendToInput("0"));
        button1.setOnClickListener(view -> appendToInput("1"));
        button2.setOnClickListener(view -> appendToInput("2"));
        button3.setOnClickListener(view -> appendToInput("3"));
        button4.setOnClickListener(view -> appendToInput("4"));
        button5.setOnClickListener(view -> appendToInput("5"));
        button6.setOnClickListener(view -> appendToInput("6"));
        button7.setOnClickListener(view -> appendToInput("7"));
        button8.setOnClickListener(view -> appendToInput("8"));
        button9.setOnClickListener(view -> appendToInput("9"));

        buttonAdd.setOnClickListener(view -> performOperation('+'));
        buttonSubtract.setOnClickListener(view -> performOperation('-'));
        buttonMultiply.setOnClickListener(view -> performOperation('*'));
        buttonDivide.setOnClickListener(view -> performOperation('/'));

        buttonClear.setOnClickListener(view -> clearInput());
        buttonEquals.setOnClickListener(view -> calculateResult());
    }

    private void appendToInput(String value) {
        editText.setText(editText.getText().toString() + value);
    }

    private void performOperation(char operation) {
        if (!Float.isNaN(valueOne)) {
            valueTwo = Float.parseFloat(editText.getText().toString());
            editText.setText(null);

            switch (currentOperation) {
                case '+':
                    valueOne = valueOne + valueTwo;
                    break;
                case '-':
                    valueOne = valueOne - valueTwo;
                    break;
                case '*':
                    valueOne = valueOne * valueTwo;
                    break;
                case '/':
                    valueOne = valueOne / valueTwo;
                    break;
            }
        } else {
            valueOne = Float.parseFloat(editText.getText().toString());
        }

        currentOperation = operation;
        editText.setText(null);
    }

    private void clearInput() {
        editText.setText(null);
        valueOne = Float.NaN;
        valueTwo = Float.NaN;
        currentOperation = ' ';
    }

    private void calculateResult() {
        if (!Float.isNaN(valueOne)) {
            valueTwo = Float.parseFloat(editText.getText().toString());

            switch (currentOperation) {
                case '+':
                    valueOne = valueOne + valueTwo;
                    break;
                case '-':
                    valueOne = valueOne - valueTwo;
                    break;
                case '*':
                    valueOne = valueOne * valueTwo;
                    break;
                case '/':
                    valueOne = valueOne / valueTwo;
                    break;
            }

            editText.setText(String.valueOf(valueOne));
            valueOne = Float.NaN;
            currentOperation = ' ';
        }
    }
}