package com.example.day1030_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateActivity extends AppCompatActivity {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@192.168.30.10:1521:xe";
    private static final String USERNAME = "HR";
    private static final String PASSWORD = "1234";
    private Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);
    }

    public void onClickSearch(View view){
        TextView inputSearch = findViewById(R.id.inputSearch);
        TextView inputSearch2 = findViewById(R.id.inputSearch2);
        TextView num = findViewById(R.id.deleteNum);
        TextView name = findViewById(R.id.deleteName);
        TextView phone = findViewById(R.id.deletePhone);
        TextView birth = findViewById(R.id.deleteBirth);
        String input = inputSearch.getText().toString();
        String input2 = inputSearch2.getText().toString();
        try{
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            Statement statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            String sql = "SELECT CUS_NUM, CUS_NAME, CUS_PHONE, TO_char(CUS_BIRTH, 'YYMMDD') FROM MART_CUSTOMER WHERE CUS_NAME = '" +input+"' " +
                    "and CUS_PHONE = '"+input2+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                stringBuffer.append(resultSet.getString(1)+"    ");
                stringBuffer.append(resultSet.getString(2)+"    ");
                stringBuffer.append(resultSet.getString(3)+"    ");
                stringBuffer.append(resultSet.getString(4)+"\n");
            }
            String[] result = stringBuffer.toString().split("   ");
            for(int i=0; i<result.length; i++){
                result[i] = result[i].replaceAll(" ","");
            }
            num.setText(result[0]);
            name.setText(result[1]);
            phone.setText(result[2]);
            birth.setText(result[3]);
        }catch (Exception e){
            Toast myToast = Toast.makeText(this.getApplicationContext(),"검색한 결과가 없습니다.", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }

    public void onClickSave(View view){
        TextView name = findViewById(R.id.deleteName);
        TextView phone = findViewById(R.id.deletePhone);
        phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        TextView num = findViewById(R.id.deleteNum);
        TextView birth = findViewById(R.id.deleteBirth);
        String uname = name.getText().toString().replaceAll(" , ", "");
        String uphone = phone.getText().toString().replaceAll(" ,   ", "");
        String unum = num.getText().toString().replaceAll(" ,   ", "");
        try{
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(UpdateActivity.this);
            myAlertBuilder.setTitle("확인메세지");
            myAlertBuilder.setMessage("수정하시겠습니까?");
            myAlertBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    // OK 버튼을 눌렸을 경우
                    try{
                        String sql = "UPDATE MART_CUSTOMER SET CUS_NAME = ?, CUS_PHONE = ? WHERE CUS_NUM = ?";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1,uname);
                        statement.setString(2,uphone);
                        statement.setString(3,unum);
                        statement.executeUpdate();
                        Toast myToast = Toast.makeText(getApplicationContext(),"수정 되었습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                    }catch (Exception e){
                        Toast myToast = Toast.makeText(getApplicationContext(),"수정 실패하였습니다.", Toast.LENGTH_SHORT);
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
            Toast myToast = Toast.makeText(this.getApplicationContext(),"수정 실패하였습니다.", Toast.LENGTH_SHORT);
            myToast.show();
        }
        name.setText("");
        phone.setText("");
        num.setText("");
        birth.setText("");
    }

    public void completeBtn(View view){
        Button insert = findViewById(R.id.main2);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}