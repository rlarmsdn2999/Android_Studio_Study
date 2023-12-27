package com.example.day1025_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Spinner sp = findViewById(R.id.spinner);
        TextView tv = findViewById(R.id.textView2);

        if(sp.getSelectedItem().toString().contains("1절")){
            tv.setText(getString(R.string.song1));
        }else if(sp.getSelectedItem().toString().contains("2절")){
            tv.setText(getString(R.string.song2));
        }else if(sp.getSelectedItem().toString().contains("3절")){
            tv.setText(getString(R.string.song3));
        }else {
            tv.setText(getString(R.string.song4));
        }
    }
}