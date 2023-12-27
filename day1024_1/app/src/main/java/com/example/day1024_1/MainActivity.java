package com.example.day1024_1;

import static java.lang.String.format;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickbtn1(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(1));
    }

    public void clickbtn2(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(2));
    }

    public void clickbtn3(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(3));
    }

    public void clickbtn4(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(4));
    }

    public void clickbtn5(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(5));
    }

    public void clickbtn6(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(6));
    }

    public void clickbtn7(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(7));
    }

    public void clickbtn8(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(8));
    }

    public void clickbtn9(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(9));
    }

    public void clickbtn0(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf(0));
    }

    public void clickbtn10(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + String.valueOf("."));
    }

    public void plusbtn(View view) {
        TextView calculator = findViewById(R.id.calculator);
        TextView result = findViewById(R.id.result);
        String getText = calculator.getText().toString();
        String getResult = result.getText().toString();
        String[] resultArr = getResult.split(" ");
        switch (resultArr[0]){
            case "0":
                calculator.setText(getText + " + ");
                break;
            case "=":
                calculator.setText(""+new BigDecimal(resultArr[1]).stripTrailingZeros()+" + ");
                break;
        }
    }

    public void minusbtn(View view) {
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        TextView result = findViewById(R.id.result);
        String getResult = result.getText().toString();
        String[] resultArr = getResult.split(" ");
        switch (resultArr[0]){
            case "0":
                calculator.setText(getText + " - ");
                break;
            case "=":
                calculator.setText(""+new BigDecimal(resultArr[1]).stripTrailingZeros()+" - ");
                break;
        }
    }

    public void multiplusbtn(View view) {
        TextView calculator = findViewById(R.id.calculator);
        TextView result = findViewById(R.id.result);
        String getText = calculator.getText().toString();
        String getResult = result.getText().toString();
        String[] resultArr = getResult.split(" ");
        switch (resultArr[0]){
            case "0":
                calculator.setText(getText + " X ");
                break;
            case "=":
                calculator.setText(""+new BigDecimal(resultArr[1]).stripTrailingZeros()+" X ");
                break;
        }
    }

    public void divisionbtn(View view) {
        TextView calculator = findViewById(R.id.calculator);
        TextView result = findViewById(R.id.result);
        String getText = calculator.getText().toString();
        String getResult = result.getText().toString();
        String[] resultArr = getResult.split(" ");
        switch (resultArr[0]){
            case "0":
                calculator.setText(getText + " ÷ ");
                break;
            case "=":
                calculator.setText(""+new BigDecimal(resultArr[1]).stripTrailingZeros()+" ÷ ");
                break;
        }
    }

    public void result(View view) {
        TextView calculator = findViewById(R.id.calculator);
        TextView result = findViewById(R.id.result);
        String text = calculator.getText().toString();
        String[] operator = text.split(" ");
        String resultout;
        float num;
        if (operator.length == 3) {
            switch (operator[1]) {
                case "+":
                    num = Float.parseFloat(operator[0]) + Float.parseFloat(operator[2]);
                    resultout = String.format("%3f", num);
                    result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                    break;
                case "-":
                    num = Float.parseFloat(operator[0]) - Float.parseFloat(operator[2]);
                    resultout = String.format("%3f", num);
                    result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                    break;
                case "X":
                    num = Float.parseFloat(operator[0]) * Float.parseFloat(operator[2]);
                    resultout = String.format("%3f", num);
                    result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                    break;
                case "÷":
                    num = Float.parseFloat(operator[0]) / Float.parseFloat(operator[2]);
                    resultout = String.format("%3f", num);
                    result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                    break;
            }
        } else if(operator.length == 2) {
            if(operator[0].equals("√")){
                double root = Double.parseDouble(operator[1]);
                double rootresult = Math.sqrt(root);
                resultout = format("%3f", rootresult);
                result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());;
            }else if(operator[1].equals("!")){
                int factorial=1;
                for(int i=1; i<=Integer.parseInt(operator[0]); i++){
                    factorial=factorial*i;
                }
                result.setText("= " + String.valueOf(factorial));
            }
        }else if (operator.length == 5) {
            switch (operator[1]) {
                case "+":
                    switch (operator[3]) {
                        case "+":
                            num = Float.parseFloat(operator[0]) + Float.parseFloat(operator[2]);
                            num = num + Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "-":
                            num = Float.parseFloat(operator[0]) + Float.parseFloat(operator[2]);
                            num = num - Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "X":
                            num = Float.parseFloat(operator[2]) * Float.parseFloat(operator[4]);
                            num = num + Float.parseFloat(operator[0]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "÷":
                            num = Float.parseFloat(operator[2]) / Float.parseFloat(operator[4]);
                            num = num + Float.parseFloat(operator[0]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                    }
                    break;
                case "-":
                    switch (operator[3]) {
                        case "+":
                            num = Float.parseFloat(operator[0]) - Float.parseFloat(operator[2]);
                            num = num + Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "-":
                            num = Float.parseFloat(operator[0]) - Float.parseFloat(operator[2]);
                            num = num - Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "X":
                            num = Float.parseFloat(operator[2]) * Float.parseFloat(operator[4]);
                            num = num - Float.parseFloat(operator[0]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "÷":
                            num = Float.parseFloat(operator[2]) / Float.parseFloat(operator[4]);
                            num = num - Float.parseFloat(operator[0]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                    }
                    break;
                case "X":
                    switch (operator[3]) {
                        case "+":
                            num = Float.parseFloat(operator[0]) * Float.parseFloat(operator[2]);
                            num = num + Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "-":
                            num = Float.parseFloat(operator[0]) * Float.parseFloat(operator[2]);
                            num = num - Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "X":
                            num = Float.parseFloat(operator[0]) * Float.parseFloat(operator[2]);
                            num = num * Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "÷":
                            num = Float.parseFloat(operator[0]) / Float.parseFloat(operator[2]);
                            num = num / Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                    }
                    break;
                case "÷":
                    switch (operator[3]) {
                        case "+":
                            num = Float.parseFloat(operator[0]) / Float.parseFloat(operator[2]);
                            num = num + Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "-":
                            num = Float.parseFloat(operator[0]) / Float.parseFloat(operator[2]);
                            num = num - Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "X":
                            num = Float.parseFloat(operator[0]) / Float.parseFloat(operator[2]);
                            num = num * Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                        case "÷":
                            num = Float.parseFloat(operator[0]) / Float.parseFloat(operator[2]);
                            num = num / Float.parseFloat(operator[4]);
                            resultout = String.format("%3f", num);
                            result.setText("= " + new BigDecimal(resultout).stripTrailingZeros());
                            break;
                    }
                    break;
            }
        }
    }

    public void reset(View view) {
        TextView calculator = findViewById(R.id.calculator);
        TextView result = findViewById(R.id.result);
        calculator.setText("");
        result.setText("0");
    }

    public void back(View view) {
        TextView back = findViewById(R.id.calculator);
        String result = back.getText().toString();
        result = result.substring(0, result.length() - 1);
        back.setText(result);
    }

    public void factorialbtn(View view){
        TextView calculator = findViewById(R.id.calculator);
        String getText = calculator.getText().toString();
        calculator.setText(getText + " ! ");
    }
    public void rootbtn(View view){
        TextView calculator = findViewById(R.id.calculator);
        calculator.setText("√ ");
    }
}