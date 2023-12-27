package com.example.day1031_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Intent getIntent = getIntent();
        String name = getIntent.getStringExtra("이름");
        String job = getIntent.getStringExtra("직급");
        Button btn1 = findViewById(R.id.button3);
        Button btn2 = findViewById(R.id.button4);
        Button btn3 = findViewById(R.id.button6);
        Button btn4 = findViewById(R.id.button8);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, ReadActivity.class);
                intent.putExtra("이름",name);
                intent.putExtra("직급",job);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, WriteActivity.class);
                intent.putExtra("이름",name);
                intent.putExtra("직급",job);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, MissActivity.class);
                intent.putExtra("이름",name);
                intent.putExtra("직급",job);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, AllActivity.class);
                intent.putExtra("이름",name);
                intent.putExtra("직급",job);
                startActivity(intent);
            }
        });
    }
}