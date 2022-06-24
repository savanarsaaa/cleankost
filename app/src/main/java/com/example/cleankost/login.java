package com.example.cleankost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText txtnama,txtalamat;
    Button buttonlg;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        buttonlg = findViewById(R.id.btn_login);
        buttonlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}

