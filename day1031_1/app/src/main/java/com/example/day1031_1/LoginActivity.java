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
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@192.168.30.10:1521:xe";
    private static final String USERNAME = "HR";
    private static final String PASSWORD = "1234";
    private Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);
    }

    public void loginBtn(View view) {
        TextView setId = findViewById(R.id.setId2);
        TextView setPassword = findViewById(R.id.setPass);
        TextView tv3 = findViewById(R.id.textView3);
        TextView setpass = findViewById(R.id.setPassword);
        TextView setInfo = findViewById(R.id.myinfo);
        String getId = setId.getText().toString().replaceAll(" ", "");
        String getPassword = setPassword.getText().toString().replaceAll(" ", "");
        Button btn = findViewById(R.id.button5);
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement stmt = connection.createStatement();
            StringBuffer id = new StringBuffer();
            StringBuffer password = new StringBuffer();
            StringBuffer name = new StringBuffer();
            StringBuffer job = new StringBuffer();
            String sql = "select * from login where id = '" + getId + "' and password = '" + getPassword + "'";
            ResultSet result = stmt.executeQuery(sql);
            if (result.next() == true) {
                id.append(result.getString(1));
                password.append(result.getString(2));
                name.append(result.getString(3));
                job.append(result.getString(4));
                String getName = name.toString();
                String getJob = job.toString();
                System.out.println(getName + "    " + getJob);
                setInfo.setText("이름 : " + getName + "   직급 : " + getJob);
                setId.setVisibility(View.INVISIBLE);
                setPassword.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                setpass.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.INVISIBLE);
                Toast myToast = Toast.makeText(this.getApplicationContext(), "로그인 성공.", Toast.LENGTH_SHORT);
                myToast.show();
            } else {
                setId.setText("");
                setPassword.setText("");
                Toast myToast = Toast.makeText(this.getApplicationContext(), "계정확인실패.", Toast.LENGTH_SHORT);
                myToast.show();
            }


        } catch (Exception e) {
            Toast myToast = Toast.makeText(this.getApplicationContext(), "로그인 실패.", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }

    public void enterBtn(View view) {
        TextView setInfo = findViewById(R.id.myinfo);
        String getInfo = setInfo.getText().toString();
        String[] info = getInfo.split(" ");
        String name = info[2];
        String job = info[7];
        Button enter = findViewById(R.id.button2);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ChoiceActivity.class);
                intent.putExtra("이름", name);
                intent.putExtra("직급", job);
                startActivity(intent);

            }
        });
    }

}