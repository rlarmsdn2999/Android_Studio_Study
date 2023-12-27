package com.example.day1031_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterActivity extends AppCompatActivity {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@192.168.30.10:1521:xe";
    private static final String USERNAME = "HR";
    private static final String PASSWORD = "1234";
    private Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);
    }

    public void registerBtn(View view){
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv4 = findViewById(R.id.tv4);
        TextView setId = findViewById(R.id.setID);
        TextView setPw = findViewById(R.id.setPw);
        TextView setName = findViewById(R.id.setName);
        TextView setJob = findViewById(R.id.setJob);
        String getId = setId.getText().toString().replaceAll(" ","");
        String getPw = setPw.getText().toString().replaceAll(" ","");
        String getName = setName.getText().toString().replaceAll(" ","");
        String getJob = setJob.getText().toString().replaceAll(" ","");

        try{
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "insert into login values (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,getId);
            pstmt.setString(2,getPw);
            pstmt.setString(3,getName);
            pstmt.setString(4,getJob);
            pstmt.executeUpdate();
            tv1.setVisibility(View.INVISIBLE);
            tv2.setVisibility(View.INVISIBLE);
            tv3.setVisibility(View.INVISIBLE);
            tv4.setVisibility(View.INVISIBLE);
            setId.setVisibility(View.INVISIBLE);
            setPw.setVisibility(View.INVISIBLE);
            setName.setVisibility(View.INVISIBLE);
            setJob.setVisibility(View.INVISIBLE);
            TextView tv11 = findViewById(R.id.textView11);
            tv11.setText("회원가입이 완료되었습니다.");
            tv11.setVisibility(View.VISIBLE);
        }catch (Exception e){
            Toast myToast = Toast.makeText(this.getApplicationContext(), "회원가입 실패.", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }

    public void completeBtn(View view){
        Button btn2 = findViewById(R.id.complete);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}