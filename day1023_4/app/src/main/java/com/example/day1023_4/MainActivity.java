package com.example.day1023_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBox1(View view){
        Random rd = new Random();
        ImageView box1 = findViewById(R.id.box1);
        ImageView fail1 = findViewById(R.id.fail1);
        TextView success = findViewById(R.id.textView3);
        TextView fail = findViewById(R.id.textView4);
        int x = Integer.parseInt(success.getText().toString());
        int y = Integer.parseInt(fail.getText().toString());
        int i = rd.nextInt(10);
        if(i % 2 == 0){
            box1.setVisibility(View.INVISIBLE);
            fail1.setVisibility(View.INVISIBLE);
            x++;
            success.setText(String.valueOf(x));
        }else{
            box1.setVisibility(View.INVISIBLE);
            y++;
            fail.setText(String.valueOf(y));
        }
    }

    public void clickBox2(View view){
        Random rd = new Random();
        ImageView box1 = findViewById(R.id.box2);
        ImageView fail1 = findViewById(R.id.fail2);
        TextView success = findViewById(R.id.textView3);
        TextView fail = findViewById(R.id.textView4);
        int x = Integer.parseInt(success.getText().toString());
        int y = Integer.parseInt(fail.getText().toString());
        int i = rd.nextInt(10);
        if(i % 2 == 0){
            box1.setVisibility(View.INVISIBLE);
            fail1.setVisibility(View.INVISIBLE);
            x++;
            success.setText(String.valueOf(x));
        }else{
            box1.setVisibility(View.INVISIBLE);
            y++;
            fail.setText(String.valueOf(y));
        }
    }

    public void clickBox3(View view){
        Random rd = new Random();
        ImageView box1 = findViewById(R.id.box3);
        ImageView fail1 = findViewById(R.id.fail3);
        TextView success = findViewById(R.id.textView3);
        TextView fail = findViewById(R.id.textView4);
        int x = Integer.parseInt(success.getText().toString());
        int y = Integer.parseInt(fail.getText().toString());
        int i = rd.nextInt(10);
        if(i % 2 == 0){
            box1.setVisibility(View.INVISIBLE);
            fail1.setVisibility(View.INVISIBLE);
            x++;
            success.setText(String.valueOf(x));
        }else{
            box1.setVisibility(View.INVISIBLE);
            y++;
            fail.setText(String.valueOf(y));
        }
    }

    public void clickBox4(View view){
        Random rd = new Random();
        ImageView box1 = findViewById(R.id.box4);
        ImageView fail1 = findViewById(R.id.fail4);
        TextView success = findViewById(R.id.textView3);
        TextView fail = findViewById(R.id.textView4);
        int x = Integer.parseInt(success.getText().toString());
        int y = Integer.parseInt(fail.getText().toString());
        int i = rd.nextInt(10);
        if(i % 2 == 0){
            box1.setVisibility(View.INVISIBLE);
            fail1.setVisibility(View.INVISIBLE);
            x++;
            success.setText(String.valueOf(x));
        }else{
            box1.setVisibility(View.INVISIBLE);
            y++;
            fail.setText(String.valueOf(y));
        }
    }

    public void clickBox5(View view){
        Random rd = new Random();
        ImageView box1 = findViewById(R.id.box5);
        ImageView fail1 = findViewById(R.id.fail5);
        TextView success = findViewById(R.id.textView3);
        TextView fail = findViewById(R.id.textView4);
        int x = Integer.parseInt(success.getText().toString());
        int y = Integer.parseInt(fail.getText().toString());
        int i = rd.nextInt(10);
        if(i % 2 == 0){
            box1.setVisibility(View.INVISIBLE);
            fail1.setVisibility(View.INVISIBLE);
            x++;
            success.setText(String.valueOf(x));
        }else{
            box1.setVisibility(View.INVISIBLE);
            y++;
            fail.setText(String.valueOf(y));
        }
    }

    public void clickBox6(View view){
        Random rd = new Random();
        ImageView box1 = findViewById(R.id.box6);
        ImageView fail1 = findViewById(R.id.fail6);
        TextView success = findViewById(R.id.textView3);
        TextView fail = findViewById(R.id.textView4);
        int x = Integer.parseInt(success.getText().toString());
        int y = Integer.parseInt(fail.getText().toString());
        int i = rd.nextInt(10);
        if(i % 2 == 0){
            box1.setVisibility(View.INVISIBLE);
            fail1.setVisibility(View.INVISIBLE);
            x++;
            success.setText(String.valueOf(x));
        }else{
            box1.setVisibility(View.INVISIBLE);
            y++;
            fail.setText(String.valueOf(y));
        }
    }

    public void clickBox7(View view){
        Random rd = new Random();
        ImageView box1 = findViewById(R.id.box7);
        ImageView fail1 = findViewById(R.id.fail7);
        TextView success = findViewById(R.id.textView3);
        TextView fail = findViewById(R.id.textView4);
        int x = Integer.parseInt(success.getText().toString());
        int y = Integer.parseInt(fail.getText().toString());
        int i = rd.nextInt(10);
        if(i % 2 == 0){
            box1.setVisibility(View.INVISIBLE);
            fail1.setVisibility(View.INVISIBLE);
            x++;
            success.setText(String.valueOf(x));
        }else{
            box1.setVisibility(View.INVISIBLE);
            y++;
            fail.setText(String.valueOf(y));
        }
    }

    public void clickBox8(View view){
        Random rd = new Random();
        ImageView box1 = findViewById(R.id.box8);
        ImageView fail1 = findViewById(R.id.fail8);
        TextView success = findViewById(R.id.textView3);
        TextView fail = findViewById(R.id.textView4);
        int x = Integer.parseInt(success.getText().toString());
        int y = Integer.parseInt(fail.getText().toString());
        int i = rd.nextInt(10);
        if(i % 2 == 0){
            box1.setVisibility(View.INVISIBLE);
            fail1.setVisibility(View.INVISIBLE);
            x++;
            success.setText(String.valueOf(x));
        }else{
            box1.setVisibility(View.INVISIBLE);
            y++;
            fail.setText(String.valueOf(y));
        }
    }

    public void clickBox9(View view){
        Random rd = new Random();
        ImageView box1 = findViewById(R.id.box9);
        ImageView fail1 = findViewById(R.id.fail9);
        TextView success = findViewById(R.id.textView3);
        TextView fail = findViewById(R.id.textView4);
        int x = Integer.parseInt(success.getText().toString());
        int y = Integer.parseInt(fail.getText().toString());
        int i = rd.nextInt(10);
        if(i % 2 == 0){
            box1.setVisibility(View.INVISIBLE);
            fail1.setVisibility(View.INVISIBLE);
            x++;
            success.setText(String.valueOf(x));
        }else{
            box1.setVisibility(View.INVISIBLE);
            y++;
            fail.setText(String.valueOf(y));
        }
    }

    public void reset(View view){
        ImageView money1 = findViewById(R.id.money1);
        money1.setVisibility(View.VISIBLE);
        ImageView money2 = findViewById(R.id.money2);
        money2.setVisibility(View.VISIBLE);
        ImageView money3 = findViewById(R.id.money3);
        money3.setVisibility(View.VISIBLE);
        ImageView money4 = findViewById(R.id.money4);
        money4.setVisibility(View.VISIBLE);
        ImageView money5 = findViewById(R.id.money5);
        money5.setVisibility(View.VISIBLE);
        ImageView money6 = findViewById(R.id.money6);
        money6.setVisibility(View.VISIBLE);
        ImageView money7 = findViewById(R.id.money7);
        money7.setVisibility(View.VISIBLE);
        ImageView money8 = findViewById(R.id.money8);
        money8.setVisibility(View.VISIBLE);
        ImageView money9 = findViewById(R.id.money9);
        money9.setVisibility(View.VISIBLE);
        ImageView fail1 = findViewById(R.id.fail1);
        fail1.setVisibility(View.VISIBLE);
        ImageView fail2 = findViewById(R.id.fail2);
        fail2.setVisibility(View.VISIBLE);
        ImageView fail3 = findViewById(R.id.fail3);
        fail3.setVisibility(View.VISIBLE);
        ImageView fail4 = findViewById(R.id.fail4);
        fail4.setVisibility(View.VISIBLE);
        ImageView fail5 = findViewById(R.id.fail5);
        fail5.setVisibility(View.VISIBLE);
        ImageView fail6 = findViewById(R.id.fail6);
        fail6.setVisibility(View.VISIBLE);
        ImageView fail7 = findViewById(R.id.fail7);
        fail7.setVisibility(View.VISIBLE);
        ImageView fail8 = findViewById(R.id.fail8);
        fail8.setVisibility(View.VISIBLE);
        ImageView fail9 = findViewById(R.id.fail9);
        fail9.setVisibility(View.VISIBLE);
        ImageView box1 = findViewById(R.id.box1);
        box1.setVisibility(View.VISIBLE);
        ImageView box2 = findViewById(R.id.box2);
        box2.setVisibility(View.VISIBLE);
        ImageView box3 = findViewById(R.id.box3);
        box3.setVisibility(View.VISIBLE);
        ImageView box4 = findViewById(R.id.box4);
        box4.setVisibility(View.VISIBLE);
        ImageView box5 = findViewById(R.id.box5);
        box5.setVisibility(View.VISIBLE);
        ImageView box6 = findViewById(R.id.box6);
        box6.setVisibility(View.VISIBLE);
        ImageView box7 = findViewById(R.id.box7);
        box7.setVisibility(View.VISIBLE);
        ImageView box8 = findViewById(R.id.box8);
        box8.setVisibility(View.VISIBLE);
        ImageView box9 = findViewById(R.id.box9);
        box9.setVisibility(View.VISIBLE);
        TextView resetnum = findViewById(R.id.resetnum);
        int reset = Integer.parseInt(resetnum.getText().toString());
        reset++;
        resetnum.setText(String.valueOf(reset));
    }
}