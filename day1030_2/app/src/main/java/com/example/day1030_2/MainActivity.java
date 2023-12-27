package com.example.day1030_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    //192.168.30.10
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@192.168.30.10:1521:xe";
    private static final String USERNAME = "HR";
    private static final String PASSWORD = "1234";
    private Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);
        TextView tv = findViewById(R.id.cusinfo);
        try{
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            Statement statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            String sql = "SELECT CUS_NUM, CUS_NAME, CUS_PHONE, TO_char(CUS_BIRTH, 'YYMMDD') FROM MART_CUSTOMER order by CUS_NUM asc";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                stringBuffer.append(resultSet.getString(1)+"    ");
                stringBuffer.append(resultSet.getString(2)+"    ");
                stringBuffer.append(resultSet.getString(3)+"    ");
                stringBuffer.append(resultSet.getString(4)+"\n");
            }
            tv.setText(stringBuffer);
        }catch (Exception e){
            tv.setText(e.toString());
        }
    }

    public void onClickInsert(View view){
        Button insert = findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);

            }
        });
    }

    public void onClickSearch(View view){
        Button search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });
    }

    public void onClickUpdate(View view){
        Button search = findViewById(R.id.update2);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);

            }
        });
    }

    public void onClickdelete(View view){
        Button search = findViewById(R.id.delete);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent);

            }
        });
    }
}