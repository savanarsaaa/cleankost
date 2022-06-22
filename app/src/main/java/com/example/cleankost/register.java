package com.example.cleankost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class register extends AppCompatActivity {

    EditText Nama, Email, pass, repassword;
    Button btn_register;
    String nama, email, password, repass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btn_register = findViewById(R.id.btn_register);
        Nama = findViewById(R.id.Nama);
        Email = findViewById(R.id.Email);
        pass = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = Nama.getText().toString();
                email = Email.getText().toString();
                password = pass.getText().toString();
                repass = repassword.getText().toString();

                if (Nama.getText().toString().length()==0){
                    Nama.setError("Nama Diperlukan!!");
                }
                if (Email.getText().toString().length()==0){
                    Email.setError("Email Diperlukan");
                }
                if (pass.getText().toString().length()==0){
                    pass.setError("Password Diperlukan");
                }
                if (repassword.getText().toString().length()==0){
                    repassword.setError("Re-Password Diperlukan");
                }
                else {
                    if ( pass.getText().toString().equals(repassword.getText().toString())) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "pendaftaran Berhasil...", Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());

                        Intent i = new Intent(getApplicationContext(), login.class);
                        i.putExtras(b);
                        startActivity(i);
                    } else {
                        Snackbar.make(view, "Password dan Re Password harus sama!!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
