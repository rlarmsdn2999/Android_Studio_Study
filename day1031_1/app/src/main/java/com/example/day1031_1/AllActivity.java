package com.example.day1031_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllActivity extends AppCompatActivity {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@192.168.30.10:1521:xe";
    private static final String USERNAME = "HR";
    private static final String PASSWORD = "1234";
    private Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        Intent getIntent = getIntent();
        String name = getIntent.getStringExtra("이름");
        String job = getIntent.getStringExtra("직급");

        TextView tv = findViewById(R.id.name);
        tv.setText("이름 : "+name+"       직급 : "+job);
        try{
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Spinner spinner = findViewById(R.id.spinner);
            Statement statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            ResultSet resultSet = statement.executeQuery("SELECT title FROM diploma");

            while(resultSet.next()){
                stringBuffer.append(resultSet.getString(1) + ",") ;
            }
            String[] title = stringBuffer.toString().split(",");
            connection.close();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_item,title);
            spinner.setAdapter(adapter);
        }catch(Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void onClickRead(View view){
        TextView diptitle = findViewById(R.id.diptitle);
        TextView fromName = findViewById(R.id.fromname);
        TextView dipmain = findViewById(R.id.dipmain);
        TextView address = findViewById(R.id.address);
        TextView toName = findViewById(R.id.toname);
        Spinner spinner = findViewById(R.id.spinner);
        String text = spinner.getSelectedItem().toString();
        TextView job1 = findViewById(R.id.job1);
        TextView job2 = findViewById(R.id.job2);
        TextView job3 = findViewById(R.id.job);
        job1.setVisibility(View.VISIBLE);
        job2.setVisibility(View.VISIBLE);
        job3.setVisibility(View.VISIBLE);
        ImageView ima = findViewById(R.id.imageView);
        try{
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            StringBuffer title = new StringBuffer();
            StringBuffer from = new StringBuffer();
            StringBuffer main = new StringBuffer();
            StringBuffer add = new StringBuffer();
            StringBuffer to = new StringBuffer();
            StringBuffer ch1 = new StringBuffer();
            StringBuffer ch2 = new StringBuffer();
            StringBuffer ch3 = new StringBuffer();

            String sql = "SELECT * FROM DIPLOMA WHERE TITLE = '"+text+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                title.append(resultSet.getString(1));
                from.append(resultSet.getString(2));
                main.append(resultSet.getString(3));
                add.append(resultSet.getString(4));
                to.append(resultSet.getString(5));
                ch1.append(resultSet.getString(6));
                ch2.append(resultSet.getString(7));
                ch3.append(resultSet.getString(8));
            }
            diptitle.setText(title);
            fromName.setText("보내는 사람 : "+from);
            dipmain.setText(main);
            address.setText("주소 : "+add);
            toName.setText("받는 사람 : "+to);
            String num1 = ch1.toString();
            String num2 = ch2.toString();
            String num3 = ch3.toString();
            if(num1.equals("1")){
                TextView check1 = findViewById(R.id.check1);
                check1.setText("결제완료");
            }else{
                TextView check1 = findViewById(R.id.check1);
                check1.setText("");
            }
            if(num2.equals("1")){
                TextView check2 = findViewById(R.id.check2);
                check2.setText("결제완료");
            }else{
                TextView check2 = findViewById(R.id.check2);
                check2.setText("");
            }
            if(num3.equals("1")){
                TextView check3 = findViewById(R.id.check3);
                check3.setText("결제완료");
            }else{
                TextView check3 = findViewById(R.id.check3);
                check3.setText("");
            }
            if(num1.equals("1") && num2.equals("1") && num3.equals("1")){
                ima.setVisibility(View.VISIBLE);
            }else {
                ima.setVisibility(View.INVISIBLE);
            }
            Toast myToast = Toast.makeText(this.getApplicationContext(),"조회 되었습니다.", Toast.LENGTH_SHORT);
            myToast.show();
        }catch (Exception e){
            Toast myToast = Toast.makeText(this.getApplicationContext(),"공문서가 없습니다.", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }

    public void onClickCheck(View view){
        Intent getIntent = getIntent();
        String job = getIntent.getStringExtra("직급");
        TextView check1 = findViewById(R.id.check1);
        TextView check2 = findViewById(R.id.check2);
        TextView check3 = findViewById(R.id.check3);
        TextView diptitle = findViewById(R.id.diptitle);
        Spinner spinner = findViewById(R.id.spinner);
        String text = spinner.getSelectedItem().toString();
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if (job.equals("사장") && diptitle.getText() != "") {
                check1.setText("결재완료");
                String sql = "UPDATE DIPLOMA SET check1 = 1 WHERE title = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1,text);
                pstmt.executeUpdate();
            } else if (job.equals("부장") && diptitle.getText() != "") {
                check3.setText("결재완료");
                String sql = "UPDATE DIPLOMA SET check3 = 1 WHERE title = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1,text);
                pstmt.executeUpdate();
            } else if (job.equals("과장") && diptitle.getText() != "") {
                check2.setText("결재완료");
                String sql = "UPDATE DIPLOMA SET check2 = 1 WHERE title = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1,text);
                pstmt.executeUpdate();
            } else if(!job.equals("과장") && !job.equals("부장") && !job.equals("사장")){
                Toast myToast = Toast.makeText(this.getApplicationContext(), "권한이 없습니다.", Toast.LENGTH_SHORT);
                myToast.show();
            }
        }catch (Exception e ){
            Toast myToast = Toast.makeText(this.getApplicationContext(), "결제 에러.", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }

    public void backBtn(View view){
        Intent getIntent = getIntent();
        String name = getIntent.getStringExtra("이름");
        String job = getIntent.getStringExtra("직급");

        Button back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllActivity.this, ChoiceActivity.class);
                intent.putExtra("이름",name);
                intent.putExtra("직급",job);
                startActivity(intent);
            }
        });
    }

    public void logoutBtn(View view){
        Button insert = findViewById(R.id.logout);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}