package com.example.day1023_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lottobtn(View view) {
        Random rd = new Random();

        TextView text1 = findViewById(R.id.textView1);
        TextView text2 = findViewById(R.id.textView2);
        TextView text3 = findViewById(R.id.textView3);
        TextView text4 = findViewById(R.id.textView4);
        TextView text5 = findViewById(R.id.textView5);
        TextView text6 = findViewById(R.id.textView6);

        int[] num = new int[6];
        for(int i=0;i < num.length;i++){
            num[i] = rd.nextInt(45) + 1;
            if(i != 0)
                for(int j=0; j < i ; j++)
                    if(num[j] == num[i])
                        i--;
        }

        text1.setText(String.valueOf(rd.nextInt(num[0])));
        text2.setText(String.valueOf(rd.nextInt(num[1])));
        text3.setText(String.valueOf(rd.nextInt(num[2])));
        text4.setText(String.valueOf(rd.nextInt(num[3])));
        text5.setText(String.valueOf(rd.nextInt(num[4])));
        text6.setText(String.valueOf(rd.nextInt(num[5])));
    }
}