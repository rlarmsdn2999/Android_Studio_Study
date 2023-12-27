package com.example.day1027_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PointActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        Intent intent = getIntent();
        String success = intent.getStringExtra("success");
        String subject = intent.getStringExtra("subject");
        int point = Integer.parseInt(success) * 10;
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = findViewById(R.id.textView4);
        TextView tv5 = findViewById(R.id.ment);
        tv3.setText(subject+"시험점수");
        tv4.setText(String.valueOf(point)+ "점 입니다!");
        if(point>=90){
            tv5.setText("정말 잘했어요!");
        }else if(point>=60){
            tv5.setText("조금 더 집중하세요.");
        }else{
            tv5.setText("조금 더 공부하세요");
        }
        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PointActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}