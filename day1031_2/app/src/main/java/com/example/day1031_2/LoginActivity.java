package com.example.day1031_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    }

    public void onClickLogin(View view) {
        TextView id = findViewById(R.id.setId2);
        TextView password = findViewById(R.id.setPass);
        String getID = id.getText().toString();
        String getPassword = password.getText().toString();
        TextView output = findViewById(R.id.textView6);

        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            StringBuffer BufId = new StringBuffer();
            StringBuffer Bufpass = new StringBuffer();
            StringBuffer Bufname = new StringBuffer();
            StringBuffer Bufjob = new StringBuffer();
            String sql = "SELECT * FROM login WHERE id = '" + getID + "' AND password = '" + getPassword + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                BufId.append(resultSet.getString(1));
                Bufpass.append(resultSet.getString(2));
                Bufname.append(resultSet.getString(3));
                Bufjob.append(resultSet.getString(4));
            }
            output.setText("이름 : "+Bufname+"    직급: "+Bufjob);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}