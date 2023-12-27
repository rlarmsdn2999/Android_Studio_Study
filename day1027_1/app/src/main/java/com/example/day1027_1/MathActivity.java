package com.example.day1027_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MathActivity extends AppCompatActivity {

    int successNum = 0;
    int failNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        Button button = findViewById(R.id.mainbtn);
        TextView success = findViewById(R.id.success);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathActivity.this, PointActivity.class);
                intent.putExtra("success", success.getText().toString());
                intent.putExtra("subject", "수학");
                startActivity(intent);
            }
        });
    }

    public void onClick1(View view) {
        TextView success = findViewById(R.id.success);
        TextView fail = findViewById(R.id.fail);
        TextView num1 = findViewById(R.id.num1);
        TextView num2 = findViewById(R.id.num2);
        TextView result = findViewById(R.id.result);
        TextView pmmd = findViewById(R.id.pmmd);
        TextView resultText = findViewById(R.id.resultText);
        TextView countView = findViewById(R.id.count);
        int number1 = Integer.parseInt(num1.getText().toString());
        int number2 = Integer.parseInt(num2.getText().toString());
        int resultOut = 0;
        String getpmmd = pmmd.getText().toString();
        RadioButton ch1 = findViewById(R.id.choice1);
        RadioButton ch2 = findViewById(R.id.choice2);
        RadioButton ch3 = findViewById(R.id.choice3);
        RadioButton ch4 = findViewById(R.id.choice4);
        if (ch1.isChecked() == false && ch2.isChecked() == false && ch3.isChecked() == false && ch4.isChecked() == false) {
            Toast myToast = Toast.makeText(this.getApplicationContext(), "정답을 선택해주세요.", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.CENTER,0,0);
            myToast.show();
        } else {
            switch (getpmmd) {
                case "+":
                    resultOut = number1 + number2;
                    result.setText(String.valueOf(resultOut));
                    break;
                case "-":
                    resultOut = number1 - number2;
                    result.setText(String.valueOf(resultOut));
                    break;
                case "X":
                    resultOut = number1 * number2;
                    result.setText(String.valueOf(resultOut));
                    break;
                case "÷":
                    resultOut = number1 / number2;
                    result.setText(String.valueOf(resultOut));
                    break;
            }
            RadioGroup rg = findViewById(R.id.choice);
            int x = rg.getCheckedRadioButtonId();
            RadioButton rb = findViewById(x);
            String choice = rb.getText().toString();
            if (Integer.parseInt(choice) == resultOut) {
                this.successNum++;
                success.setText(String.valueOf(this.successNum));
                rg.setVisibility(View.INVISIBLE);
                resultText.setText("내가 선택한 답 : " + choice + "\n정답입니다!");
                resultText.setVisibility(View.VISIBLE);
            } else {
                this.failNum++;
                fail.setText(String.valueOf(this.failNum));
                rg.setVisibility(View.INVISIBLE);
                resultText.setText("내가 선택한 답 : " + choice + "\n오답입니다ㅠ");
                resultText.setVisibility(View.VISIBLE);
            }
            countView.setText(String.valueOf(this.successNum + this.failNum));
        }
    }

    public void onClick2(View view) {
        TextView num1 = findViewById(R.id.num1);
        TextView num2 = findViewById(R.id.num2);
        TextView answer = findViewById(R.id.result);
        TextView pmmd = findViewById(R.id.pmmd);
        TextView resultText = findViewById(R.id.resultText);
        RadioButton ch1 = findViewById(R.id.choice1);
        RadioButton ch2 = findViewById(R.id.choice2);
        RadioButton ch3 = findViewById(R.id.choice3);
        RadioButton ch4 = findViewById(R.id.choice4);
        if (ch1.isChecked() == false && ch2.isChecked() == false && ch3.isChecked() == false && ch4.isChecked() == false) {
            Toast myToast = Toast.makeText(this.getApplicationContext(), "정답을 선택해주세요.", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.CENTER,0,0);
            myToast.show();
        } else {
            RadioGroup rg = findViewById(R.id.choice);
            rg.setVisibility(View.VISIBLE);
            resultText.setVisibility(View.INVISIBLE);
            Random rd = new Random();
            int rdNum1 = rd.nextInt(100) + 1;
            int rdNum2 = rd.nextInt(100) + 1;
            int rdpmmd = rd.nextInt(4) + 1;
            int rdNum3 = rd.nextInt(4) + 1;
            num1.setText(String.valueOf(rdNum1));
            num2.setText(String.valueOf(rdNum2));
            int result = 0;
            switch (rdpmmd) {
                case 1:
                    pmmd.setText("+");
                    result = rdNum1 + rdNum2;
                    break;
                case 2:
                    pmmd.setText("-");
                    result = rdNum1 - rdNum2;
                    break;
                case 3:
                    pmmd.setText("X");
                    result = rdNum1 * rdNum2;
                    break;
                case 4:
                    pmmd.setText("÷");
                    result = rdNum1 / rdNum2;
                    break;
            }
            RadioButton rb1 = findViewById(R.id.choice1);
            RadioButton rb2 = findViewById(R.id.choice2);
            RadioButton rb3 = findViewById(R.id.choice3);
            RadioButton rb4 = findViewById(R.id.choice4);
            rb2.setText(String.valueOf(rd.nextInt(2000)));
            rb3.setText(String.valueOf(rd.nextInt(2000)));
            rb4.setText(String.valueOf(rd.nextInt(2000)));

            switch (rdNum3) {
                case 1:
                    rb1.setText(String.valueOf(result));
                    break;
                case 2:
                    rb2.setText(String.valueOf(result));
                    break;
                case 3:
                    rb3.setText(String.valueOf(result));
                    break;
                case 4:
                    rb4.setText(String.valueOf(result));
                    break;
            }

            answer.setText("?");
            Button mainbtn = findViewById(R.id.mainbtn);
            Button btn2 = findViewById(R.id.button2);
            Button next = findViewById(R.id.next);
            TextView equal = findViewById(R.id.equal);
            TextView tv10 = findViewById(R.id.textView10);
            TextView tv16 = findViewById(R.id.textView16);
            TextView count = findViewById(R.id.count);
            if (this.failNum + this.successNum == 10) {
                rg.setVisibility(View.INVISIBLE);
                num1.setVisibility(View.INVISIBLE);
                num2.setVisibility(View.INVISIBLE);
                pmmd.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.INVISIBLE);
                equal.setVisibility(View.INVISIBLE);
                mainbtn.setVisibility(View.VISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv16.setVisibility(View.INVISIBLE);
                count.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
            }
        }
    }
}