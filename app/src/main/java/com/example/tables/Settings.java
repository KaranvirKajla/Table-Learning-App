package com.example.tables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Settings extends AppCompatActivity {
    final public static String A="com.example.tables.A";
   public static final String B="com.example.tables.B";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    }
    public void Ok(View view){
        Intent intent = new Intent(Settings.this,MainActivity.class);
        EditText editText1 =findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        if(editText1.getText().toString().equals("")){
            MainActivity.tableMax=20;
        }
        else{MainActivity.tableMax=Integer.parseInt(editText1.getText().toString());}
        if(editText2.getText().toString().equals("")){
            MainActivity.tableLength=10;
        }
        else{
            MainActivity.tableLength=Integer.parseInt(editText2.getText().toString());}

        startActivity(intent);
    }
}
