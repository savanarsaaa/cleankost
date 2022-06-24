package com.example.cleankost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cleankost.App.DBCleaningKost;


public class cleaningkost extends AppCompatActivity {
    private EditText tNama, temail, talmt;
    private Button simpanBtn;
    String nm, email, almt;
    DBCleaningKost controller = new DBCleaningKost(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_kost);

        tNama = (EditText) findViewById(R.id.NamaKM);
        temail = (EditText) findViewById(R.id.Email);
        talmt = (EditText) findViewById(R.id.Alamat);
        simpanBtn = (Button) findViewById(R.id.btn_pesan);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cleaningkost.this, maincleaning.class);
                startActivity(intent);
            }
        });
    }
}