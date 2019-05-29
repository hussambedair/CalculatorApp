package com.example.android.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = findViewById(R.id.result_text_view);



    }


    public void onButtonClicked (View v) {

        String t = ((Button)v).getText().toString();
        res.setText(res.getText().toString() + t);

    }

    public void onEqualClicked (View v) {
        String s = res.getText().toString();

        String RHS = "";
        String LHS = "";
        char op = ' ';

        for (int i = 0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c<= '9') {   //You have a digit
                if (op == ' ') {
                    LHS =LHS+c;
                } else {
                    RHS = RHS+c;
                }

            } else {
                op = c;
            }

        }

        calculate(LHS,RHS,op);
    }

    public void calculate (String LHS, String RHS, char op) {
        int n1 = Integer.parseInt(LHS);
        int n2 = Integer.parseInt(RHS);
        int result = 0;
        switch (op){
            case '+': result = n1 + n2;
            break;
            case '-': result = n1 - n2;
            break;
            case '*': result = n1 *n2;
            break;
            case '/' : result = n1/n2;
        }

        res.setText(result + "");
    }

    public void onClearClicked (View v) {
        res.setText(" ");
    }
}

