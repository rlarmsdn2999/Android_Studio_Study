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

public class WriteActivity extends AppCompatActivity {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@192.168.30.10:1521:xe";
    private static final String USERNAME = "HR";
    private static final String PASSWORD = "1234";
    private Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        Intent getIntent = getIntent();
        String name = getIntent.getStringExtra("이름");
        String job = getIntent.getStringExtra("직급");

        TextView tv = findViewById(R.id.name);
        tv.setText("이름 : "+name+"       직급 : "+job);
    }

    public void writeBtn(View view){
        TextView title = findViewById(R.id.editTextText2);
        TextView from = findViewById(R.id.editTextText);
        TextView main = findViewById(R.id.editTextText3);
        TextView address = findViewById(R.id.editTextText4);
        TextView to = findViewById(R.id.editTextText5);
        TextView textfrom = findViewById(R.id.fromname);
        TextView textaddress = findViewById(R.id.address);
        TextView textto = findViewById(R.id.toname);
        String getTitle = title.getText().toString();
        String getFrom = from.getText().toString();
        String getMain = main.getText().toString();
        String getAddress = address.getText().toString();
        String getTo = to.getText().toString();

        try{
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            String sql = "insert into diploma values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,getTitle);
            pstmt.setString(2,getFrom);
            pstmt.setString(3,getMain);
            pstmt.setString(4,getAddress);
            pstmt.setString(5,getTo);
            pstmt.setString(6,"0");
            pstmt.setString(7,"0");
            pstmt.setString(8,"0");
            pstmt.executeUpdate();
            title.setVisibility(View.INVISIBLE);
            from.setVisibility(View.INVISIBLE);
            main.setVisibility(View.INVISIBLE);
            address.setVisibility(View.INVISIBLE);
            to.setVisibility(View.INVISIBLE);
            textfrom.setVisibility(View.INVISIBLE);
            textaddress.setVisibility(View.INVISIBLE);
            textto.setVisibility(View.INVISIBLE);
            TextView result = findViewById(R.id.result);
            result.setText("등록이 완료되었습니다.");
            result.setVisibility(View.VISIBLE);
        }catch (Exception e){
            Toast myToast = Toast.makeText(this.getApplicationContext(),"등록 실패.", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }

    public void back(View view){
        Button btn2 = findViewById(R.id.success);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WriteActivity.this, ChoiceActivity.class);
                startActivity(intent);

            }
        });
    }

}