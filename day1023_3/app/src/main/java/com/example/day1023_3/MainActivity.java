package com.example.day1023_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClikedTextView(View view){
        TextView tv = findViewById(R.id.tx1);

        int x = Integer.parseInt(tv.getText().toString());
        x++;
        tv.setText(String.valueOf(x));
    }

    public void onClikedTextView2(View view){
        TextView tv = findViewById(R.id.tx2);

        int x = Integer.parseInt(tv.getText().toString());
        x++;
        tv.setText(String.valueOf(x));
    }

    public void onClikedTextView3(View view){
        TextView tv = findViewById(R.id.tx4);

        int x = Integer.parseInt(tv.getText().toString());
        x++;
        tv.setText(String.valueOf(x));
    }

    public void onClikedTextView4(View view){
        TextView tv = findViewById(R.id.tx4);

        int x = Integer.parseInt(tv.getText().toString());
        x--;
        tv.setText(String.valueOf(x));
    }
}