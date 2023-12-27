package com.example.day1027_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.spinner);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spin.getSelectedItem().toString().equals("수학사칙연산")) {
                    Intent intent = new Intent(MainActivity.this, MathActivity.class);
                    startActivity(intent);
                }else if(spin.getSelectedItem().toString().equals("국어단어퀴즈")){
                    Intent intent = new Intent(MainActivity.this, KoreanActivity.class);
                    startActivity(intent);
                }else if(spin.getSelectedItem().toString().equals("영어단어퀴즈")){
                    Intent intent = new Intent(MainActivity.this, EnglishActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}