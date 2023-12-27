package com.example.day1031_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, ReadActivity.class);
                intent.putExtra("이름",name);
                intent.putExtra("직급",job);
                startActivity(intent);
            }
        });
    }
}