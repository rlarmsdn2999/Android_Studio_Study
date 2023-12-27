package com.example.day1025_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClicked(View view){
        TextView result = findViewById(R.id.result);
        TextView choice = findViewById(R.id.choice);
        RadioGroup rg = findViewById(R.id.season);
        int num = rg.getCheckedRadioButtonId();
        RadioButton rb = findViewById(num);
        String str = rb.getText().toString();
        choice.setText("내가 선택한 답 : " + str);
        switch (str){
            case "apple":
                result.setText("결과 : 정답입니다!");
                break;
            default:
                result.setText("결과 : 오답입니다.!");
        }
    }
}