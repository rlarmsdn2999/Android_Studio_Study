package com.example.day1023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plusbtn(View view){
        TextView inputx = findViewById(R.id.inputx);
        TextView inputy = findViewById(R.id.inputy);
        TextView output = findViewById(R.id.output);

        int x, y;
        x = Integer.parseInt(inputx.getText().toString());
        y = Integer.parseInt(inputy.getText().toString());

        output.setText(String.valueOf(x+y));
    }

    public void minusbtn(View view){
        TextView inputx = findViewById(R.id.inputx);
        TextView inputy = findViewById(R.id.inputy);
        TextView output = findViewById(R.id.output);

        int x, y;
        x = Integer.parseInt(inputx.getText().toString());
        y = Integer.parseInt(inputy.getText().toString());

        output.setText(String.valueOf(x-y));
    }

    public void multiplusbtn(View view){
        TextView inputx = findViewById(R.id.inputx);
        TextView inputy = findViewById(R.id.inputy);
        TextView output = findViewById(R.id.output);

        int x, y;
        x = Integer.parseInt(inputx.getText().toString());
        y = Integer.parseInt(inputy.getText().toString());

        output.setText(String.valueOf(x*y));
    }

    public void divisionbtn(View view){
        TextView inputx = findViewById(R.id.inputx);
        TextView inputy = findViewById(R.id.inputy);
        TextView output = findViewById(R.id.output);

        output.setText(String.valueOf(
                Integer.parseInt(inputx.getText().toString())/Integer.parseInt(inputy.getText().toString())));
    }
}