package com.example.day1025_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int menu1count=0;
    int menu2count=0;
    int menu3count=0;
    int menu4count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        TextView result = findViewById(R.id.result);
        TextView menu1 = findViewById(R.id.menu1result);
        TextView menu2 = findViewById(R.id.menu2result);
        TextView menu3 = findViewById(R.id.menu3result);
        TextView menu4 = findViewById(R.id.menu4result);

        int menu1money = 8500;
        int menu2money = 9000;
        int menu3money = 10000;
        int menu4money = 11000;

        int menu1cnt = Integer.parseInt(menu1.getText().toString());
        int menu2cnt = Integer.parseInt(menu2.getText().toString());
        int menu3cnt = Integer.parseInt(menu3.getText().toString());
        int menu4cnt = Integer.parseInt(menu4.getText().toString());
        int resultmoney = (menu1cnt * menu1money) + (menu2cnt * menu2money) + (menu3cnt * menu3money)
                + (menu4cnt * menu4money);

        result.setText(String.valueOf("합계 : " + resultmoney+"원"));
    }

    public void menu1p(View view){
        CheckBox cb1 = findViewById(R.id.menu1);
        TextView menu1 = findViewById(R.id.menu1result);
        if(cb1.isChecked()){
            this.menu1count++;
            menu1.setText(String.valueOf(this.menu1count));
        }
    }

    public void menu1m(View view){
        CheckBox cb1 = findViewById(R.id.menu1);
        TextView menu1 = findViewById(R.id.menu1result);
        if(cb1.isChecked()){
            this.menu1count--;
            if(this.menu1count < 0){
                this.menu1count = 0;
            }
            menu1.setText(String.valueOf(this.menu1count));
        }
    }

    public void menu2p(View view){
        CheckBox cb1 = findViewById(R.id.menu2);
        TextView menu1 = findViewById(R.id.menu2result);
        if(cb1.isChecked()){
            this.menu2count++;
            menu1.setText(String.valueOf(this.menu2count));
        }
    }
    public void menu2m(View view){
        CheckBox cb1 = findViewById(R.id.menu2);
        TextView menu1 = findViewById(R.id.menu2result);
        if(cb1.isChecked()){
            this.menu2count--;
            if(this.menu2count < 0){
                this.menu2count = 0;
            }
            menu1.setText(String.valueOf(this.menu2count));
        }
    }

    public void menu3p(View view){
        CheckBox cb1 = findViewById(R.id.menu3);
        TextView menu1 = findViewById(R.id.menu3result);
        if(cb1.isChecked()){
            this.menu3count++;
            menu1.setText(String.valueOf(this.menu3count));
        }
    }

    public void menu3m(View view){
        CheckBox cb1 = findViewById(R.id.menu3);
        TextView menu1 = findViewById(R.id.menu3result);
        if(cb1.isChecked()){
            this.menu3count--;
            if(this.menu3count < 0){
                this.menu3count = 0;
            }
            menu1.setText(String.valueOf(this.menu3count));
        }
    }

    public void menu4p(View view){
        CheckBox cb1 = findViewById(R.id.menu4);
        TextView menu1 = findViewById(R.id.menu4result);
        if(cb1.isChecked()){
            this.menu4count++;
            menu1.setText(String.valueOf(this.menu4count));
        }
    }

    public void menu4m(View view){
        CheckBox cb1 = findViewById(R.id.menu4);
        TextView menu1 = findViewById(R.id.menu4result);
        if(cb1.isChecked()){
            this.menu4count--;
            if(this.menu4count < 0){
                this.menu4count = 0;
            }
            menu1.setText(String.valueOf(this.menu4count));
        }
    }

    public void check1(View view){
        TextView menu1 = findViewById(R.id.menu1result);
        ImageView plus = findViewById(R.id.menu1p);
        ImageView minus = findViewById(R.id.menu1m);
        CheckBox cb = findViewById(R.id.menu1);
        if(cb.isChecked()){
            this.menu1count++;
            menu1.setText(String.valueOf(this.menu1count));
            menu1.setVisibility(View.VISIBLE);
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);
        }else{
            this.menu1count=0;
            menu1.setVisibility(View.INVISIBLE);
            plus.setVisibility(View.INVISIBLE);
            minus.setVisibility(View.INVISIBLE);
        }
    }

    public void check2(View view){
        TextView menu1 = findViewById(R.id.menu2result);
        ImageView plus = findViewById(R.id.menu2p);
        ImageView minus = findViewById(R.id.menu2m);
        CheckBox cb = findViewById(R.id.menu2);
        if(cb.isChecked()){
            this.menu2count++;
            menu1.setText(String.valueOf(this.menu2count));
            menu1.setVisibility(View.VISIBLE);
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);
        }else{
            this.menu2count=0;
            menu1.setVisibility(View.INVISIBLE);
            plus.setVisibility(View.INVISIBLE);
            minus.setVisibility(View.INVISIBLE);
        }
    }
    public void check3(View view){
        TextView menu1 = findViewById(R.id.menu3result);
        ImageView plus = findViewById(R.id.menu3p);
        ImageView minus = findViewById(R.id.menu3m);
        CheckBox cb = findViewById(R.id.menu3);
        if(cb.isChecked()){
            this.menu3count++;
            menu1.setVisibility(View.VISIBLE);
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);
            menu1.setText(String.valueOf(this.menu3count));
        }else{
            this.menu3count=0;
            menu1.setVisibility(View.INVISIBLE);
            plus.setVisibility(View.INVISIBLE);
            minus.setVisibility(View.INVISIBLE);
        }
    }

    public void check4(View view){
        TextView menu1 = findViewById(R.id.menu4result);
        ImageView plus = findViewById(R.id.menu4p);
        ImageView minus = findViewById(R.id.menu4m);
        CheckBox cb = findViewById(R.id.menu4);
        if(cb.isChecked()){
            this.menu4count++;
            menu1.setVisibility(View.VISIBLE);
            menu1.setText(String.valueOf(this.menu4count));
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);
        }else{
            this.menu4count=0;
            menu1.setVisibility(View.INVISIBLE);
            plus.setVisibility(View.INVISIBLE);
            minus.setVisibility(View.INVISIBLE);
        }
    }

    public void reset(View view){
        CheckBox cb1 = findViewById(R.id.menu1);
        CheckBox cb2 = findViewById(R.id.menu2);
        CheckBox cb3 = findViewById(R.id.menu3);
        CheckBox cb4 = findViewById(R.id.menu4);
        TextView tv1 = findViewById(R.id.menu1result);
        tv1.setVisibility(View.INVISIBLE);
        TextView tv2 = findViewById(R.id.menu2result);
        tv2.setVisibility(View.INVISIBLE);
        TextView tv3 = findViewById(R.id.menu3result);
        tv3.setVisibility(View.INVISIBLE);
        TextView tv4 = findViewById(R.id.menu4result);
        tv4.setVisibility(View.INVISIBLE);
        ImageView p1 = findViewById(R.id.menu1p);
        p1.setVisibility(View.INVISIBLE);
        ImageView p2 = findViewById(R.id.menu2p);
        p2.setVisibility(View.INVISIBLE);
        ImageView p3 = findViewById(R.id.menu3p);
        p3.setVisibility(View.INVISIBLE);
        ImageView p4 = findViewById(R.id.menu4p);
        p4.setVisibility(View.INVISIBLE);
        ImageView m1 = findViewById(R.id.menu1m);
        m1.setVisibility(View.INVISIBLE);
        ImageView m2 = findViewById(R.id.menu2m);
        m2.setVisibility(View.INVISIBLE);
        ImageView m3 = findViewById(R.id.menu3m);
        m3.setVisibility(View.INVISIBLE);
        ImageView m4 = findViewById(R.id.menu4m);
        m4.setVisibility(View.INVISIBLE);
        TextView result = findViewById(R.id.result);
        result.setText("");
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
        this.menu1count = 0;
        this.menu2count = 0;
        this.menu3count = 0;
        this.menu4count = 0;

    }
}