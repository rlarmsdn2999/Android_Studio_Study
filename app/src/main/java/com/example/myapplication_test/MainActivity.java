package com.example.myapplication_test;

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

    public void btn1Click(View view){
        TextView outputTv = findViewById(R.id.text1);
        TextView inputTv = findViewById(R.id.editTextText);

        int x;
        x = Integer.parseInt(inputTv.getText().toString());

        outputTv.setText(String.valueOf(x));
    }
}