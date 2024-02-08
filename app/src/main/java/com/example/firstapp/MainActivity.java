package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    double num1;
    double num2;
    String selectedOpe;
    boolean firstNumTaken;
    boolean secondNumTaken;
    boolean equalClicked;
    boolean numberClicked;
    boolean operatorClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);
        num1 = 0;
        num2 = 0;
    }

    public void funcNumber(View view) {

        Button button = (Button) view;
        numberClicked = true;
        if(equalClicked)
        {
            result.setText("");
            equalClicked = false;
        }
        result.append(button.getText());
    }

    public void funcOpe(View view) {
        if(numberClicked) {
            if (!firstNumTaken) {
                num1 = Double.parseDouble(result.getText().toString());
                result.setText("");
                firstNumTaken = true;
            }
            Button button = (Button) view;
            if (button.getText().toString().equals("+")) {
                selectedOpe = "+";
            } else if (button.getText().equals("-")) {
                selectedOpe = "-";
            } else if (button.getText().equals("*")) {
                selectedOpe = "*";
            } else if (button.getText().equals("/")) {
                selectedOpe = "/";
            }
            numberClicked = false;
            operatorClicked = true;
        }
    }

    @SuppressLint("DefaultLocale")
    public void funcEqual(View view) {
        if(operatorClicked) {
            double res = 0;
            if (!equalClicked) {
                num2 = Integer.parseInt(result.getText().toString());

                switch (selectedOpe) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        if (num1 % num2 != 0) {
                            res = (double) num1 / num2;
                        }
                        break;
                }
                if (res % 1 == 0) {
                    result.setText(String.valueOf((int) res));
                } else {
                    result.setText(String.valueOf(String.format("%.3f" ,res)));
                }
                firstNumTaken = false;
                equalClicked = true;
            }
            operatorClicked = false;
        }
    }

    public void funcDelete(View view) {
        result.setText("");
    }
}