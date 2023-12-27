package com.example.day1030_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        TextView tv = findViewById(R.id.textView);
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            tv.setText("연결성공!");
        }catch (Exception e){
            tv.setText("연결실패.");
        }
    }
}