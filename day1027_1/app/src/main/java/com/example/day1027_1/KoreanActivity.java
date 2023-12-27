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

public class KoreanActivity extends AppCompatActivity {
    int count = 0;
    int successNum = 0;
    int failNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korean);

        Button button = findViewById(R.id.mainbtn);
        TextView success = findViewById(R.id.success);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KoreanActivity.this, PointActivity.class);
                intent.putExtra("success", success.getText().toString());
                intent.putExtra("subject", "국어");
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        RadioGroup rg = findViewById(R.id.choice);
        TextView resultText = findViewById(R.id.resultText);
        TextView examtext = findViewById(R.id.textView2);
        TextView success = findViewById(R.id.success);
        TextView fail = findViewById(R.id.fail);
        TextView countView = findViewById(R.id.count);
        RadioButton ch1 = findViewById(R.id.choice1);
        RadioButton ch2 = findViewById(R.id.choice2);
        RadioButton ch3 = findViewById(R.id.choice3);
        RadioButton ch4 = findViewById(R.id.choice4);
        if (ch1.isChecked() == false && ch2.isChecked() == false && ch3.isChecked() == false && ch4.isChecked() == false) {
            Toast myToast = Toast.makeText(this.getApplicationContext(), "정답을 선택해주세요.", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.CENTER,0,0);
            myToast.show();
        } else {
            rg.setVisibility(View.INVISIBLE);
            switch (count) {
                case 0:
                    int x = rg.getCheckedRadioButtonId();
                    RadioButton rb = findViewById(x);
                    String choice = rb.getText().toString();
                    if (choice.equals("나날이")) {
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
                    String exam = examtext.getText().toString();
                    examtext.setText(exam + "\n정답 : 나날이");
                    this.count++;
                    break;
                case 1:
                    int x1 = rg.getCheckedRadioButtonId();
                    RadioButton rb1 = findViewById(x1);
                    String choice1 = rb1.getText().toString();
                    if (choice1.equals("엄단하다")) {
                        this.successNum++;
                        success.setText(String.valueOf(this.successNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice1 + "\n정답입니다!");
                        resultText.setVisibility(View.VISIBLE);
                    } else {
                        this.failNum++;
                        fail.setText(String.valueOf(this.failNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice1 + "\n오답입니다ㅠ");
                        resultText.setVisibility(View.VISIBLE);
                    }
                    countView.setText(String.valueOf(this.successNum + this.failNum));
                    String exam1 = examtext.getText().toString();
                    examtext.setText(exam1 + "\n정답 : 엄단하다");
                    this.count++;
                    break;
                case 2:
                    int x2 = rg.getCheckedRadioButtonId();
                    RadioButton rb2 = findViewById(x2);
                    String choice2 = rb2.getText().toString();
                    if (choice2.equals("회연하다")) {
                        this.successNum++;
                        success.setText(String.valueOf(this.successNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice2 + "\n정답입니다!");
                        resultText.setVisibility(View.VISIBLE);
                    } else {
                        this.failNum++;
                        fail.setText(String.valueOf(this.failNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice2 + "\n오답입니다ㅠ");
                        resultText.setVisibility(View.VISIBLE);
                    }
                    countView.setText(String.valueOf(this.successNum + this.failNum));
                    String exam2 = examtext.getText().toString();
                    examtext.setText(exam2 + "\n정답 : 회연하다");
                    this.count++;
                    break;
                case 3:
                    int x3 = rg.getCheckedRadioButtonId();
                    RadioButton rb3 = findViewById(x3);
                    String choice3 = rb3.getText().toString();
                    if (choice3.equals("용빼다")) {
                        this.successNum++;
                        success.setText(String.valueOf(this.successNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice3 + "\n정답입니다!");
                        resultText.setVisibility(View.VISIBLE);
                    } else {
                        this.failNum++;
                        fail.setText(String.valueOf(this.failNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice3 + "\n오답입니다ㅠ");
                        resultText.setVisibility(View.VISIBLE);
                    }
                    countView.setText(String.valueOf(this.successNum + this.failNum));
                    String exam3 = examtext.getText().toString();
                    examtext.setText(exam3 + "\n정답 : 용빼다");
                    this.count++;
                    break;
                case 4:
                    int x4 = rg.getCheckedRadioButtonId();
                    RadioButton rb4 = findViewById(x4);
                    String choice4 = rb4.getText().toString();
                    if (choice4.equals("이물리다")) {
                        this.successNum++;
                        success.setText(String.valueOf(this.successNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice4 + "\n정답입니다!");
                        resultText.setVisibility(View.VISIBLE);
                    } else {
                        this.failNum++;
                        fail.setText(String.valueOf(this.failNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice4 + "\n오답입니다ㅠ");
                        resultText.setVisibility(View.VISIBLE);
                    }
                    countView.setText(String.valueOf(this.successNum + this.failNum));
                    String exam4 = examtext.getText().toString();
                    examtext.setText(exam4 + "\n정답 : 이물리다");
                    this.count++;
                    break;
                case 5:
                    int x5 = rg.getCheckedRadioButtonId();
                    RadioButton rb5 = findViewById(x5);
                    String choice5 = rb5.getText().toString();
                    if (choice5.equals("비난하다")) {
                        this.successNum++;
                        success.setText(String.valueOf(this.successNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice5 + "\n정답입니다!");
                        resultText.setVisibility(View.VISIBLE);
                    } else {
                        this.failNum++;
                        fail.setText(String.valueOf(this.failNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice5 + "\n오답입니다ㅠ");
                        resultText.setVisibility(View.VISIBLE);
                    }
                    countView.setText(String.valueOf(this.successNum + this.failNum));
                    String exam5 = examtext.getText().toString();
                    examtext.setText(exam5 + "\n정답 : 비난하다");
                    this.count++;
                    break;
                case 6:
                    int x6 = rg.getCheckedRadioButtonId();
                    RadioButton rb6 = findViewById(x6);
                    String choice6 = rb6.getText().toString();
                    if (choice6.equals("곱닿다")) {
                        this.successNum++;
                        success.setText(String.valueOf(this.successNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice6 + "\n정답입니다!");
                        resultText.setVisibility(View.VISIBLE);
                    } else {
                        this.failNum++;
                        fail.setText(String.valueOf(this.failNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice6 + "\n오답입니다ㅠ");
                        resultText.setVisibility(View.VISIBLE);
                    }
                    countView.setText(String.valueOf(this.successNum + this.failNum));
                    String exam6 = examtext.getText().toString();
                    examtext.setText(exam6 + "\n정답 : 곱닿다");
                    this.count++;
                    break;
                case 7:
                    int x7 = rg.getCheckedRadioButtonId();
                    RadioButton rb7 = findViewById(x7);
                    String choice7 = rb7.getText().toString();
                    if (choice7.equals("설명하다")) {
                        this.successNum++;
                        success.setText(String.valueOf(this.successNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice7 + "\n정답입니다!");
                        resultText.setVisibility(View.VISIBLE);
                    } else {
                        this.failNum++;
                        fail.setText(String.valueOf(this.failNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice7 + "\n오답입니다ㅠ");
                        resultText.setVisibility(View.VISIBLE);
                    }
                    countView.setText(String.valueOf(this.successNum + this.failNum));
                    String exam7 = examtext.getText().toString();
                    examtext.setText(exam7 + "\n정답 : 설명하다");
                    this.count++;
                    break;
                case 8:
                    int x8 = rg.getCheckedRadioButtonId();
                    RadioButton rb8 = findViewById(x8);
                    String choice8 = rb8.getText().toString();
                    if (choice8.equals("답답하다")) {
                        this.successNum++;
                        success.setText(String.valueOf(this.successNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice8 + "\n정답입니다!");
                        resultText.setVisibility(View.VISIBLE);
                    } else {
                        this.failNum++;
                        fail.setText(String.valueOf(this.failNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice8 + "\n오답입니다ㅠ");
                        resultText.setVisibility(View.VISIBLE);
                    }
                    countView.setText(String.valueOf(this.successNum + this.failNum));
                    String exam8 = examtext.getText().toString();
                    examtext.setText(exam8 + "\n정답 : 답답하다");
                    this.count++;
                    break;
                case 9:
                    int x9 = rg.getCheckedRadioButtonId();
                    RadioButton rb9 = findViewById(x9);
                    String choice9 = rb9.getText().toString();
                    if (choice9.equals("축전하다")) {
                        this.successNum++;
                        success.setText(String.valueOf(this.successNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice9 + "\n정답입니다!");
                        resultText.setVisibility(View.VISIBLE);
                    } else {
                        this.failNum++;
                        fail.setText(String.valueOf(this.failNum));
                        rg.setVisibility(View.INVISIBLE);
                        resultText.setText("내가 선택한 답 : " + choice9 + "\n오답입니다ㅠ");
                        resultText.setVisibility(View.VISIBLE);
                    }
                    countView.setText(String.valueOf(this.successNum + this.failNum));
                    String exam9 = examtext.getText().toString();
                    examtext.setText(exam9 + "\n정답 : 축전하다");
                    this.count++;
                    break;
            }
        }
    }

    public void onClick2(View view) {
        RadioButton rb1 = findViewById(R.id.choice1);
        RadioButton rb2 = findViewById(R.id.choice2);
        RadioButton rb3 = findViewById(R.id.choice3);
        RadioButton rb4 = findViewById(R.id.choice4);
        TextView exam = findViewById(R.id.textView2);
        TextView result = findViewById(R.id.resultText);
        RadioButton ch1 = findViewById(R.id.choice1);
        RadioButton ch2 = findViewById(R.id.choice2);
        RadioButton ch3 = findViewById(R.id.choice3);
        RadioButton ch4 = findViewById(R.id.choice4);
        if (ch1.isChecked() == false && ch2.isChecked() == false && ch3.isChecked() == false && ch4.isChecked() == false) {
            Toast myToast = Toast.makeText(this.getApplicationContext(), "정답을 선택해주세요.", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.CENTER,0,0);
            myToast.show();
        } else {
            result.setVisibility(View.INVISIBLE);
            RadioGroup rg = findViewById(R.id.choice);
            switch (count) {
                case 1:
                    exam.setText(R.string.ex2);
                    rb1.setText(R.string.ex2_1);
                    rb2.setText(R.string.ex2_2);
                    rb3.setText(R.string.ex2_3);
                    rb4.setText(R.string.ex2_4);
                    break;
                case 2:
                    exam.setText(R.string.ex3);
                    rb1.setText(R.string.ex3_1);
                    rb2.setText(R.string.ex3_2);
                    rb3.setText(R.string.ex3_3);
                    rb4.setText(R.string.ex3_4);
                    break;
                case 3:
                    exam.setText(R.string.ex4);
                    rb1.setText(R.string.ex4_1);
                    rb2.setText(R.string.ex4_2);
                    rb3.setText(R.string.ex4_3);
                    rb4.setText(R.string.ex4_4);
                    break;
                case 4:
                    exam.setText(R.string.ex5);
                    rb1.setText(R.string.ex5_1);
                    rb2.setText(R.string.ex5_2);
                    rb3.setText(R.string.ex5_3);
                    rb4.setText(R.string.ex5_4);
                    break;
                case 5:
                    exam.setText(R.string.ex6);
                    rb1.setText(R.string.ex6_1);
                    rb2.setText(R.string.ex6_2);
                    rb3.setText(R.string.ex6_3);
                    rb4.setText(R.string.ex6_4);
                    break;
                case 6:
                    exam.setText(R.string.ex7);
                    rb1.setText(R.string.ex7_1);
                    rb2.setText(R.string.ex7_2);
                    rb3.setText(R.string.ex7_3);
                    rb4.setText(R.string.ex7_4);
                    break;
                case 7:
                    exam.setText(R.string.ex8);
                    rb1.setText(R.string.ex8_1);
                    rb2.setText(R.string.ex8_2);
                    rb3.setText(R.string.ex8_3);
                    rb4.setText(R.string.ex8_4);
                    break;
                case 8:
                    exam.setText(R.string.ex9);
                    rb1.setText(R.string.ex9_1);
                    rb2.setText(R.string.ex9_2);
                    rb3.setText(R.string.ex9_3);
                    rb4.setText(R.string.ex9_4);
                    break;
                case 9:
                    exam.setText(R.string.ex10);
                    rb1.setText(R.string.ex10_1);
                    rb2.setText(R.string.ex10_2);
                    rb3.setText(R.string.ex10_3);
                    rb4.setText(R.string.ex10_4);
                    break;
            }
            rg.setVisibility(View.VISIBLE);
            Button mainbtn1 = findViewById(R.id.mainbtn);
            Button btn2 = findViewById(R.id.button2);
            Button next = findViewById(R.id.next);
            TextView tv10 = findViewById(R.id.textView10);
            TextView count = findViewById(R.id.count);
            if (this.failNum + this.successNum == 10) {
                rg.setVisibility(View.INVISIBLE);
                exam.setVisibility(View.INVISIBLE);
                mainbtn1.setVisibility(View.VISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                count.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
            }
        }
    }
}