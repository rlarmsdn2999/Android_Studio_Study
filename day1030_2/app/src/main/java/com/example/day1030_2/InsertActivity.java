package com.example.day1030_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertActivity extends AppCompatActivity {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@192.168.30.10:1521:xe";
    private static final String USERNAME = "HR";
    private static final String PASSWORD = "1234";
    private Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);
    }

    public void insertBtn(View view){
        TextView name = findViewById(R.id.setName);
        TextView phone = findViewById(R.id.setPhone);
        phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        TextView birth = findViewById(R.id.setBirth);
        String setName = name.getText().toString().replaceAll(" ,   ", "");
        String setPhone = phone.getText().toString().replaceAll(" , ", "");
        String setBirth = birth.getText().toString().replaceAll(" , ", "");
        try{
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(InsertActivity.this);
            myAlertBuilder.setTitle("확인메세지");
            myAlertBuilder.setMessage("등록하시겠습니까?");
            myAlertBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    // OK 버튼을 눌렸을 경우
                    try{
                        String sql = "INSERT INTO MART_CUSTOMER VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?, TO_DATE(?))";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1,setName);
                        statement.setString(2,setPhone);
                        statement.setString(3,setBirth);
                        statement.executeUpdate();
                        Toast myToast = Toast.makeText(getApplicationContext(),"등록 되었습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                    }catch (Exception e){
                        Toast myToast = Toast.makeText(getApplicationContext(),"등록 실패하였습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                    }
                }
            });
            myAlertBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Cancle 버튼을 눌렸을 경우
                    Toast.makeText(getApplicationContext(),"취소하였습니다.",
                            Toast.LENGTH_SHORT).show();
                }
            });
            myAlertBuilder.show();
        }catch (Exception e){
            Toast myToast = Toast.makeText(this.getApplicationContext(),"등록 실패하였습니다.", Toast.LENGTH_SHORT);
            myToast.show();
        }
        name.setText("");
        phone.setText("");
        birth.setText("");
    }

    public void completeBtn(View view){
        Button insert = findViewById(R.id.button2);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

}