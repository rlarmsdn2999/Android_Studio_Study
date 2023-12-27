package com.example.day1030_2;

import androidx.appcompat.app.AppCompatActivity;

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
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchActivity extends AppCompatActivity {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@192.168.30.10:1521:xe";
    private static final String USERNAME = "HR";
    private static final String PASSWORD = "1234";
    private Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);
    }

    public void onClickSearch(View view){
        TextView inputSearch = findViewById(R.id.inputSearch);
        TextView inputSearch2 = findViewById(R.id.inputSearch2);
        TextView num = findViewById(R.id.setNum);
        TextView name = findViewById(R.id.setName2);
        TextView phone = findViewById(R.id.setPhone2);
        phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        TextView birth = findViewById(R.id.setBirth2);
        String input = inputSearch.getText().toString().replaceAll(" ,  ", "");
        String input2 = inputSearch2.getText().toString().replaceAll(" ,    ", "");
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
            Toast myToast = Toast.makeText(this.getApplicationContext(),"검색이 완료되었습니다.", Toast.LENGTH_SHORT);
            myToast.show();
        }catch (Exception e){
            Toast myToast = Toast.makeText(this.getApplicationContext(),"검색한 결과가 없습니다.", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }

    public void completeBtn(View view){
        Button insert = findViewById(R.id.updateBtn);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

}